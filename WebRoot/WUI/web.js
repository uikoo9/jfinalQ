qiao.ajaxinit();

var web = {};

// login
web.login = {};
web.login.init = function(options){
	qiao.on('.loginbtn', 'click', web.login.login);
	qiao.on('.loginform', 'keydown', function(e){if(e.keyCode == 13) web.login.login();});
};
web.login.login = function(){
	var $form = $('.loginform');
	var $h5 = $form.find('h5');
	
	var res = qiao.ajax({
		url : '/login/login',
		data : $form.qser()
	});
	
	if(res){
		if(res.msg == '010101'){
			$h5.text('登录成功，正在跳转。。。');
			qiao.to(base + '/ac');
		}else if(res.msg == '010102'){
			$h5.text('登录成功，正在跳转。。。');
			qiao.to(base + '/manage');
		}else{
			$h5.text(res.msg);
		}
	}else{
		$h5.text('ajax fail');
	}
};

// modifypwd
web.modifypwd = {};
web.modifypwd.init = function(){
	qiao.on('.modifyPwd', 'click', web.modifypwd.modifypwdp);
};
web.modifypwd.modifypwdp = function(){
	qiao.bs.dialog({
		url : '/login/modifyPwdp',
		title : '修改密码',
		okbtn : '修改'
	}, web.modifypwd.modifypwd);
};
web.modifypwd.modifypwd = function(){
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

// project
web.project = {};
web.project.init = function(){
	$('body').scrollspy({target:'.scrolldiv'});
};

// blog
web.blog = {};
web.blog.init = function(){
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
};

// account
web.account = {};
web.account.init = function(){
	web.modifypwd.init();

	qiao.crud.init();
	qiao.on('.shouzhi', 'click', toshouzhi);
	qiao.on('.zhuan', 'click', tozhuan);
};
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

// manage
web.manage = {};
web.manage.init = function(){
	web.modifypwd.init();
	qiao.crud.init();
};