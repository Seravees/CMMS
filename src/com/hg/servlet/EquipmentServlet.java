package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EquipmentServlet
 */
@WebServlet(name = "/EquipmentServlet", urlPatterns = { "/equipment" })
public class EquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EquipmentServlet() {
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
		System.out.println("EquipmentServlet");

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
				"<table id='datagrid-equipment' class='easyui-datagrid' title='设备'"
						+ "	style='border-left: 0px; border-right: 0px;' "
						+ "toolbar='#toolbar' rownumbers='true' singleSelect='true'>"
						+ "</table>"
						+ "<div id='toolbar'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-add' plain='true' onclick='newEquipment()'>"
						+ "添加设备</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='editEquipment()'>"
						+ "编辑设备</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='removeEquipment()'>"
						+ "删除设备</a>"
						+ "</div>"
						+ "<div id='dlg-equipment' class='easyui-dialog' style='width:400px;height:600px;padding:10px 20px' closed='true'  buttons='#dlg-equipment-buttons'>"
						+ "<form id='fm-equipment' method='post'>"
						+ "<div class='fitem'><label>设备编号：</label><br>"
						+ "<input id='equipmentNo' name='equipmentNo' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备类型：</label><br>"
						+ "<input id='equipmentType' name='equipmentType' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备内部名称：</label><br>"
						+ "<input id='equipmentNameInside' name='equipmentNameInside' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备外部名称：</label><br>"
						+ "<input id='equipmentNameOutside' name='equipmentNameOutside' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>开始使用日期：</label><br>"
						+ "<input id='accountStarttime' name='accountStarttime' class='easyui-datebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备状态：</label><br>"
						+ "<input id='equipmentState' name='equipmentState' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>设备位置：</label><br>"
						+ "<input id='equipmentAddress' name='equipmentAddress' class='easyui-validatebox' required='true' style='width: 200px'></div><br>"
						+ "<div class='fitem'><label>备注：</label><br>"
						+ "<input id='equipmentRemark' name='equipmentRemark' class='easyui-textbox' "
						+ "data-options='multiline:true' style='width: 200px; height: 50px'></div><br>"
						+ "</form>"
						+ "</div>"
						+ "<div id='dlg-equipment-buttons'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-ok' onclick='saveEquipment()'>save</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-cancel' onclick='closeDlgEquipment()'>取消</a>"
						+ "</div>");

		request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(
				request, response);
	}

}
