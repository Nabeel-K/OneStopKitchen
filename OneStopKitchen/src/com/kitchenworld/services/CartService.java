/*
 * Filename: CartService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-03-20 Added deleteAllItemsFromCart method
 * 
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for cart entities
 * 
 * @author Nabeel
 *
 */
public class CartService extends AbstractServices {

	public CartService() {
		super();
	}

	/**
	 * Adds a cart to database
	 * 
	 * @param cart to add
	 */
	public void addCart(Cart cart) {
		em.getTransaction().begin();
		em.persist(cart);
		em.getTransaction().commit();
	}

	/**
	 * @param id to find
	 * @return the cart identified by the id
	 */
	@SuppressWarnings("unchecked")
	public Cart findCartById(Long id) {
		Query getCart = em.createNamedQuery("Cart.findById");
		getCart.setParameter(SELECT_ID, id);
		List<Cart> results = getCart.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @return all carts in database
	 */
	@SuppressWarnings("unchecked")
	public List<Cart> findAllCarts() {
		Query getCarts = em.createNamedQuery("Cart.findAll");
		return getCarts.getResultList();
	}

	/**
	 * @param id of cart to locate
	 * @return all items in cart given by id
	 */
	@SuppressWarnings("unchecked")
	public List<CartItems> findAllItemsInCart(Long id) {
		Query getDetails = em.createQuery(QUERY_CART_ITEMS + " JOIN ci.cart c WHERE c.cartId = :selectId");
		getDetails.setParameter(SELECT_ID, id);
		return getDetails.getResultList();
	}

	/**
	 * @param id       cart to update
	 * @param newItems to place in the cart
	 */
	public void updateCartItems(Long id, List<CartItems> newItems) {
		em.getTransaction().begin();
		Cart cartToUpdate = em.find(Cart.class, id);
		cartToUpdate.setCartItems(newItems);
		em.getTransaction().commit();
	}

	/**
	 * removes a cart from the database
	 * 
	 * @param cart to remove
	 */
	public void deleteCart(Cart cart) {
		em.getTransaction().begin();
		em.remove(cart);
		em.getTransaction().commit();
	}

}
