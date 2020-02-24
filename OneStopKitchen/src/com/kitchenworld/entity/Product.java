/*
 * Filename: Product.java
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
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQueries(value= {
		@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p"),
		@NamedQuery(name="Product.findById", query="SELECT p FROM Product p WHERE p.productId = :selectId"),
		@NamedQuery(name="Product.deleteById", query="DELETE FROM Product p WHERE p.productId = :deleteId")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;

	@Lob
	private String description;

	@Column(nullable=false, precision=10, scale=2)
	private double price;

	@Column(name="product_name", unique=true, nullable=false, length=50)
	private String productName;

	@Column(name="quantity_in_stock", nullable=false)
	private int quantityInStock;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	

	/**
	 * @param productId
	 * @param description
	 * @param price
	 * @param productName
	 * @param quantityInStock
	 * @param category
	 */
	public Product(Long productId, String description, double price, String productName, int quantityInStock,
			 Category category) {
		this.setProductId(productId);
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setCategory(category);
	}

	public Product(String description, double price, String productName, int quantityInStock,
			 Category category) {
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setCategory(category);
	}
	
	public Product(String description, double price, String productName, int quantityInStock) {
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
	}
	
	public Product() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityInStock() {
		return this.quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", quantityInStock=");
		builder.append(quantityInStock);
		builder.append(", category=");
		builder.append(category.getCategoryName());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + quantityInStock;
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!productId.equals(other.productId)) {
			return false;
		}
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equals(other.productName)) {
			return false;
		}
		if (quantityInStock != other.quantityInStock) {
			return false;
		}
		return true;
	}



	
}