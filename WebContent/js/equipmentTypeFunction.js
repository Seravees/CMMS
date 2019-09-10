$('#datagrid-equipment-type').datagrid({
	columns : [ [ {
		field : 'typeId',
		title : '设备类型编号',
		fixed : true
	}, {
		field : 'typeName',
		title : '设备类型',
		fixed : true
	} ] ],
	fitColumns : true,
	pagination : true,
	url : 'equipmentTypeList',
	loadFilter : pagerFilter
});

/* 分页显示 */
function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') {
		data = {
			total : data.length,
			rows : data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}

function newEquipmentType() {
	$('#dlg-equipment-type').dialog('open').dialog('setTitle', '添加设备类型');
	$('#fm-equipment-type').form('clear');
	$('#typeId').validatebox({
		editable : true
	});
	url = 'EquipmentTypeSave';
}

/* 设备添加、修改保存 */
function saveEquipmentType() {
	$('#fm-equipment-type').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(res) {
			if (res == 'fail add') {
				$.messager.show({
					title : 'Error',
					msg : '添加失败'
				});
			} else if (res == 'success add') {
				$.messager.show({
					title : 'Success',
					msg : '添加成功'
				});
			} else if (res == 'fail edit') {
				$.messager.show({
					title : 'Error',
					msg : '修改失败'
				});
			} else if (res == 'success edit') {
				$.messager.show({
					title : 'Success',
					msg : '修改成功'
				});
			}
			$('#dlg-equipment-type').dialog('close');
			$('#datagrid-equipment-type').datagrid('reload');
		}
	});
}

function editEquipmentType() {
	var row = $('#datagrid-equipment-type').datagrid('getSelected');
	if (row) {
		$('#dlg-equipment-type').dialog('open').dialog('setTitle', '编辑设备');
		$('#fm-equipment-type').form('load', row);
		$('#typeId').validatebox({
			editable : false
		});
		url = 'EquipmentTypeEdit?typeId=' + row.typeId;
	}
}

function closeDlgEquipmentType() {
	$('#dlg-equipment-type').dialog('close');
}