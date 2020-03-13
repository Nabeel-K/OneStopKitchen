/**
 * Filename: TestCartItemsService.java
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

import com.kitchenworld.entity.CartItems;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;

/**
 * @author Nabeel
 *
 */
class TestCartITemsService {
	CartItemsService cis;
	CartItems item;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cis = new CartItemsService();
		CartService cs = new CartService();
		item = new CartItems(1, 5, 39.99, "LE90023", cs.findCartById(2L));
		cs.closeConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		cis.closeConnection();
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#addCartItem(com.kitchenworld.entity.CartItems)}.
	 */
	@Test
	void testAddCartItemAndFindById() {
		CartItems expected = item;
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		assertEquals(expected, cis.findCartItemsById(idToTest),"Item found should match item added");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#findAllCartItems()}.
	 */
	@Test
	void testFindAllCartItems() {
		cis.addCartItem(item);
		List<CartItems> items = cis.findAllCartItems();

		assertNotNull(items, "List should not be null");
		assertTrue(items.contains(item), "List of items should contain added item");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#findMaxItemLineNumber(com.kitchenworld.entity.User)}.
	 */
	@Test
	void testFindMaxItemLineNumber() {
		cis.addCartItem(item);
		
		int maxLineNumber = cis.findMaxItemLineNumber(item.getCart().getUser());
		
		assertTrue(maxLineNumber > 0, "Line number should be greater than 0 given the one added item");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#updateCartLineNumber(java.lang.Long, java.lang.Integer)}.
	 */
	@Test
	void testUpdateCartLineNumber() {
		//given
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		//when
		Integer newLineNo = 19;
		cis.updateCartLineNumber(idToTest, newLineNo);
		assertTrue(item.getLineNumber().equals(newLineNo),"Updated cart item should have a new line number");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#updatePriceEach(java.lang.Long, double)}.
	 */
	@Test
	void testUpdatePriceEach() {
		//given
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		//when
		double newPrice = 1.19;
		cis.updatePriceEach(idToTest, newPrice);
		assertTrue(item.getPriceEach() == newPrice,"Updated cart item should have a new price");	
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#updateQuantityDetails(java.lang.Long, int)}.
	 */
	@Test
	void testUpdateQuantityDetails() {
		//given
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		//when
		int newQuantity = 123;
		cis.updateQuantityDetails(idToTest, newQuantity);
		assertTrue(item.getQuantity() == newQuantity,"Updated cart item should have a new quantity");		
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#updateSKU(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateSKU() {
		//given
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		//when
		String newSku = "AnotherItem";
		cis.updateSKU(idToTest, newSku);
		assertTrue(item.getSkuNumber().equals(newSku),"Updated cart item should have a new sku number");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartItemsService#deleteCartItems(com.kitchenworld.entity.CartItems)}.
	 */
	@Test
	void testDeleteCartItems() {
		cis.addCartItem(item);
		long idToTest = item.getId();
		
		cis.deleteCartItems(item);
		CartItems deletedItem = cis.findCartItemsById(idToTest);
		assertNull(deletedItem, "Item should be removed and not returned");
	}
	

}
