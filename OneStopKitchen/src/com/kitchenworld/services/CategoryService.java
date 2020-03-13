/*
 * Filename: CategoryService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-12-29 Updated delete method
 * 
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Product;

/**
 * @author Nabeel Khan
 *
 */
public class CategoryService extends AbstractServices {
	
	public CategoryService() {
		super();
	}
	
	public void addCategory(Category category) {
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Category findCategoryById(Long id) {
		Query getCategory = em.createNamedQuery("Category.findById");
		getCategory.setParameter("selectId", id);
		List<Category> results = getCategory.getResultList();
		if(results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProductsInCategory(String categoryName) {
		Query getProducts = em.createQuery("SELECT p from Product p JOIN p.category g WHERE g.categoryName = :selectName");
		getProducts.setParameter("selectName", categoryName);
		return getProducts.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() {
		Query getCategories = em.createNamedQuery("Category.findAll");
		return getCategories.getResultList();
	}

	public void updateCategoryName(Long id, String newName) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setCategoryName(newName);
		em.getTransaction().commit();
	}

	public void updateProducts(Long id, List<Product> newProducts) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setProducts(newProducts);
		em.getTransaction().commit();
	}

	public void deleteCategory(Category category) {
		em.getTransaction().begin();
		em.remove(category);
		em.getTransaction().commit();
	}
}
