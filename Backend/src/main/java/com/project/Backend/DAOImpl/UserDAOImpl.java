package com.project.Backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.Backend.DAO.UserDAO;
import com.project.Backend.Model.Address;
import com.project.Backend.Model.Cart;
import com.project.Backend.Model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddresss(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
//
//	@Override
//	public boolean add(Cart cart) {
//		try {
//			sessionFactory.getCurrentSession().persist(cart);
//
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}


	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email =:email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId= :userId AND billing= :billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("userId", userId)
					.setParameter("billing", true).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> listShiipingAddress(int  userId) {
		String selectQuery = "FROM Address WHERE userId= :user AND shipping= :shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("userId", userId)
					.setParameter("shipping", true).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
