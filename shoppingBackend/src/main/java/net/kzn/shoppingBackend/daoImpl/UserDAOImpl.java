package net.kzn.shoppingBackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingBackend.dao.UserDAO;
import net.kzn.shoppingBackend.dto.Address;
import net.kzn.shoppingBackend.dto.Cart;
import net.kzn.shoppingBackend.dto.User;


@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUase(User user) {
		try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
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
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		
		try {			
			sessionFactory.getCurrentSession().persist(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

}
