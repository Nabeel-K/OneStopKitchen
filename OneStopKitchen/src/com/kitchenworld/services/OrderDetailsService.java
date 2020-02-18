/**
 * 
 */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.OrderDetail;

/**
 * @author Nabeel
 *
 */
public class OrderDetailsService extends AbstractServices{
	public void addOrderDetails(OrderDetail od) {
		em.getTransaction().begin();
		em.persist(od);
		em.getTransaction().commit();
	}
	

	@SuppressWarnings("unchecked")
	public OrderDetail findOrderById(Long id) {
		Query getOrderDetails = em.createNamedQuery("OrderDetail.findById");
		getOrderDetails.setParameter("selectId", id);
		List<OrderDetail> results = getOrderDetails.getResultList();
		
		return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> findAllOrderDetails(){
		Query getOrderDetails = em.createNamedQuery("OrderDetail.findAll");
		return getOrderDetails.getResultList();
	}
	
	public void updateOrderLineNumber(Long id, Integer lineNumber) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setLineNumber(lineNumber);
		em.getTransaction().commit();
	}
	
	public void updatePriceEach (Long id, double newPrice) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setPriceEach(newPrice);
		em.getTransaction().commit();
	}
	
	public void updateQuantityDetails (Long id, int quantity) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setQuantityOrdered(quantity);
		em.getTransaction().commit();
	}
	
	public void updateSKU (Long id, String newSku) {
		em.getTransaction().begin();
		OrderDetail detailsToUpdate = em.find(OrderDetail.class, id);
		detailsToUpdate.setSkuNumber(newSku);
		em.getTransaction().commit();
	}
	
	public void deleteOrderDetails(Long id) {
		Query deleteOrderDetails = em.createNamedQuery("OrderDetail.deleteById");
		deleteOrderDetails.setParameter("deleteId", id);
		deleteOrderDetails.executeUpdate();
	}
	
	
}
