/*
 * Filename: CartItemsService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 2-27-20 Added method to get max line number of a user's cart
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.CartItems;
import com.kitchenworld.entity.User;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for cart item entities
 * 
 * @author Nabeel
 *
 */
@SuppressWarnings("unchecked")
public class CartItemsService extends AbstractServices {

	public CartItemsService() {
		super();
	}

	/**
	 * Adds a cart item to the database
	 * 
	 * @param item to add
	 */
	public void addCartItem(CartItems item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}

	/**
	 * @param id of the cart to find
	 * @return the cart item with given id
	 */
	public CartItems findCartItemsById(Long id) {
		Query getCartItems = em.createNamedQuery("CartItems.findById");
		getCartItems.setParameter(SELECT_ID, id);
		List<CartItems> results = getCartItems.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @return all items in the database
	 */
	public List<CartItems> findAllCartItems() {
		Query getCartItems = em.createNamedQuery("CartItems.findAll");
		return getCartItems.getResultList();
	}

	/**
	 * @param user the cart belongs to
	 * @return the maximum line number in a user's cart
	 */
	public int findMaxItemLineNumber(User user) {
		Query findItems = em.createQuery(QUERY_MAX_LINE_NUMBER);
		findItems.setParameter(SELECT_ID, user.getUserId());

		int maxLines = (Integer) findItems.getResultList().get(0);

		if (maxLines > 0) {
			return maxLines;
		}

		return 0;
	}

	/**
	 * Updates/changes a line number of a cart item in database
	 * 
	 * @param id         of cart to update
	 * @param lineNumber to replace existing linenumber
	 */
	public void updateCartLineNumber(Long id, Integer lineNumber) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setLineNumber(lineNumber);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes the price of a cart item in database
	 * 
	 * @param id       of cart to update
	 * @param newPrice
	 */
	public void updatePriceEach(Long id, double newPrice) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setPriceEach(newPrice);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes quantity of a cart item in database
	 * 
	 * @param id       of cart to update
	 * @param quantity
	 */
	public void updateQuantityDetails(Long id, int quantity) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setQuantity(quantity);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes SKU number of a cart item in database
	 * 
	 * @param id     of cart to update
	 * @param newSku to replace existing
	 */
	public void updateSKU(Long id, String newSku) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setSkuNumber(newSku);
		em.getTransaction().commit();
	}

	/**
	 * deletes an item from database
	 * 
	 * @param item to remove
	 */
	public void deleteCartItems(CartItems item) {
		em.getTransaction().begin();
		em.remove(item);
		em.getTransaction().commit();
	}

}
