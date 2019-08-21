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
		url = 'maintenanceList?malfunctionId=' + row.malfunctionId;
		$('#datagrid-maintenance').datagrid('options').url = url;
		$('#datagrid-maintenance').datagrid('load');

	}
}

function maintenanceAdd() {
	$('#dlg-maintenanceAdd').dialog('open').dialog('setTitle', '维修记录添加');
}