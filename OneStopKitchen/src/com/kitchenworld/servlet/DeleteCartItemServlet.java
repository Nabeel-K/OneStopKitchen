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
 * Servlet implementation class DeleteCartItemServlet
 */
@WebServlet("/deleteitem")
public class DeleteCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("cartItem");
		if(!item.equals(null)) {
			HttpSession session = request.getSession();
			Cart cart =(Cart) session.getAttribute("userCart");
			int itemIndexToRemove = -1;
			int i = 0;
			for (CartItems itemToRemove : cart.getCartItems()) {
				if(itemToRemove.getSkuNumber().contentEquals(item)) {
					itemIndexToRemove = i;
					break;
				}
				++i;
			}
			cart.getCartItems().remove(itemIndexToRemove);
			session.setAttribute("userCart", cart);
		}
		response.sendRedirect("cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
