package edu.iu.sagar.composition;

public abstract class Wheels
{
	protected double diameter;
	protected int resistance;

	public double getDiameter()
	{
		return this.diameter;
	}

	public void setDiameter(double diameter)
	{
		this.diameter = diameter;
	}

	public int getResistance()
	{
		return this.resistance;
	}

	public void setResistance(int resistance)
	{
		this.resistance = resistance;
	}

}
