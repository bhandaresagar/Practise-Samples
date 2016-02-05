package edu.iu.sagar.composition;

public abstract class Car
{
	protected Engine engine;
	protected Wheels wheels;

	public Engine getEngine()
	{
		return this.engine;
	}

	public void setEngine(Engine engine)
	{
		this.engine = engine;
	}

	public Wheels getWheels()
	{
		return this.wheels;
	}

	public void setWheels(Wheels wheels)
	{
		this.wheels = wheels;
	}

}
