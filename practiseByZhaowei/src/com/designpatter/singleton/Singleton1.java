package com.designpatter.singleton;

public class Singleton1 {
	static boolean instance_flag = false; // true if 1 instance

	public Singleton1() {
		if (instance_flag)
			throw new SingletonException("Only one instance allowed");
		else
			instance_flag = true; // set flag for 1 instance
	}
}
