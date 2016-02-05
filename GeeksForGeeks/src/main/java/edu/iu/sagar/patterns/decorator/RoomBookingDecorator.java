package edu.iu.sagar.patterns.decorator;

public abstract class RoomBookingDecorator extends HotelRoomBooking
{
	HotelRoomBooking booking;

	public RoomBookingDecorator(HotelRoomBooking booking)
	{
		this.booking = booking;
	}

}
