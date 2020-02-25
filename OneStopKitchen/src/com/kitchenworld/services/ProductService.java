/*
 * Filename: ProductService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 2-25-20 Added find by name method
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Product;

/**
 * @author Nabeel
 *
 */
public class ProductService extends AbstractServices {
	
	public ProductService() {
		super();
	}
	
	public void addProduct(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Product findProductById(Long id) {
		Query getProduct = em.createNamedQuery("Product.findById");
		getProduct.setParameter("selectId", id);
		List<Product> results = getProduct.getResultList();

		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public Product findProductByName(String productName) {
		Query getProduct = em.createQuery("SELECT p FROM Product p WHERE p.productName = :selectName");
		getProduct.setParameter("selectName", productName);
		List<Product> results = getProduct.getResultList();
		return results.get(0);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Query getProducts = em.createNamedQuery("Product.findAll");
		List<Product> results = getProducts.getResultList();

		return results;
	}

	public void updateProductName(Long id, String newName) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setProductName(newName);
		em.getTransaction().commit();
	}

	public void updateProductDescription(Long id, String newDesc) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setDescription(newDesc);
		em.getTransaction().commit();
	}

	public void updateProductPrice(Long id, double price) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setPrice(price);
		em.getTransaction().commit();
	}

	public void updateProductQuantity(Long id, int quantity) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setQuantityInStock(quantity);
		em.getTransaction().commit();
	}

	public void updateProductCategory(Long id, Category category) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setCategory(category);
		em.getTransaction().commit();
	}

	public void deleteProduct(Long id) {
		Query deleteProduct = em.createNamedQuery("Product.deleteById");
		deleteProduct.setParameter("deleteId", id);
		deleteProduct.executeUpdate();
	}
}
