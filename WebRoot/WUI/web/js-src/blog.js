require(['jquery', 'bootstrap', 'qiao', 'login'], function($, bs, qiao, login){
	$(function(){
		qiao.ajaxinit();
		login.init();
	});
});