package com.techruna.restaurante.menu.service;

import com.odoojava.api.Row;
import com.odoojava.api.RowCollection;

public interface PartnerService {
	
	public Row obtenerPartner(String id) throws Exception;
	
	public Row obtenerPartner(String id, String[] listaCampos) throws Exception;
	
	public RowCollection obtenerPartners() throws Exception ;
	
	public void registrarPartner() throws Exception ;
	
}
