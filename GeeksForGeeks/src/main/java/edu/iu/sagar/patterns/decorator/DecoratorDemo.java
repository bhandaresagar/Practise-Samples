package edu.iu.sagar.patterns.decorator;

public class DecoratorDemo
{
	public static void main(String[] args)
	{
		DeluxRoomBooking booking = new DeluxRoomBooking();
		System.out.println(booking.getTotalBill() + " " + booking.getFacilities());
		
		PersonalLaundry laundry = new PersonalLaundry(booking);
		System.out.println(laundry.getTotalBill() + " " + laundry.getFacilities());
		
		PickupDrop pickupDrop = new PickupDrop(laundry);
		System.out.println(pickupDrop.getTotalBill() +" " + pickupDrop.getFacilities());
	}
}
