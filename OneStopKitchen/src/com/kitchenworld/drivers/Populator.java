/**
 * 
 */
package com.kitchenworld.drivers;

import java.util.Date;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;
import com.kitchenworld.entity.Category;
import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.Product;
import com.kitchenworld.entity.Shipment;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;
import com.kitchenworld.services.CategoryService;
import com.kitchenworld.services.OrderDetailsService;
import com.kitchenworld.services.OrdersService;
import com.kitchenworld.services.ProductService;
import com.kitchenworld.services.ShipmentService;
import com.kitchenworld.services.UserService;

/**
 * @author Nabeel
 *
 */
public class Populator {
	private UserService us;
	private CategoryService cs;
	private ProductService ps;
	private OrdersService os;
	private OrderDetailsService ods;
	private ShipmentService ss;
	private CartService cts;
	private CartItemsService cis;

	public Populator() {
		us = new UserService();
		cs = new CategoryService();
		ps = new ProductService();
		os = new OrdersService();
		ods = new OrderDetailsService();
		ss = new ShipmentService();
		cts = new CartService();
		cis = new CartItemsService();
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
	

		/* ADD USERS */
		User user1 = new User("bob@gold.com", "ba4d5eaeb28b670caebbebc331d5daba", "Bob", "Stevens");
		User user2 = new User("dobmaej@mail.com", "43a070d0ee87e7cc54345cd920528689", "John", "Doe");

		// With all values except for order and cart information
		User user3 = new User("1234 Street st", "Boston", "USA", "doej@mail.com", "43a070d0ee87e7cc54345cd920528689",
				"John", "Doe", "MA", "71298");
		User user4 = new User("213 Avenue st", "Detroit", "USA", "adf@mail.com", "43aadfaf7cc54345cd920528689",
				"Mackenzie", "Lows", "MI", "48029");
		User user5 = new User("213 adfe st", "Detroit", "USA", "adf@gmail.com", "adfaeadfaf7cc54345cd920528689",
				"Games", "Josling", "MI", "48029");

		us.addUser(user1);
		us.addUser(user2);
		us.addUser(user3);
		us.addUser(user4);
		us.addUser(user5);

		/* ADD CATEGORIES */
		Category c1 = new Category("Refrigerators", "./images/fridge.png");
		Category c2 = new Category("Microwaves", "./images/microwave.png");
		Category c3 = new Category("Small Appliances", "./images/toaster.png");
		Category c4 = new Category("Ovens and Stoves", "./images/gas_stove.png");

		cs.addCategory(c1);
		cs.addCategory(c2);
		cs.addCategory(c3);
		cs.addCategory(c4);

		/* ADD PRODUCTS */
		Product p1 = new Product("Cooks Fast", 530.10, "Samsung Stove", 15, "./images/gas_stove.png",
				cs.findCategoryById(4L));
		Product p2 = new Product("Keeps food fresh longer", 700.10, "Maytag Refrigerator", 10, "./images/fridge.png",
				cs.findCategoryById(1L));
		Product p3 = new Product("Mess-Free Opening", 30.80, "Automaitc Can Opener", 80, "./images/toaster.png",
				cs.findCategoryById(3L));
		Product p4 = new Product("Cooks Faster", 799.99, "Samsung Stove Mk II", 10, "./images/gas_stove.png",
				cs.findCategoryById(4L));
		Product p5 = new Product("Warms food", 89.99, "GE Microwave", 20, "./images/microwave.png",
				cs.findCategoryById(2L));
		Product p6 = new Product("New Defrost Setting", 109.10, "Samsung Microwave", 7, "./images/microwave.png",
				cs.findCategoryById(2L));
		Product p7 = new Product("Cooks at moderate tempo", 499.10, "Whirlpool Stove", 15, "./images/gas_stove.png",
				cs.findCategoryById(4L));
		Product p8 = new Product("Makes great smoothies", 129.10, "Blender", 15, "./images/toaster.png",
				cs.findCategoryById(3L));
		Product p9 = new Product("Now with better ice maker", 1299.10, "Samsung Refrigerator", 2, "./images/fridge.png",
				cs.findCategoryById(1L));
		Product p10 = new Product("The best coffee", 49.10, "MyBrand Coffee Maker", 99, "./images/toaster.png",
				cs.findCategoryById(3L));

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

		/* Update Categories with product lists */
		cs.updateProducts(1L, cs.findAllProductsInCategory("Refrigerators"));
		cs.updateProducts(2L, cs.findAllProductsInCategory("Microwaves"));
		cs.updateProducts(3L, cs.findAllProductsInCategory("Small Appliances"));
		cs.updateProducts(4L, cs.findAllProductsInCategory("Ovens and Stoves"));

		/* ADD ORDERS */
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "CANCELLED", null, us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "SHIPPED", null, us.findUserById(3L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(2L), null));
		os.addOrder(new Orders(new Date(), "CANCELLED", null, us.findUserById(1L), null));
		os.addOrder(new Orders(new Date(), "PROCESSING", null, us.findUserById(1L), null));

