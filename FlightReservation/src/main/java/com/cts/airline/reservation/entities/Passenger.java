package com.cts.airline.reservation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the passenger database table.
 * 
 */
@Entity
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="passenger_id")
	@GeneratedValue
	private Long passengerId;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;
	
	private String age;

	//bi-directional many-to-many association to BookingRecord
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="booking_details"
		, joinColumns={
			@JoinColumn(name="passenger_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="booking_id")
			}
		)
	private List<BookingRecord> bookingRecords;

	//bi-directional many-to-one association to BookingRecord
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private BookingRecord bookingRecord;
	
	

	public Passenger(String emailAddress, String firstName, String gender, String lastName, String mobileNumber, BookingRecord bookingRecord,String age) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.age=age;
		this.bookingRecord=bookingRecord;
	}

	public Passenger() {
	}

	public Long getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<BookingRecord> getBookingRecords() {
		return this.bookingRecords;
	}

	public void setBookingRecords(List<BookingRecord> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}

	public BookingRecord getBookingRecord() {
		return this.bookingRecord;
	}

	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}