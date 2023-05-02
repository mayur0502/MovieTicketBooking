package com.moive.servie;

import com.moive.model.BookedSeat;
import com.moive.model.FinalTicket;

public interface BookingService {

	FinalTicket ticketBooking(BookedSeat bookedSeat, String tname, String movieName, String movieTime);

}
