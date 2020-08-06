package com.cts.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.airline.reservation.entities.Passenger;

public interface PassangerRepository extends JpaRepository<Passenger, Long> {

}
