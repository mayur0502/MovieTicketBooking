package com.moive.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moive.dao.TheaterDao;
import com.moive.entity.Movie;
import com.moive.entity.Theater;

@Repository
public class TheaterDaoIMPL implements TheaterDao{
	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean addTheater(Theater theater) {
		boolean isAdded = false;
		Session session = null;		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(theater);
			transaction.commit();
			isAdded = true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			isAdded = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List gettheater() {
		Session session = sf.openSession();
		List<Theater> list=null;
		Criteria criteria = session.createCriteria(Theater.class);		
		list = criteria.list();
		
//		NativeQuery Query = session.createSQLQuery("SELECT * FROM movie inner join theater on movie.t_name = theater.tname;");
//		list = Query .list();
//		System.out.println(list);
//		System.out.println(list);
		return list;
	}

	@Override
	public Theater getTheaterByName(String Tname) {
		Theater theater=null;
		Session session = null;
		try {
			session = sf.openSession();
			session.beginTransaction().commit();			
			theater = session.get(Theater.class, Tname);
//			System.out.println(theater);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return theater;
	}
	
}


