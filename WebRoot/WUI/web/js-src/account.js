require(['jquery', 'bootstrap', 'qiao'], function($, bs, qiao){
	$(function(){
		qiao.crud.init();
		qiao.ajaxinit();
	});
});