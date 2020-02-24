/*
 * Filename: CategoryService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 *
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
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProductsInCategory(Long id) {
		Query getProducts = em.createQuery("SELECT p from Product p JOIN p.category g WHERE g.categoryId = :selectId");
		getProducts.setParameter("selectId", id);
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

	public void deleteCategory(Long id) {
		Query deleteCategory = em.createNamedQuery("Category.deleteById");
		deleteCategory.setParameter("deleteId", id);
		deleteCategory.executeUpdate();
	}
}
