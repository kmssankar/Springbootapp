package com.cts.airline.reservation.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String destination;

	private String duration;

	@Temporal(TemporalType.DATE)
	@Column(name="flight_date")
	private Date flightDate;

	@Column(name="flight_number")
	private String flightNumber;

	@Column(name="flight_time")
	private Time flightTime;

	private String origin;

	//bi-directional many-to-one association to FlightInfo
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="flight_infoid")
	private FlightInfo flightInfo;

	//bi-directional many-to-one association to Inventory
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="inv_id")
	private Inventory inventory;

	//bi-directional many-to-one association to Fare
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fare_id")
	private Fare fare;
	
	

	public Flight( String destination, String duration, Date flightDate, String flightNumber, Time flightTime,
			String origin, FlightInfo flightInfo, Inventory inventory, Fare fare) {
		super();
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
		this.flightInfo = flightInfo;
		this.inventory = inventory;
		this.fare = fare;
	}

	public Flight() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getFlightDate() {
		return this.flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Time getFlightTime() {
		return this.flightTime;
	}

	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public FlightInfo getFlightInfo() {
		return this.flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Fare getFare() {
		return this.fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

}