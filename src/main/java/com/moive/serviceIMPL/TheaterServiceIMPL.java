package com.moive.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moive.dao.TheaterDao;
import com.moive.entity.Theater;
import com.moive.servie.TheaterService;

@Service
public class TheaterServiceIMPL implements TheaterService {

	@Autowired
	TheaterDao dao;
	@Override
	public boolean addTheater(Theater theater) {
		return dao.addTheater(theater);
		
	}
	@Override
	public List gettheater() {
		// TODO Auto-generated method stub
		return dao.gettheater();
	}
	@Override
	public Theater getTheaterByName(String Tname) {
	
		return dao.getTheaterByName(Tname);
	}

}
