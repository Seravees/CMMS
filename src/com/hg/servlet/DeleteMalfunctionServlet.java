package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hg.service.IMalfunctionService;
import com.hg.service.impl.MalfunctionServiceImpl;

/**
 * 报修记录删除 Servlet implementation class DeleteMalfunctionServlet
 */
@WebServlet("/DeleteMalfunctionServlet")
public class DeleteMalfunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMalfunctionServlet() {
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
		System.out.println("DeleteMalfunctionServlet");
		IMalfunctionService malfunctionService = new MalfunctionServiceImpl();
		String malfunctionId = request.getParameter("malfunctionId");
		int rs = malfunctionService.deleteMalfunction(malfunctionId);
		if (rs == 1) {
			PrintWriter writer = response.getWriter();
			writer.write("success delete");
			writer.close();
		} else {
			// System.out.println("fail");
			PrintWriter writer = response.getWriter();
			writer.write("fail delete");
			writer.close();
		}
	}

}