		/* ADD ORDER DETAILS */
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "GA213512", os.findOrderById(1L)));
		ods.addOrderDetails(new OrderDetail(2, 225.50, 2, "GA212312", os.findOrderById(1L)));
		ods.addOrderDetails(new OrderDetail(3, 215.50, 2, "GA2514512", os.findOrderById(1L)));
		ods.addOrderDetails(new OrderDetail(1, 125.50, 2, "GA2135142", os.findOrderById(2L)));
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "HN254512", os.findOrderById(3L)));
		ods.addOrderDetails(new OrderDetail(1, 625.50, 2, "HN21512", os.findOrderById(4L)));
		ods.addOrderDetails(new OrderDetail(2, 215.50, 2, "HN25312", os.findOrderById(4L)));
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "HN259712", os.findOrderById(5L)));
		ods.addOrderDetails(new OrderDetail(2, 75.50, 2, "HN258912", os.findOrderById(5L)));
		ods.addOrderDetails(new OrderDetail(1, 15.50, 2, "HN253212", os.findOrderById(6L)));
		ods.addOrderDetails(new OrderDetail(1, 35.50, 2, "HN252412", os.findOrderById(7L)));
		ods.addOrderDetails(new OrderDetail(1, 15.50, 1, "LE96323", os.findOrderById(8L)));
		ods.addOrderDetails(new OrderDetail(1, 65.50, 2, "LE91223", os.findOrderById(9L)));
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "LE91878", os.findOrderById(10L)));
		ods.addOrderDetails(new OrderDetail(2, 15.50, 2, "LE12823", os.findOrderById(10L)));
		ods.addOrderDetails(new OrderDetail(3, 215.50, 2, "LE98923", os.findOrderById(10L)));
		ods.addOrderDetails(new OrderDetail(1, 125.50, 2, "LE90823", os.findOrderById(11L)));
		ods.addOrderDetails(new OrderDetail(2, 25.50, 2, "LE90023", os.findOrderById(11L)));
		ods.addOrderDetails(new OrderDetail(1, 525.50, 2, "IP19820", os.findOrderById(12L)));
		ods.addOrderDetails(new OrderDetail(1, 225.50, 2, "IP09120", os.findOrderById(13L)));
		ods.addOrderDetails(new OrderDetail(2, 25.50, 2, "IP19030", os.findOrderById(13L)));
		ods.addOrderDetails(new OrderDetail(1, 225.50, 3, "IP54120", os.findOrderById(14L)));
		ods.addOrderDetails(new OrderDetail(1, 215.50, 2, "IP16420", os.findOrderById(15L)));
		ods.addOrderDetails(new OrderDetail(2, 25.50, 2, "IP16920", os.findOrderById(15L)));
		ods.addOrderDetails(new OrderDetail(3, 235.50, 2, "IP14220", os.findOrderById(15L)));
		ods.addOrderDetails(new OrderDetail(4, 215.50, 2, "GA218912", os.findOrderById(15L)));
		ods.addOrderDetails(new OrderDetail(1, 215.50, 2, "GA214612", os.findOrderById(16L)));
		ods.addOrderDetails(new OrderDetail(2, 215.50, 2, "GA21112", os.findOrderById(16L)));
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "GA216512", os.findOrderById(17L)));
		ods.addOrderDetails(new OrderDetail(1, 25.50, 2, "GA983512", os.findOrderById(18L)));
		ods.addOrderDetails(new OrderDetail(2, 251.50, 2, "GA210412", os.findOrderById(18L)));
		ods.addOrderDetails(new OrderDetail(2, 215.50, 2, "GA214622", os.findOrderById(2L)));
		ods.addOrderDetails(new OrderDetail(3, 725.50, 2, "GA209512", os.findOrderById(2L)));
		ods.addOrderDetails(new OrderDetail(2, 25.50, 2, "GA217822", os.findOrderById(3L)));
		ods.addOrderDetails(new OrderDetail(3, 245.50, 2, "GA210572", os.findOrderById(4L)));
		ods.addOrderDetails(new OrderDetail(3, 25.50, 2, "GA213978", os.findOrderById(5L)));
		ods.addOrderDetails(new OrderDetail(2, 25.50, 2, "GA20512", os.findOrderById(12L)));

		/* Update Orders to match order details */
		os.updateOrderDetailsList(1L, os.findAllOrderDetailsInOrder(1L));
		os.updateOrderDetailsList(2L, os.findAllOrderDetailsInOrder(2L));
		os.updateOrderDetailsList(3L, os.findAllOrderDetailsInOrder(3L));
		os.updateOrderDetailsList(4L, os.findAllOrderDetailsInOrder(4L));
		os.updateOrderDetailsList(5L, os.findAllOrderDetailsInOrder(5L));
		os.updateOrderDetailsList(6L, os.findAllOrderDetailsInOrder(6L));
		os.updateOrderDetailsList(7L, os.findAllOrderDetailsInOrder(7L));
		os.updateOrderDetailsList(8L, os.findAllOrderDetailsInOrder(8L));
		os.updateOrderDetailsList(9L, os.findAllOrderDetailsInOrder(9L));
		os.updateOrderDetailsList(10L, os.findAllOrderDetailsInOrder(10L));
		os.updateOrderDetailsList(11L, os.findAllOrderDetailsInOrder(11L));
		os.updateOrderDetailsList(12L, os.findAllOrderDetailsInOrder(12L));
		os.updateOrderDetailsList(13L, os.findAllOrderDetailsInOrder(13L));
		os.updateOrderDetailsList(14L, os.findAllOrderDetailsInOrder(14L));
		os.updateOrderDetailsList(15L, os.findAllOrderDetailsInOrder(15L));
		os.updateOrderDetailsList(16L, os.findAllOrderDetailsInOrder(16L));
		os.updateOrderDetailsList(17L, os.findAllOrderDetailsInOrder(17L));
		os.updateOrderDetailsList(18L, os.findAllOrderDetailsInOrder(18L));

		/* ADD SHIPMENTS */
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(2L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(3L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(4L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(5L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(7L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(8L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(9L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(11L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(14L)));
		ss.addShipment(new Shipment(new Date(), new Date(), os.findOrderById(15L)));

		/* Update order to reflect shipments ONLY where status = "SHIPPED" */
		os.updateOrderShipmentDetails(2L, os.findAllShipmentsInOrder(2L));
		os.updateOrderShipmentDetails(3L, os.findAllShipmentsInOrder(3L));
		os.updateOrderShipmentDetails(4L, os.findAllShipmentsInOrder(4L));
		os.updateOrderShipmentDetails(5L, os.findAllShipmentsInOrder(5L));
		os.updateOrderShipmentDetails(7L, os.findAllShipmentsInOrder(7L));
		os.updateOrderShipmentDetails(8L, os.findAllShipmentsInOrder(8L));
		os.updateOrderShipmentDetails(9L, os.findAllShipmentsInOrder(9L));
		os.updateOrderShipmentDetails(11L, os.findAllShipmentsInOrder(11L));
		os.updateOrderShipmentDetails(14L, os.findAllShipmentsInOrder(14L));
		os.updateOrderShipmentDetails(15L, os.findAllShipmentsInOrder(15L));

		/* ADD CARTS 1 per user */
		cts.addCart(new Cart(us.findUserById(1L), null));
		cts.addCart(new Cart(us.findUserById(2L), null));
		cts.addCart(new Cart(us.findUserById(3L), null));
		cts.addCart(new Cart(us.findUserById(4L), null));
		cts.addCart(new Cart(us.findUserById(5L), null));

		/* ADD CART ITEMS */
		cis.addCartItem(new CartItems(1, 5, 39.99, "LE90023", cts.findCartById(1L)));
		cis.addCartItem(new CartItems(2, 7, 9.99, "IP19820", cts.findCartById(1L)));
		cis.addCartItem(new CartItems(3, 1, 339.99, "GA214612", cts.findCartById(1L)));
		cis.addCartItem(new CartItems(1, 2, 39.99, "LE90023", cts.findCartById(2L)));
		cis.addCartItem(new CartItems(2, 8, 19.99, "LE9223", cts.findCartById(2L)));
		cis.addCartItem(new CartItems(1, 3, 39.99, "LE932023", cts.findCartById(3L)));
		cis.addCartItem(new CartItems(2, 1, 29.99, "LE96023", cts.findCartById(3L)));
		cis.addCartItem(new CartItems(1, 8, 69.99, "LE96023", cts.findCartById(4L)));
		cis.addCartItem(new CartItems(2, 5, 89.99, "LE80023", cts.findCartById(4L)));
		cis.addCartItem(new CartItems(3, 5, 19.99, "LE72023", cts.findCartById(4L)));
		cis.addCartItem(new CartItems(1, 5, 19.99, "LE98623", cts.findCartById(5L)));
		cis.addCartItem(new CartItems(2, 7, 39.99, "LE03023", cts.findCartById(5L)));
		cis.addCartItem(new CartItems(3, 2, 29.99, "LE7823", cts.findCartById(5L)));
		
		System.out.println(cts.findCartById(1L));
		for (CartItems item : cts.findAllItemsInCart(1L)) {
			System.out.println(item);
			item.setCart(null);
			cis.deleteCartItems(cis.findCartItemsById(item.getId()));
		}
		cts.findCartById(1L).setCartItems(null);		
		cts.deleteCart(cts.findCartById(1L));
	
	}

	private void close() {
		us.closeConnection();
		cs.closeConnection();
		ps.closeConnection();
		os.closeConnection();
		ods.closeConnection();
		ss.closeConnection();
		cts.closeConnection();
		cis.closeConnection();
	}

}
