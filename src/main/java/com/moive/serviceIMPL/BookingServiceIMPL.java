package com.moive.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moive.dao.BookingDao;
import com.moive.entity.Ticket;
import com.moive.model.BookedSeat;
import com.moive.model.FinalTicket;
import com.moive.servie.BookingService;

@Service
public class BookingServiceIMPL implements BookingService{
	
	@Autowired
	BookingDao dao;
		
	@Override
	public FinalTicket ticketBooking(BookedSeat bookedSeat, String tname, String movieName, String movieTime) {
		
		List<BookedSeat> listSeat=null;
		listSeat.add(bookedSeat);
		FinalTicket fTicket = null;
		Ticket ticket =  dao.ticketBooking(bookedSeat,tname,movieName,movieTime);
		
		if(ticket!=null) {
			fTicket.setMovieName(ticket.getMovieName());
			fTicket.setMovieTime(ticket.getMovieTime());
			fTicket.setPrice(ticket.getPrice());
			fTicket.setSeat(listSeat);
			fTicket.setSeatQty(ticket.getSeatQty());
			fTicket.setTheaterName(ticket.getTheaterName());
			fTicket.setTotalAmount(ticket.getPrice()*ticket.getSeatQty());
				}
		
		
		return fTicket;
		
		
	}

}
