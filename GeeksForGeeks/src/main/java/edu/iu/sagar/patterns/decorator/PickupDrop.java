package edu.iu.sagar.patterns.decorator;

public class PickupDrop extends RoomBookingDecorator
{
	public PickupDrop(HotelRoomBooking booking)
	{
		super(booking);
	}

	@Override
	public double getTotalBill()
	{
		return booking.getTotalBill() + 5.0;
	}

	@Override
	public String getFacilities()
	{
		return booking.getFacilities() + ", " + "Pickup-Drop";
	}
}
