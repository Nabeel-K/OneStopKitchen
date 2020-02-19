/**
 * QueryRunner.java
 * Desc - Test class to test the functions of query services after the populator has been run
 */
package com.kitchenworld.drivers;

import java.util.List;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Product;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.*;

/**
 * @author CTStudent
 *
 */
public class QueryRunner {

	public static void main(String[] args) {
		QueryRunner qr = new QueryRunner();
		qr.runUserQueries();
		qr.runCategoryQueries();
		qr.runProductQueries();
	}

	private void runUserQueries() {
		UserService us = new UserService();
		us.connect();

		Long testUserId = 2L;

		System.out.println("USERS");
		List<User> allUsers = us.findAllUsers();
		User foundUser = us.findUserById(testUserId);
		for (User user : allUsers) {
			System.out.println(user);
		}
		System.out.println("User " +testUserId+" is " + foundUser.getFirstName() + " " + foundUser.getLastName()
				+ " and he lives in " + foundUser.getCity());

		us.updateUserCity(testUserId, "London");
		us.updateUserAddress(testUserId, "12345 Help Street");
		us.updateUserState(testUserId, "Texas");
		us.updateUserCountry(testUserId, "USA");
		us.updateUserZipCode(testUserId, "71293");
		us.updateUserFirstName(testUserId, "Nabeel");
		us.updateUserLastName(testUserId, "Terminatus");
		us.updateUserEmail(testUserId, "oijfs@nonsense.com");

		foundUser = us.findUserById(testUserId);
		System.out.println(foundUser);
		
//		us.deleteUser(2L);
//		allUsers = us.findAllUsers();
//		for (User user : allUsers) {
//			System.out.println(user);
//		}
		
		us.closeConnection();
	}
	
	private void runCategoryQueries() {
		CategoryService cs = new CategoryService();
		cs.connect();
		
		Long testId = 2L;
		List<Category> allCategories = cs.findAllCategories();
		Category foundCatgeory = cs.findCategoryById(testId);
		for (Category c : allCategories) {
			System.out.println(c);
		}
		System.out.println(foundCatgeory);
		
		cs.updateCategoryName(testId, "Dishwashers");
		foundCatgeory = cs.findCategoryById(testId);
		System.out.println(foundCatgeory);
		cs.closeConnection();
	}
	private void runProductQueries() {
		ProductService ps = new ProductService();
		ps.connect();
		Long testId = 4L;

		List<Product> allProducts = ps.findAllProducts();
		Product foundProduct = ps.findProductById(testId);
		for (Product p : allProducts) {
			System.out.println(p);
		}
		System.out.println(foundProduct);
		
		ps.updateProductName(testId, "Toaster");
		ps.updateProductDescription(testId, "Toasts bread to perfection");
		ps.updateProductPrice(testId, 29.99);
		ps.updateProductQuantity(testId, 17);
		foundProduct = ps.findProductById(testId);
		System.out.println(foundProduct);

		
		ps.closeConnection();
	}

}
