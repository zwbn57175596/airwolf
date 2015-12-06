package com.designpatter.factory.shape;

//定义返回 circle 实例的 CircleFactory 
public class CircleFactory extends ShapeFactory {

	@Override
	// 重载factoryMethod方法,返回Circle对象
	protected Shape factoryMethod(String aName) {
		return new Circle(aName + " (created by CircleFactory)");
	}

}
