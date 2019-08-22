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

$('#datagrid-maintenance').datagrid({
	columns : [ [ {
		field : 'mStarttime',
		title : '维修开始时间',
		fixed : true
	}, {
		field : 'mEndtime',
		title : '维修结束时间',
		fixed : true
	}, {
		field : 'mResultRecords',
		title : '维修描述',
		fixed : true
	}, {
		field : 'mManName',
		title : '维修人',
		fixed : true
	}, {
		field : 'mRemark',
		title : '备注',
		fixed : true
	} ] ],
	fitColumns : true,
	pagination : true,
	// url : 'maintenanceList',
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

function detail() {
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$('#dlg-maintenance').dialog('open').dialog('setTitle', '维修记录');
		$('#equipmentNo').textbox({
			value : row.equipmentNo
		});
		$('#malfunctionId').textbox({
			value : row.malfunctionId
		});
		url = 'maintenanceList?malfunctionId=' + row.malfunctionId;
		$('#datagrid-maintenance').datagrid('options').url = url;
		$('#datagrid-maintenance').datagrid('load');

	}
}

function maintenanceAdd() {
	$('#dlg-maintenanceAdd').dialog('open').dialog('setTitle', '维修记录添加');
	$('#fm').form('clear');
	$('#equipmentNo-maintenanceAdd').textbox({
		value : $('#equipmentNo').val()
	});
	$('#malfunctionId-maintenanceAdd').textbox({
		value : $('#malfunctionId').val()
	});
}

function saveMaintenance() {
	$('#fm').form('submit', {
		url : 'maintenanceAdd',
		onSubmit : function() {
			// return $(this).form('validate');
			// alert('a')
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
			$('#dlg-maintenanceAdd').dialog('close');
			$('#datagrid-maintenance').datagrid('reload');
		}
	});
}

function closeDlg() {
	$('#dlg-maintenanceAdd').dialog('close');
}