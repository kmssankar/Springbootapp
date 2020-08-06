package com.cts.airline.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.airline.reservation.models.SearchForm;
import com.cts.airline.reservation.models.SearchResult;
import com.cts.airline.reservation.service.SearchAirlineService;

@Controller
public class AirlinesSearchController {
	@Autowired
	SearchAirlineService searchAirlineService;

	@GetMapping("/searchjourney")
	public String getSearchreq(Model model) {
		SearchForm serForm = new SearchForm();
		model.addAttribute("searcform", serForm);
		model.addAttribute("resultfound", false);
		model.addAttribute("invalidCount", false);
		return "search";
	}

	@PostMapping("/searchjourney")
	public String postSearchreq(Model model, @ModelAttribute SearchForm searcform) {
		boolean noresult = false;
		boolean resultfound = false;
		boolean invalidCount = false;
		invalidCount = ((searcform.getNoOfPassangers() > 4) || (searcform.getNoOfPassangers() < 1)) ? true : false;
		if (!invalidCount) {
			System.out.println(searcform.getOrigin() + " " + searcform.getDestnation() + " " + searcform.getJouneyDate()
					+ " " + searcform.getNoOfPassangers());
			List<SearchResult> searchRes = searchAirlineService.searchFilght(searcform.getOrigin(),
					searcform.getDestnation(), searcform.getJouneyDate(), searcform.getNoOfPassangers());
			noresult = searchRes.size() < 1 ? true : false;
			resultfound = searchRes.size() > 0 ? true : false;
			searcform.setSearchResults(searchRes);
		}
		model.addAttribute("searcform", searcform);
		model.addAttribute("noresult", noresult);
		model.addAttribute("resultfound", resultfound);
		model.addAttribute("invalidCount", invalidCount);
		return "search";
	}
}
