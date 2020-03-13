/*
 * Filename: OrdersService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-12-20 Updated delete method
 *
 * 
 * */
package com.kitchenworld.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.Shipment;
import com.kitchenworld.entity.User;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for Order entities
 * 
 * @author Nabeel
 *
 */
@SuppressWarnings("unchecked")
public class OrdersService extends AbstractServices {

	public OrdersService() {
		super();
	}

	/**
	 * Adds an order to the database
	 * 
	 * @param order to add
	 */
	public void addOrder(Orders order) {
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}

	/**
	 * @param id of order to find
	 * @return order defined by given id
	 */
	public Orders findOrderById(Long id) {
		Query getOrder = em.createNamedQuery("Orders.findById");
		getOrder.setParameter(SELECT_ID, id);
		List<Orders> results = getOrder.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @return all orders in the database
	 */
	public List<Orders> findAllOrders() {
		Query getOrders = em.createNamedQuery("Orders.findAll");
		return getOrders.getResultList();
	}

	/**
	 * @param id of the order to search
	 * @return all orderDetails in the order
	 */
	public List<OrderDetail> findAllOrderDetailsInOrder(Long id) {
		Query getDetails = em.createQuery(QUERY_ORDER_DETAILS + " JOIN od.order o WHERE o.orderId = :selectId");
		getDetails.setParameter(SELECT_ID, id);
		return getDetails.getResultList();
	}

	/**
	 * NOT YET IMPLEMENTED
	 * 
	 * @param id of the order to search
	 * @return all shipments belonging to this order
	 */
	public List<Shipment> findAllShipmentsInOrder(Long id) {
		Query getShipments = em.createQuery("SELECT s from Shipment s JOIN s.order o WHERE o.orderId = :selectId");
		getShipments.setParameter(SELECT_ID, id);
		return getShipments.getResultList();
	}

	/**
	 * Updates the date the order was placed on
	 * 
	 * @param id      of the order to update
	 * @param newDate to replace the old date
	 */
	public void updateOrderDate(Long id, Date newDate) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setDateOrdered(newDate);
		em.getTransaction().commit();
	}

	/**
	 * Updates the status of the order
	 * 
	 * @param id     of the order to update
	 * @param status to replace the old status
	 */
	public void updateOrderStatus(Long id, String status) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setOrderStatus(status);
		em.getTransaction().commit();
	}

	/**
	 * Updates the list of details in the order
	 * 
	 * @param id         of the order to update
	 * @param newDetails to replace the old details
	 */
	public void updateOrderDetailsList(Long id, List<OrderDetail> newDetails) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setOrderDetails(newDetails);
		em.getTransaction().commit();
	}

	/**
	 * NOT IMPLEMENTED Updates the shipments of the order
	 * 
	 * @param id           of the order to update
	 * @param newShipments to replace the old shipments
	 */
	public void updateOrderShipmentDetails(Long id, List<Shipment> newShipmentDetails) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setShipments(newShipmentDetails);
		em.getTransaction().commit();
	}

	/**
	 * Updates the user of the order
	 * 
	 * @param id   of the order to update
	 * @param user to replace the old user
	 */
	public void updateOrderUsers(Long id, User user) {
		em.getTransaction().begin();
		Orders orderToUpdate = em.find(Orders.class, id);
		orderToUpdate.setUser(user);
		em.getTransaction().commit();
	}

	/**
	 * Removes order from the database
	 * 
	 * @param order to delete
	 */
	public void deleteOrder(Orders order) {
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();
	}

}
