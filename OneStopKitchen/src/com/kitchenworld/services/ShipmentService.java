/*
 * Filename: ShipmentService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-13-20 Updated delete method
 * 
 * */
package com.kitchenworld.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import com.kitchenworld.entity.Shipment;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * @author Nabeel
 *
 */
public class ShipmentService extends AbstractServices {

	public ShipmentService() {
		super();
	}

	public void addShipment(Shipment shipment) {
		em.getTransaction().begin();
		em.persist(shipment);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Shipment findOrderById(Long id) {
		Query getShipment = em.createNamedQuery("Shipment.findById");
		getShipment.setParameter(SELECT_ID, id);
		List<Shipment> results = getShipment.getResultList();

		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Shipment> findAllOrders() {
		Query getShipment = em.createNamedQuery("Shipment.findAll");
		return getShipment.getResultList();
	}

	public void updateShipDate(Long id, Date newDate) {
		em.getTransaction().begin();
		Shipment shipmentToUpdate = em.find(Shipment.class, id);
		shipmentToUpdate.setDateShipped(newDate);
		em.getTransaction().commit();
	}

	public void updateShipmentDevliveryDate(Long id, Date newDate) {
		em.getTransaction().begin();
		Shipment shipmentToUpdate = em.find(Shipment.class, id);
		shipmentToUpdate.setDateDelivered(newDate);
		em.getTransaction().commit();
	}

	public void deleteShipment(Shipment shipment) {
		em.getTransaction().begin();
		em.remove(shipment);
		em.getTransaction().commit();
	}
}
