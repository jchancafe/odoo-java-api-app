package com.techruna.restaurante.menu.service;

import com.odoojava.api.Row;
import com.odoojava.api.RowCollection;

public interface ProductService {

	public Row obtenerProduct(String id) throws Exception;
	
	public Row obtenerProduct(String id, String[] listaCampos) throws Exception;
	
	public RowCollection obtenerProducts(String[] listaCampos) throws Exception ;
	
	//public void registrarPartner() throws Exception ;
	
}