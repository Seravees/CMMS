$('#datagrid').datagrid({
	columns : [ [ {
		field : 'accountID',
		width : 100,
		title : 'itemid'
	}, {
		field : 'name',
		width : 100,
		title : 'productid'
	}, {
		field : 'tel',
		width : 100,
		title : 'tel'
	} ] ],
	pagination : true,
	url : 'showUsersServlet',
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

function doSearch() {
	var $userName = $('#searchByName');
	var ByName = $userName.value;
	$('#datagrid').datagrid({
		queryParams : {
			ByName : ByName
		},
		columns : [ [ {
			field : 'accountID',
			width : 100,
			title : 'itemid'
		}, {
			field : 'name',
			width : 100,
			title : 'productid'
		}, {
			field : 'tel',
			width : 100,
			title : 'tel'
		} ] ],
		url : 'searchUser',
		ByName : ByName
		//loadFilter : pagerFilter
	});
}
