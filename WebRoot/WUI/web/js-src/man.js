require(['jquery', 'eui'], function($, eui){
	$(function(){
		$('#tt').tabs();
		$('#tt').qaddTab('test', 'md5');
	});
});
