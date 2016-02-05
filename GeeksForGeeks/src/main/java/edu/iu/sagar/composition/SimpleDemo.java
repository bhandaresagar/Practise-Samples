package edu.iu.sagar.composition;

public class SimpleDemo
{

	public static void main(String[] args)
	{
		Audi audi = new Audi();
		//can be set to multiple cars 
		Wheels wheels = new MrfTyres();
		audi.setWheels(wheels);
	
		
		String s = "test string";
		
		String t = s.substring(5, 11);
		
		s = null;
		
		
		
		
		System.out.println(t);
		
	}
}
