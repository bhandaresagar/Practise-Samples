package edu.iu.sagar.composition;

public class Audi extends Car
{

	public Audi()
	{
		//composition
		this.engine = new AudiEngine();
	}
	
	public void setWheels(Wheels wheels)
	{
		//aggregation
		this.wheels = wheels;
	}

}
