/*
 * Filename: WelcomeServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-24-20 Original Creation
 * Maint Date: 3-02-20 Added cart quantity to accurately keep track of number of items in cart
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
import com.kitchenworld.entity.Category;
import com.kitchenworld.services.CartService;
import com.kitchenworld.services.CategoryService;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(description = "Servlet to handle the landing page information", urlPatterns = { "/welcome" })
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = null;
		List<CartItems> cartItemList;
		if (session.getAttribute("userCart") == null) {
			System.out.println("Makin carts");
			Cart emptyCart = new Cart();
			cartItemList = new ArrayList<>();
			emptyCart.setCartItems(cartItemList);
			session.setAttribute("userCart", emptyCart);

		} else {
			cart = (Cart) session.getAttribute("userCart");

			if (session.getAttribute("loggedInUser") != null){
				int cartQuantity = 0;

				CartService cs = new CartService();
				cartItemList = cs.findAllItemsInCart(cart.getCartId());
				
					for (CartItems item : cartItemList) {
						cartQuantity += item.getQuantity();
					}
					session.setAttribute("userCartQuantity", cartQuantity);
			}
			
			
		}

		if (session.getAttribute("userCartQuantity")==null) {
			session.setAttribute("userCartQuantity", 0);
		}

		CategoryService cs = new CategoryService();
		List<Category> categories = cs.findAllCategories();
		cs.closeConnection();
		
		session.setAttribute("categories", categories);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
