window.onload = function() {
	addNewTab('测试', 'www.baidu.com');
};

$(function(){
    $("#ac").accordion('getSelected').panel('collapse');
});

$('#ac').accordion({
	multiple:false,
	fit:true
});



$(function() {
	$("#tt,#tt1").tree({
		onClick : function(node) {
			if ($(node).tree('isLeaf', node.target)) {
				var name=node.text;
				var url='localhost:8080/mei/jsp/'+node.text+'.jsp';
				addNewTab(name,url);
			}
		}
	});
});





function addNewTab(tabname, url) {
	// 创建一个新的窗口，在mainlayout上
	if (!$("#mainTabs").tabs('getTab', tabname)) {
		$("#mainTabs")
				.tabs(
						'add',
						{
							title : tabname,
							selected : true,
							closable : true,
							content : "<iframe src='"
									+ 'http://'
									+ url
									+ "' style='width:100%;height:100%'  frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no' />"
						}); 
	} else {
		$('#mainTabs').tabs('select', tabname);
	}
}
