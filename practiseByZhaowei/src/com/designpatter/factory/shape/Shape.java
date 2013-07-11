package com.designpatter.factory.shape;

abstract class Shape {
	
	// 勾画shape
	public abstract void draw();

	// 擦去 shape
	public abstract void erase();

	public String name;

	public Shape(String aName) {
		name = aName;
	}
}
