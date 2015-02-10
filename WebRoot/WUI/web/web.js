var web = {};

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
	$('input[name="row.blog_comment_uname"]').val('');
	$('input[name="row.blog_comment_parent_id"]').val('');
	$('textarea[name="row.blog_comment_content"]').val('');
};
web.blog.go = function(){
	qiao.to(base + '/blog/detail/' + $(this).qdata().code);
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
		var res = qiao.ajax({url : '/blog/article/save',data : $form.qser()});
		qiao.bs.msg(res);
		
		if(res && res.type == 'success'){
			setTimeout(function(){
				qiao.to(base + '/blog/detail/' + res.object.blog_article_code);
			},1000);
		}
	}
};