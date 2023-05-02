package com.moive.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Movie {

	@Id
	private String moviename;
    private String description;
    private LocalDate releasedate;
    private String duration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="t_name")
    @JsonIgnore
    private Theater theater;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieName, String description, LocalDate releaseDate, String duration, Theater theater) {
		super();
		this.moviename = movieName;
		this.description = description;
		this.releasedate = releaseDate;
		this.duration = duration;
		this.theater = theater;
	}
	public String getMovieName() {
		return moviename;
	}
	public void setMovieName(String movieName) {
		this.moviename = movieName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getReleaseDate() {
		return releasedate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releasedate = releaseDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + moviename + ", description=" + description + ", releaseDate=" + releasedate
				+ ", duration=" + duration + ", theater=" + theater + "]";
	}
	
    
        
}
