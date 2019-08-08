package com.hg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute(
				"test",
				"<table id='datagrid' class='easyui-datagrid' title='用户'"
						+ "	style='border-left: 0px; border-right: 0px;' "
						+ "toolbar='#toolbar' rownumbers='true' singleSelect='true'>"
						+ "</table>"
						+ "<div id='toolbar'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-add' plain='true' onclick='newUser()'>"
						+ "添加用户</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='editUser()'>"
						+ "编辑用户</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='removeUser()'>"
						+ "删除用户</a>"
						+ "<input id='searchByName'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-search' plain='true' onclick='doSearch()'>"
						+ "查找用户</a>"
						+ "</div>"
						+ "<div id='dlg' class='easyui-dialog' style='width:400px;height:280px;padding:10px 20px' closed='true'  buttons='#dlg-buttons'>"
						+ "<form id='fm' method='post'>"
						+ "<div fitem><laber>用户名：</laber>"
						+ "<input name='user' class='easyui-validatebox' required='true'></div><br>"
						+ "<div fitem><laber>密    码：</laber>"
						+ "<input name='psd' class='easyui-validatebox' required='true' type='password'></div><br>"
						+ "<div fitem><laber>姓    名：</laber>"
						+ "<input name='name' class='easyui-validatebox' required='true'></div><br>"
						+ "</form>"
						+ "</div>"
						+ "<div id='dlg-buttons'>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-ok' onclick='saveUser()'>save</a>"
						+ "<a href='#' class='easyui-linkbutton' iconCls='icon-cancel' onclick='closeDlg()'>取消</a>"
						+ "</div>"
						+ "<script type='text/javascript' src='js/function.js'></script>"
						+ "<script type='text/javascript' src='js/search.js'></script>");
		request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(
				request, response);
	}

}
