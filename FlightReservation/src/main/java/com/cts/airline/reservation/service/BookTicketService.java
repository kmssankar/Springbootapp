package com.cts.airline.reservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.BookingRecord;
import com.cts.airline.reservation.entities.Flight;
import com.cts.airline.reservation.entities.Inventory;
import com.cts.airline.reservation.entities.Passenger;
import com.cts.airline.reservation.entities.User;
import com.cts.airline.reservation.models.BookTicket;
import com.cts.airline.reservation.models.PassangerDetail;
import com.cts.airline.reservation.repository.BookingRecordRepository;
import com.cts.airline.reservation.repository.FlightRepository;
import com.cts.airline.reservation.repository.InventoryRepository;
import com.cts.airline.reservation.repository.UserRepository;

@Service
public class BookTicketService {
    @Autowired
	UserRepository userRepository;
	@Autowired
    AppUserInfoService appUserInfoService; 
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired 
	BookingRecordRepository bookingRecordRepository;
	
	public BookTicket processgetBookTicket(int count, String flightNum) {
		int passRow = 1;
		BookTicket bookticket = new BookTicket();
		List<PassangerDetail>  passangerDetails = new ArrayList<>();
		User user = userRepository.getUserByUserName(appUserInfoService.getLoggedInUser()).get();
		PassangerDetail passangerDetail = new PassangerDetail();
		passangerDetail.setId("1");	
		passangerDetail.setFirstName(user.getFirstName());
		passangerDetail.setLastName(user.getLastName());
		passangerDetail.setGender(" ");
		passangerDetail.setMobileNo(user.getPhoneNo());
		passangerDetails.add(passangerDetail);
		for(int i=1 ;i< count ; i++) {
			passRow ++;
			PassangerDetail copassangerDetail = new PassangerDetail();
			copassangerDetail.setId(passRow+"");
			copassangerDetail.setFirstName("");
			copassangerDetail.setLastName("");
			copassangerDetail.setGender("");
			passangerDetails.add(copassangerDetail);
		}
		Flight flight = flightRepository.findOneFlightbyFlightNum(flightNum);
		bookticket.setTotalfare(count * (int)(flight.getFare().getFare()));
		bookticket.setBookingEmail(user.getEmailId());
		bookticket.setFlight(flight);	
		bookticket.setPassangerDetails(passangerDetails);
		return bookticket;
	}
	
	public String confirmBookTicket(BookTicket bookTicket) {
		System.out.println(" booking  Inp passanger detail size : " + bookTicket);		
		User user = userRepository.getUserByUserName(appUserInfoService.getLoggedInUser()).get();
		Flight searchedFlight = flightRepository.findOneFlightbyFlightNum(bookTicket.getFlight().getFlightNumber());
		int currentcount = searchedFlight.getInventory().getCount();
		Inventory inventory = searchedFlight.getInventory();
		inventory.setCount(currentcount - bookTicket.getPassangerDetails().size());
		inventoryRepository.save(inventory);
		BookingRecord bookingRecord = new BookingRecord();
		bookingRecord.setFlightDate(searchedFlight.getFlightDate());
		bookingRecord.setBookingDate(new Date());
		bookingRecord.setDestination(searchedFlight.getDestination());
		bookingRecord.setOrigin(searchedFlight.getOrigin());
		bookingRecord.setFare(searchedFlight.getFare().getFare());
		bookingRecord.setFlightNumber(searchedFlight.getFlightNumber());
		bookingRecord.setFlightTime(searchedFlight.getFlightTime());
		bookingRecord.setBookedUser(user.getUserName());
		bookingRecord.setStatus("Confirmed");
		flightRepository.save(searchedFlight);
		List<Passenger> passangerList = new ArrayList<>();
		for(PassangerDetail passangerDetail : bookTicket.getPassangerDetails()) {
			passangerList.add(new Passenger(user.getEmailId(), passangerDetail.getFirstName(), passangerDetail.getGender(),
					passangerDetail.getLastName(), passangerDetail.getMobileNo(),bookingRecord,passangerDetail.getAge()+""));
		}
		bookingRecord.setPassengers1(passangerList);
		BookingRecord bookedRecord =  bookingRecordRepository.save(bookingRecord);
		
		return "Ticket booked successfully : Booking Id " + bookedRecord.getBookingId();
	}
}
