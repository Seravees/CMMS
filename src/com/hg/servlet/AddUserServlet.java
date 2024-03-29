package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hg.domain.User;
import com.hg.service.IUserService;
import com.hg.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AddUserServlet 用户添加
 */
@WebServlet(name = "/AddUserServlet", urlPatterns = { "/UserSave" })
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
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
		System.out.println("AddUserServlet");
		User user = new User();
		user.setAccountID(request.getParameter("accountID"));
		user.setPsd(request.getParameter("psd"));
		user.setName(new String(request.getParameter("name").getBytes(
				"ISO8859_1"), "UTF-8"));
		user.setTel(request.getParameter("tel"));
		user.setAccountGroupID(request.getParameter("accountGroupID"));

		IUserService service = new UserServiceImpl();
		int rs = service.addUser(user);
		if (rs == 1) {
			PrintWriter writer = response.getWriter();
			writer.write("success add");
			writer.close();
		} else {
			// System.out.println("fail");
			PrintWriter writer = response.getWriter();
			writer.write("fail add");
			writer.close();
		}
	}

}
