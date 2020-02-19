/**
 * 
 */
package com.kitchenworld.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import com.kitchenworld.entity.Shipment;

/**
 * @author Nabeel
 *
 */
public class ShipmentService extends AbstractServices {
	public void addShipment(Shipment shipment) {
		em.getTransaction().begin();
		em.persist(shipment);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Shipment findOrderById(Long id) {
		Query getShipment = em.createNamedQuery("Shipment.findById");
		getShipment.setParameter("selectId", id);
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

	public void deleteShipment(Long id) {
		Query deleteShipment = em.createNamedQuery("Shipment.deleteById");
		deleteShipment.setParameter("deleteId", id);
		deleteShipment.executeUpdate();
	}
}
