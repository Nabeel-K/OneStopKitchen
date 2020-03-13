/*
 * Filename: Cart.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 * 
 * @author Nabeel
 */
@Entity
@Table(name = "cart")
@NamedQueries(value = { @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.cartId = :selectId"),
		@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
		@NamedQuery(name = "Cart.deleteById", query = "DELETE FROM Cart c WHERE c.cartId = :deleteId") })
public class Cart implements Serializable {

	/**
	 * Id of the cart
	 */
	@Id
	@Column(name = "cart_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	/**
	 * User who owns this cart
	 */
	@OneToOne
	private User user;

	/**
	 * Items belonging to this cart
	 */
	@OneToMany(mappedBy = "cart")
	private List<CartItems> cartItems;

	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
	}

	/**
	 * Full Constructor
	 * 
	 * @param cartId
	 * @param user
	 * @param cartItems
	 */
	public Cart(Long cartId, User user, List<CartItems> cartItems) {
		this.setCartId(cartId);
		this.setUser(user);
		this.setCartItems(cartItems);
	}

	/**
	 * Constructor for population and testing
	 * 
	 * @param user
	 * @param cartItems
	 */
	public Cart(User user, List<CartItems> cartItems) {
		this.setUser(user);
		this.setCartItems(cartItems);
	}

	/**
	 * @return the cartItems
	 */
	public List<CartItems> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the cartId
	 */
	public Long getCartId() {
		return this.cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart [cartId=");
		builder.append(cartId);
		builder.append(", cartItems=");
		builder.append(cartItems);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null) {
				return false;
			}
		} else if (!cartId.equals(other.cartId)) {
			return false;
		}
		if (cartItems == null) {
			if (other.cartItems != null) {
				return false;
			}
		} else if (!cartItems.equals(other.cartItems)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}
