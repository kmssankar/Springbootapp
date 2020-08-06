package com.cts.airline.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cts.airline.reservation.models.BookingDetails;
import com.cts.airline.reservation.service.BookingDetailsService;

@Controller
public class BookingDetailsController {
	
	@Autowired
	BookingDetailsService	bookDetailsService;
	
	@GetMapping("/mybookings")
	public String getAllBookings(Model model) {
		BookingDetails bookingDetails =  bookDetailsService.getAllbookingDetails();		
		model.addAttribute("bookingsFound",bookingDetails.getBookingRecords().size()>0);
		model.addAttribute("bookingDetails",bookingDetails);
		return "allbookings";
	}
}
