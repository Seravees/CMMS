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


