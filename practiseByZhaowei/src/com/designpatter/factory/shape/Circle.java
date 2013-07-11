package com.designpatter.factory.shape;

//圆形子类
class Circle extends Shape {
	
	@Override
	public void draw() {
		System.out.println("It will draw a circle.");
	}

	@Override
	public void erase() {
		System.out.println("It will erase a circle.");
	}

	// 构造函数
	public Circle(String aName) {
		super(aName);
	}
}
