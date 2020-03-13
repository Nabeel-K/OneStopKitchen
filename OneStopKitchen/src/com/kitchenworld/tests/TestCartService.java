/**
 * Filename: TestCartService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;
import com.kitchenworld.services.UserService;

/**
 * @author Nabeel
 *
 */
class TestCartService {
	CartService cs;
	Cart cart;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cs = new CartService();
		UserService us = new UserService();
		cart = new Cart();
		cart.setUser(us.findUserById(1L));
		us.closeConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		cs.closeConnection();
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.CartService#addCart(com.kitchenworld.entity.Cart)}.
	 */
	@Test
	void testAddCartAndFindById() {
		Cart expected = cart;
		cs.addCart(cart);
		long idToTest = cart.getCartId();

		assertEquals(expected, cs.findCartById(idToTest), "Retrieved cart should match added cart");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CartService#findAllCarts()}.
	 */
	@Test
	void testFindAllCarts() {
		cs.addCart(cart);
		List<Cart> carts = cs.findAllCarts();

		assertNotNull(carts, "List should not be null");
		assertTrue(carts.contains(cart), "List of carts should contain added cart");
	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.CartService#findAllItemsInCart(java.lang.Long)}.
	 */
	@Test
	void testUpdateAndFindAllItemsInCart() {
		// Given
		cs.addCart(cart);
		long idToTest = cart.getCartId();
		CartItems cartItem1 = new CartItems(1, 5, 39.99, "TestITem", cart);
		CartItems cartItem2 = new CartItems(1, 2, 39.99, "ItemTest", cart);

		// When
		List<CartItems> items = new ArrayList<>();
		CartItemsService cis = new CartItemsService();
		items.add(cartItem1);
		cis.addCartItem(cartItem1);
		items.add(cartItem2);
		cis.addCartItem(cartItem2);
		cis.closeConnection();
		cs.updateCartItems(idToTest, items);

		assertEquals(items, cart.getCartItems(), "The expected items should match the addedd items");

		List<CartItems> actualItems = cs.findAllItemsInCart(idToTest);

		assertEquals(items, actualItems, "Items retrieved should belong to this cart and match added items");

	}

	/**
	 * Test method for
	 * {@link com.kitchenworld.services.CartService#deleteCart(com.kitchenworld.entity.Cart)}.
	 */
	@Test
	void testDeleteCart() {
		cs.addCart(cart);
		long idToTest = cart.getCartId();

		cs.deleteCart(cart);
		assertNull(cs.findCartById(idToTest),"Cart should be removed and not returned");
	}

}
