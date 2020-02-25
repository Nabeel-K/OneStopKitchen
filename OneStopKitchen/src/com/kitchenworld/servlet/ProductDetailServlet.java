/*
 * Filename: ProductServlet.java
 * Author: Nabeel Khan
 * Creation Date: 2-25-20 Original Creation
 * Maint Date: 
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

import com.kitchenworld.entity.Product;
import com.kitchenworld.services.ProductService;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet(description = "Handles the details page for a single product", urlPatterns = { "/details" })
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("product");
		ProductService ps = new ProductService();
		Product product = ps.findProductByName(productName);
		request.setAttribute("product", product);
		request.getRequestDispatcher("productDetail.jsp").forward(request, response);
		
	}
}
