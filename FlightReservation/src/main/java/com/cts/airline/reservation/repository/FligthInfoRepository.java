package com.cts.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.airline.reservation.entities.FlightInfo;

public interface FligthInfoRepository extends JpaRepository<FlightInfo,Long>{

}
