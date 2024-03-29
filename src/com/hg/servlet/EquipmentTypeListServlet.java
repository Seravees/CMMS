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
import com.hg.domain.EquipmentType;
import com.hg.service.IEquipmentTypeService;
import com.hg.service.impl.EquipmentTypeServiceImpl;

/**
 * Servlet implementation class EquipmentTypeListServlet
 */
@WebServlet(name = "/EquipmentTypeListServlet", urlPatterns = { "/equipmentTypeList" })
public class EquipmentTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EquipmentTypeListServlet() {
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
		System.out.println("EquipmentTypeListServlet");

		IEquipmentTypeService equipmentTypeService = new EquipmentTypeServiceImpl();
		List<EquipmentType> list = equipmentTypeService.findAllEquipmentType();

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);

	}

}
