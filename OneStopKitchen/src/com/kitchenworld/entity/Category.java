/*
 * Filename: Category.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-27-20 Added image attribute
 * Maint Date:2-28-20 Changed image type from BLOB to String path
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 * @author Nabeel
 */
@Entity
@Table(name = "category")
@NamedQueries(value = {
		@NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.categoryId = :selectId"),
		@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
		@NamedQuery(name = "Category.deleteById", query = "DELETE FROM Category c WHERE c.categoryId = :deleteId") })
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Id of this category
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Long categoryId;

	/**
	 * Name of this category
	 */
	@Column(name = "category_name", unique = true, nullable = false, length = 20)
	private String categoryName;

	/**
	 * Image path of this category's image in filesystem
	 */
	@Column(name = "category_image", nullable = false)
	private String imagePath;

	/**
	 * Products belonging to this category
	 */
	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	// Constructors
	public Category() {
	}

	/**
	 * @param categoryId
	 * @param categoryName
	 * @param imagePath
	 * @param products
	 */
	public Category(Long categoryId, String categoryName, String imagePath, List<Product> products) {
		this.setCategoryId(categoryId);
		this.setCategoryName(categoryName);
		this.setImagePath(imagePath);
		this.setProducts(products);
	}

	/**
	 * @param categoryName
	 * @param imagePath
	 * @param products
	 */
	public Category(String categoryName, String imagePath, List<Product> products) {
		this.setCategoryName(categoryName);
		this.setImagePath(imagePath);
		this.setProducts(products);
	}

	/**
	 * Constructor for initial category creation when running populator
	 * 
	 * @param categoryName
	 * @param imagePath
	 */
	public Category(String categoryName, String imagePath) {
		this.setCategoryName(categoryName);
		this.setImagePath(imagePath);
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
		builder.append(", imagePath=");
		builder.append(imagePath);
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
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
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
		if (imagePath == null) {
			if (other.imagePath != null) {
				return false;
			}
		} else if (!imagePath.equals(other.imagePath)) {
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