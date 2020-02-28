/*
 * Filename: LoginServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-26-20 Original Creation
 * Maint Date: 2-27-20 Finished functionality
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

/**
 * Servlet implementation class CartServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemName = request.getParameter("productName");
		double itemPrice = Double.parseDouble(request.getParameter("productPrice"));
		int quantityOrdered = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		
		Cart tempCart = (Cart)session.getAttribute("userCart");
		
		CartItems item = new CartItems();
		item.setSkuNumber(itemName);
		item.setPriceEach(itemPrice);
		item.setQuantity(quantityOrdered);
		item.setCart(tempCart);
		item.setLineNumber(tempCart.getCartItems().size() + 1);
		
		List<CartItems> newItems = tempCart.getCartItems();
		newItems.add(item);
		tempCart.setCartItems(newItems);
		
		session.setAttribute("userCart", tempCart);
		response.sendRedirect("cart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
