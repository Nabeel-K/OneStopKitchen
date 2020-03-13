/*
 * Filename: OrderDetailsService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-12-20 Updated delete method
 * 
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.OrderDetail;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for order detail entities
 * 
 * @author Nabeel
 *
 */
public class OrderDetailsService extends AbstractServices {

	public OrderDetailsService() {
		super();
	}

	/**
	 * Adds an order detail to the database
	 * 
	 * @param od detail to add to the database
	 */
	public void addOrderDetails(OrderDetail od) {
		em.getTransaction().begin();
		em.persist(od);
		em.getTransaction().commit();
	}

	/**
	 * @param id of the orderdetail to find
	 * @return the order detail given by the id
	 */
	@SuppressWarnings("unchecked")
	public OrderDetail findOrderDetailsById(Long id) {
		Query getOrderDetails = em.createNamedQuery("OrderDetail.findById");
		getOrderDetails.setParameter(SELECT_ID, id);
		List<OrderDetail> results = getOrderDetails.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @return all order details in database
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> findAllOrderDetails() {
		Query getOrderDetails = em.createNamedQuery("OrderDetail.findAll");
		return getOrderDetails.getResultList();
	}

	/**
	 * Updates a detail's line number
	 * 
	 * @param id         of detail to update
	 * @param lineNumber to replace old linenumber
	 */
	public void updateOrderLineNumber(Long id, Integer lineNumber) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setLineNumber(lineNumber);
		em.getTransaction().commit();
	}

	/**
	 * Updates a detail's price
	 * 
	 * @param id       of detail to update
	 * @param newPrice to replace old price
	 */
	public void updatePriceEach(Long id, double newPrice) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setPriceEach(newPrice);
		em.getTransaction().commit();
	}

	/**
	 * Updates a detail's quantity
	 * 
	 * @param id       of detail to update
	 * @param quantity to replace old quantity
	 */
	public void updateQuantityDetails(Long id, int quantity) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setQuantityOrdered(quantity);
		em.getTransaction().commit();
	}

	/**
	 * Updates a detail's skuNumber
	 * 
	 * @param id     of detail to update
	 * @param newSku to replace old skuNumber
	 */
	public void updateSKU(Long id, String newSku) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setSkuNumber(newSku);
		em.getTransaction().commit();
	}

	/**
	 * Removes an order detail from the database
	 * 
	 * @param detail to remove
	 */
	public void deleteOrderDetails(OrderDetail detail) {
		em.getTransaction().begin();
		em.remove(detail);
		em.getTransaction().commit();
	}

}
