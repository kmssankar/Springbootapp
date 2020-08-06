package com.cts.airline.reservation.entities;

import java.io.Serializable;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the booking_record database table.
 * 
 */
@Entity
@Table(name="booking_record")
public class BookingRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	@GeneratedValue
	private Long bookingId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="booking_date")
	private Date bookingDate;

	private String destination;

	private double fare;

	@Temporal(TemporalType.DATE)
	@Column(name="flight_date")
	private Date flightDate;

	@Column(name="flight_number")
	private String flightNumber;

	@Column(name="flight_time")
	private Time flightTime;

	private String origin;

	private String status;
	
	private String bookedUser;

	//bi-directional many-to-many association to Passenger
	@ManyToMany(mappedBy="bookingRecords",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Passenger> passengers1;

	//bi-directional many-to-one association to Passenger
	@OneToMany(mappedBy="bookingRecord",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Passenger> passengers2;

	public BookingRecord() {
	}

	public Long getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
	
	public String getBookedUser() {
		return bookedUser;
	}

	public void setBookedUser(String bookedUser) {
		this.bookedUser = bookedUser;
	}

	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return this.fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Passenger> getPassengers1() {
		return this.passengers1;
	}

	public void setPassengers1(List<Passenger> passengers1) {
		this.passengers1 = passengers1;
	}

	public List<Passenger> getPassengers2() {
		return this.passengers2;
	}

	public void setPassengers2(List<Passenger> passengers2) {
		this.passengers2 = passengers2;
	}

	public Passenger addPassengers2(Passenger passengers2) {
		getPassengers2().add(passengers2);
		passengers2.setBookingRecord(this);

		return passengers2;
	}

	public Passenger removePassengers2(Passenger passengers2) {
		getPassengers2().remove(passengers2);
		passengers2.setBookingRecord(null);

		return passengers2;
	}

	@Override
	public String toString() {
		return "BookingRecord [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", destination=" + destination
				+ ", flightDate=" + flightDate + ", flightNumber=" + flightNumber + ", flightTime=" + flightTime
				+ ", origin=" + origin + ", status=" + status + "]";
	}
	
}