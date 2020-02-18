/**
 * 
 */
package com.kitchenworld.drivers;

import java.util.Date;

import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.Product;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.CategoryService;
import com.kitchenworld.services.OrdersService;
import com.kitchenworld.services.ProductService;
import com.kitchenworld.services.UserService;

/**
 * @author CTStudent
 *
 */
public class Populator {
	private UserService us;
	private CategoryService cs;
	private ProductService ps;
	private OrdersService os;
	
	public Populator() {
		us = new UserService();
		cs = new CategoryService();
		ps = new ProductService();
		os = new OrdersService();
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Populator p = new Populator();
		p.run();
		p.close();
	}
	
	private void run() {
		us.connect();
		cs.connect();
		ps.connect();
		os.connect();
		
		/*ADD USERS*/
		User user1 = new User("bob@gold.com","ba4d5eaeb28b670caebbebc331d5daba", "Bob", "Stevens");
		User user2 = new User("doej@mail.com","43a070d0ee87e7cc54345cd920528689", "John", "Doe");
		
		//With all values except for order and cart information
		User user3 = new User("1234 Street st","Boston","USA","doej@mail.com","43a070d0ee87e7cc54345cd920528689", 
				"John", "Doe","MA","71298");
		User user4 = new User("213 Avenue st","Detroit","USA","adf@mail.com","43aadfaf7cc54345cd920528689", 
				"Mackenzie", "Lows","MI","48029");
		User user5 = new User("213 adfe st","Detroit","USA","adf@gmail.com","adfaeadfaf7cc54345cd920528689", 
				"Games", "Josling","MI","48029");

		us.addUser(user1);
		us.addUser(user2);
		us.addUser(user3);
		us.addUser(user4);
		us.addUser(user5);
		
		
		/*ADD CATEGORIES*/
		Category c1 = new Category("Refrigerators");
		Category c2 = new Category("Microwaves");
		Category c3 = new Category("Small Appliances");
		Category c4 = new Category("Ovens and Stoves");
		
		cs.addCategory(c1);
		cs.addCategory(c2);
		cs.addCategory(c3);
		cs.addCategory(c4);
		
		/*ADD PRODUCTS*/
		Product p1 =  new Product("Cooks Fast", 530.10, "Samsung Stove", 15, cs.findCategoryById(4L));
		Product p2 =  new Product("Keeps food fresh longer", 700.10, "Maytag Refrigerator", 10, cs.findCategoryById(1L));
		Product p3 =  new Product("Mess-Free Opening", 30.80, "Automaitc Can Opener", 80, cs.findCategoryById(3L));
		Product p4 =  new Product("Cooks Faster", 799.99, "Samsung Stove Mk II", 10, cs.findCategoryById(4L));
		Product p5 =  new Product("Warms food", 89.99, "GE Microwave", 20, cs.findCategoryById(2L));
		Product p6 =  new Product("New Defrost Setting", 109.10, "Samsung Microwave", 7, cs.findCategoryById(2L));
		Product p7 =  new Product("Cooks at moderate tempo", 499.10, "Whirlpool Stove", 15, cs.findCategoryById(4L));
		Product p8 =  new Product("Makes great smoothies", 129.10, "Blender", 15, cs.findCategoryById(3L));
		Product p9 =  new Product("Now with better ice maker", 1299.10, "Samsung Refrigerator", 2, cs.findCategoryById(1L));
		Product p10 =  new Product("The best coffee", 49.10, "MyBrand Coffee Maker", 99, cs.findCategoryById(3L));

		
		ps.addProduct(p1);
		ps.addProduct(p2);
		ps.addProduct(p3);
		ps.addProduct(p4);
		ps.addProduct(p5);
		ps.addProduct(p6);
		ps.addProduct(p7);
		ps.addProduct(p8);
		ps.addProduct(p9);
		ps.addProduct(p10);
		
		/*Update Categories with product lists*/
		cs.updateProducts(1L, cs.findAllProductsInCategory(1L));
		cs.updateProducts(2L, cs.findAllProductsInCategory(2L));
		cs.updateProducts(3L, cs.findAllProductsInCategory(3L));
		cs.updateProducts(4L, cs.findAllProductsInCategory(4L));
		
		
		/*ADD ORDERS*/
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "CANCELLED", null , us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null , us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "CANCELLED", null , us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null , us.findUserById(1L), null));

	}
	
	private void close() {
		us.closeConnection();
		cs.closeConnection();
		ps.closeConnection();
		os.closeConnection();
	}

}
