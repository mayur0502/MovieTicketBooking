package com.moive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moive.entity.Movie;
import com.moive.entity.Theater;
import com.moive.servie.TheaterService;

@RestController
@RequestMapping(value="/theater")
public class TheaterController {
	
	@Autowired
	TheaterService service;

	@PostMapping(value="/register-theater")
	public ResponseEntity<Boolean> addTheater(@RequestBody Theater theater) {
		
		System.out.println(theater);
		boolean isAdded = service.addTheater(theater);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			// throw custom exception ( ResourceAlreadyExistsExceptio(String msg) )
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.ALREADY_REPORTED);
		}
	}
	
	@GetMapping(value="/get-all-theater")
	public ResponseEntity<List<Theater>> getAllTheater() {
			List<Theater> theaterList=null;
			theaterList = service.gettheater();
		if(theaterList != null) {
			return new ResponseEntity<List<Theater>>(theaterList,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<List<Theater>>(theaterList,HttpStatus.ALREADY_REPORTED);
		}
	}

	@GetMapping(value="/get-theater/{Tname}")
	public ResponseEntity<Theater> getTheaterByName(@PathVariable String Tname) {
		
		Theater theater= service.getTheaterByName(Tname);
		if(theater!=null) {
			return new ResponseEntity<Theater>(theater,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Theater>(theater,HttpStatus.ALREADY_REPORTED);
		}
	}
	
}
