package com.cts.airline.reservation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fare_id")
	@GeneratedValue
	private Long fareId;

	private String currency;

	private double fare;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="fare",cascade = CascadeType.PERSIST)
	private List<Flight> flights;

	public Fare() {
	}

	public Long getFareId() {
		return this.fareId;
	}

	public void setFareId(Long fareId) {
		this.fareId = fareId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getFare() {
		return this.fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setFare(this);

		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setFare(null);

		return flight;
	}

	@Override
	public String toString() {
		return "Fare [fareId=" + fareId + ", currency=" + currency + ", fare=" + fare + "]";
	}

	
}