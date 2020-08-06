package com.cts.airline.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.airline.reservation.entities.AirlineInfo;



public interface AirlineInfoRepository extends JpaRepository<AirlineInfo, Long>{
	
	@Query("Select a from AirlineInfo a where a.nameOfAirline = ?1")
	public List<AirlineInfo> findAllAirlinebyName(String name);

}
