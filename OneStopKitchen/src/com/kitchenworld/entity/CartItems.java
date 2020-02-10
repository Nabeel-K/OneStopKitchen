package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CartItems
 *
 */
@Entity
@NamedQueries(value= {
		@NamedQuery(name="CartItems.findById", query="SELECT c FROM CartItems c WHERE c.id = :selectKey"),
		@NamedQuery(name="CartItems.findAll", query="SELECT c FROM CartItems c"),
		@NamedQuery(name="CartItems.deleteById", query="DELETE FROM CartItems c WHERE c.id = :deleteId")
})
public class CartItems implements Serializable {

	@Id
	private Integer id;

	@Column(name = "quantity")
	private int quantity;

	@OneToOne
	private Cart cart;

	private static final long serialVersionUID = 1L;

	public CartItems(Integer id, int quantity) {
		this.setCartItemsKey(id);
		this.setQuantity(quantity);
	}

	public CartItems() {
		super();
	}

	/**
	 * @return the cartItemsKey
	 */
	public Integer getCartItemsKey() {
		return id;
	}

	/**
	 * @param cartItemsKey the cartItemsKey to set
	 */
	public void setCartItemsKey(Integer cartItemsKey) {
		this.id = cartItemsKey;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Integer [cartItemsKey=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantity;
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
		CartItems other = (CartItems) obj;
		if (cart == null) {
			if (other.cart != null) {
				return false;
			}
		} else if (!cart.equals(other.cart)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		return true;
	}



}
