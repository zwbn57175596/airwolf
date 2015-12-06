package com.designpatter.singleton;

//测试类
public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if (s1 == s2)
			System.out.println("s1 is the same instance with s2");
		else
			System.out.println("s1 is not the same instance with s2");
	}
}