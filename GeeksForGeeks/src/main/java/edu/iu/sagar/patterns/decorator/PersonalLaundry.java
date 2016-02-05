package edu.iu.sagar.patterns.decorator;

public class PersonalLaundry extends RoomBookingDecorator
{
	
	public PersonalLaundry(HotelRoomBooking booking)
	{
		super(booking);
	}

	@Override
	public double getTotalBill()
	{
		return booking.getTotalBill() + 10.0;
	}

	@Override
	public String getFacilities()
	{
		return booking.getFacilities() + ", " + "Laundry"	;
	}

}
