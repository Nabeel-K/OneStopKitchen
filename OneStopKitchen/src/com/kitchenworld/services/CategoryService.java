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

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Services for Category entities
 * 
 * @author Nabeel Khan
 *
 */
public class CategoryService extends AbstractServices {

	public CategoryService() {
		super();
	}

	/**
	 * Adds a category to the database
	 * 
	 * @param category to add
	 */
	public void addCategory(Category category) {
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}

	/**
	 * @param id of the category to find
	 * @return the category identified by given id
	 */
	@SuppressWarnings("unchecked")
	public Category findCategoryById(Long id) {
		Query getCategory = em.createNamedQuery("Category.findById");
		getCategory.setParameter(SELECT_ID, id);
		List<Category> results = getCategory.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	/**
	 * @param categoryName of the category to search
	 * @return products within a given category
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAllProductsInCategory(String categoryName) {
		Query getProducts = em.createQuery(QUERY_PRODUCTS + " JOIN p.category g WHERE g.categoryName = :selectName");
		getProducts.setParameter("selectName", categoryName);
		return getProducts.getResultList();
	}

	/**
	 * @return all categories in database
	 */
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() {
		Query getCategories = em.createNamedQuery("Category.findAll");
		return getCategories.getResultList();
	}

	/**
	 * Updates the name of a category
	 * 
	 * @param id      of the cart to update
	 * @param newName to replace old name of category
	 */
	public void updateCategoryName(Long id, String newName) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setCategoryName(newName);
		em.getTransaction().commit();
	}

	/**
	 * Changes the list of products in a given category
	 * 
	 * @param id          of the cart to update
	 * @param newProducts to replace exisitng products in category
	 */
	public void updateProducts(Long id, List<Product> newProducts) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setProducts(newProducts);
		em.getTransaction().commit();
	}

	/**
	 * Removes a category from the database
	 * 
	 * @param category to remove
	 */
	public void deleteCategory(Category category) {
		em.getTransaction().begin();
		em.remove(category);
		em.getTransaction().commit();
	}
}
