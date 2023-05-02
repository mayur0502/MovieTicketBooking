package com.moive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moive.entity.Movie;

import com.moive.servie.MovieService;

@RestController
@RequestMapping(value="/moive")
public class MovieController {

	@Autowired
	MovieService service;
	
	@PostMapping(value="/register-movie")
	public ResponseEntity<Boolean> addmovie(@RequestBody Movie movie) {
		System.out.println(movie);
		boolean isAdded = service.addMovie(movie);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			// throw custom exception ( ResourceAlreadyExistsExceptio(String msg) )
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.ALREADY_REPORTED);
		}
	}
	@GetMapping(value="/get-movie/{movieName}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName) {
			
		Movie movie = service.getMovieByName(movieName);
		if(movie!=null) {
			return new ResponseEntity<Movie>(movie,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Movie>(movie,HttpStatus.ALREADY_REPORTED);
		}
	}
	
	@GetMapping(value="/get-all-movie")
	public ResponseEntity<List<Movie>> getAllMovie() {
			List<Movie> movieList=null;
			movieList = service.getAllMovie();
		if(movieList!=null) {
			return new ResponseEntity<List<Movie>>(movieList,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<List<Movie>>(movieList,HttpStatus.ALREADY_REPORTED);
		}
	}
	
	@DeleteMapping("/delete/{movieName}")
	public ResponseEntity<Boolean> deleteMovieByName(@PathVariable String movieName) {
		boolean isDeleted = service.deleteMovieByName(movieName);
		if(isDeleted) {
			return new ResponseEntity<>(isDeleted,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(isDeleted,HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/update-movie")
	public ResponseEntity<Boolean> updateMovie(@RequestBody Movie movie){
		boolean isUpdated=service.updateMovie(movie);
		
		return new ResponseEntity<Boolean>(isUpdated,HttpStatus.OK);
	}
	
//	@GetMapping(value="/select-movie/{movieName}")
//	public ResponseEntity<Movie> selectMovieByName(@PathVariable String movieName) {
//			
//		Movie movie = service.selectMovieByName(movieName);
//		if(movie!=null) {
//			return new ResponseEntity<Movie>(movie,HttpStatus.ACCEPTED);
//		}else {
//			return new ResponseEntity<Movie>(movie,HttpStatus.ALREADY_REPORTED);
//		}
//	}
}
