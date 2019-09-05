package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hg.domain.Equipment;
import com.hg.service.IEquipmentService;
import com.hg.service.impl.EquipmentServiceImpl;

/**
 * Servlet implementation class AddEquipmentServlet
 */
@WebServlet(name = "/AddEquipmentServlet", urlPatterns = { "/EquipmentSave" })
public class AddEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEquipmentServlet() {
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
		System.out.println("AddEquipmentServlet");
		IEquipmentService equipmentService = new EquipmentServiceImpl();

		Equipment equipment = new Equipment();
		equipment.setEquipmentNo(request.getParameter("equipmentNo"));
		equipment.setEquipmentType(request.getParameter("equipmentType"));
		equipment.setEquipmentNameInside(request
				.getParameter("equipmentNameInside"));
		equipment.setEquipmentNameOutside(request
				.getParameter("equipmentNameOutside"));
		equipment.setAccountStarttime(request.getParameter("accountStarttime"));
		equipment.setEquipmentState(request.getParameter("equipmentState"));
		equipment.setEquipmentAddress(request.getParameter("equipmentAddress"));
		equipment.setEquipmentRemark(request.getParameter("equipmentRemark"));

		System.out.println(equipment.toString());
		int rs = equipmentService.addEquipment(equipment);
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
