package com.app.items.services;

import java.util.List;
import com.app.items.models.Items;

public interface IServicesItem {
	
	public List<Items> findAll();
	public Items findById(Long id, Integer cantidad);
	
}
