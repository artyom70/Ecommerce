package com.app;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminUserAddServlet
 */
@WebServlet(urlPatterns = "/admin/users/add",
	initParams = @WebInitParam(name="redirectUrl", value="http://localhost:8080/Ecommerce/admin/users")
		)
public class AdminUserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CustomerDaoBean cDaoBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserAddServlet() {
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
		request.getRequestDispatcher("/admin/adduser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		password = HashBean.getMd5(password);
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);	
		Group group = new Group();
		if(role .equals("1")) {
			group.setGroupName("admin");
		}
		else if(role.equals("2")){
			group.setGroupName("user");
		}
		group.setUser(user);
		cDaoBean.createUser(user,group);
		ServletConfig conf = getServletConfig();
		String url = conf.getInitParameter("redirectUrl");
		response.sendRedirect(url);
	}

}
