package com.app.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.items.models.Items;
import com.app.items.services.ServicesItem;

@RestController
@RequestMapping("/api/item")
public class ItemsRestController {

	@Autowired
	private ServicesItem servicesItem;

	@GetMapping("")
	public List<Items> listar() {
		return servicesItem.findAll();
	}

	@GetMapping("{id}/cantidad/{cantidad}")
	public Items detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return servicesItem.findById(id, cantidad);
	}
}
