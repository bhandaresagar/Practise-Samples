package edu.iu.sagar.patterns.decorator;

public class SimpleRoomBooking extends HotelRoomBooking
{
	
	public SimpleRoomBooking()
	{
		totalBill = 80.0;
	}

	@Override
	public double getTotalBill()
	{
		return totalBill;
	}

	@Override
	public String getFacilities()
	{
		return "Simple Room";
	}
}
