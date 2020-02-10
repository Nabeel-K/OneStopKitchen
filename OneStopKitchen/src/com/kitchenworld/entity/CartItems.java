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

	@Column(name="line_number", nullable=false)
	private Integer lineItems;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	private static final long serialVersionUID = 1L;

	
	
	public CartItems() {
		super();
	}



	/**
	 * @param id
	 * @param lineItems
	 * @param quantity
	 * @param cart
	 */
	public CartItems(Integer id, Integer lineItems, int quantity, Cart cart) {
		this.setId(id);
		this.setLineItems(lineItems);
		this.setQuantity(quantity);
		this.setCart(cart);
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the lineItems
	 */
	public Integer getLineItems() {
		return lineItems;
	}



	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(Integer lineItems) {
		this.lineItems = lineItems;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}


	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartItems [id=");
		builder.append(id);
		builder.append(", lineItems=");
		builder.append(lineItems);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", cart=");
		builder.append(cart);
		builder.append("]");
		return builder.toString();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lineItems == null) ? 0 : lineItems.hashCode());
		result = prime * result + quantity;
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
		CartItems other = (CartItems) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lineItems == null) {
			if (other.lineItems != null)
				return false;
		} else if (!lineItems.equals(other.lineItems))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
