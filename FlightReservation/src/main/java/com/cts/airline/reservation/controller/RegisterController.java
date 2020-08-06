package com.cts.airline.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.cts.airline.reservation.models.RegisterUser;
import com.cts.airline.reservation.service.UserRegistrationService;

@Controller
public class RegisterController {
	@Autowired
	UserRegistrationService userRegistrationService;

	@GetMapping("/register")
	public String getRegister(Model model) {
		RegisterUser registeruser = new RegisterUser();
		model.addAttribute("registerInput", registeruser);
		return "register";
	}
	
	

	@PostMapping("/register")
	public String postRegister(Model model, @ModelAttribute RegisterUser registerInput) {
		if (! userRegistrationService.checkUserExistence(registerInput.getUserName())) {
			model.addAttribute("duplicateUserid", true);
			model.addAttribute("regSuccessfull", false);
			model.addAttribute("regSuccessfailed", false);
			model.addAttribute("registerInput", registerInput);
			return "register";
		} else {
			if (userRegistrationService.registerUsertoDB(registerInput)) {
				model.addAttribute("regSuccessfull", true);
				model.addAttribute("registerInput", new RegisterUser());
			} else {
				model.addAttribute("regSuccessfailed", true);
				model.addAttribute("registerInput", new RegisterUser());
			}
		}
		return "register";
	}
}
