package com.kitchenworld.entity;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 *
 */
@Entity
@Table(name="cart")
@NamedQueries(value= {
		@NamedQuery(name="Cart.findById", query="SELECT c FROM Cart c WHERE c.cartId = :selectId"),
		@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c"),
		@NamedQuery(name="Cart.deleteById", query="DELETE FROM Cart c WHERE c.cartId = :deleteId")
})
public class Cart implements Serializable {

	@Id
	private Integer cartId;
	
	@OneToOne(mappedBy = "cart")
	private User user;
	
	@OneToOne
	private CartItems cartItems;
	
	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
	}   
	/**
	 * @param cartId
	 * @param user
	 */
	public Cart(Integer cartId, User user) {
		this.setCartId(cartId);
		this.setUser(user); 
	}

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
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
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
