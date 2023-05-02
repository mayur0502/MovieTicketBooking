package com.moive.servie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moive.entity.Movie;

@Service
public interface MovieService {

	boolean addMovie(Movie movie);

	Movie getMovieByName(String movieName);

	boolean deleteMovieByName(String movieName);

	List<Movie> getAllMovie();

	boolean updateMovie(Movie movie);

}
