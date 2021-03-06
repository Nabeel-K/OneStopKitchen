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
 * @author Nabeel
 */
@Entity
@Table(name = "products")
@NamedQueries(value = { @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
		@NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.productId = :selectId"),
		@NamedQuery(name = "Product.deleteById", query = "DELETE FROM Product p WHERE p.productId = :deleteId") })
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Id of this product
	 */
	@Id
	@Column(name = "product_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	/**
	 * Description of this product
	 */
	@Lob
	private String description;

	/**
	 * Price of this product
	 */
	@Column(nullable = false, precision = 10, scale = 2)
	private double price;

	/**
	 * Name of this product
	 */
	@Column(name = "product_name", unique = true, nullable = false, length = 50)
	private String productName;

	/**
	 * Quantity left of this product
	 */
	@Column(name = "quantity_in_stock", nullable = false)
	private int quantityInStock;

	/**
	 * Path of this product's image in the filesystem
	 */
	@Column(name = "product_image", nullable = false)
	private String imagePath;

	/**
	 * Category of this product
	 */
	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Product() {
	}

	/**
	 * Full Constructor
	 * 
	 * @param productId
	 * @param description
	 * @param price
	 * @param productName
	 * @param quantityInStock
	 * @param imagePath
	 * @param category
	 */
	public Product(Long productId, String description, double price, String productName, int quantityInStock,
			String imagePath, Category category) {
		this.setProductId(productId);
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setImagePath(imagePath);
		this.setCategory(category);
	}

	/**
	 * First testing Constructor
	 * 
	 * @param description
	 * @param price
	 * @param productName
	 * @param quantityInStock
	 * @param imagePath
	 * @param category
	 */
	public Product(String description, double price, String productName, int quantityInStock, String imagePath,
			Category category) {
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setImagePath(imagePath);
		this.setCategory(category);
	}

	/**
	 * Second testing Constructor
	 * 
	 * @param description
	 * @param price
	 * @param productName
	 * @param quantityInStock
	 * @param imagePath
	 */
	public Product(String description, double price, String productName, int quantityInStock, String imagePath) {
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setImagePath(imagePath);

	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the quantityInStock
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
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
		builder.append(", imagePath=");
		builder.append(imagePath);
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
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
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
		} else if (!category.getCategoryName().equals(other.category.getCategoryName())) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (imagePath == null) {
			if (other.imagePath != null) {
				return false;
			}
		} else if (!imagePath.equals(other.imagePath)) {
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