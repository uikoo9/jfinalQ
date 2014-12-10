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

// blog
web.blog = {};
web.blog.init = function(){
	qiao.bs.initimg();
	web.blog.reset();

	qiao.on('.readda', 'click', web.blog.readd);
	qiao.on('.addComment', 'click', web.blog.save);
	$('.taba:eq(0)').on('shown.bs.tab', web.blog.redis);
};
web.blog.reset = function(){
	$('input[name="row.blog_comment_uname"]').val('');
	$('input[name="row.blog_comment_parent_id"]').val('');
	$('textarea[name="row.blog_comment_content"]').val('');
};
web.blog.readd = function(){
	$('input[name="row.blog_comment_parent_id"]').val($(this).qdata().id);
	$('.taba:eq(1)').tab('show');
	$('#commentreadd').find('fieldset').attr('disabled',null).end().find('.btn').attr('disabled',null).focus();
};
web.blog.redis = function(){
	web.blog.reset();
	$('#commentreadd').find('fieldset').attr('disabled','disabled').end().find('.btn').attr('disabled','disabled');
};
web.blog.save = function(){
	var $form = $(this).parent().prev();
	var title = $.trim($form.find('input[name="row.blog_comment_uname"]').val()); 
	
	if(!title){
		qiao.bs.msg({msg:'请填写评论昵称！',type:'danger'});
	}else{
		var res = qiao.ajax({url : '/blog/comment/save',data : $form.qser()});
		qiao.bs.msg(res);
		
		if(res && res.type == 'success'){
			setTimeout(function(){location.reload();},1000);
		}
	}
};

// diary
web.diary = {};
web.diary.init = function(){
	qiao.on('.addDiary', 'click', web.diary.save);
};
web.diary.save = function(){
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

// role
web.role = {};
web.role.init = function(){
	qiao.on('.roleadduserbtn',	'click', web.role.addUserp);
	qiao.on('.roleaddurlbtn', 	'click', web.role.addUrlp);
	qiao.on('.mytr',			'click', function(){$(this).toggleClass('info');});
};
web.role.addUserp = function(){
	var id = $(this).parents('tr').qdata().id;
	qiao.bs.dialog({
		url : '/ucenter/role/addUserp/' + id,
		title : '设置用户',
		okbtn : '关闭'
	});
};
web.role.addUser = function(){
	var ids = [];
	$('tr.outtr').each(function(){if($(this).hasClass('info')) ids.push($(this).attr('data'));});
	
	var res = qiao.ajax({url:'/ucenter/role/addUser',data:{userids:ids.join(','),roleid:$('input[name="roleid"]').val()}});
	if(res && res.type == 'success'){
		$('tr.outtr').each(function(){if($(this).hasClass('info')) $(this).removeClass('outtr').addClass('intr').prependTo('table.intable');});
	}else{
		qiao.bs.msg(res);
	}
};
web.role.removeUser = function(){
	var ids = [];
	$('tr.intr').each(function(){if($(this).hasClass('info')) ids.push($(this).attr('data'));});
	
	var res = qiao.ajax({url:'/ucenter/role/removeUser',data:{userids:ids.join(','),roleid:$('input[name="roleid"]').val()}});
	if(res && res.type == 'success'){
		$('tr.intr').each(function(){if($(this).hasClass('info')) $(this).removeClass('intr').addClass('outtr').prependTo('table.outtable');});
	}else{
		qiao.bs.msg(res);
	}
};
web.role.addUrlp = function(){
	
};