package com.app;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminProductsServlet
 */
@WebServlet("/admin/products")
public class AdminProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CustomerDaoBean cDaoBean;
	@EJB
	private ProductDaoBean pDaoBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String authUser = request.getRemoteUser();
		User user = cDaoBean.findByEmail(authUser);
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String[] login = {firstName,lastName};
		request.setAttribute("login", login);
		List<Product> products = pDaoBean.getProducts();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/admin/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
