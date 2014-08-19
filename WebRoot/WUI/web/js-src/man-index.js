require(['jquery', 'easyui', 'easyuizh', 'qiao'], function($, easyui, easyuizh, qiao){
	$(function(){
		init();
	});
	
	function init(){
		$('body').layout().layout('add',qiao.layout('center')).layout('add',qiao.layout('west',null,'菜单'));
		
		var west = $('body').layout('panel','west');
		west.tree({
			data : [
			        qiao.tree('aaaa'),
			        qiao.tree('aaaa'),
			        qiao.tree('aaaa'),
			        qiao.tree('aaaa'),
			        qiao.tree('aaaa')
			       ]
		});
	}
});
