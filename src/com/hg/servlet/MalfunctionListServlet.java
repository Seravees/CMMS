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
import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMaintenanceService;
import com.hg.service.IMalfunctionService;
import com.hg.service.impl.MaintenanceServiceImpl;
import com.hg.service.impl.MalfunctionServiceImpl;

/**
 * Servlet implementation class MalfunctionListServlet
 */
@WebServlet("/MalfunctionListServlet")
public class MalfunctionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MalfunctionListServlet() {
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
		System.out.println("MalfunctionListServlet");

		IMalfunctionService malfunctionService = new MalfunctionServiceImpl();
		IMaintenanceService maintenanceService = new MaintenanceServiceImpl();

		String confirm = null;
		confirm = request.getParameter("confirm");
		String malfunctionId = request.getParameter("malfunctionId");
		String equipmentRemark = null;
		equipmentRemark = request.getParameter("equipmentRemark");
		// System.out.println(confirm);
		if (confirm != null) {
			if (confirm.equals("1")) {
				malfunctionService.editMalfunctionState(malfunctionId, "3");
			} else if (confirm.equals("2")) {
				// System.out.println(malfunctionId);
				// System.out.println(equipmentRemark);
				maintenanceService.updateMremarkbyMrecordsId(equipmentRemark);
				malfunctionService.editMalfunctionState(malfunctionId, "1");
			}
		}
		String malfunctionState = null;
		malfunctionState = request.getParameter("malfunctionState");
		List<MalfunctionRecords> list;
		if (malfunctionState != null) {
			list = malfunctionService.getMalfunction(malfunctionState);
		} else {
			list = malfunctionService.getMalfunction();
		}

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		System.out.println(request.getSession().getAttribute("name"));
	}

}
