package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EquipmentTypeServlet
 */
@WebServlet(name = "/EquipmentTypeServlet", urlPatterns = { "/equipmentType" })
public class EquipmentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EquipmentTypeServlet() {
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
		System.out.println("EquipmentTypeServlet");

		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect("/CMMS/index.jsp");
			return;
		}
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		if (name == null) {
			response.sendRedirect("/CMMS/index.jsp");
			return;
		}

		request.setAttribute(
				"datagridHtml",
				"<table id='datagrid-equipment-type' class='easyui-datagrid' title='设备类型'"
						+ "	style='border-left: 0px; border-right: 0px;' "
						+ "toolbar='#toolbar' rownumbers='true' singleSelect='true'>"
						+ "</table>"
						+ "<div id='toolbar'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-add' plain='true' onclick='newEquipmentType()'>"
						+ "添加设备类型</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='editEquipmentType()'>"
						+ "编辑设备类型</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='removeEquipmentType()'>"
						+ "删除设备类型</a>"
						+ "</div>"
						+ "<div id='dlg-equipment-type' class='easyui-dialog' style='width:400px;height:250px;padding:10px 20px' closed='true'  buttons='#dlg-equipment-type-buttons'>"
						+ "<form id='fm-equipment-type' method='post'>"
						+ "<div class='fitem'><label>设备类型ID：</label><br>"
						+ "<input id='typeId' name='typeId' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备类型：</label><br>"
						+ "<input id='typeName' name='typeName' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "</form>"
						+ "</div>"
						+ "<div id='dlg-equipment-type-buttons'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-ok' onclick='saveEquipmentType()'>save</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-cancel' onclick='closeDlgEquipmentType()'>取消</a>"
						+ "</div>");

		request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(
				request, response);
	}

}
