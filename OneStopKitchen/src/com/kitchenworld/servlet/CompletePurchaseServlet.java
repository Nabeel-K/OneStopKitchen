/*
 * Filename: CompletePurchaseServlet.java
 * Author: Nabeel Khan
 * Creation Date: 3-01-20 Original Creation
 * Maint Date 3-03-20 Added handler for removing the quantity of items from session
 * */
package com.kitchenworld.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;
import com.kitchenworld.entity.OrderDetail;
import com.kitchenworld.entity.Orders;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;
import com.kitchenworld.services.OrderDetailsService;
import com.kitchenworld.services.OrdersService;

/**
 * Servlet implementation class CompletePurchaseServlet
 * @author Nabeel
 */
@WebServlet("/purchase")
public class CompletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		Cart cart = (Cart) session.getAttribute("userCart");
		Orders order = new Orders();
		List<OrderDetail> orderDetails = new ArrayList<>();

		order.setDateOrdered(new Date());
		order.setOrderStatus("PROCESSING");
		
		OrdersService os = new OrdersService();
		OrderDetailsService ods = new OrderDetailsService();
		
		long idToUpdate = os.findAllOrders().size() + 1;

		
		os.addOrder(order);
		
		int i = 1;
		for (CartItems item : cart.getCartItems()) {
			OrderDetail orderDetail = new OrderDetail();

			orderDetail.setLineNumber(i);
			++i;
			orderDetail.setOrder(order);
			orderDetail.setPriceEach(item.getPriceEach());
			orderDetail.setQuantityOrdered(item.getQuantity());
			orderDetail.setSkuNumber(item.getSkuNumber());
			
			orderDetails.add(orderDetail);
			
			ods.addOrderDetails(orderDetail);
		}
		ods.closeConnection();
		
		os.updateOrderDetailsList(idToUpdate, orderDetails);
		
		if(loggedInUser != null) {
			os.updateOrderUsers(idToUpdate, loggedInUser);
			List<CartItems> items = cart.getCartItems();
			CartService cs = new CartService();
			CartItemsService cis = new CartItemsService();
			System.out.println(cs.findAllItemsInCart(cart.getCartId()));
			for(CartItems item : cs.findAllItemsInCart(cart.getCartId())) {
				cis.deleteCartItems(cis.findCartItemsById(item.getId()));
			}
			cs.closeConnection();
			cis.closeConnection();
			items.clear();
			cart.setCartItems(items);
			session.setAttribute("userCart", cart);
		} else {
			Cart emptyCart = new Cart();
			List<CartItems> cartItemList = new ArrayList<>();
			emptyCart.setCartItems(cartItemList);
			session.setAttribute("userCart",emptyCart);
		}
		
		os.closeConnection();
		
		session.setAttribute("userCartQuantity",0);
		response.sendRedirect("orderplaced.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
