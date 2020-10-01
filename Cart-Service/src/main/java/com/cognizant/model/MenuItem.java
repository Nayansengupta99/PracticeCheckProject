package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class MenuItem {

	private long id;

	private String name;

	private double price;

	private boolean actv;

	private String dateOfLaunch;

	private String category;

	private String freeDelivery;

}