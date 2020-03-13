/*
 * Filename: UpdateCartServlet.java
 * Author: Nabeel Khan
 * Creation Date: 3-03-20 Original Creation
 *
 * 
 * */
package com.kitchenworld.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.CartItems;

/**
 * Servlet implementation class UpdateCartServlet
 * 
 * @author Nabeel
 */
@WebServlet("/updatecart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateItem = request.getParameter("cartItem");
		String quantity = request.getParameter("quantity");
		if (!updateItem.equals(null) && !quantity.equals(null)) {
			int newQuantity = Integer.parseInt(quantity);
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("userCart");
			int itemIndexToUpdate = -1;
			int i = 0;
			for (CartItems itemToUpdate : cart.getCartItems()) {
				if (itemToUpdate.getSkuNumber().contentEquals(updateItem)) {
					itemIndexToUpdate = i;
					break;
				}
				++i;
			}
			CartItems updatedItem = cart.getCartItems().get(i);
			updatedItem.setQuantity(newQuantity);
			cart.getCartItems().set(itemIndexToUpdate, updatedItem);
			session.setAttribute("userCart", cart);

			int newTotalQuantity = 0;
			for (CartItems item : cart.getCartItems()) {
				newTotalQuantity += item.getQuantity();
			}
			session.setAttribute("userCartQuantity", newTotalQuantity);
		}
		response.sendRedirect("cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}