/*
 * Filename: JpqlConstants.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * Maint Date: 3-13-20 Set more fields for more jpql parameters and queries
 * 
 * 
 * */
package com.kitchenworld.util;

/**
 * A class that holds constant variables to be used in JPQL queries in service
 * classes
 * 
 * @author Nabeel
 *
 */
public final class JpqlConstants {

	private JpqlConstants() {
		throw new IllegalStateException("This utility class cannot and should not be instantiated");
	}

	// Names for set parameters
	public static final String SELECT_ID = "selectId";

	// Basic select queries
	public static final String QUERY_ORDER_DETAILS = "SELECT od from OrderDetail od";
	public static final String QUERY_CART_ITEMS = "SELECT ci from CartItems ci";
	public static final String QUERY_PRODUCTS = "SELECT p from Product p";
	public static final String QUERY_USERS = "SELECT u FROM User u";

	// Complex Queries
	public static final String QUERY_MAX_LINE_NUMBER = "SELECT MAX(ci.lineNumber) FROM CartItems ci JOIN Cart c"
			+ " JOIN User u WHERE u.userId = :selectId GROUP BY u.userId";
}
