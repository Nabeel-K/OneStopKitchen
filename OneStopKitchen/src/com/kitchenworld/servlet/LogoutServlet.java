/*
 * Filename: LogoutServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-23-20 Original Creation
 * Maint Date: 3-03-20 Added functionality to save user's cart upon logout
 * 
 * 
 * */
package com.kitchenworld.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;

/**
 * Servlet implementation class LogoutServlet
 * @author Nabeel
 */
@WebServlet(description = "A servlet to handle logging out", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//Save user's cart
		Cart cartToSave = (Cart) session.getAttribute("userCart");
		List<CartItems> itemsToSave = cartToSave.getCartItems();
		
		cartToSave.setUser((User)session.getAttribute("loggedInUser"));
		for (CartItems item: itemsToSave) {
			item.setCart(cartToSave);
		}
		
		CartService cs = new CartService();
		CartItemsService cis = new CartItemsService();
		//cs.deleteAllItemsInCart(cartToSave.getCartId());
		
		for (CartItems item: itemsToSave) {
			cis.addCartItem(item);
		}
		cs.closeConnection();
		cis.closeConnection();
		
		session.removeAttribute("loggedInUser");
		session.removeAttribute("userCart");
		session.removeAttribute("userCartQuantity");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
