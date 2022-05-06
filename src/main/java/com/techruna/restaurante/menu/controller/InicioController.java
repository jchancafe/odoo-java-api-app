package com.techruna.restaurante.menu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odoojava.api.Row;
import com.techruna.restaurante.menu.service.PartnerService;

@Controller
public class InicioController {
	private static final Logger log = LogManager.getLogger(InicioController.class);
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping("inicio")
	public String inicio() {
		log.info("inicio de InicioController");
		try {
			Row row = partnerService.obtenerPartner("1");
			log.info(row.getFieldsOdoo());
			//partnerService.registrarPartner(new String[]{"name", "ref", "email", "field1", "field2"});
//			partnerService.obtenerPartners();
			//partnerService.registrarPartner();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inicio";
	}
}
