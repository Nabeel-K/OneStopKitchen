package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQueries(value= {
		@NamedQuery(name="Category.findById", query="SELECT c FROM Category c WHERE c.categoryId = :selectId"),
		@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c"),
		@NamedQuery(name="Category.deleteById", query="DELETE FROM Category c WHERE c.categoryId = :deleteId")
})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id", unique=true, nullable=false)
	private int categoryId;

	@Column(name="category_name", nullable=false, length=20)
	private String categoryName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	//Constructors
	public Category() {
	}

	/**
	 * @param categoryId
	 * @param categoryName
	 * @param products
	 */
	public Category(int categoryId, String categoryName, List<Product> products) {
		this.setCategoryId(categoryId);
		this.setCategoryName(categoryName);
		this.setProducts(products);
	}
	
	public Category(String categoryName, List<Product> products) {
		this.setCategoryName(categoryName);
		this.setProducts(products);
	}

	//Getters and setters
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//Overrides
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryId=");
		builder.append(categoryId);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

}