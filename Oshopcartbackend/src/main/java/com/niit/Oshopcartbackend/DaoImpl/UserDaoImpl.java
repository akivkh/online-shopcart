package com.niit.Oshopcartbackend.DaoImpl;

import java.util.List;

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
	public User getByEmail(String email) {
		String selectQuery="FROM User WHERE email= :email";
		 try {
			 return sessionFactory.getCurrentSession()
					 .createQuery(selectQuery,User.class)
					     .setParameter("email", email)
					    .getSingleResult();
			 
		 }
		 catch(Exception ex) {
			 //ex.printStackTrace();
			 return null;
		 }
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery="FROM Address WHERE userid = :user AND billing = :billing";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("user", userId)
					  .setParameter("billing", true)
					     .getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery="FROM Address WHERE userid = :user AND shipping = :shipping";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("user", userId)
					  .setParameter("shipping", true)
					    .getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public Address getAddress(int addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, addressId);
		}
		catch(Exception ex) {
			System.out.println();
			return  null;
		}
	}

	@Override
	public Boolean updateAddress(Address address) {
	
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
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
			return false;
		}
	}
}
