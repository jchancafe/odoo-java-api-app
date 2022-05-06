package com.techruna.restaurante.menu.service;

import com.odoojava.api.Row;
import com.odoojava.api.RowCollection;

public interface PartnerService {
	
	public Row obtenerPartner(String id);
	
	public RowCollection obtenerPartners();
	
	public void registrarPartner();
	
}
