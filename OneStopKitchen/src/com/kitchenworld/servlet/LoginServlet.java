/*
 * Filename: LoginServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-23-20 Original Creation
 * Maint Date: 2-25-20 Updated to add user's cart to session
 * 
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

import com.kitchenworld.entity.User;
import com.kitchenworld.services.UserService;

/**
 * Servlet implementation class LoginServlet
 * @author Nabeel
 */
@WebServlet(description = "Servlet to handle validation of login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("loginEmail");
		String pass = request.getParameter("loginPassword");
		UserService us = new UserService();
		
		User userLoggingIn = us.loginMatch(email, pass);
		
		if(userLoggingIn != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", userLoggingIn);
			session.setAttribute("userCart", userLoggingIn.getCart());
			response.sendRedirect("welcome");
		} else {
			request.setAttribute("errorMessage", "Invalid email or password. Please try again");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		us.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
