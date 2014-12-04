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

// account
web.account = {};
web.account.init = function(){
	qiao.crud.init();
	qiao.on('.shouzhi', 'click', web.account.toshouzhi);
	qiao.on('.zhuan', 'click', web.account.tozhuan);
};
web.account.toshouzhi = function(){
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
};
web.account.tozhuan = function(){
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
};

// diary-add
web.diaryadd = {};
web.diaryadd.init = function(){
	qiao.on('.addDiary', 'click', web.diaryadd.add);
};
web.diaryadd.add = function(){
	var $form = $('#addDiaryForm');
	var title = $.trim($form.find('input[name="row.diary_article_title"]').val()); 

	if(!title){
		qiao.bs.msg({msg:'请填写日记标题！',type:'danger'});
	}else{
		var res = qiao.ajax({url : '/diary/article/save',data : $form.qser()});
		qiao.bs.msg(res);
		
		if(res && res.type == 'success'){
			setTimeout(function(){
				qiao.to(base + '/diary/detail/' + res.object.id);
			},1000);
		}
	}
};