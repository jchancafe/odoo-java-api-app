package com.techruna.restaurante.menu.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoojava.api.FilterCollection;
import com.odoojava.api.ObjectAdapter;
import com.odoojava.api.OdooApiException;
import com.odoojava.api.Row;
import com.odoojava.api.RowCollection;
import com.odoojava.api.Session;
import com.techruna.restaurante.menu.service.PartnerService;
import com.techruna.restaurante.menu.service.SessionOdooService;
import com.techruna.restaurante.menu.util.Constantes;

@Service("partnerService")
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	private SessionOdooService sessionOdooService;
	private static final Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

	@Override
	public Row obtenerPartner(String id) throws Exception {
		Row row = this.obtenerPartner(id, new String[] {});
		return row;
	}

	@Override
	public Row obtenerPartner(String id, String[] listaCampos) throws Exception {
		Row row = null;
		try {
			Session session = sessionOdooService.getSession();
			session.startSession();
			ObjectAdapter objectAdapter = session.getObjectAdapter(Constantes.MODEL_RES_PARTNER);
			FilterCollection filter = new FilterCollection();
			filter.add("id", "=",id);
			RowCollection rowCollection = objectAdapter.searchAndReadObject(filter, listaCampos);
			if(rowCollection != null && rowCollection.size() > 0) {
				return rowCollection.get(0);
			}
		} catch (XmlRpcException | OdooApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	@Override
	public RowCollection obtenerPartners() throws Exception {
		RowCollection rowCollection = null;
		try {
			Session session = sessionOdooService.getSession();
			session.startSession();
			
			ObjectAdapter objectAdapter = session.getObjectAdapter(Constantes.MODEL_RES_PARTNER);
			FilterCollection filter = new FilterCollection();
			rowCollection = objectAdapter.searchAndReadObject(filter, new String[]{"name","email"});
			if(rowCollection != null && rowCollection.size() > 0) {
				return rowCollection;
			}
		} catch (XmlRpcException | OdooApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCollection;
	}

	@Override
	public void registrarPartner() throws Exception {
		try {
			Session session = sessionOdooService.getSession();
			session.startSession();
			
			ObjectAdapter partnerAdapter = session.getObjectAdapter(Constantes.MODEL_RES_PARTNER);
			
			Row newPartner = partnerAdapter.getNewRow(new String[]{"name", "ref", "email"});
			newPartner.put("name", "Jhon Doe");
			newPartner.put("ref", "Reference value");
			newPartner.put("email", "personalemail@mail.com");
			//newPartner.put("field1", "1");
			//newPartner.put("field2", "2");

			partnerAdapter.createObject(newPartner);

			// Getting fields for tracking/audit purposes
			//HashMap<String, Object> rowSaved = newPartner.getFieldsOdoo().toString();
			logger.info("new Partner id: " + newPartner.getID());

		} catch (XmlRpcException | OdooApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
