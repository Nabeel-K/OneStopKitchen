package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id", unique=true, nullable=false)
	private int productId;

	@Lob
	private String description;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal price;

	@Column(name="product_name", nullable=false, length=50)
	private String productName;

	@Column(name="quantity_in_stock", nullable=false)
	private int quantityInStock;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="product")
	private List<Review> reviews;
	
	@OneToOne
	private CartItems cartItem;

	/**
	 * @param productId
	 * @param description
	 * @param price
	 * @param productName
	 * @param quantityInStock
	 * @param category
	 * @param reviews
	 */
	public Product(int productId, String description, BigDecimal price, String productName, int quantityInStock,
			 Category category, List<Review> reviews) {
		this.setProductId(productId);
		this.setDescription(description);
		this.setPrice(price);
		this.setProductName(productName);
		this.setQuantityInStock(quantityInStock);
		this.setCategory(category);
		this.setReviews(reviews);
	}

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
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

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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
		builder.append(category);
		builder.append(", reviews=");
		builder.append(reviews);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItem == null) ? 0 : cartItem.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + quantityInStock;
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		if (cartItem == null) {
			if (other.cartItem != null) {
				return false;
			}
		} else if (!cartItem.equals(other.cartItem)) {
			return false;
		}
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
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (productId != other.productId) {
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
		if (reviews == null) {
			if (other.reviews != null) {
				return false;
			}
		} else if (!reviews.equals(other.reviews)) {
			return false;
		}
		return true;
	}

	

}