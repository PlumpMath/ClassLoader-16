package com.moss.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class Factory {

	public static SomeSuperClass newInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
		
		ClassLoader mossCL = new MossClassLoader(urls);
		//System.out.println(urls);
		
		return (SomeSuperClass) mossCL.loadClass("com.moss.classloader.SomeClass").newInstance();
	}
}
