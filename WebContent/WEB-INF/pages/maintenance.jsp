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
<title>维修</title>
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
			<table id='datagrid' class='easyui-datagrid' title='维修'
				style='border-left: 0px; border-right: 0px;' toolbar='#toolbar'
				rownumbers='true' singleSelect='true'>
			</table>
			<div id='toolbar'>
				<a href='#' class='easyui-linkbutton' iconCls='icon-search'
					plain='true' onclick='detail()'></a>
			</div>

			<div id='dlg-maintenance' class='easyui-dialog'
				style='width: 600px; height: 400px;' closed='true'
				buttons='#dlg-buttons'>
				<label>设备</label><input id='equipmentNo' name='equipmentNo'
					class='easyui-textbox'><label>报修</label><input
					id='malfunctionId' name='malfunctionId' class='easyui-textbox'>
				<table id='datagrid-maintenance' class='easyui-datagrid'
					style='border-left: 0px; border-right: 0px;'
					toolbar='#toolbar-maintenance' rownumbers='true'
					singleSelect='true'>
				</table>
				<div id='toolbar-maintenance'>
					<a href='#' class='easyui-linkbutton' iconCls='icon-add'
						plain='true' onclick='maintenanceAdd()'></a>
				</div>
			</div>

			<div id='dlg-maintenanceAdd' class='easyui-dialog'
				style='width: 600px; height: 500px;' closed='true'
				buttons='#dlg-buttons'>
				<form id='fm' method='post'>
					<label>设备</label><input id='equipmentNo-maintenanceAdd'
						name='equipmentNo-maintenanceAdd' class='easyui-textbox'><label>报修</label><input
						id='malfunctionId-maintenanceAdd'
						name='malfunctionId-maintenanceAdd' class='easyui-textbox'>
					<div class='fitem'>
						<label>维修详细描述</label><br> <input id='mResultRecords'
							name='mResultRecords' class='easyui-textbox'
							data-options='multiline:true' required='true'
							style='width: 400px; height: 100px'>
					</div>
					<br>
					<div class='fitem'>
						<label>维修开始时间</label><br> <input id='mStarttime'
							name='mStarttime' class='easyui-datetimebox'>
					</div>
					<br>
					<div class='fitem'>
						<label>维修结束时间</label> <br> <input id='mEndtime'
							name='mEndtime' class='easyui-datetimebox'>
					</div>
					<br>
					<div class='fitem'>
						<label>备 注</label><br> <input id='mRemark' name='mRemark'
							class='easyui-textbox' data-options='multiline:true'
							style='width: 400px; height: 50px'>
					</div>
				</form>
			</div>
			<div id='dlg-buttons'>
				<a href='#' class='easyui-linkbutton' iconCls='icon-ok'
					onclick='saveMaintenance()'>save</a> <a href='#'
					class='easyui-linkbutton' iconCls='icon-cancel'
					onclick='closeDlg()'>取消</a>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var datalist = [ {
			text : '维修管理',
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
	<script type="text/javascript" src="js/maintenanceFunction.js"></script>
</body>
</html>