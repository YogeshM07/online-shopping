package net.kzn.shoppingBackend.dao;

import net.kzn.shoppingBackend.dto.Address;
import net.kzn.shoppingBackend.dto.Cart;
import net.kzn.shoppingBackend.dto.User;

public interface UserDAO {
	
	boolean addUase(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);

}
