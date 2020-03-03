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
		}
		
		os.closeConnection();
		
		session.removeAttribute("userCart");
		session.removeAttribute("userCartQuantity");

		response.sendRedirect("orderplaced.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
