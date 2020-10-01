package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Cart;
import com.cognizant.model.MenuItem;
import com.cognizant.service.CartService;

@Controller
@RequestMapping("userpanel")
public class WebMvcController {

@Autowired
CartService cartService;

@GetMapping("/")
public String showAllMenuItems(ModelMap model) {
	model.addAttribute("list", cartService.getMenuDetails());
	return "usermenuitem";
}
@PostMapping("/cart/1/{id}")
public String buyById(@PathVariable("id") Long id, Model model) {
	cartService.addToCart(1L, id);
	return "redirect:/userpanel/";
}
@GetMapping("/cartitems")
public String showCart( @RequestParam(value = "sum", required = false)Double sum, ModelMap model,Cart cart) {
	
List<MenuItem> items=cartService.viewCartItems(1L, cart);

Double s=0.0;
for(MenuItem i:items) {
	s=i.getPrice()+s;
}
sum=s;
model.put("sum",sum);
model.put("cartitem",items);
return "usercart";
}
@GetMapping("/cart/delete")
public String getDeletePage(Model model, @ModelAttribute("delete")Cart cart) {
	List<MenuItem> items=cartService.viewCartItems(1L, cart);
	model.addAttribute("list",items);
	return "deletecartitem";
}
@PostMapping("/cart/delete")
public String deleteMenuItem(Model model, @ModelAttribute("delete") Cart cart) {

	
	cartService.deleteFromCart(1L, cart.getId());
    return "redirect:/userpanel/cartitems";
}


}
