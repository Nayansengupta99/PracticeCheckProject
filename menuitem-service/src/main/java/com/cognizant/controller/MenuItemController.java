package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.MenuItem;
import com.cognizant.service.MenuItemService;

@RestController
@RequestMapping("menuItem")
public class MenuItemController {
@Autowired
private MenuItemService menuItemService;

@GetMapping("/details")
public List<MenuItem> getMenuItemListCustomer(){
	return menuItemService.findAll();
}
@GetMapping("/{id}")
public Optional<MenuItem> getMenuItemById(@PathVariable Long id) {
	return menuItemService.findById(id);
	
}
@PostMapping("/add")
public MenuItem addMenuItem(@RequestBody MenuItem newItem) {
	return menuItemService.save(newItem);
}

@PutMapping("/{id}")
public MenuItem updateMenuItem(@PathVariable("id") Long id,@RequestBody MenuItem menuItem) {
	
	return menuItemService.updateMenuItem(id, menuItem);
}
@DeleteMapping("/{id}")
public String deleteMenuItemById(@PathVariable Long id) {
	
	return menuItemService.deleteMenuItem(id);
	
}



}
