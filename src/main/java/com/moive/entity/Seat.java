package com.moive.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Seat {
	
	@Id
	String movieName;
	private int bookedSeat;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(String movieName, int bookedSeat) {
		super();
		this.movieName = movieName;
		this.bookedSeat = bookedSeat;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getBookedSeat() {
		return bookedSeat;
	}
	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat = bookedSeat;
	}
	@Override
	public String toString() {
		return "Seat [movieName=" + movieName + ", bookedSeat=" + bookedSeat + "]";
	}
	
		
	
}
