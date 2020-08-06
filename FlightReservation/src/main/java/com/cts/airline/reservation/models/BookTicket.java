package com.cts.airline.reservation.models;

import java.util.List;

import com.cts.airline.reservation.entities.Flight;

public class BookTicket  {


	public Flight flight;
	
	public List<PassangerDetail> passangerDetails;
	
	public int totalfare;
	
	public String bookingEmail;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<PassangerDetail> getPassangerDetails() {
		return passangerDetails;
	}

	public void setPassangerDetails(List<PassangerDetail> passangerDetails) {
		this.passangerDetails = passangerDetails;
	}

	public int getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}

	public String getBookingEmail() {
		return bookingEmail;
	}

	public void setBookingEmail(String bookingEmail) {
		this.bookingEmail = bookingEmail;
	}

	@Override
	public String toString() {
		return "BookTicket [flight=" + flight + ", passangerDetails=" + passangerDetails + ", totalfare=" + totalfare
				+ ", bookingEmail=" + bookingEmail + "]";
	}

	
}
