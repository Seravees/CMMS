$('#datagrid-equipment').datagrid({
	columns : [ [ {
		field : 'equipmentNo',
		title : '设备编号',
		fixed : true
	}, {
		field : 'equipmentType',
		title : '设备类型',
		fixed : true
	}, {
		field : 'equipmentNameInside',
		title : '设备内部名称',
		fixed : true
	}, {
		field : 'equipmentNameOutside',
		title : '设备外部名称',
		fixed : true
	}, {
		field : 'accountStarttime',
		title : '开始使用日期',
		fixed : true
	}, {
		field : 'equipmentState',
		title : '设备状态',
		fixed : true
	}, {
		field : 'equipmentAddress',
		title : '设备位置',
		fixed : true
	}, {
		field : 'equipmentRemark',
		title : '备注',
		fixed : true
	} ] ],
	fitColumns : true,
	pagination : true,
	url : 'equipmentList',
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

/* 设备添加 */
function newEquipment() {
	$('#dlg-equipment').dialog('open').dialog('setTitle', '添加设备');
	$('#fm-equipment').form('clear');
	$('#equipmentNo').validatebox({
		editable : true
	});
	url = 'EquipmentSave';
}

/* 设备添加、修改保存 */
function saveEquipment() {
	$('#fm-equipment').form('submit', {
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
			$('#dlg-equipment').dialog('close');
			$('#datagrid-equipment').datagrid('reload');
		}
	});
}

/* 设备修改 */
function editEquipment() {
	var row = $('#datagrid-equipment').datagrid('getSelected');
	if (row) {
		$('#dlg-equipment').dialog('open').dialog('setTitle', '编辑设备');
		$('#fm-equipment').form('load', row);
		$('#equipmentNo').validatebox({
			editable : false
		});
		url = 'EquipmentEdit?equipmentNo=' + row.equipmentNo;
	}
}

/* 设备删除 */
function removeEquipment() {
	var row = $('#datagrid-equipment').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除此设备？', function(r) {
			if (r) {
				$.post('EquipmentDelete', {
					equipmentNo : row.equipmentNo
				}, function(result) {
					if (result == 'success delete') {
						$('#datagrid-equipment').datagrid('reload');
						$.messager.show({
							title : 'Success',
							msg : '删除成功'
						});
					} else if (result == 'fail delete') {
						$.messager.show({
							title : 'Error',
							msg : '删除失败'
						});
					}
				})
			}
		});
	}
}

function closeDlgEquipment() {
	$('#dlg-equipment').dialog('close');
}