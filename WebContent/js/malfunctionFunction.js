$('#datagrid').datagrid({
	columns : [ [ {
		field : 'malfunctionTime',
		title : '报修日期',
		fixed : true
	}, {
		field : 'equipmentNo',
		title : '报修设备',
		fixed : true
	}, {
		field : 'malfunctionRecords',
		title : '报修故障描述',
		fixed : true
	}, {
		field : 'malfunctionMan',
		title : '报修人',
		fixed : true
	}, {
		field : 'malfunctionState',
		title : '状态',
		fixed : true
	} ] ],
	fitColumns : true,
	pagination : true,
	url : 'malfunctionList',
	loadFilter : pagerFilter
});

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
	url : 'equipment',
	loadFilter : pagerFilter
});

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

function newMalfunction() {
	$('#dlg-add').dialog('open').dialog('setTitle', '新增报修记录');
	$('#fm-add').form('clear');
	url = '';
}

function doEquipmentSearch() {
	$('#dlg-equipment').dialog('open').dialog('setTitle', '设备选择');
}

function equipmentConfirm() {
	var row = $('#datagrid-equipment').datagrid('getSelected');
	if (row) {
		$('#equipmentNo').val(row.equipmentNo);
		$('#equipmentNameInside').val(row.equipmentNameInside);
		$('#equipmentNameOutside').val(row.equipmentNameOutside);
		$('#dlg-equipment').dialog('close');
	}
}

function malfunctionConfirm() {
	$('#fm-add').form('submit', {
		url : 'malfunctionAdd',
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
			$('#dlg-add').dialog('close');
			$('#datagrid').datagrid('reload');
		}
	});
}