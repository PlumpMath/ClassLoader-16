package com.moss.classloader;

public class Main {


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		SomeSuperClass ssc = Factory.newInstance();
		SomeClass sc = new SomeClass();
		
		while (true) {
			System.out.println("ClassLoader " + ssc.getClass().getClassLoader());
			System.out.println(ssc.message());
			System.out.println("ClassLoader " + sc.getClass().getClassLoader());
			System.out.println(sc.message());
		}
		
	}

}
