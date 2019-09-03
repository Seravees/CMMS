package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMalfunctionService;
import com.hg.service.impl.MalfunctionServiceImpl;

/**
 * Servlet implementation class AddMalfunctionServlet 报修记录添加
 */
@WebServlet(name = "/AddMalfunctionServlet", urlPatterns = { "/malfunctionAdd" })
public class AddMalfunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMalfunctionServlet() {
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
		System.out.println("AddMalfunctionServlet");
		IMalfunctionService malfunctionService = new MalfunctionServiceImpl();
		HttpSession session = request.getSession();
		MalfunctionRecords mr = new MalfunctionRecords();
		mr.setEquipmentNo(request.getParameter("equipmentNo"));
		mr.setMalfunctionRecords(new String(request.getParameter(
				"malfunctionRecords").getBytes("ISO8859_1"), "UTF-8"));
		mr.setMalfunctionMan((String) session.getAttribute("name"));
		mr.setMalfunctionState("1");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mr.setMalfunctionTime(sdf.format(date));
		System.out.println(mr.toString());
		int rs = malfunctionService.addMalfunction(mr);
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
