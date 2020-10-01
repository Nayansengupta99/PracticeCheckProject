package com.cognizant.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.model.MenuItem;

@FeignClient(name="menuitem-service",url="${feign.url}")
public interface MenuFeignClient {
	@GetMapping("/menuitems")
	public List<MenuItem> getMenuItemListCustomer();
}
