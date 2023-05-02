package com.moive.servie;

import java.util.List;

import org.springframework.stereotype.Service;


import com.moive.entity.Theater;


public interface TheaterService {

	boolean addTheater(Theater theater);

	List gettheater();

	Theater getTheaterByName(String tname);
}
