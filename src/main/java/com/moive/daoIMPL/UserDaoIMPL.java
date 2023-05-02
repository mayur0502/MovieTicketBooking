package com.moive.daoIMPL;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moive.dao.UserDao;
import com.moive.entity.Movie;
import com.moive.entity.User;

@Repository
public class UserDaoIMPL implements UserDao{
	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean adduser(User user) {

		boolean isAdded = false;
		Session session = null;		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
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
	public User getUser(String email) {
		boolean isAdded = false;
		Session session = null;
		User user=null;
		try {
			session=sf.openSession();
			user = session.get(User.class, email);
//			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			if(session!=null) {
				session.close();
			}
		}	
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isUpdated = false;
		Session session=null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			User dbuser= getUser(user.getName());

			if(dbuser != null) {
				
				session.update(user);
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


