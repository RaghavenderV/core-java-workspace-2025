package com.abhi.designpatterns;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 5, 2017
 */
//https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
//create a factory class
class ShapeFactory{
	
	public Shape getShape(String shapeType) {
		if(shapeType == null)
			return null;
		if(shapeType.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		if(shapeType.equalsIgnoreCase("RECTNAGLE"))
			return new Rectangle();
		if(shapeType.equalsIgnoreCase("SQUARE"))
			return new Square();
		
		return null;
	}
}
public class FactoryPatternDemo {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();
		
		Shape rectangle = shapeFactory.getShape("RECTNAGLE");
		rectangle.draw();
		
		Shape square = shapeFactory.getShape("SQUARE");
		square.draw();

	}

}

/**
 Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
*/