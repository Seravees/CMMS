package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hg.domain.MaintenanceRecords;
import com.hg.service.IMaintenanceService;
import com.hg.service.impl.MaintenanceServiceImpl;

/**
 * Servlet implementation class AddMaintenanceServlet
 */
@WebServlet("/AddMaintenanceServlet")
public class AddMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMaintenanceServlet() {
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
		System.out.println("AddMaintenanceServlet");
		IMaintenanceService maintenanceService = new MaintenanceServiceImpl();

		HttpSession session = request.getSession();
		MaintenanceRecords mr = new MaintenanceRecords();
		mr.setEquipmentNo(request.getParameter("equipmentNo-maintenanceAdd"));
		mr.setMalfunctionId(request
				.getParameter("malfunctionId-maintenanceAdd"));
		mr.setmResultRecords(new String(request.getParameter("mResultRecords")
				.getBytes("ISO8859_1"), "UTF-8"));
		mr.setmStarttime(request.getParameter("mStarttime"));
		mr.setmEndtime(request.getParameter("mEndtime"));
		mr.setmManName((String) session.getAttribute("name"));
		mr.setmState("");
		mr.setmRemark(new String(request.getParameter("mRemark").getBytes(
				"ISO8859_1"), "UTF-8"));

		System.out.println(mr.toString());

		maintenanceService.addMaintenanceRecords(mr);
	}

}
