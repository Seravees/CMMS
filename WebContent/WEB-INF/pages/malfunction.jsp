<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/easyUIDemo/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUIDemo/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/themes/icon.css"></link>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/demo/demo.css"></link>
<script type="text/javascript"
	src="js/easyUIDemo/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	width: 100%;
	height: 100%;
}
</style>
<title>报修</title>
</head>
<body>

	<div class="easyui-layout" style="height: 550px">

		<div data-options="region:'north',split:true,collapsible:false"
			style="height: 50px">
			<%=session.getAttribute("name")%>
			<a href='logout' class='easyui-linkbutton' plain='true'>注销</a>
		</div>

		<div data-options="region:'west',split:true,collapsible:false"
			title="" style="width: 300px;">
			<div class="easyui-sidemenu"
				data-options="data:datalist,onSelect:function(obj){		
				if(obj.text=='用户管理'){
					post('user');
				}else if(obj.text=='设备管理'){
					post('user');		
				}
				
			}"
				style="width: 293px;"></div>
		</div>

		<div data-options="region:'center'" title=""
			style="border-left: 0px; border-right: 0px;">
			<table id='datagrid' class='easyui-datagrid' title='报修'
				style='border-left: 0px; border-right: 0px;' toolbar='#toolbar'
				rownumbers='true' singleSelect='true'>
			</table>
			<div id='toolbar'>
				<a href='#' class='easyui-linkbutton' iconCls='icon-add'
					plain='true' onclick='newMalfunction()'>新增报修</a> <a href='#'
					class='easyui-linkbutton' iconCls='icon-edit' plain='true'
					onclick='editMalfunction()'>维修确认</a><a href='#'
					class='easyui-linkbutton' iconCls='icon-remove' plain='true'
					onclick='removeUser()'>撤销报修</a>
			</div>
			<div id='dlg-add' class='easyui-dialog'
				style='width: 400px; height: 280px; padding: 10px 20px'
				closed='true' buttons='#dlg-buttons'>
				<form id='fm-add' method='post'>
					<div class='fitem'>
						<label>设备编号：</label><input id='equipmentNo' name='equipmentNo'
							class='easyui-validatebox' required='true'><a href='#'
							class='easyui-linkbutton' iconCls='icon-search' plain='true'
							onclick='doEquipmentSearch()'></a>
					</div>
					<br>
					<div class='fitem'>
						<label>设备内部名称：</label><input id='equipmentNameInside'
							name='equipmentNameInside' class='easyui-validatebox'
							required='true'>
					</div>
					<br>
					<div class='fitem'>
						<label>设备外部名称：</label><input id='equipmentNameOutside'
							name='equipmentNameOutside' class='easyui-validatebox'
							required='true'>
					</div>
					<br>
					<div class='fitem'>
						<label>设备故障描述：</label><input id='malfunctionRecords'
							name='malfunctionRecords' class='easyui-validatebox'
							required='true'>
					</div>
					<br>
					<a href='#' class='easyui-linkbutton' iconCls='icon-ok'
					onclick='malfunctionConfirm()'>确认</a>
				</form>
			</div>
			<div id='dlg-equipment' class='easyui-dialog'
				style='width: 600px; height: 400px;' closed='true'
				buttons='#dlg-buttons'>
				<table id='datagrid-equipment' class='easyui-datagrid'
					style='border-left: 0px; border-right: 0px;'
					toolbar='#toolbar-equipment' rownumbers='true' singleSelect='true'>
				</table>
				<a href='#' class='easyui-linkbutton' iconCls='icon-ok'
					onclick='equipmentConfirm()'>确认</a>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var datalist = [ {
			text : '报修管理',
			children : [ {
				text : '待维修'
			}, {
				text : '已维修'
			}, {
				text : '已确认'
			} ]
		} ]

		function post(o) {
			var f = document.createElement("form");
			f.action = o;
			f.method = "post";
			var hdnFilePath = document.createElement('input');
			hdnFilePath.type = "hidden";
			hdnFilePath.name = "user";
			hdnFilePath.value = "user";
			f.appendChild(hdnFilePath);
			document.body.appendChild(f);
			f.submit();
		}
	</script>
	<script type="text/javascript" src="js/malfunctionFunction.js"></script>
</body>
</html>