package com.designpatter.singleton;

public class Singleton {
	private static Singleton s;

	private Singleton() {
	};

	/**
	 * Class method to access the singleton instance of the class.
	 */
	public static Singleton getInstance() {
		if (s == null)
			s = new Singleton();
		return s;
	}
}
