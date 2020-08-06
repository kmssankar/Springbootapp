package com.cts.airline.reservation.entities;
import java.io.Serializable;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the flight_info database table.
 * 
 */
@Entity
@Table(name="flight_info")
public class FlightInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="flight_infoid")
	@GeneratedValue
	private Long flightInfoid;

	@Column(name="flight_number")
	private String flightNumber;

	@Column(name="flight_type")
	private String flightType;

	@Column(name="numberof_seats")
	private int numberofSeats;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="flightInfo")
	private List<Flight> flights;

	//bi-directional many-to-many association to AirlineInfo
	@ManyToMany(mappedBy="flightInfos")
	private List<AirlineInfo> airlineInfos;

	public FlightInfo() {
	}

	public Long getFlightInfoid() {
		return this.flightInfoid;
	}

	public void setFlightInfoid(Long flightInfoid) {
		this.flightInfoid = flightInfoid;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightType() {
		return this.flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getNumberofSeats() {
		return this.numberofSeats;
	}

	public void setNumberofSeats(int numberofSeats) {
		this.numberofSeats = numberofSeats;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setFlightInfo(this);

		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setFlightInfo(null);

		return flight;
	}

	public List<AirlineInfo> getAirlineInfos() {
		return this.airlineInfos;
	}

	public void setAirlineInfos(List<AirlineInfo> airlineInfos) {
		this.airlineInfos = airlineInfos;
	}

}