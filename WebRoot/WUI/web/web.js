var web = {};

// ue
web.ue = function(id, options){
	if(typeof(UE) != "undefined"){
		if(!options){
			return UE.getEditor(id);
		}else if(typeof options == 'string'){
			if(options == 'mini'){
				return UE.getEditor(id, {toolbars: [['bold','italic','underline','forecolor','backcolor','|','fontfamily','fontsize','|','removeformat','formatmatch','pasteplain']]});
			}
		}else{
			var opt = $.extend({}, window.UEDITOR_CONFIG);
			return UE.getEditor(id, $.extend(opt, options));
		}
	}
	
	return {};
};

// reg
web.reg = {};
web.reg.init = function(){
	qiao.on('.regbtn', 'click', web.reg.reg);
};
web.reg.reg = function(){
	var $form = $('.regform');
	var $h5 = $form.find('h5');
	
	qiao.ajax({
		url : '/reg/reg',
		data : $form.qser()
	}, function(res){
		if(res){
			$h5.text(res.msg);
		}else{
			$h5.text('ajax fail');
		}
	});
};

// login
web.login = {};
web.login.init = function(options){
	qiao.on('.loginbtn', 'click', web.login.login);
	qiao.on('.loginform', 'keydown', function(e){if(e.keyCode == 13) web.login.login();});
};
web.login.show = function(){
	qiao.bs.dialog({
		url 	: '/login',
		title 	: '登录',
		head	: false,
		foot	: false,
		backdrop: true,
		mstyle	: 'width:300px;margin:40px auto;'
	});
};
web.login.login = function(){
	var $form = $('.loginform');
	var $h5 = $form.find('h5');
	
	qiao.ajax({
		url : '/login/login',
		data : $form.qser()
	}, function(res){
		if(res){
			if(res.type == 'success'){
				$h5.text('登录成功，正在跳转。。。');
				if(res.msg == '/'){
					location.reload(true);
				}else{
					location.href = base + res.msg;
				}
			}else{
				$h5.text(res.msg);
			}
		}else{
			$h5.text('ajax fail');
		}
	});
};

// modify nickname
web.modifyNickname = {};
web.modifyNickname.init = function(){
	qiao.on('.modifyNickname', 'click', web.modifyNickname.modifyNicknamep);
};
web.modifyNickname.modifyNicknamep = function(){
	qiao.bs.dialog({
		url : '/login/modifyNicknamep',
		title : '修改昵称',
		okbtn : '修改'
	}, web.modifyNickname.modifyNickname);
};
web.modifyNickname.modifyNickname = function(){
	var newname = $.trim($('input[name="newname"]').val());
	if(!newname){
		qiao.bs.msg({msg:'请输入新昵称！',type:'danger'});
		return false;
	}else{
		var res;
		qiao.ajax({
			async: false,
			url: '/login/modifyNickname',
			data:{nickname:newname}
		}, function(json){
			res = json;
		});
		
		qiao.bs.msg(res);
		if(res && res.type == 'success'){
			setTimeout(function(){
				location.href = base + '/login/logout';
			}, 1000);
		}
		return false;
	}
};

// modify pwd
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
		var res; 
		qiao.ajax({
			async: false,
			url: '/login/modifyPwd',
			data:{password:newpwd}
		}, function(json){
			res = json;
		});
		
		qiao.bs.msg(res);
		if(res && res.type == 'success'){
			setTimeout(function(){
				location.href = base + '/login/logout';
			}, 1000);
		}
		return false;
	}
};

