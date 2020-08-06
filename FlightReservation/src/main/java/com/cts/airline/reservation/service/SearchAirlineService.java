package com.cts.airline.reservation.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.Flight;
import com.cts.airline.reservation.models.SearchResult;
import com.cts.airline.reservation.repository.FlightRepository;
import com.cts.airline.reservation.utilities.AppConstants;

@Service
public class SearchAirlineService {
	@Autowired
	FlightRepository flightRepository;

	public List<SearchResult> searchFilght(String source, String dest, String date, int count) {
		List<Flight> flightList = null;
		List<SearchResult> searchResults = new ArrayList<>();
		try {
			flightList = flightRepository
					.findAllFlightbySrcDstDateInv(source, dest, new SimpleDateFormat("MM/dd/yyyy").parse(date), count)
					.orElse(null);
			if (flightList != null) {
			searchResults = flightList.stream().map(n -> SearchAirlineService.mapResults(n))
					.collect(Collectors.toList());
			searchResults.forEach(n -> n.setHrefForbook(AppConstants.bookUrl.
					replace("[%no]", n.getFlightNumber()).replace("[%cnt]", count+"")
					));
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		return searchResults;
	}

	private static SearchResult mapResults(Flight flight) {
		SearchResult searchResult = new SearchResult();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");  
		searchResult.setFlightNumber(flight.getFlightNumber());
		searchResult.setFlightDate(dateFormat.format(flight.getFlightDate()));
		searchResult.setFlightTime(timeFormat.format(flight.getFlightTime()));
		searchResult.setFare(flight.getFare().getFare());
		return searchResult;
	}

}
