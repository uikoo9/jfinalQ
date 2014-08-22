require(['jquery', 'bootstrap', 'qiao'], function($, bs, qiao){
	$(function(){
		qiao.on('.menus','click',function(){
			var $this = $(this);
			var url = $this.qdata().url;
			
			$this.siblings().removeClass('active').end().addClass('active');
			if(url) qiao.crud(url);
		});
		
		qhide();
	});
});