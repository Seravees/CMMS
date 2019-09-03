package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hg.domain.User;
import com.hg.service.IUserService;
import com.hg.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet 用户登录
 */
@WebServlet(name = "/LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginServlet");
		String accountID = request.getParameter("accountID");
		String psd = request.getParameter("psd");
		String url = null;

		IUserService service = new UserServiceImpl();
		User user = service.loginUser(accountID, psd);
		if (user.getAccountGroupID() != null) {
			switch (user.getAccountGroupID()) {
			case "1":
				url = "/WEB-INF/pages/manage.jsp";
				break;
			case "2":
				url = "/WEB-INF/pages/maintenance.jsp";
				break;
			case "3":
				url = "/WEB-INF/pages/malfunction.jsp";
				break;
			}
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("url", url);
			// request.setAttribute("name", user.getName());
			request.setAttribute("datagridHtml", "");
			// request.setAttribute("test1", "user");
			request.setAttribute("user", user);
			// System.out.println(url);
			// response.sendRedirect(url);
			// request.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect("/CMMS/manageServlet");
		} else {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}
}
