package com.cts.airline.reservation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.airline.reservation.entities.Flight;
import com.cts.airline.reservation.models.BookTicket;
import com.cts.airline.reservation.service.BookTicketService;

@Controller
public class BookTicketController {
	@Autowired
	BookTicketService bookTicketService;
	
	
	@GetMapping("/bookticket")
	public String geBbookticket(Model model, @RequestParam String flightno , @RequestParam int count) {
		boolean onbooking = true;
		boolean successfulbooking =false;
		System.out.println(" Count " + count + " Flight No : " + flightno);
		model.addAttribute("bookticket", bookTicketService.processgetBookTicket(count, flightno));
		model.addAttribute("onbooking",onbooking);
		//model.addAttribute("flightInp",bookTicketService.processgetBookTicket(count, flightno).getFlight());
		model.addAttribute("successfulbooking",successfulbooking);
		return "bookticket";
	}
	
	
	@PostMapping("/bookticket")
	public String postBookticket(@ModelAttribute BookTicket bookTicket ,Model model) {
		System.out.println(" In controller : " + bookTicket);
		String msg = bookTicketService.confirmBookTicket(bookTicket);
		boolean onbooking=false ;
		boolean successfulbooking =true;
		model.addAttribute("onbooking",onbooking);
	    model.addAttribute("successfulbooking",successfulbooking);
		model.addAttribute("bookingmsg",msg);		 
		return "bookticket" ;
	}
	
}
