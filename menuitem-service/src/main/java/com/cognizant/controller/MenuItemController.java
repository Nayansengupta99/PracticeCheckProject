package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.model.MenuItem;
import com.cognizant.repository.MenuItemRepository;
import com.cognizant.service.MenuItemService;

@Controller
@RequestMapping("menuitems")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private MenuItemRepository menuRepo;

	@GetMapping("/")
	public String getMenuDetails(ModelMap model) {

		model.addAttribute("menuItem", menuItemService.findAll());
		return "adminmenuitem";

	}

	@GetMapping("/admin/add")
	public String add(@ModelAttribute("add") MenuItem newItem) {

		return "adminaddmenuitem";
	}

	@PostMapping("/admin/add")
	public String addMenuItem(Model model, @ModelAttribute("add") MenuItem newItem) {

		menuItemService.save(newItem);
		return "redirect:/menuitems/";

	}

	@GetMapping("/admin/delete")
	public String getDeletePage(Model model, @ModelAttribute("delete") MenuItem menuItem) {
		model.addAttribute("list", menuItemService.findAll());
		return "admindeletemenu";
	}

	@PostMapping("/admin/delete")
	public String deleteMenuItem(Model model, @ModelAttribute("delete") MenuItem newMenu) {
		model.addAttribute("list", menuItemService.findAll());
		menuRepo.deleteByName(newMenu.getName());
        return "redirect:/menuitems/";
	}

}
