package com.vodapally.inheritance;

class Animal{
	public static void hide(){ // remove static and check
		System.out.println("hide() method in Animal");
	}
	
	public void override(){
		System.out.println("override() method in Animal");
	}
	
}

class Tiger extends Animal{
	public static void hide(){
		System.out.println("hide() method in Tiger"); //static methods can not be overridden, just hides the super class method
	}
	
	public void override(){
		System.out.println("override() method in Tiger");
	}
}
public class StaticPolymorphism {
	public static void main(String[] args) {
		
		Tiger tiger=new Tiger();
		Tiger.hide();		
		tiger.override();
		
		System.out.println("~~~~~~~~~~Animal animal=new Tiger();~~~~~~~~~~~~~~~~~");
		Animal animal=new Tiger();		
		Animal.hide();	
		//animal.hide(); // works same as Animal.hide();	
		animal.override();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Animal animalSuper=new Animal();
		
		animalSuper.hide();
		animalSuper.override();
				
	}	

}
