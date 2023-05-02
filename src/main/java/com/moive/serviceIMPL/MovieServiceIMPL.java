package com.moive.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moive.dao.MovieDao;
import com.moive.entity.Movie;
import com.moive.servie.MovieService;

@Service
public class MovieServiceIMPL implements MovieService {
	
	@Autowired
	MovieDao dao;
	
	@Override
	public boolean addMovie(Movie movie) {
		
		return dao.addMovie(movie);
	}

	@Override
	public Movie getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		return dao.getMovieByName(movieName);
	}

	@Override
	public boolean deleteMovieByName(String movieName) {
		// TODO Auto-generated method stub
		return dao.deleteMovieByName(movieName);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return dao.getAllMovie();
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return dao.updateMovie(movie);
	}

}
