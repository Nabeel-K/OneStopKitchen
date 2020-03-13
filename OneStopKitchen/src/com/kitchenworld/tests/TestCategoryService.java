/**
 * Filename: TestCategoryService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Product;
import com.kitchenworld.services.CategoryService;
import com.kitchenworld.services.ProductService;

/**
 * @author Nabeel
 *
 */
class TestCategoryService {
	CategoryService cs;
	Category category;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cs = new CategoryService();
		category = new Category("testCategory", "./images/fridge.png");
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		cs.deleteCategory(category);
		cs.closeConnection();
	}


	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#addCategory(com.kitchenworld.entity.Category)}.
	 */
	@Test
	void testAddCategory() {
		Category expected = category;
		cs.addCategory(category);
		
		assertEquals(expected, cs.findCategoryById(category.getCategoryId()),"added category should match expected");
		
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#findCategoryById(java.lang.Long)}.
	 */
	@Test
	void testFindCategoryById() {
		//given
		cs.addCategory(category);
		long idToTest = category.getCategoryId();
		//when
		Category actualCategory = cs.findCategoryById(idToTest);
		assertTrue(actualCategory.equals(category),"The category retrieved should match the category added");
	
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#findAllProductsInCategory(java.lang.String)}.
	 */
	@Test
	void testFindAllProductsInCategoryAndUpdateProductList() {
		//given
		Category testlistCategory = new Category("testListCategory", "./images/fridge.png");
		ProductService ps = new ProductService();
		//when
		cs.addCategory(testlistCategory);
		long idToTest = testlistCategory.getCategoryId();
		Product product1 =  new Product("Now with better ice maker", 1299.10, "Samsung Last Fridge", 2, "./images/fridge.png",
				testlistCategory);
		Product product2 =  new Product("Now with better ice maker", 1299.10, "Samsung Ultmiate Fridge", 2, "./images/fridge.png",
				testlistCategory);
		List<Product> products = new ArrayList<>();
		
		products.add(product1);
		ps.addProduct(product1);
		products.add(product2);
		ps.addProduct(product2);
		cs.updateProducts(idToTest, products);
		
		List<Product> actualProducts = cs.findAllProductsInCategory(testlistCategory.getCategoryName());
		ps.closeConnection();

		assertTrue(actualProducts.contains(product1));
		assertTrue(actualProducts.contains(product2));
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#findAllCategories()}.
	 */
	@Test
	void testFindAllCategories() {
		//given		
		Category category1 = new Category("oneCat","./images/fridge.png");
		Category category2 = new Category("twoCat","./images/fridge.png");

		cs.addCategory(category1);
		cs.addCategory(category2);
		
		//When
		List<Category> actaulCategories = cs.findAllCategories();
		
		assertTrue(actaulCategories.contains(category1), "Users added should be retrieved in find all");
		assertTrue(actaulCategories.contains(category2), "Users added should be retrieved in find all");
		//delete to avoid duplicate email entries
		cs.deleteCategory(category1);
		cs.deleteCategory(category2);
	}

	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#updateCategoryName(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateCategoryName() {
		//given 
		cs.addCategory(category);
		long idToTest = category.getCategoryId();
		//when
		String newName = "Anothertest";
		cs.updateCategoryName(idToTest, newName);
		assertTrue(category.getCategoryName().equals(newName),"The updated category should have a new name");
	}


	/**
	 * Test method for {@link com.kitchenworld.services.CategoryService#deleteCategory(java.lang.Long)}.
	 */
	@Test
	void testDeleteCategory() {
		//given

		cs.addCategory(category);
		long idToTest = category.getCategoryId();
		
		//when
		cs.deleteCategory(category);
		Category deletedCategory = cs.findCategoryById(idToTest);
		assertNull(deletedCategory,"Category should be removed and not returned when called from database");
	}
}
