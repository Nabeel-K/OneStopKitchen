/*
 * Filename: AbstractServices.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.services;

import javax.persistence.*;

/**
 * @author Nabeel
 *
 */
public class AbstractServices {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractServices(){
		this.connect();
	}
	
	public void connect() {
		emf = Persistence.createEntityManagerFactory("OneStopKitchen");
		em = emf.createEntityManager();
	}
	
	public void closeConnection() {
		em.close();
		emf.close();
	}
}
