package com.moive.model;

import java.util.List;

public class BookedSeat {

	private List<Integer> bookedSeat;

	public BookedSeat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookedSeat(List<Integer> bookedSeat) {
		super();
		this.bookedSeat = bookedSeat;
	}

	public List<Integer> getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(List<Integer> bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	@Override
	public String toString() {
		return "BookedSeat [bookedSeat=" + bookedSeat + "]";
	}
	
}
