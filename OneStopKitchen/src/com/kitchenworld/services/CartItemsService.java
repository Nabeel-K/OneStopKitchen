/*
 * Filename: CartItemsService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * 
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.CartItems;

/**
 * @author Nabeel
 *
 */
public class CartItemsService extends AbstractServices {
	
	public CartItemsService() {
		super();
	}
	
	public void addCartItem(CartItems item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public CartItems findCartItemsById(Long id) {
		Query getCartItems = em.createNamedQuery("CartItems.findById");
		getCartItems.setParameter("selectId", id);
		List<CartItems> results = getCartItems.getResultList();

		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<CartItems> findAllCartItems() {
		Query getCartItems = em.createNamedQuery("CartItems.findAll");
		return getCartItems.getResultList();
	}

	public void updateCartLineNumber(Long id, Integer lineNumber) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setLineNumber(lineNumber);
		em.getTransaction().commit();
	}

	public void updatePriceEach(Long id, double newPrice) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setPriceEach(newPrice);
		em.getTransaction().commit();
	}

	public void updateQuantityDetails(Long id, int quantity) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setQuantity(quantity);
		em.getTransaction().commit();
	}

	public void updateSKU(Long id, String newSku) {
		em.getTransaction().begin();
		CartItems itemsToUpdate = em.find(CartItems.class, id);
		itemsToUpdate.setSkuNumber(newSku);
		em.getTransaction().commit();
	}

	public void deleteCartItems(Long id) {
		Query deleteCartItems = em.createNamedQuery("CartItems.deleteById");
		deleteCartItems.setParameter("deleteId", id);
		deleteCartItems.executeUpdate();
	}

}
