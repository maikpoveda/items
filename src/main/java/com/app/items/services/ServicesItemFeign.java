package com.app.items.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.items.clientes.ProductoClienteRest;
import com.app.items.models.Items;

public class ServicesItemFeign implements IServicesItem {

	@Autowired
	private ProductoClienteRest clienteFeing;

	@Override
	public List<Items> findAll() {
		return clienteFeing.listar().stream().map(p -> new Items(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Items findById(Long id, Integer cantidad) {
		return new Items(clienteFeing.ver(id), cantidad);
	}
}
