require(['jquery', 'bootstrap', 'qiao', 'login'], function($, bs, qiao, login){
	$(function(){
		login.init();
		qiao.ajaxinit();
		
		initImg();
	});
	
	function initImg(){
		$('img').each(function(){
			var clazz = $(this).attr('class');
			if(clazz){
				if(!clazz.contains('img-responsive')){
					$(this).addClass('img-responsive');
				}
			}else{
				$(this).addClass('img-responsive');
			}
		});
	}
});