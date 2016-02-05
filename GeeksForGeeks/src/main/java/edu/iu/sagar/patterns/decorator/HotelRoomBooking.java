package edu.iu.sagar.patterns.decorator;

public abstract class HotelRoomBooking
{
	protected double totalBill = 0.0;
	public abstract double getTotalBill();
	public abstract String getFacilities();
}
