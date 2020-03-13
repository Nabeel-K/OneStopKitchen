/**
 * Filename: TestProductService.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * */
package com.kitchenworld.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kitchenworld.entity.Product;
import com.kitchenworld.services.CategoryService;
import com.kitchenworld.services.ProductService;

/**
 * @author Nabeel
 *
 */
class TestProductService {
	ProductService ps;
	Product product;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ps = new ProductService();
		CategoryService cs = new CategoryService();
		product = new Product("Now with better ice maker", 1299.10, "Samsung Refrigerator mk 2", 2, "./images/fridge.png",cs.findCategoryById(1L));
		cs.closeConnection();
	}	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		ps.deleteProduct(product);
		ps.closeConnection();
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#addProduct(com.kitchenworld.entity.Product)}.
	 */
	@Test
	void testAddProductAndFindById() {
		Product expected = product;
		ps.addProduct(product);
		long idToTest = product.getProductId();
		
		assertEquals(expected, ps.findProductById(idToTest),"found product should match added product");
		
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#findProductByName(java.lang.String)}.
	 */
	@Test
	void testFindProductByName() {
		ps.addProduct(product);
		String nameToTest = product.getProductName();
		
		assertEquals(ps.findProductByName(nameToTest), product,"Product retrieved should match the product added");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#findAllProducts()}.
	 */
	@Test
	void testFindAllProducts() {
		ps.addProduct(product);
		List<Product> products = ps.findAllProducts();
		
		assertNotNull(products, "List should not be null");
		assertTrue(products.contains(product), "List of products should include added product");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#updateProductName(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateProductName() {
		//given 
		ps.addProduct(product);
		long idToTest = product.getProductId();
		//when
		String newName = "anotherProduct";
		ps.updateProductName(idToTest, newName);
		assertTrue(product.getProductName().equals(newName),"The updated product should have a new name");	
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#updateProductDescription(java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testUpdateProductDescription() {
		//given 
		ps.addProduct(product);
		long idToTest = product.getProductId();
		//when
		String newDesc = "try this one out";
		ps.updateProductDescription(idToTest, newDesc);
		assertTrue(product.getDescription().equals(newDesc),"The updated product should have a new description");	
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#updateProductPrice(java.lang.Long, double)}.
	 */
	@Test
	void testUpdateProductPrice() {
		ps.addProduct(product);
		long idToTest = product.getProductId();
		//when
		double newPrice = 88.89;
		ps.updateProductPrice(idToTest, newPrice);
		assertTrue(product.getPrice() == newPrice, "The updated product should have a new price");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#updateProductQuantity(java.lang.Long, int)}.
	 */
	@Test
	void testUpdateProductQuantity() {
		ps.addProduct(product);
		long idToTest = product.getProductId();
		//when
		int newQuantity = 77;
		ps.updateProductQuantity(idToTest, newQuantity);
		assertTrue(product.getQuantityInStock() == newQuantity, "The updated product should have a new quantity");
	}

	/**
	 * Test method for {@link com.kitchenworld.services.ProductService#deleteProduct(java.lang.Long)}.
	 */
	@Test
	void testDeleteProduct() {

		ps.addProduct(product);
		long idToTest = product.getProductId();
		
		//when
		ps.deleteProduct(product);
		Product deletedProduct = ps.findProductById(idToTest);
		assertNull(deletedProduct,"product should be removed and not returned");
	}

}
