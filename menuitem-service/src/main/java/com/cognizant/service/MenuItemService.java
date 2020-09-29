package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.exception.MenuItemNotFoundException;
import com.cognizant.model.MenuItem;
import com.cognizant.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	MenuItemRepository menuRepo;

	public List<MenuItem> findAll() {

		return menuRepo.findAll();
	}

	public Optional<MenuItem> findById(Long id) {

		return menuRepo.findById(id);
	}

	public MenuItem save(MenuItem newItem) {
		// TODO Auto-generated method stub
		return menuRepo.save(newItem);
	}

	public MenuItem updateMenuItem(Long id, MenuItem newItem) {
		newItem.setId(id);
		return menuRepo.save(newItem);
	}

	public String deleteMenuItem(Long id) {

		if (menuRepo.findById(id).isPresent()) {
			menuRepo.deleteById(id);

			return "Menu id " + Long.toString(id) + " deleted successfully";

		} else {
			throw new MenuItemNotFoundException(id);
		}

	}

}
