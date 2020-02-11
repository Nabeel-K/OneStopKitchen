/**
 * 
 */
package com.kitchenworld.services;

import javax.persistence.*;

/**
 * @author Nabeel
 *
 */
public class AbstractServices {
	protected EntityManagerFactory emf = null;
	protected EntityManager em = null;
	
	public void connect() {
		emf = Persistence.createEntityManagerFactory("OneStopKitchen");
		em = emf.createEntityManager();
	}
	
	public void closeConnection() {
		em.close();
		emf.close();
	}
}
