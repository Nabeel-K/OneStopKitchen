/*
 * Filename: CreateAccountServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-23-20 Original Creation
 * Maint Date: 
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

import org.mindrot.jbcrypt.BCrypt;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.User;
import com.kitchenworld.services.CartService;
import com.kitchenworld.services.UserService;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet(description = "Servlet to handle account creation", urlPatterns = { "/create_account" })
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User newUser = new User();
		newUser.setFirstName(request.getParameter("firstName"));
		newUser.setLastName(request.getParameter("lastName"));
		newUser.setEmail(request.getParameter("loginEmail"));
		newUser.setPassword(BCrypt.hashpw(request.getParameter("createPassword"), BCrypt.gensalt()));
		
		Cart cart = new Cart();
		cart.setUser(newUser);
		
		UserService us = new UserService();
		us.addUser(newUser);
		newUser.setCart(cart);
		List<User> allUsers = us.findAllUsers();
		us.updateCart(allUsers.get(allUsers.size()-1).getUserId(), cart);
		
		HttpSession session = request.getSession();
		session.setAttribute("loggedInUser", newUser);
		session.setAttribute("userCart", cart);
		us.closeConnection();
		response.sendRedirect("welcome");
		
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
