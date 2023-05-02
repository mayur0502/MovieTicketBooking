package com.moive.model;

import java.util.List;

public class FinalTicket {

	private String movieName;
    private String TheaterName;
    private int seatQty;
    private String MovieTime;
    private double price;
    private List Seat;
    private double totalAmount;
	public FinalTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinalTicket(String movieName, String theaterName, int seatQty, String movieTime, double price, List seat,
			double totalAmount) {
		super();
		this.movieName = movieName;
		TheaterName = theaterName;
		this.seatQty = seatQty;
		MovieTime = movieTime;
		this.price = price;
		Seat = seat;
		this.totalAmount = totalAmount;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheaterName() {
		return TheaterName;
	}
	public void setTheaterName(String theaterName) {
		TheaterName = theaterName;
	}
	public int getSeatQty() {
		return seatQty;
	}
	public void setSeatQty(int seatQty) {
		this.seatQty = seatQty;
	}
	public String getMovieTime() {
		return MovieTime;
	}
	public void setMovieTime(String movieTime) {
		MovieTime = movieTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List getSeat() {
		return Seat;
	}
	public void setSeat(List seat) {
		Seat = seat;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "FinalTicket [movieName=" + movieName + ", TheaterName=" + TheaterName + ", seatQty=" + seatQty
				+ ", MovieTime=" + MovieTime + ", price=" + price + ", Seat=" + Seat + ", totalAmount=" + totalAmount
				+ "]";
	}
    
    
}
