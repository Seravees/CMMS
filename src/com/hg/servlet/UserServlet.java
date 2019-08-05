package com.hg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		request.setAttribute(
				"test",
				"<table class='easyui-datagrid' title='Basic DataGrid'"
						+ "	style='border-left: 0px; border-right: 0px;'>"
						+ "<thead><tr><th field='name1'>1</th><th field='name2'>2</th></tr></thead>"
						+ "<tbody><tr><td>1</td><td>2</td></tr></tbody>"
						+ "</table>");
		request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(
				request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute(
				"test",
				"<table class='easyui-datagrid' title='Basic DataGrid'"
						+ "	style='border-left: 0px; border-right: 0px;'>"
						+ "<thead><tr><th field='name1'>1</th><th field='name2'>2</th></tr></thead>"
						+ "<tbody><tr><td>1</td><td>2</td></tr></tbody>"
						+ "</table>");
		request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(
				request, response);
	}

}
