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
import com.techruna.restaurante.menu.service.ProductService;
import com.techruna.restaurante.menu.service.SessionOdooService;
import com.techruna.restaurante.menu.util.Constantes;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private SessionOdooService sessionOdooService;
	private static final Logger logger = LogManager.getLogger(PartnerServiceImpl.class);
	
	@Override
	public Row obtenerProduct(String id) throws Exception {
		Row row = this.obtenerProduct(id, new String[] {});
		return row;
	}

	@Override
	public Row obtenerProduct(String id, String[] listaCampos) throws Exception {
		logger.info("obtener product");
		Row row = null;
		try {
			Session session = sessionOdooService.getSession();
			session.startSession();
			ObjectAdapter objectAdapter = session.getObjectAdapter(Constantes.MODEL_PRODUCT_TEMPLATE);
			FilterCollection filter = new FilterCollection();
			filter.add("id", "=", id);
			RowCollection rowCollection = objectAdapter.searchAndReadObject(filter, listaCampos);
			if(rowCollection != null && rowCollection.size() > 0) {
				return rowCollection.get(0);
			}
		} catch (XmlRpcException | OdooApiException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public RowCollection obtenerProducts(String[] listaCampos) throws Exception {
		RowCollection rowCollection = null;
		try {
			Session session = sessionOdooService.getSession();
			session.startSession();
			
			ObjectAdapter objectAdapter = session.getObjectAdapter(Constantes.MODEL_PRODUCT_TEMPLATE);
			FilterCollection filter = new FilterCollection();
			rowCollection = objectAdapter.searchAndReadObject(filter, new String[]{});
			if(rowCollection != null && rowCollection.size() > 0) {
				return rowCollection;
			}
		} catch (XmlRpcException | OdooApiException e) {
			e.printStackTrace();
		}
		return rowCollection;
	}

}
