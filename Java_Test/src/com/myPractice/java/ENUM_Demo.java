package com.myPractice.java;

enum Colour{ // can be defined inside a class or outside a class but can't be declared inside
			 // a method.
	RED,BLUE,GREEN(100);
	
	int intensity;
	Colour(){
		intensity = 50;
	}
	Colour(int i){
		intensity = i;
	}
	
	public int getIntensity() {
		return intensity;
	}
}

/*
 * class Colour{
 * 
 * public static final Colour RED= new Colour();
 * public static final Colour BLUE= new Colour();
 * public static final Colour GREEN= new Colour();
 * }
 */

public class ENUM_Demo {

	public static void main(String[] args) {
		Colour c = Colour.BLUE;
		Colour c1 = Colour.GREEN;
		System.out.println(c);
		System.out.println(c.intensity);
		System.out.println(c1);
		System.out.println(c1.intensity);
		
		Colour cArr[] = Colour.values();  // values() method is provided by JVM
		for(Colour colour:cArr) {
			System.out.println(colour);
		}
	
	/* All enums extend java.lang.Enum class which is an abstract class having different methods
	 *  and therefore enums can't extends any other class,however, they can implement other 
	 *  interfaces.
	 * */
	
		/*
		 * try{ int array[] = new int[10]; array[10] = 30/0; }catch(Exception |
		 * ArithmeticException | ArrayIndexOutOfBoundsException e){
		 * System.out.println(e.getMessage()); }
		 */ 
	
	}
}
