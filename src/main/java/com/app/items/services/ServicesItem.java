package com.app.items.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.items.models.Items;
import com.app.items.models.Producto;

@Service

public class ServicesItem  implements IServicesItem{

		@Autowired
		private RestTemplate clienteRest;
		
		@Override
		public List<Items> findAll(){
			List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8082/api/productos", Producto[].class));
			return productos.stream().map(p -> new Items(p,1)).collect(Collectors.toList());
		}
		
		@Override
		public Items findById(Long id, Integer cantidad){
			Map<String, String> pathVariables = new HashMap<String, String>();
			pathVariables.put("id",id.toString());	
			Producto producto = clienteRest.getForObject("http://localhost:8082/api/productos/{id}",Producto.class, pathVariables);
			return new Items(producto, cantidad);
		}
}
























