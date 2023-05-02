package com.moive.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Theater {

	@Id
	private String Tname;
	private String street;
	private String city;
	private String state;
	private String Zipcode;
	private int seating_capacity;
	private double price;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "theater")
	List<Movie> movie;

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theater(String tname, String street, String city, String state, String zipcode, int seating_capacity,
			double price) {
		super();
		Tname = tname;
		this.street = street;
		this.city = city;
		this.state = state;
		Zipcode = zipcode;
		this.seating_capacity = seating_capacity;
		this.price = price;

	}

	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Theater [Tname=" + Tname + ", street=" + street + ", city=" + city + ", state=" + state + ", Zipcode="
				+ Zipcode + ", seating_capacity=" + seating_capacity + ", price=" + price + ", movie=" + movie + "]";
	}

	

}
