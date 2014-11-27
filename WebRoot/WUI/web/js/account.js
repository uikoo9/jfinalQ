require(['jquery', 'bootstrap', 'qiao', 'modifypwd'], function($, bs, qiao, modifypwd){
	$(function(){
		init();
	});
	
	function init(){
		qiao.ajaxinit();
		qiao.crud.init();
		modifypwd.init();
		
		qiao.on('.shouzhi', 'click', toshouzhi);
		qiao.on('.zhuan', 'click', tozhuan);
	}
	
	function toshouzhi(){
		qiao.bs.dialog({
			url : '/ac/detail/savep',
			title : '收入&支出',
			okbtn : '添加'
		}, function(){
			var res = qiao.ajax({url:'/ac/detail/save',data:$('#bsmodal').find('form').qser()});
			qiao.bs.msg(res);

			if(res && res.type == 'success'){
				setTimeout(function(){
					location.reload();
				},1000);
				return true;
			}else{
				return false;
			}
		});
	}
	
	function tozhuan(){
		qiao.bs.dialog({
			url : '/ac/tozhuan',
			title : '转账',
			okbtn : '转账'
		}, function(){
			var res = qiao.ajax({url:'/ac/zhuan',data:$('#bsmodal').find('form').qser()});
			qiao.bs.msg(res);
			
			if(res && res.type == 'success'){
				setTimeout(function(){
					location.reload();
				},1000);
				return true;
			}else{
				return false;
			}
		});
	}
});