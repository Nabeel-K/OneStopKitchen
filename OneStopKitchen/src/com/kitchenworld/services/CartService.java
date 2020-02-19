/**
 * 
 */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;

/**
 * @author Nabeel
 *
 */
public class CartService extends AbstractServices {
	public void addCart(Cart cart) {
		em.getTransaction().begin();
		em.persist(cart);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Cart findCartById(Long id) {
		Query getCart = em.createNamedQuery("Cart.findById");
		getCart.setParameter("selectId", id);
		List<Cart> results = getCart.getResultList();

		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> findAllCarts() {
		Query getCarts = em.createNamedQuery("Cart.findAll");
		return getCarts.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CartItems> findAllItemsInCart(Long id) {
		Query getDetails = em.createQuery("SELECT ci from CartItems ci JOIN ci.cart c WHERE c.cartId = :selectId");
		getDetails.setParameter("selectId", id);
		return getDetails.getResultList();
	}

	public void updateCartItems(Long id, List<CartItems> newItems) {
		em.getTransaction().begin();
		Cart cartToUpdate = em.find(Cart.class, id);
		cartToUpdate.setCartItems(newItems);
		em.getTransaction().commit();
	}

	public void deleteCart(Long id) {
		Query deleteCart = em.createNamedQuery("Cart.deleteById");
		deleteCart.setParameter("deleteId", id);
		deleteCart.executeUpdate();
	}

}
