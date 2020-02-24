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
 */
@WebServlet(description = "Servlet to handle validation of login", urlPatterns = { "/LoginServlet" })
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
		us.connect();
		
		User userLoggingIn = new User();
		
		userLoggingIn.setEmail(email);
		userLoggingIn.setPassword(pass);
		
		if(us.loginMatch(userLoggingIn)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", userLoggingIn);
			response.sendRedirect("index.jsp");
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
