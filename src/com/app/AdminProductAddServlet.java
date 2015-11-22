package com.app;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class AdminProductAddServlet
 */
@WebServlet(urlPatterns = {"/admin/products/add"},
	initParams = {@WebInitParam(name = "path", value="/uploads/original"),
			@WebInitParam(name = "resizePath", value = "/uploads/resize"),
			}
		)
@MultipartConfig(maxFileSize = 2097152)
public class AdminProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	private CustomerDaoBean cDaoBean;
	@EJB 
	private CategoryDaoBean categoryDaoBean;
	@EJB
	private ProductDaoBean productDaoBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductAddServlet() {
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
		List<Category> categories = categoryDaoBean.getCategories();
		request.setAttribute("login", login);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/admin/addproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int category = Integer.parseInt(request.getParameter("category"));
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productSize = request.getParameter("productSize");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		Product product = new Product();
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setProductSize(productSize);
		product.setPrice(productPrice);
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		String path = request.getServletContext().getRealPath(config.getInitParameter("path"));
		String resizedPath = request.getServletContext().getRealPath(config.getInitParameter("resizePath"));
		String uri = request.getRequestURI();
		String imageName = null;
		String imageName1 = null;
		String imageName2 = null;
		String imageName3 = null;
		String imageName4 = null;
		if(request.getPart("image") != null && request.getPart("image1") == null) {
			Part image = request.getPart("image");
			imageName = new UploadImageBean().uploadImage(path, resizedPath, image,context);
			if(imageName == null) {
				response.getWriter().println("Please input image <a href='"+uri+"'>go back</a>");
			}
			else {
				product.setProductImage(imageName);
				productDaoBean.addProduct(product, category);
				response.sendRedirect(uri);
			}
		}
		else if(request.getPart("image") != null && request.getPart("image1") !=null && request.getPart("image2")  == null) {
			Part image = request.getPart("image");
			Part image1 = request.getPart("image1");
			imageName = new UploadImageBean().uploadImage(path, resizedPath, image, context);
			imageName1 = new UploadImageBean().uploadImage(path, resizedPath, image1, context);
			if(imageName == null && imageName1 == null) {
				response.getWriter().println("Please input image <a href='"+uri+"'>go back</a>");
			}
			else {
				product.setProductImage(imageName);
				product.setProductImage1(imageName1);
				productDaoBean.addProduct(product, category);
				response.sendRedirect(uri);
			}
		}
		else if(request.getPart("image") != null && request.getPart("image1") !=null && request.getPart("image2")  != null && request.getPart("image3")  == null) {
			Part image = request.getPart("image");
			Part image1 = request.getPart("image1");
			Part image2 = request.getPart("image2");
			imageName = new UploadImageBean().uploadImage(path, resizedPath, image, context);
			imageName1 = new UploadImageBean().uploadImage(path, resizedPath, image1, context);
			imageName2 = new UploadImageBean().uploadImage(path, resizedPath, image2, context);
			if(imageName == null && imageName1 == null && imageName2 == null) {
				response.getWriter().println("Please input image <a href='"+uri+"'>go back</a>");
			}
			else {
				product.setProductImage(imageName);
				product.setProductImage1(imageName1);
				product.setProductImage2(imageName2);
				productDaoBean.addProduct(product, category);
				response.sendRedirect(uri);
			}
		}
		else if(request.getPart("image") != null && request.getPart("image1") !=null && request.getPart("image2")  != null && request.getPart("image3")  != null && request.getPart("image4") == null) {
			Part image = request.getPart("image");
			Part image1 = request.getPart("image1");
			Part image2 = request.getPart("image2");
			Part image3 = request.getPart("image3");
			imageName = new UploadImageBean().uploadImage(path, resizedPath, image, context);
			imageName1 = new UploadImageBean().uploadImage(path, resizedPath, image1, context);
			imageName2 = new UploadImageBean().uploadImage(path, resizedPath, image2, context);
			imageName3 = new UploadImageBean().uploadImage(path, resizedPath, image3, context);
			if(imageName == null && imageName1 == null && imageName2 == null && imageName3 == null) {
				response.getWriter().println("Please input image <a href='"+uri+"'>go back</a>");
			}
			else {
				product.setProductImage(imageName);
				product.setProductImage1(imageName1);
				product.setProductImage2(imageName2);
				product.setProductImage3(imageName3);
				productDaoBean.addProduct(product, category);
				response.sendRedirect(uri);
			}
		}
		else if(request.getPart("image") != null && request.getPart("image1") !=null && request.getPart("image2")  != null && request.getPart("image3")  != null && request.getPart("image4") != null) {
			Part image = request.getPart("image");
			Part image1 = request.getPart("image1");
			Part image2 = request.getPart("image2");
			Part image3 = request.getPart("image3");
			Part image4 = request.getPart("image4");
			imageName = new UploadImageBean().uploadImage(path, resizedPath, image, context);
			imageName1 = new UploadImageBean().uploadImage(path, resizedPath, image1, context);
			imageName2 = new UploadImageBean().uploadImage(path, resizedPath, image2, context);
			imageName3 = new UploadImageBean().uploadImage(path, resizedPath, image3, context);
			imageName4 = new UploadImageBean().uploadImage(path, resizedPath, image4, context);
			if(imageName == null && imageName1 == null && imageName2 == null && imageName3 == null && imageName4 == null) {
				response.getWriter().println("Please input image <a href='"+uri+"'>go back</a>");
			} 
			else {
				product.setProductImage(imageName);
				product.setProductImage1(imageName1);
				product.setProductImage2(imageName2);
				product.setProductImage3(imageName3);
				product.setProductImage4(imageName4);
				productDaoBean.addProduct(product, category);
				response.sendRedirect(uri);
			}
		}
		else {
			response.sendRedirect(uri);
		}
		
	}

}
