package com.moive.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moive.entity.Seat;
import com.moive.entity.Ticket;
import com.moive.model.BookedSeat;
import com.moive.model.FinalTicket;
import com.moive.servie.BookingService;

@RestController
@RequestMapping(value="/booked")
public class BookingController {

	@Autowired
	BookingService service;
	
	@PostMapping(value="/ticket-booked")
	public FinalTicket ticketBooking(@RequestBody BookedSeat bookedSeat,String Tname,String movieName,String MovieTime) {

//		This is an logic to retive bookedseat object elements to store it in DATA BASE
//		List<Integer> bookedSeat2 = bookedSeat.getBookedSeat();
//		for (Integer integer : bookedSeat2) {
//			System.out.println(integer);
//		}
		
		//from here we will call service layer in that we will fetch movie and theater object by name  and stored in ticket entity
		//all details and then store selected seats in seat entity after that return ticket object to controller
		FinalTicket finalTicket =  service.ticketBooking(bookedSeat,Tname,movieName,MovieTime);
		System.out.println(bookedSeat);
		System.out.println(Tname);
		System.out.println(movieName);
	return finalTicket;
		
	}
}
