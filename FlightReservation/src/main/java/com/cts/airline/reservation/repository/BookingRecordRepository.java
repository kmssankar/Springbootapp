package com.cts.airline.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.airline.reservation.entities.BookingRecord;

public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long>{
	
	@Query("Select b from BookingRecord b where b.bookedUser = ?1")
	public List<BookingRecord> findBookingRecordBybookingUser(String userBooked);

}
