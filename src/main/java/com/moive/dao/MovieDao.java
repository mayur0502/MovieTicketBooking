package com.moive.dao;

import java.util.List;

import com.moive.entity.Movie;

public interface MovieDao {

	boolean addMovie(Movie movie);

	Movie getMovieByName(String movieName);

	boolean deleteMovieByName(String movieName);

	List<Movie> getAllMovie();

	boolean updateMovie(Movie movie);

}
