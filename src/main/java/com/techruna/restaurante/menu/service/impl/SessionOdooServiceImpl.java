package com.techruna.restaurante.menu.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.odoojava.api.Session;
import com.odoojava.api.OdooXmlRpcProxy.RPCProtocol;
import com.techruna.restaurante.menu.service.SessionOdooService;
import com.techruna.restaurante.menu.util.RestauranteMenuProperties;

@Service("SessionOdooService")
public class SessionOdooServiceImpl implements SessionOdooService {
	private static final Logger log = LogManager.getLogger(SessionOdooServiceImpl.class);
	@Autowired
	private Environment env;
	/*private String ODOO_DATABASE = RestauranteMenuProperties.getProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_DATABASE);
	private String ODOO_PROTOCOLO = RestauranteMenuProperties.getProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_PROTOCOLO);
	private Integer ODOO_PUERTO = RestauranteMenuProperties.getIntProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_PUERTO);
	private String ODOO_URL = RestauranteMenuProperties.getProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_URL);
	private String ODOO_USUARIO = RestauranteMenuProperties.getProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_USUARIO);
	private String ODOO_PASSWORD = RestauranteMenuProperties.getProperty(RestauranteMenuProperties.RestauranteMenuEnum.ODOO_PASSWORD);*/

	@Override
	public Session getSession() {
		String ODOO_PROTOCOLO =  env.getProperty("odoo.protocolo");
		String ODOO_DATABASE =  env.getProperty("odoo.database");
		String ODOO_USUARIO =  env.getProperty("odoo.usuario");
		String ODOO_PASSWORD =  env.getProperty("odoo.password");
		String ODOO_PUERTO =  env.getProperty("odoo.puerto");
		String ODOO_URL =  env.getProperty("odoo.url");
		
		log.info("getSession");
		RPCProtocol protocol = RPCProtocol.RPC_HTTPS;
		if(ODOO_PROTOCOLO.equalsIgnoreCase("http")) {
			protocol = RPCProtocol.RPC_HTTP;
		}
		Session session = new Session(protocol, ODOO_URL,new Integer(ODOO_PUERTO), ODOO_DATABASE, ODOO_USUARIO, ODOO_PASSWORD);
		try {
			log.info(session.getServerVersion());
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

}
