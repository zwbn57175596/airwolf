package com.designpatter.factory.shape;

//定义返回 Square 实例的 SquareFactory
public class SquareFactory extends ShapeFactory {

	// 重载factoryMethod方法,返回Square对象
	@Override
	protected Shape factoryMethod(String aName) {
		return new Square(aName + " (created by SquareFactory)");
	}

}
