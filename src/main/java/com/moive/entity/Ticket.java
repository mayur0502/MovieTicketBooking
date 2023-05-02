package com.moive.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String movieName;
    private String TheaterName;
    private int seatQty;
    private String MovieTime;
    private double price;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Long id, String movieName, String theaterName, int seatQty, String movieTime, double price) {
		super();
		this.id = id;
		this.movieName = movieName;
		TheaterName = theaterName;
		this.seatQty = seatQty;
		MovieTime = movieTime;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", movieName=" + movieName + ", TheaterName=" + TheaterName + ", seatQty=" + seatQty
				+ ", MovieTime=" + MovieTime + ", price=" + price + "]";
	}

    
}
