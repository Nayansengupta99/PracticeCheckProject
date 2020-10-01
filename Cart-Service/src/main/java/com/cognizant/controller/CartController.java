package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.model.Cart;
import com.cognizant.model.MenuItem;
import com.cognizant.service.CartService;

@RestController
@RequestMapping("user")
public class CartController {

	@Autowired
	CartService cartService;

	@GetMapping("/menuitems")
	public List<MenuItem> getAllMenu() {
		return cartService.getMenuDetails();
	}
	
	@PostMapping("/cart/{userid}/{id}")
	public String addToCart(@PathVariable("userid") Long userid, @PathVariable("id") Long id) {

		return cartService.addToCart(userid,id);
		}
 
    @GetMapping("/cart/{userid}")
	public List<MenuItem> viewCartItems(@PathVariable("userid") Long userid, Cart cart) {
		return  cartService.viewCartItems(userid, cart);
	}

    @DeleteMapping("/cart/{userid}/{id}")
	public String deleteFromCart(@PathVariable("userid") Long userid, @PathVariable("id") Long id) {
		return cartService.deleteFromCart(userid,id);
	}






}
