package com.techruna.restaurante.menu.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.odoojava.api.Row;
import com.techruna.restaurante.menu.service.PartnerService;

@Controller
public class PartnerController {
	private static final Logger log = LogManager.getLogger(PartnerController.class);
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping("/partner")
	public String index(HttpSession session) {
		log.info("inicio de PartnerController");
		try {
			Row row = partnerService.obtenerPartner("1", new String[]{"name", "ref", "email"});
			log.info(row.getFieldsOdoo());
			//model.addAttribute();
			session.setAttribute("partner", row);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "partner";
	}
}
