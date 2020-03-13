/**
 * Filename: TestOrdersService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.OrderDetailsService;
import com.kitchenworld.services.OrdersService;
import com.kitchenworld.services.UserService;

/**
 * @author Nabeel
 *
 */
class TestOrdersService {
	OrdersService os;
	Orders order;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		os = new OrdersService();
		order = new Orders(new Date(), "PROCESSING", null, null);
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		os.closeConnection();
		
		order = null;
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#addOrder(com.kitchenworld.entity.Orders)}.
	 */
	@Test
	void testAddOrder() {
		//Given order from setUp method
		//when
		os.addOrder(order);
		List<Orders> orders = os.findAllOrders();
		assertTrue(orders.contains(order), "The order added should be in the list");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#findAllOrders()}.
	 */
	@Test
	void testFindAllOrders() {
		//given
		Orders order1 = new Orders(new Date(), "PROCESSING", null, null);
		Orders order2 = new Orders(new Date(), "SHIPPED", null, null);
		Orders order3 = new Orders(new Date(), "CANCELLED", null, null);
		
		os.addOrder(order1);
		os.addOrder(order2);
		os.addOrder(order3);
		
		//When
		List<Orders> actualOrders= os.findAllOrders();
		
		assertTrue(actualOrders.contains(order1), "Orders added should be retrieved in find all");
		assertTrue(actualOrders.contains(order2), "Orders added should be retrieved in find all");
		assertTrue(actualOrders.contains(order3), "Orders added should be retrieved in find all");
	}
	
	@Test
	void testFindById() {
		//given
		os.addOrder(order);
		long idToTest = order.getOrderId();
		//when
		Orders actualOrder = os.findOrderById(idToTest);
		assertTrue(actualOrder.equals(order),"The order retrieved should match the order added");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#findAllOrderDetailsInOrder(java.lang.Long)}.
	 */
	@Test
	void testFindAllOrderDetailsInOrderAndUpdateList() {
		//given
		OrderDetail details1 =  new OrderDetail(1,22.22,3,"123",order);
		OrderDetail details2 =  new OrderDetail(1,22.22,3,"456",order);
		List<OrderDetail> orderDetails = new ArrayList<>();
		OrderDetailsService ods = new OrderDetailsService();
		//when
		os.addOrder(order);
		
		long idToTest = order.getOrderId();
		
		orderDetails.add(details1);
		ods.addOrderDetails(details1);
		orderDetails.add(details2);
		ods.addOrderDetails(details2);
		os.updateOrderDetailsList(idToTest, orderDetails);
		
		List<OrderDetail> actualDetails = os.findAllOrderDetailsInOrder(idToTest);
		ods.closeConnection();

		assertTrue(actualDetails.contains(details1));
		assertTrue(actualDetails.contains(details2));
	}


	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#updateOrderDate(java.lang.Long, java.util.Date)}.
	 */
	@Test
	void testUpdateOrderDate() {
		//given 
		os.addOrder(order);
		long idToTest = order.getOrderId();
		//when
		Date newTimeStamp = new Date(980000000);
		os.updateOrderDate(idToTest, newTimeStamp);
		assertTrue(order.getDateOrdered() == newTimeStamp,"The updated order should have a new timestamp");
		
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#updateOrderStatus(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateOrderStatus() {
		//given 
		os.addOrder(order);
		long idToTest = order.getOrderId();
		//when
		String newStatus ="SHIPPED";
		os.updateOrderStatus(idToTest, newStatus);
		assertTrue(order.getOrderStatus() == newStatus,"The updated order should have a new status");
		
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#updateOrderUsers(java.lang.Long, com.kitchenworld.entity.User)}.
	 */
	@Test
	void testUpdateOrderUsers() {
		//given 
		os.addOrder(order);
		long idToTest = order.getOrderId();
		//when
		UserService us = new UserService();
		User newUser = us.findUserById(1L);
		os.updateOrderUsers(idToTest, newUser);
		
		us.closeConnection();
		assertNotNull(order.getUser());
	}

	/**
	 * Test method for {@link com.kitchenworld.services.OrdersService#deleteOrder(java.lang.Long)}.
	 */
	@Test
	void testDeleteOrder() {
		//given

		os.addOrder(order);
		long idToTest = order.getOrderId();
		
		//when
		os.deleteOrder(order);
		Orders deletedOrder = os.findOrderById(idToTest);
		assertNull(deletedOrder,"Order should be removed from retrieved list");
	}

}
