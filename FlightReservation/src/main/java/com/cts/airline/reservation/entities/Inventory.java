package com.cts.airline.reservation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inv_id")
	private long invId;

	private int count;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="inventory" ,cascade = CascadeType.PERSIST)
	private List<Flight> flights;

	public Inventory() {
	}

	public long getInvId() {
		return this.invId;
	}

	public void setInvId(long invId) {
		this.invId = invId;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setInventory(this);
		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setInventory(null);
		return flight;
	}

}