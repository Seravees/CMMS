function doSearch() {
	var $userName = $('#searchByName');
	var ByName = $userName.val();
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
