package com.cts.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.airline.reservation.entities.Fare;

public interface FareRepository extends JpaRepository<Fare, Long> {

}
