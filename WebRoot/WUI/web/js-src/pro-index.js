require(['jquery', 'bootstrap', 'qiao'], function($, bs, qiao){
	$(function(){
		bind();
		qiao.ajaxinit();
	});
	
	function bind(){
		qiao.on('.loginbtn', 'click', login);
		qiao.on('.loginform', 'keydown', function(e){if(e.keyCode == 13) login();});
	}
	
	function login(){
		var $form = $('.loginform');
		var $h5 = $form.find('h5');
		
		var res = qiao.ajax({
			url : '/ucenter/login/login',
			data : $form.qser()
		});
		
		if(res){
			if(res.msg == 'suc'){
				qiao.to(baseurl + '/ucenter');
			}else{
				$h5.text(res.msg);
			}
		}else{
			$h5.text('ajax fail');
		}
	}
});
