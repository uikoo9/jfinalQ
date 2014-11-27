require(['jquery', 'bootstrap', 'qiao', 'modifypwd'], function($, bs, qiao, modifypwd){
	$(function(){
		qiao.crud.init();
		qiao.ajaxinit();
		modifypwd.init();
	});
});