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
import com.hg.domain.Equipment;
import com.hg.service.IEquipmentService;
import com.hg.service.impl.EquipmentServiceImpl;

/**
 * Servlet implementation class EquipmentServlet
 * 设备列表展示
 */
@WebServlet("/EquipmentServlet")
public class EquipmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EquipmentListServlet() {
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
		System.out.println("EquipmentListServlet");
		IEquipmentService equipmentService = new EquipmentServiceImpl();
		List<Equipment> list = equipmentService.getEquipment();

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		// System.out.println("flag");
	}

}
