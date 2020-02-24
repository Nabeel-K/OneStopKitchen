package com.kitchenworld.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitchenworld.entity.Product;
import com.kitchenworld.services.CategoryService;
import com.kitchenworld.services.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productType = request.getParameter("category");
		if(productType == null) {
			ProductService ps = new ProductService();
			List<Product> allProducts = ps.findAllProducts();
			request.setAttribute("categoryName", "All Products");
			request.setAttribute("products", allProducts);
			request.getRequestDispatcher("shop.jsp").forward(request, response);
			ps.closeConnection();
		} else {
			CategoryService cs = new CategoryService();
			List<Product> productsInCategory = cs.findAllProductsInCategory(1L); //update to use name of category
			request.setAttribute("categoryName", cs.findCategoryById(1L).getCategoryName());
			request.setAttribute("products", productsInCategory);
			response.sendRedirect("shop.jsp");
			cs.closeConnection();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}