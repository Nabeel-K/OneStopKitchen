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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;
import com.kitchenworld.services.CartItemsService;
import com.kitchenworld.services.CartService;

/**
 * Servlet implementation class LogoutServlet
 * 
 * @author Nabeel
 */
@WebServlet(description = "A servlet to handle logging out", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Save user's cart
		Cart cartToSave = (Cart) session.getAttribute("userCart");
		List<CartItems> itemsToSave = cartToSave.getCartItems();

		CartService cs = new CartService();
		CartItemsService cis = new CartItemsService();

		for (CartItems item : cs.findAllItemsInCart(cartToSave.getCartId())) {
			cis.deleteCartItems(cis.findCartItemsById(item.getId()));
		}
		for (CartItems item : itemsToSave) {
			cis.addCartItem(item);
		}
		cs.updateCartItems(cartToSave.getCartId(), itemsToSave);

		cs.closeConnection();
		cis.closeConnection();

		Cart emptyCart = new Cart();
		List<CartItems> cartItemList = new ArrayList<>();
		emptyCart.setCartItems(cartItemList);

		session.removeAttribute("loggedInUser");
		session.setAttribute("userCart", emptyCart);
		session.setAttribute("userCartQuantity", 0);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
