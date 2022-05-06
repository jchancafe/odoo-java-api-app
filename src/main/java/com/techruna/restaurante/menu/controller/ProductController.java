package com.techruna.restaurante.menu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odoojava.api.Row;
import com.odoojava.api.RowCollection;
import com.techruna.restaurante.menu.service.PartnerService;
import com.techruna.restaurante.menu.service.ProductService;

@Controller
public class ProductController {
	private static final Logger log = LogManager.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@RequestMapping("inicioProductos")
	public String inicio() {
		log.info("inicio de ProductController");
		try {
			RowCollection rowCollection = productService.obtenerProducts(new String[] {});
			for(Row row : rowCollection) {
				log.info(row.getFieldsOdoo());
			}
			//log.info(rowCollection. .getFieldsOdoo());
			//return row.getFields().toString();
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
