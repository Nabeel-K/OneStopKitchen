/**
 * OrdersService.java
 * DESC: DAO Services for Orders entities
 */
package com.kitchenworld.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.Shipment;

/**
 * @author Nabeel
 *
 */
public class OrdersService extends AbstractServices{
	public void addOrder(Orders order) {
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public Orders findOrderById(Long id) {
		Query getOrder = em.createNamedQuery("Orders.findById");
		getOrder.setParameter("selectId", id);
		List<Orders> results = getOrder.getResultList();
		
		return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> findAllOrders(){
		Query getOrders = em.createNamedQuery("Orders.findAll");
		return getOrders.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> findAllOrderDetailsInOrder(Long id){
		Query getDetails = em.createQuery("SELECT od from OrderDetail od JOIN od.order o WHERE o.orderId = :selectId");
		getDetails.setParameter("selectId", id);
		return getDetails.getResultList();
	}
	
	public void updateOrderDate(Long id, Date newDate) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setDateOrdered(newDate);
		em.getTransaction().commit();
	}
	
	public void updateOrderStatus(Long id, String status) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setOrderStatus(status);
		em.getTransaction().commit();
	}
	
	public void updateOrderDetailsList(Long id, List<OrderDetail> newDetails) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setOrderDetails(newDetails);
		em.getTransaction().commit();
	}
	
	public void updateOrderShipmentDetails(Long id, List<Shipment> newShipmentDetails) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setShipments(newShipmentDetails);
		em.getTransaction().commit();
	}
	
	public void deleteOrder(Long id) {
		Query deleteOrder = em.createNamedQuery("Orders.deleteById");
		deleteOrder.setParameter("deleteId", id);
		deleteOrder.executeUpdate();
	}
	
	
	
}
