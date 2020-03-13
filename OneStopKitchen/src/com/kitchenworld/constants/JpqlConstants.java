/**
 * Filename: JpqlConstants.java
 * Author: Nabeel Khan
 * Creation Date: 3-12-20 Original Creation
 * 
 * 
 * 
 * */
package com.kitchenworld.constants;

/**
 * A class that holds constant variables to be used in JPQL queries in service classes
 * @author Nabeel
 *
 */
public final class JpqlConstants {
	
	private JpqlConstants() {
		throw new IllegalStateException("This utility class cannot and should not be instantiated");
	}
	
	public static final String SELECT_ID = "selectId";
}
