package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMaintenanceService;
import com.hg.service.impl.MaintenanceServiceImpl;

/**
 * Servlet implementation class MaintenanceListServlet
 * 维修记录列表展示
 */
@WebServlet("/MaintenanceListServlet")
public class MaintenanceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaintenanceListServlet() {
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
		System.out.println("MaintenanceListServlet");
		IMaintenanceService maintenanceService = new MaintenanceServiceImpl();

		MalfunctionRecords malr = new MalfunctionRecords();
		malr.setMalfunctionId(request.getParameter("malfunctionId"));

		List<MaintenanceRecords> list = maintenanceService
				.getMaintenanceRecordsByMalfunction(malr);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		System.out.println(request.getSession().getAttribute("name"));

	}

}
