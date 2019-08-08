$('#datagrid').datagrid({
	columns : [ [ {
		field : 'accountID',
		width : 100,
		title : '用户名'
	}, {
		field : 'name',
		width : 100,
		title : '姓名'
	}, {
		field : 'tel',
		width : 100,
		title : '电话'
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

function newUser() {
	$('#dlg').dialog('open').dialog('setTitle', '添加用户');
	$('#fm').form('clear');
	url = 'Save';
}

function saveUser() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(res) {
			$('#dlg').dialog('close');
			$('#dg').datagrid('reload');
			if (res == 'fail') {
				$.messager.show({
					title:'Error',
					msg:'添加失败'
				});
			}else{
				$.messager.show({
					title:'Success',
					msg:'添加成功'
				});
			}
		}
	});
}

function closeDlg() {
	$('#dlg').dialog('close');
}