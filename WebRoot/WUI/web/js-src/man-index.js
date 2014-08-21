require(['jquery', 'bootstrap', 'qiao'], function($, bs, qiao){
	$(function(){
		spinner.stop();
		
		qiao.on('.menus','click',function(){
			var $this = $(this);
			
			$this.siblings().removeClass('active').end().addClass('active');
			if($this.qdata().url) qiao.html($this.qdata().url);
		});
	});
});