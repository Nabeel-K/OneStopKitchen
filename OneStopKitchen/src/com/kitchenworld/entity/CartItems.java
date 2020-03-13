/*
 * Filename: CartItems.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CartItems
 *
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "CartItems.findById", query = "SELECT c FROM CartItems c WHERE c.id = :selectId"),
		@NamedQuery(name = "CartItems.findAll", query = "SELECT c FROM CartItems c"),
		@NamedQuery(name = "CartItems.deleteById", query = "DELETE FROM CartItems c WHERE c.id = :deleteId") })
public class CartItems implements Serializable {

	@Id
	@Column(name = "cartline_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "line_number", nullable = false)
	private Integer lineNumber;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price_each")
	private double priceEach;

	@Column(name = "sku_number", nullable = false)
	private String skuNumber;
	
	@Column(name="image")
	private String imagePath;

	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	private static final long serialVersionUID = 1L;

	public CartItems() {
		super();
	}

	/**
	 * @param id
	 * @param lineNumber
	 * @param quantity
	 * @param priceEach
	 * @param skuNumber
	 * @param cart
	 */
	public CartItems(Long id, Integer lineNumber, int quantity, double priceEach, String skuNumber, String imagePath, Cart cart) {
		this.setId(id);
		this.setLineNumber(lineNumber);
		this.setQuantity(quantity);
		this.setPriceEach(priceEach);
		this.setSkuNumber(skuNumber);
		this.setImagePath(imagePath);
		this.setCart(cart);
	}

	/**
	 * @param lineNumber
	 * @param quantity
	 * @param priceEach
	 * @param skuNumber
	 * @param cart
	 */
	public CartItems(Integer lineNumber, int quantity, double priceEach, String skuNumber, Cart cart) {
		this.setLineNumber(lineNumber);
		this.setQuantity(quantity);
		this.setPriceEach(priceEach);
		this.setSkuNumber(skuNumber);
		this.setCart(cart);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lineItems
	 */
	public Integer getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
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
	 * @return the priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}

	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	/**
	 * @return the skuNumber
	 */
	public String getSkuNumber() {
		return skuNumber;
	}

	/**
	 * @param skuNumber the skuNumber to set
	 */
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
		builder.append(", lineNumber=");
		builder.append(lineNumber);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", priceEach=");
		builder.append(priceEach);
		builder.append(", skuNumber=");
		builder.append(skuNumber);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", cart=");
		builder.append(cart.getCartId());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceEach);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((skuNumber == null) ? 0 : skuNumber.hashCode());
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
		} else if (!cart.getCartId().equals(other.cart.getCartId())) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (imagePath == null) {
			if (other.imagePath != null) {
				return false;
			}
		} else if (!imagePath.equals(other.imagePath)) {
			return false;
		}
		if (lineNumber == null) {
			if (other.lineNumber != null) {
				return false;
			}
		} else if (!lineNumber.equals(other.lineNumber)) {
			return false;
		}
		if (Double.doubleToLongBits(priceEach) != Double.doubleToLongBits(other.priceEach)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		if (skuNumber == null) {
			if (other.skuNumber != null) {
				return false;
			}
		} else if (!skuNumber.equals(other.skuNumber)) {
			return false;
		}
		return true;
	}



}