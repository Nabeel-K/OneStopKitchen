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

/**
 * @author Nabeel
 *
 */
@SuppressWarnings("unchecked")
public class CartItemsService extends AbstractServices {
	
	public CartItemsService() {
		super();
	}
	
	public void addCartItem(CartItems item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}

	public CartItems findCartItemsById(Long id) {
		Query getCartItems = em.createNamedQuery("CartItems.findById");
		getCartItems.setParameter("selectId", id);
		List<CartItems> results = getCartItems.getResultList();

		return results.get(0);
	}

	public List<CartItems> findAllCartItems() {
		Query getCartItems = em.createNamedQuery("CartItems.findAll");
		return getCartItems.getResultList();
	}
	
	public int findMaxItemLineNumber(User user) {
		Query findItems = em.createQuery("SELECT MAX(ci.lineNumber) FROM CartItems ci JOIN Cart c"
				+ " JOIN User u WHERE u.userId = :selectId GROUP BY u.userId");
		findItems.setParameter("selectId", user.getUserId());
		
		int maxLines = (Integer)findItems.getResultList().get(0);
		
		if(maxLines > 0) {
			return maxLines;
		}
		
		return 0;
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

	public void deleteCartItems(CartItems item) {
//		Query deleteCartItems = em.createNamedQuery("CartItems.deleteById");
//		deleteCartItems.setParameter("deleteId", id);
//		deleteCartItems.executeUpdate();
		em.getTransaction().begin();
		em.remove(item);
		em.getTransaction().commit();
	}

}
