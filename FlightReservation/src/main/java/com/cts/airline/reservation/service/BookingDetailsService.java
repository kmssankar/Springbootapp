package com.cts.airline.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.User;
import com.cts.airline.reservation.models.BookingDetails;
import com.cts.airline.reservation.repository.BookingRecordRepository;

@Service
public class BookingDetailsService {
	
	@Autowired
    AppUserInfoService appUserInfoService; 
	
	@Autowired 
	BookingRecordRepository bookingRecordRepository;
	
	public BookingDetails getAllbookingDetails() {		
		BookingDetails bookingDetails = new BookingDetails();
		User user = appUserInfoService.getLoggedInUserObj();
		bookingDetails.setBookingRecords(bookingRecordRepository.findBookingRecordBybookingUser(user.getUserName()));
		bookingDetails.setUserName(user.getFirstName()+ " " + user.getLastName());
		return bookingDetails;
	}

}
