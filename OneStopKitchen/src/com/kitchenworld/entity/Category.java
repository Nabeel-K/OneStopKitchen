/*
 * Filename: Category.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-27-20 Added image attribute
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name = "category")
@NamedQueries(value = {
		@NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.categoryId = :selectId"),
		@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
		@NamedQuery(name = "Category.deleteById", query = "DELETE FROM Category c WHERE c.categoryId = :deleteId") })
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Long categoryId;

	@Column(name = "category_name", unique=true, nullable = false, length = 20)
	private String categoryName;
	
	@Lob
	@Column(name="category_image", nullable=false, columnDefinition="mediumblob")
	private byte[] image;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	// Constructors
	public Category() {
	}

	/**
	 * @param categoryId
	 * @param categoryName
	 * @param image
	 * @param products
	 */
	public Category(Long categoryId, String categoryName, byte[] image, List<Product> products) {
		this.setCategoryId(categoryId);
		this.setCategoryName(categoryName);
		this.setImage(image);
		this.setProducts(products);	}

	
	/**
	 * @param categoryName
	 * @param image
	 * @param products
	 */
	public Category(String categoryName, byte[] image, List<Product> products) {
		this.setCategoryName(categoryName);
		this.setImage(image);
		this.setProducts(products);
	}

	/**
	 * Constructor for initial category creation when running populator
	 * @param categoryName
	 * @param image
	 */
	public Category(String categoryName, byte[] image) {
		this.setCategoryName(categoryName);
		this.setImage(image);
	}

	
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryId=");
		builder.append(categoryId);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", image=");
		builder.append(Arrays.toString(image));
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Category other = (Category) obj;
		if (categoryId == null) {
			if (other.categoryId != null) {
				return false;
			}
		} else if (!categoryId.equals(other.categoryId)) {
			return false;
		}
		if (categoryName == null) {
			if (other.categoryName != null) {
				return false;
			}
		} else if (!categoryName.equals(other.categoryName)) {
			return false;
		}
		if (!Arrays.equals(image, other.image)) {
			return false;
		}
		if (products == null) {
			if (other.products != null) {
				return false;
			}
		} else if (!products.equals(other.products)) {
			return false;
		}
		return true;
	}

}