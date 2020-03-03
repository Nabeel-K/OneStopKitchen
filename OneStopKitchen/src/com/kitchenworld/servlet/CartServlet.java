/*
 * Filename: LoginServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-26-20 Original Creation
 * Maint Date: 2-27-20 Finished functionality
 * Maint Date: 3-01-20 Added Cart total calculation
 * Maint Date: 3-03-20 Handled duplicate items being added
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

/**
 * Servlet implementation class CartServlet
 * 
 * @author Nabeel
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemName = request.getParameter("productName");
		String unparsedPrice = request.getParameter("productPrice");
		String unparsedQuantity = request.getParameter("quantity");

		HttpSession session = request.getSession();
		Cart tempCart = (Cart) session.getAttribute("userCart");
		List<CartItems> items = tempCart.getCartItems();

		if (itemName != null && unparsedPrice != null && unparsedQuantity != null) {
			CartItems itemToAdd = new CartItems();
			double itemPrice = Double.parseDouble(unparsedPrice);
			int quantityOrdered = Integer.parseInt(unparsedQuantity);
			boolean isInCart = false;
			itemToAdd.setSkuNumber(itemName);
			for (CartItems item : items) {
				if (item.getSkuNumber().equals(itemToAdd.getSkuNumber())) {
					item.setQuantity(item.getQuantity() + quantityOrdered);
					isInCart = true;
					break;
				}
			}
			if (!isInCart) {
				itemToAdd.setPriceEach(itemPrice);
				itemToAdd.setQuantity(quantityOrdered);
				itemToAdd.setCart(tempCart);
				itemToAdd.setLineNumber(tempCart.getCartItems().size() + 1);
				items.add(itemToAdd);
				tempCart.setCartItems(items);
			}

		}

		double total = 0;
		int cartQuantity = 0;
		for (CartItems item : items) {
			total += (item.getPriceEach() * item.getQuantity());
			cartQuantity += item.getQuantity();
		}

		session.setAttribute("userCart", tempCart);
		session.setAttribute("userCartQuantity", cartQuantity);
		request.setAttribute("cartTotal", total);
		request.getRequestDispatcher("cart.jsp").forward(request, response);

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
