$('#datagrid1').datagrid({
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

function oEquipmentSearch() {

}