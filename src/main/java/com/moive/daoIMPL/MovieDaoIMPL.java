package com.moive.daoIMPL;

import java.util.List;

import javax.management.Query;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moive.dao.MovieDao;
import com.moive.entity.Movie;
import com.moive.entity.User;

@Repository
public class MovieDaoIMPL implements MovieDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean addMovie(Movie movie) {
		
		boolean isAdded = false;
		Session session = null;		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(movie);
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
	public Movie getMovieByName(String movieName) {

		Movie movie=null;
		Session session = null;
		try {
			session = sf.openSession();
//			session.beginTransaction().commit();
			movie = session.get(Movie.class, movieName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return movie;
	}

	@Override
	public boolean deleteMovieByName(String movieName) {
		Movie movie=null;
		Session session = null;
		Boolean isDelted=false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			movie = session.get(Movie.class, movieName);
//			System.out.println(movie);
			if(movie!=null) {
				session.delete(movie);
				transaction.commit();
				isDelted=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return isDelted;
	}

	@Override
	public List<Movie> getAllMovie() {
		Session session = null;
		List<Movie> listMovie=null;
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Movie.class);
			listMovie=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return listMovie;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		boolean isUpdated = false;
		Session session=null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Movie dbmovie = getMovieByName(movie.getMovieName());

			if(dbmovie != null) {
				
				session.update(movie);
				transaction.commit();
				isUpdated=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return isUpdated;
	}

}
