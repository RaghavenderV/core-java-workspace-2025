package com.abhi.designpatterns;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 5, 2017
 */

interface Shape{
	public abstract void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
		
	}
	
}

class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square::draw()");
		
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
		
	}
	
}

//create a facade class
class ShapeMaker{
	Shape circle;
	Shape square;
	Shape rectangle;
	
	public ShapeMaker() {
		this.circle = new Circle();
		this.square = new Square();
		this.rectangle = new Rectangle();
	}
	
	public void drawCircle(){
		circle.draw();
	}
	
	public void drawSquare(){
		square.draw();
	}
	
	public void drawRectangle(){
		rectangle.draw();
	}
	
	
}

public class FacadePatternDemo {

	public static void main(String[] args) {
		
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawSquare();
		shapeMaker.drawRectangle();

	}

}

/**
 Facade pattern hides the complexities of the system and provides an interface to the client 
 using which the client can access the system.
 
 This pattern involves a single class which provides simplified methods required by client and delegates calls 
 to methods of existing system classes.
 
 We are going to create a Shape interface and concrete classes implementing the Shape interface. 
 A facade class ShapeMaker is defined as a next step.

ShapeMaker class uses the concrete classes to delegate user calls to these classes.
*/