package com.cognizant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menuitems")
@Data
public class MenuItem {
	@Id
	@Column(name = "id")

	private long id;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "price")
	@NotNull
	private float price;
	@Column(name = "actv")
	@NotNull
	private boolean actv;

	@Column(name = "dateoflaunch")
	@NotNull
	private Date dateOfLaunch;
	@Column(name = "category")
	@NotNull
	private String category;
	@Column(name = "freedelivery")
	@NotNull
	private boolean freeDelivery;

}