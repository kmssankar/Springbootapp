package com.cts.airline.reservation.models;

import java.util.List;
import com.cts.airline.reservation.entities.BookingRecord;
public class BookingDetails {
	
	String userName;
	
	List<BookingRecord> bookingRecords;

	public List<BookingRecord> getBookingRecords() {
		return bookingRecords;
	}

	public void setBookingRecords(List<BookingRecord> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
