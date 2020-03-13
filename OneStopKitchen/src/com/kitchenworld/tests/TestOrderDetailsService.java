/**
 * Filename: TestOrderDetailsService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.services.OrderDetailsService;
import com.kitchenworld.services.OrdersService;

/**
 * @author Nabeel
 *
 */
class TestOrderDetailsService {
	OrderDetailsService ods = new OrderDetailsService();
	OrderDetail detail;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ods = new OrderDetailsService();
		OrdersService os = new OrdersService();
		detail = new OrderDetail(1, 25.50, 2, "GA213512", os.findOrderById(1L));
		os.closeConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		ods.deleteOrderDetails(detail);
		ods.closeConnection();
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#addOrderDetails(com.kitchenworld.entity.OrderDetail)}.
	 */
	@Test
	void testAddOrderDetailsAndFindById() {
		OrderDetail expected = detail;
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();

		assertEquals(ods.findOrderDetailsById(idToTest), expected, "found detail should match added detail");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#findAllOrderDetails()}.
	 */
	@Test
	void testFindAllOrderDetails() {
		ods.addOrderDetails(detail);
		List<OrderDetail> details = ods.findAllOrderDetails();

		assertNotNull(details, "List should not be null");
		assertTrue(details.contains(detail), "List of details should include added detail");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#updateOrderLineNumber(java.lang.Long, java.lang.Integer)}.
	 */
	@Test
	void testUpdateOrderLineNumber() {
		// given
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();
		// when
		int newLineNumber = 13;
		ods.updateOrderLineNumber(idToTest, newLineNumber);
		assertTrue(detail.getLineNumber().equals(newLineNumber), "The updated detail should have a new line number");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#updatePriceEach(java.lang.Long, double)}.
	 */
	@Test
	void testUpdatePriceEach() {
		// given
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();
		// when
		double newPrice = 13.13;
		ods.updatePriceEach(idToTest, newPrice);
		assertTrue(detail.getPriceEach() == newPrice, "The updated detail should have a new price");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#updateQuantityDetails(java.lang.Long, int)}.
	 */
	@Test
	void testUpdateQuantityDetails() {
		// given
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();
		// when
		int newQuantity = 13;
		ods.updateQuantityDetails(idToTest, newQuantity);
		assertTrue(detail.getQuantityOrdered() == newQuantity, "The updated detail should have a new quantity ordered");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#updateSKU(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateSKU() {
		// given
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();
		// when
		String newSKU = "AnotherName";
		ods.updateSKU(idToTest, newSKU);
		assertTrue(detail.getSkuNumber().equals(newSKU), "The updated detail should have a new SKU");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.OrderDetailsService#deleteOrderDetails(java.lang.Long)}.
	 */
	@Test
	void testDeleteOrderDetails() {
		// given
		ods.addOrderDetails(detail);
		long idToTest = detail.getId();	
		
		//when
		ods.deleteOrderDetails(detail);
		OrderDetail deletedDetail = ods.findOrderDetailsById(idToTest);
		assertNull(deletedDetail,"Detail should be removed and not returned");
	}

}
