define(function(require, exports){
	var $ = require('jquery');
	var bs = require('bootstrap');
	var qiao = require('qiao');
	
	exports.init = function(options){
		qiao.on('.loginbtn', 'click', exports.login);
		qiao.on('.loginform', 'keydown', function(e){if(e.keyCode == 13) exports.login();});
	};
	
	exports.login = function(){
		var $form = $('.loginform');
		var $h5 = $form.find('h5');
		
		var res = qiao.ajax({
			url : '/login/login',
			data : $form.qser()
		});
		
		if(res){
			if(res.msg == 'suc'){
				$h5.text('登录成功，正在跳转。。。');
				qiao.to(baseurl + '/manage');
			}else{
				$h5.text(res.msg);
			}
		}else{
			$h5.text('ajax fail');
		}
	};
});