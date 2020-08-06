package com.cts.airline.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AirlinesHomeController {

	@GetMapping("/")
	public String getHomepage() {
		return "home";				
	}
}
