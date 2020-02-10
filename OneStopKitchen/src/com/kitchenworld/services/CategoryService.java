/**
 * CategoryService.java
 * DESC:Service file for category entities
 */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Product;
import com.kitchenworld.entity.Category;

/**
 * @author Nabeel Khan
 *
 */
public class CategoryService extends AbstractServices {
	public void addCategory(Category category) {
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}
	
	public Category findCategoryById(int id) {
		Query getCategory = em.createNamedQuery("Category.findById");
		getCategory.setParameter("selectId", id);
		List<Category> results = getCategory.getResultList();
		
		return results.get(0);
	}
	
	public List<Category> findAllCategories(){
		Query getCategories = em.createNamedQuery("Category.findAll");
		List<Category> results = getCategories.getResultList();
		
		return results;
	}
	
	public void updateCategoryName(int id, String newName) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setCategoryName(newName);
		em.getTransaction().commit();
	}
	
	public void updateProducts(int id, List<Product> newProducts) {
		em.getTransaction().begin();
		Category categoryToUpdate = em.find(Category.class, id);
		categoryToUpdate.setProducts(newProducts);
		em.getTransaction().commit();
	}
	
	public void deleteCategory(int id) {
		Query deleteCategory = em.createNamedQuery("Category.deleteById");
		deleteCategory.setParameter("selectId", id);
		deleteCategory.executeUpdate();
	}
}
