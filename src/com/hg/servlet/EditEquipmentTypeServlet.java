package com.hg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hg.domain.EquipmentType;
import com.hg.service.IEquipmentTypeService;
import com.hg.service.impl.EquipmentTypeServiceImpl;

/**
 * Servlet implementation class EditEquipmentTypeServlet
 */
@WebServlet(name = "/EditEquipmentTypeServlet", urlPatterns = { "/EquipmentTypeEdit" })
public class EditEquipmentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEquipmentTypeServlet() {
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
		System.out.println("EditEquipmentTypeServlet");
		IEquipmentTypeService equipmentTypeService = new EquipmentTypeServiceImpl();

		EquipmentType equipmentType = new EquipmentType();
		equipmentType.setTypeId(request.getParameter("typeId"));
		equipmentType.setTypeName(new String(request.getParameter("typeName")
				.getBytes("ISO8859_1"), "UTF-8"));

		// System.out.println(equipmentType.toString());

		int rs = equipmentTypeService.editEquipmentType(equipmentType);

		if (rs == 1) {
			PrintWriter writer = response.getWriter();
			writer.write("success edit");
			writer.close();
		} else {
			// System.out.println("fail");
			PrintWriter writer = response.getWriter();
			writer.write("fail edit");
			writer.close();
		}
	}

}
