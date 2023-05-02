package com.moive.dao;

import com.moive.entity.Ticket;
import com.moive.model.BookedSeat;

public interface BookingDao {

	Ticket ticketBooking(BookedSeat bookedSeat, String tname, String movieName, String movieTime);

}
