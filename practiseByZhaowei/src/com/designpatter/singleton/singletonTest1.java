package com.designpatter.singleton;

//测试类
public class singletonTest1 {
	@SuppressWarnings("unused")
	static public void main(String argv[]) {
		Singleton1 s1, s2;
		// create one incetance--this should always work
		System.out.println("Creating one instance");
		try {
			s1 = new Singleton1();
		} catch (SingletonException e) {
			System.out.println(e.getMessage());
		}
		// try to create another spooler --should fail
		System.out.println("Creating two instance");
		try {
			s2 = new Singleton1();
		} catch (SingletonException e) {
			System.out.println(e.getMessage());
		}
	}
}