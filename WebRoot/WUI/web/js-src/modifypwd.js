define(function(require, exports){
	var $ = require('jquery');
	var qiao = require('qiao');
	
	exports.init = function(options){qiao.on('.modifyPwd', 'click', exports.modifypwdp);};
	exports.modifypwdp = function(){
		qiao.bs.dialog({
			url : '/login/modifyPwdp',
			title : '修改密码',
			okbtn : '修改'
		}, exports.modifypwd);
	};
	exports.modifypwd = function(){
		var newpwd = $.trim($('input[name="newpwd"]').val());
		if(!newpwd){
			qiao.bs.msg({msg:'请输入新密码！',type:'danger'});
			return false;
		}else{
			var res = qiao.ajax({url:'/login/modifyPwd',data:{password:newpwd}});
			qiao.bs.msg(res);
			if(res && res.type == 'success'){
				setTimeout(function(){
					qiao.to(base + '/login/logout');
				}, 1000);
			}
			return false;
		}
	};
});