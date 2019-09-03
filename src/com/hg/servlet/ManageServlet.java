package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageServlet 根据用户权限跳转
 */
@WebServlet(name = "/ManageServlet", urlPatterns = { "/manageServlet" })
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageServlet() {
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
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ManageServlet");
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect("/CMMS/index.jsp");
			return;
		}
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		if (name == null) {
			response.sendRedirect("/CMMS/index.jsp");
			return;
		}

		request.setAttribute("datagridHtml", "");
		request.getRequestDispatcher((String) session.getAttribute("url"))
				.forward(request, response);
	}

}
