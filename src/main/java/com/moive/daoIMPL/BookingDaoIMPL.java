package com.moive.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.moive.dao.BookingDao;
import com.moive.entity.Movie;
import com.moive.entity.Seat;
import com.moive.entity.Theater;
import com.moive.entity.Ticket;
import com.moive.model.BookedSeat;

@Repository
public class BookingDaoIMPL implements BookingDao {

	@Autowired
	SessionFactory sf;
	
	public boolean addSeat(Seat seat) {

	boolean isAdded = false;
	Session session = null;		
	try {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(seat);
		transaction.commit();
		isAdded = true;
	} catch (PersistenceException e) {
		e.printStackTrace();
		isAdded = false;
	}
	catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();
		}
	}
	return isAdded;
}

	public boolean addTicket(Ticket ticket) {

	boolean isAdded = false;
	Session session = null;		
	try {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ticket);
		transaction.commit();
		isAdded = true;
	} catch (PersistenceException e) {
		e.printStackTrace();
		isAdded = false;
	}
	catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();
		}
	}
	return isAdded;
}	
	
	@Override
	public Ticket ticketBooking(BookedSeat bookedSeat, String tname, String movieName, String movieTime) {

		

		List<Integer> bookedSeat2 = bookedSeat.getBookedSeat();
		for (Integer integer : bookedSeat2) {
			Seat seat = null;
			seat.setMovieName(movieName);
			seat.setBookedSeat(integer);
			addSeat(seat);
		}
		
		TheaterDaoIMPL theater = new TheaterDaoIMPL();
		Theater theaterByName = theater.getTheaterByName(tname);
		
		double Tprice= theaterByName.getPrice();
		int seatqty = bookedSeat2.size();
		Ticket newticket = new  Ticket();
		newticket.setMovieName(movieName);
		newticket.setMovieTime(movieTime);
		newticket.setPrice(Tprice);
		newticket.setSeatQty(seatqty);
		newticket.setTheaterName(tname);
		
		boolean addTicket = addTicket(newticket);
		if(addTicket) {
			return newticket;
		}else {
		return null;
		}
	}

}
