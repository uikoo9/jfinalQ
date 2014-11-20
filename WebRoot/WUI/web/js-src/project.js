require(['jquery', 'bootstrap', 'qiao', 'login'], function($, bs, qiao, login){
	$(function(){
		login.init();
		qiao.ajaxinit();
		$('body').scrollspy({target:'.scrolldiv'});
	});
});