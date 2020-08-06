package com.cts.airline.reservation.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the airline_info database table.
 * 
 */
@Entity
@Table(name="airline_info")
public class AirlineInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="airline_id")
	@GeneratedValue
	private long airlineId;

	@Column(name="airline_logo")
	private String airlineLogo;

	@Column(name="name_of_airline")
	private String nameOfAirline;

	//bi-directional many-to-many association to FlightInfo
	@ManyToMany
	@JoinTable(
		name="flights_info"
		, joinColumns={
			@JoinColumn(name="airline_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="flight_infoid")
			}
		)
	private List<FlightInfo> flightInfos;

	public AirlineInfo() {
	}

	public long getAirlineId() {
		return this.airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineLogo() {
		return this.airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public String getNameOfAirline() {
		return this.nameOfAirline;
	}

	public void setNameOfAirline(String nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}

	public List<FlightInfo> getFlightInfos() {
		return this.flightInfos;
	}

	public void setFlightInfos(List<FlightInfo> flightInfos) {
		this.flightInfos = flightInfos;
	}

}