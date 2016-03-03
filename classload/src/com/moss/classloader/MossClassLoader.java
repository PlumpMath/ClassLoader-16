package com.moss.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class MossClassLoader extends URLClassLoader {
	
	public MossClassLoader(URL[] urls) {
		super(urls);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.endsWith("SomeClass")) {
			return findClass(name);
		}

		return super.loadClass(name);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = null;
		try {
			bytes = loadClassData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Class<?> result = defineClass(name, bytes, 0, bytes.length);
		return result;
	}

	private byte[] loadClassData() throws IOException {
		URLConnection connection = new URL("http://localhost:8080/rest/resources/message").openConnection();
		InputStream input = connection.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int data = input.read();

		while (data != -1) {
			buffer.write(data);
			data = input.read();
		}

		input.close();

		return buffer.toByteArray();
	}
}
