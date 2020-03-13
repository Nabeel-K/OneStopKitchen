/*
 * Filename: ProductService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 2-25-20 Added find by name method
 * Maint Date: 3-12-20 Updated delete method
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Product;

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for product entities
 * 
 * @author Nabeel
 *
 */
public class ProductService extends AbstractServices {

	public ProductService() {
		super();
	}

	/**
	 * Adds a product to the database
	 * 
	 * @param product to add
	 */
	public void addProduct(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	/**
	 * @param id of product to find
	 * @return the product identified by the given id
	 */
	@SuppressWarnings("unchecked")
	public Product findProductById(Long id) {
		Query getProduct = em.createNamedQuery("Product.findById");
		getProduct.setParameter(SELECT_ID, id);
		List<Product> results = getProduct.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @param productName to search by
	 * @return product with the given name
	 */
	@SuppressWarnings("unchecked")
	public Product findProductByName(String productName) {
		Query getProduct = em.createQuery(QUERY_PRODUCTS + " WHERE p.productName = :selectName");
		getProduct.setParameter("selectName", productName);
		List<Product> results = getProduct.getResultList();
		return results.get(0);
	}

	/**
	 * @return all products in the database
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Query getProducts = em.createNamedQuery("Product.findAll");
		return getProducts.getResultList();
	}

	/**
	 * Updates/changes name of a product in database
	 * 
	 * @param id      of product to update
	 * @param newName to replace existing name
	 */
	public void updateProductName(Long id, String newName) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setProductName(newName);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes description of a product in database
	 * 
	 * @param id      of product to update
	 * @param newDesc to replace existing description
	 */
	public void updateProductDescription(Long id, String newDesc) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setDescription(newDesc);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes price of a product in database
	 * 
	 * @param id    of product to update
	 * @param price to replace existing price
	 */
	public void updateProductPrice(Long id, double price) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setPrice(price);
		em.getTransaction().commit();
	}

	/**
	 * Updates/changes quantity of a product in database
	 * 
	 * @param id       of product to update
	 * @param quantity to replace existing quantity
	 */
	public void updateProductQuantity(Long id, int quantity) {
		em.getTransaction().begin();
		Product productToUpdate = em.find(Product.class, id);
		productToUpdate.setQuantityInStock(quantity);
		em.getTransaction().commit();
	}

	/**
	 * Removes a product from the database
	 * 
	 * @param product to delete
	 */
	public void deleteProduct(Product product) {
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}
}
