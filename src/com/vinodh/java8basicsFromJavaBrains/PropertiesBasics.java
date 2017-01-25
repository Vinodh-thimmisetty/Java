package com.vinodh.java8basicsFromJavaBrains;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.omg.CORBA.Environment;

public class PropertiesBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 Properties properties = new Properties();
	 properties.setProperty("name", "vinodh");
	 properties.setProperty("email", "jaffa@ti.com");
	 properties.setProperty("phone", "1234");
	 
	 if(properties.contains("vinodh")){
		 System.out.println("Name is found");
		 System.out.println("total key-values--->"+properties.size());
		 System.out.println(properties.get("name"));
	 }
	 System.out.println("-----------");
	 Enumeration<Object> enusm = properties.keys();
	 while(enusm.hasMoreElements()){
		 System.out.println(enusm.nextElement());
	 }
	 System.out.println("-----------");
	 Enumeration<?> enumeration = properties.propertyNames();
	 while(enumeration.hasMoreElements()){
		 System.out.println("prop-->"+enumeration.nextElement());
	 }
	 System.out.println("-----------");
	 Iterator<Entry<Object,Object>> entries = properties.entrySet().iterator();
	while(entries.hasNext()){
		System.out.println("entry set--->"+entries.next()); 
	}
	 	System.out.println("-----------");
		System.out.println(properties.remove("phone")); 
	
		
		// Querying Environment Variables
	Map<String, String> map = System.getenv();
	  
	for (String string : map.keySet()) {
		System.out.println(string+"-----map value------"+map.get(string));
	}
	
	System.out.println("user name-->"+System.getProperty("user.name"));
	System.out.println("other system properties--->"+System.getProperties());
	
	
	// Security Manager
	SecurityManager manager = System.getSecurityManager();
	// SecurityManager.checkExit to ensure that the current thread has permission to shut down the application.
	manager=null;
	// time
	System.out.println("current time--->"+System.currentTimeMillis());
	// to shutdown JVM
	// System.exit(0);
	}

}
