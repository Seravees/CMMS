$('#datagrid').datagrid({
	columns : [ [ {
		field : 'accountID',	
		title : '用户名',
		fixed : true
	}, {
		field : 'name',
		title : '姓名',
		fixed : true
	}, {
		field : 'tel',	
		title : '电话',
		fixed : true
	}, {
		field : 'accountGroupName',	
		title : '角色',
		fixed : true
	} ] ],
	fitColumns : true,
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
	$('#accountID').validatebox({
		editable : true
	});
	url = 'UserSave';
}

function saveUser() {
	$('#fm').form('submit', {
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
			$('#dlg').dialog('close');
			$('#datagrid').datagrid('reload');
		}
	});
}

function editUser() {
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑用户');
		$('#fm').form('load', row);
		$('#accountID').validatebox({
			editable : false
		});
		url = 'UserEdit?accountID=' + row.accountID;
	}
}

function removeUser() {
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除此用户？', function(r) {
			if (r) {
				$.post('UserDelete', {
					accountID : row.accountID
				}, function(result) {
					if (result== 'success delete') {
						$('#datagrid').datagrid('reload');
						$.messager.show({
							title : 'Success',
							msg : '删除成功'
						});
					} else if(result== 'fail delete'){
						$.messager.show({
							title : 'Error',
							msg : '删除失败'
						}, 'json');
					}
				})
			}
		});
	}
}

function doSearch() {
	var $userName = $('#searchByName');
	var ByName = $userName.val();
	$('#datagrid').datagrid({
		queryParams : {
			ByName : ByName
		},
		columns : [ [ {
			field : 'accountID',		
			title : '用户名',
			fixed : true
		}, {
			field : 'name',
			title : '姓名',
			fixed : true
		}, {
			field : 'tel',		
			title : '电话',
			fixed : true
		}, {
			field : 'accountGroupName',		
			title : '角色',
			fixed : true
		} ] ],
		fitColumns : true,
		url : 'searchUser',
		ByName : ByName
	// loadFilter : pagerFilter
	});
}

function closeDlg() {
	$('#dlg').dialog('close');
}

