package com.cts.airline.reservation.repository;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.airline.reservation.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	  @Query("select f from Flight f  " +
	  "join f.flightInfo fi2  " +
	  "join fi2.airlineInfos ai  " +
	  "where  ai.nameOfAirline = ?1 and f.flightDate = ?2 ")
	public List<Flight> findAllFlightsbyNameanddate(String Name, Date date);
	
	 @Query("select f from Flight f join f.fare fa where f.origin= ?1 and f.destination =?2 and f.flightDate = ?3 order by fa.fare ")
	public List<Flight> findAllFlightbySrcDstDate(String source , String dest , Date date);
	 
	 @Query("select f from Flight f where f.origin= ?1 and f.flightDate = ?2  ")
		public List<Flight> findAllFlightbySrcDate(String source , Date date);
	 
	 @Query("select f from Flight f where f.flightNumber= ?1 and f.origin= ?2 and f.destination =?3")
	 	public List<Flight> findAllFlightbyFlightSrcDst(String flight ,String Source ,String dest);
	 
	 @Query(value ="select * from Flight f  where f.flight_Number= ?1 and  f.flight_Date = ?2 and f.flight_Time = ?3 LIMIT ?4", nativeQuery = true)
	 public Flight findOneFlightbyFlightDtTime(String flightNum , Date date ,Time time , int limit);
	 
	 @Query(value ="select f from Flight f  where f.flightNumber= ?1 ")
	 public Flight findOneFlightbyFlightNum(String flightNum);
	 
	 @Query("select f from Flight f join f.fare fa  join f.inventory i where f.origin= ?1 "
	 		+ "and f.destination =?2 and f.flightDate = ?3 "
	 		+ "and f.flightTime = ?4 and i.count >= ?5")
		public List<Flight> findAllFlightbySrcDstDatetimeInv(String source , String dest , Date date , Time time , int count);
	 
	 @Query("select f from Flight f join f.fare fa  join f.inventory i where f.origin= ?1 "
		 		+ "and f.destination =?2 and f.flightDate = ?3  and i.count >= ?4")
			public Optional< List<Flight>> findAllFlightbySrcDstDateInv(String source , String dest , Date date ,  int count);
}
