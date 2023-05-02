package com.moive.dao;

import java.util.List;

import com.moive.entity.Theater;

public interface TheaterDao {

	boolean addTheater(Theater theater);

	List gettheater();

	Theater getTheaterByName(String tname);

}
