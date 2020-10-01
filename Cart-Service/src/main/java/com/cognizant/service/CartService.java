package com.cognizant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.CartItemEmptyForUserException;
import com.cognizant.feign.MenuFeignClient;
import com.cognizant.model.Cart;

import com.cognizant.model.MenuItem;
import com.cognizant.repository.CartRepository;

@Service
public class CartService {

@Autowired
CartRepository cartRepo;

@Autowired
MenuFeignClient menuFeign;
public List<MenuItem> getMenuDetails(){
	return menuFeign.getMenuItemListCustomer();
	
}
public String addToCart(Long userid,Long id) {
	cartRepo.insertCartItems(userid, id);
	return "Menu Item with  Id " + Long.toString(id) + " successfully added in the cart";
}
public List<MenuItem> viewCartItems(Long userid, Cart cart){


	List<MenuItem> menuItems = menuFeign.getMenuItemListCustomer();
	List<Cart> cartItems = cartRepo.findById(userid);

	List<MenuItem> addedItems = menuItems.stream()
			.filter(items -> (cartItems).stream().anyMatch(menus -> menus.getId() == items.getId()))
			.collect(Collectors.toList());
	if (addedItems.size() > 0) {
		return addedItems;
	} else {
		throw new CartItemEmptyForUserException(userid);
	}
}
public String deleteFromCart(Long userid, Long id) {
	cartRepo.deleteById(id);
	return "Menu Item with Id " + Long.toString(id) + " successfully deleted from the cart";
}


}
