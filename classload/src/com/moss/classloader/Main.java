package com.moss.classloader;

public class Main {


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		MossClassLoader mfcl = new MossClassLoader();
		SomeSuperClass ssc = (SomeSuperClass)mfcl.loadClass("com.moss.classloader.SomeClass").newInstance();
		
		System.out.println("ClassLoader " + ssc.getClass().getClassLoader());
		System.out.println(ssc.message());
		
	}

}
