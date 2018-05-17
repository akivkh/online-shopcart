package com.niit.Oshopcartbackend.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Oshopcartbackend.Dao.UserDao;
import com.niit.Oshopcartbackend.model.Address;
import com.niit.Oshopcartbackend.model.Cart;
import com.niit.Oshopcartbackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery="FROM User WHERE email= :email";
		 try {
			 return sessionFactory.getCurrentSession()
					 .createQuery(selectQuery,User.class)
					     .setParameter("email", email)
					    .getSingleResult();
			 
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
			 return null;
		 }
	}
	

}
