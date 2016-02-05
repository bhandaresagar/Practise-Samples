package edu.iu.sagar.patterns.decorator;

public class DeluxRoomBooking extends HotelRoomBooking
{
	
	public DeluxRoomBooking()
	{
		totalBill = 100.0;
	}

	@Override
	public double getTotalBill()
	{
		return totalBill;
	}

	@Override
	public String getFacilities()
	{
		return "Delux Room";
	}
}
