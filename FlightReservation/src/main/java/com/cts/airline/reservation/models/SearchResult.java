package com.cts.airline.reservation.models;

public class SearchResult {
	
	String flightNumber;
	String flightTime;
	String flightDate;
	String hrefForbook;
	double fare;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getHrefForbook() {
		return hrefForbook;
	}
	public void setHrefForbook(String hrefForbook) {
		this.hrefForbook = hrefForbook;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "SearchResult [flightNumber=" + flightNumber + ", flightTime=" + flightTime + ", flightDate="
				+ flightDate + ", hrefForbook=" + hrefForbook + ", fare=" + fare + "]";
	}
}
