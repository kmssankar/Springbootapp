package com.cts.airline.reservation.models;

import java.util.List;

public class SearchForm {
	
	String origin;
	String destnation;
	String jouneyDate;
	int noOfPassangers;
	
	List<SearchResult> searchResults;
	
	
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestnation() {
		return destnation;
	}
	public void setDestnation(String destnation) {
		this.destnation = destnation;
	}
	public String getJouneyDate() {
		return jouneyDate;
	}
	public void setJouneyDate(String jouneyDate) {
		this.jouneyDate = jouneyDate;
	}
	public int getNoOfPassangers() {
		return noOfPassangers;
	}
	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	public List<SearchResult> getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(List<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}
}
