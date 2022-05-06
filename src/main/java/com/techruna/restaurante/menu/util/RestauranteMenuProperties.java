package com.techruna.restaurante.menu.util;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestauranteMenuProperties {
	private static final Logger log = LogManager.getLogger(RestauranteMenuProperties.class);
	private static final Properties properties;
	//public static String RESTAURANTE_MENU_PROPERTIES = "restaurante_menu/restaurante_menu.properties";
	public static String RESTAURANTE_MENU_PROPERTIES = "/home/d02/Proyectos/TECHRUNA/app.restaurante.menu/restaurante_menu/restaurante_menu.properties";
	
	public enum RestauranteMenuEnum {
		ODOO_PROTOCOLO("odoo.protocolo"),
		ODOO_DATABASE("odoo.database"),
		ODOO_USUARIO("odoo.usuario"),
		ODOO_PASSWORD("odoo.password"),
		ODOO_URL("odoo.url"),
		ODOO_PUERTO("odoo.puerto"),
		;
		
		private String key;

		RestauranteMenuEnum(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key;
        }
	}
	
	static {
        properties = new Properties();
        try {
            properties.putAll(PropertyFileUtil.load(RESTAURANTE_MENU_PROPERTIES));
        } catch (Exception e) {
        	log.error("No se encuentra el archivo '" + RESTAURANTE_MENU_PROPERTIES + "' en el classpath.", e);
        }
    }

    private RestauranteMenuProperties() {
    }

    public static String getProperty(RestauranteMenuEnum property) {
        return properties.getProperty(property.getKey());
    }
    
    public static int getIntProperty(RestauranteMenuEnum property) {
        return Integer.valueOf(properties.getProperty(property.getKey())).intValue();
    }
    
    public static long getLongProperty(RestauranteMenuEnum property) {
        return Long.valueOf(properties.getProperty(property.getKey())).longValue();
    }
    
    public static String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }
}