// role
web.role = {};
web.role.init = function(){
	qiao.on('.roleadduserbtn',	'click', web.role.setuser);
	qiao.on('.roleaddurlbtn', 	'click', web.role.seturl);
	qiao.on('.mytr',			'click', function(){$(this).toggleClass('info');});
};
web.role.setuser = function(){
	var id = $(this).parents('tr').qdata().id;
	qiao.bs.dialog({
		url : '/ucenter/role/setUser/' + id,
		title : '设置用户',
		okbtn : '关闭'
	});
};
web.role.addUser = function(){
	var ids = [];
	$('tr.outtr').each(function(){if($(this).hasClass('info')) ids.push($(this).qdata().id);});
	
	qiao.ajax({
		url: '/ucenter/role/addUser',
		data:{userids:ids.join(','),roleid:$('input[name="roleid"]').val()}
	}, function(res){
		if(res && res.type == 'success'){
			$('tr.outtr').each(function(){if($(this).hasClass('info')) $(this).removeClass('outtr').addClass('intr').prependTo('table.intable');});
		}else{
			qiao.bs.msg(res);
		}
	});
};
web.role.removeUser = function(){
	var ids = [];
	$('tr.intr').each(function(){if($(this).hasClass('info')) ids.push($(this).qdata().id);});
	
	qiao.ajax({
		url: '/ucenter/role/removeUser',
		data:{rlids:ids.join(','),roleid:$('input[name="roleid"]').val()}
	}, function(res){
		if(res && res.type == 'success'){
			$('tr.intr').each(function(){if($(this).hasClass('info')) $(this).removeClass('intr').addClass('outtr').prependTo('table.outtable');});
		}else{
			qiao.bs.msg(res);
		}
	});
};
web.role.seturl = function(){
	var id = $(this).parents('tr').qdata().id;
	qiao.bs.dialog({
		url : '/ucenter/role/setUrl/' + id,
		title : '设置Url',
		okbtn : '保存'
	}, web.role.addUrl);
};
web.role.addUrl = function(){
	var ids = [];
	$('#treeul input:checked').each(function(){ids.push($(this).parent().qdata().id);});
	
	var res;
	qiao.ajax({
		async: false,
		url: '/ucenter/role/saveUrl',
		data:{ids:ids.join(','),roleid:$('input[name="roleid"]').val()}
	}, function(json){
		res = json;
	});
	
	if(res && res.type == 'success'){
		return true;
	}else{
		qiao.bs.msg(res);
		return false;
	}
};
web.role.removeUrl = function(){
	var urls = [];
	$('tr.intr').each(function(){if($(this).hasClass('info')) urls.push($(this).qdata().id);});
	
	qiao.ajax({
		url: '/ucenter/role/removeUrl',
		data:{urls:urls.join(','),roleid:$('input[name="roleid"]').val()}
	}, function(res){
		if(res && res.type == 'success'){
			$('tr.intr').each(function(){if($(this).hasClass('info')) $(this).removeClass('intr').addClass('outtr').prependTo('table.outtable');});
		}else{
			qiao.bs.msg(res);
		}
	});
};

// blog
web.blog = {};
web.blog.init = function(){
	qiao.bs.initimg();
	web.blog.reset();

	qiao.on('.goblog', 'click', web.blog.go);
	
	qiao.on('.readda', 'click', web.blog.readd);
	qiao.on('.addComment', 'click', web.blog.save);
	$('.taba:eq(0)').on('shown.bs.tab', web.blog.redis);
};
web.blog.reset = function(){
	$('input[name="row.blog_comment_parent_id"]').val('');
	$('textarea[name="row.blog_comment_content"]').val('');
};
web.blog.go = function(){
	location.href = base + '/blog/detail/' + $(this).qdata().code;
};
web.blog.readd = function(){
	$('input[name="row.blog_comment_parent_id"]').val($(this).qdata().id);
	$('.taba:eq(1)').tab('show');
	$('#commentreadd').find('fieldset').attr('disabled',null).end().find('.btn').attr('disabled',null).focus();
	if(ue2) ue2.setEnabled();
};
web.blog.redis = function(){
	web.blog.reset();
	$('#commentreadd').find('fieldset').attr('disabled','disabled').end().find('.btn').attr('disabled','disabled');
	setTimeout(function(){if(ue2) ue2.setDisabled();}, 400);
};
web.blog.save = function(){
	qiao.ajax({
		url : '/blog/comment/save',
		data : $(this).parent().prev().qser()
	}, function(res){
		if(res){
			if(res.msg == 'notlogin'){
				web.login.show();
			}else{
				qiao.bs.msg(res);
				if(res.type == 'success'){
					setTimeout(function(){location.reload();},1000);
				}
			}
		}
	});
};

// blog-edit
web.blogedit = {};
web.blogedit.init = function(){
	qiao.on('.addBlog', 'click', web.blogedit.save);
};
web.blogedit.save = function(){
	var $form = $('#addBlogForm');
	var title = $.trim($form.find('input[name="row.blog_article_title"]').val()); 
	
	if(!title){
		qiao.bs.msg({msg:'请填写博客标题！',type:'danger'});
	}else{
		qiao.ajax({
			url : '/blog/article/save',
			data : $form.qser()
		}, function(res){
			qiao.bs.msg(res);
			
			if(res && res.type == 'success'){
				setTimeout(function(){
					location.href = base + '/blog/detail/' + res.object.blog_article_code;
				},1000);
			}
		});
	}
};