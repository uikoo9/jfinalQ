/**
 * 扩展一些js默认的方法
 * 1.string.contains
 * 2.string.startWith
 * 3.string.endWith
 * 4.string.inArray
 */
String.prototype.contains = function(s){
	return this.indexOf(s) != -1;
};
String.prototype.startWith=function(s){  
    return this.indexOf(s) == 0;
};
String.prototype.endWith=function(s){
	if(this.length == 0){
		return false;
	}else{
		return this.indexOf(s) == this.length - 1;
	}
};
String.prototype.inArray = function(array){
	if(this && array){
		for(var i=0; i<array.length; i++){
			if(this == array[i]){
				return true;
			}
		}
	}
	
	return false;
};

/**
 * jquery的一些常用方法
 * 1.qser
 * 2.qdata
 */
$.fn.qser = function(){
	var obj = {};
	
	var objs = $(this).serializeArray();
	if(objs.length != 0){
		for(var i=0; i<objs.length; i++){
			obj[objs[i].name] = objs[i].value;
		}
	}

	return obj;
};
$.fn.qdata = function(){
	var res = {};
	
	var data = $(this).attr('data');
	if(data){
		var options = data.split(';');
		for(var i=0; i<options.length; i++){
			if(options[i]){
				var opt = options[i].split(':');
				res[opt[0]] = opt[1];
			}
		}
	}
	
	return res;
};

/**
 * 封装一些常用方法
 * 1.ajax
 * 2.html
 * 3.ajaxinit
 * 4.to
 * 5.con
 * 6.on
 */
var qiao = {};

qiao.ajaxoptions = {
	url 	: '',
	data 	: {},
	type 	: 'post',
	dataType: 'json',
	async 	: false
};
qiao.ajaxopt = function(options){
	var opt = $.extend({}, qiao.ajaxoptions);
	if(typeof options == 'string'){
		opt.url = options;
	}else{
		$.extend(opt, options);
	}
	
	return opt;
};
qiao.ajax = function(options){
	if(!options){
		alert('need options');
	}else{
		var opt = qiao.ajaxopt(options);
		opt.url = base + opt.url;
		
		var res;
		$.ajax(opt).done(function(obj){res = obj;});
		return res;
	}
};
qiao.html = function(options, target){
	var opt = qiao.ajaxopt(options);
	opt.dataType = 'html';
	
	var obj = target ? target : '#cruddiv';
	$(obj).empty().append(qiao.ajax(opt));
};
qiao.ajaxinit = function(){
	qmask.hide();
	$(document).ajaxStart(function(){
		qmask.show();
	});
	$(document).ajaxStop(function(){
		qmask.hide();
	});
};
qiao.to = function(url){
	if(url){
		window.location.href = url;
	}else{
		alert('need url');
	}
};
qiao.con = function(obj){
	console.log(obj);
};
qiao.on = function(obj, event, func){
	$(document).off(event, obj).on(event, obj, func);
};

/**
 * 对bootstrap的封装
 * 1.alert
 * 2.confirm
 * 3.dialog
 * 4.msg
 * 5.initimg
 * 6.bstro
 * 7.scrollspy
 */
qiao.bs 	= {};
qiao.bs.modaloptions = {
	url 	: '',
	fade	: 'fade',
	close	: true,
	title	: 'title',
	btn		: false,
	okbtn	: '确定',
	qubtn	: '取消',
	msg		: 'msg',
	big		: false,
	show	: false,
	remote	: false,
	backdrop: 'static',
	keyboard: true,
	style	: ''
};
qiao.bs.modalstr = function(opt){
	var start = '<div class="modal '+opt.fade+'" id="bsmodal" tabindex="-1" role="dialog" aria-labelledby="bsmodaltitle" aria-hidden="true" style="position:fixed;top:20px;'+opt.style+'">';
	if(opt.big){
		start += '<div class="modal-dialog modal-lg"><div class="modal-content">';
	}else{
		start += '<div class="modal-dialog"><div class="modal-content">';
	}
	var end = '</div></div></div>';
	
	var head = '<div class="modal-header">';
	if(opt.close){
		head += '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>';
	}
	head += '<h3 class="modal-title" id="bsmodaltitle">'+opt.title+'</h3></div>';
	var body = '<div class="modal-body"><p><h4>'+opt.msg+'</h4></p></div>';
	var foot = '<div class="modal-footer"><button type="button" class="btn btn-primary bsok">'+opt.okbtn+'</button>';
	if(opt.btn){
		foot += '<button type="button" class="btn btn-default bscancel">'+opt.qubtn+'</button>';
	}
	foot += '</div>';
	
	return start + head + body + foot + end;
};
qiao.bs.alert = function(options, func){
	// options
	var opt = $.extend({}, qiao.bs.modaloptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	opt.title = '提示';
	
	// add
	$('body').append(qiao.bs.modalstr(opt));
	
	// init
	var $modal = $('#bsmodal'); 
	$modal.modal(opt);
	
	// bind
	qiao.on('button.bsok', 'click', function(){
		if(func) func();
		$modal.modal('hide');
	});
	qiao.on('#bsmodal', 'hidden.bs.modal', function(){
		$modal.remove();
	});
	
	// show
	$modal.modal('show');
};
qiao.bs.confirm = function(options, ok, cancel){
	// options
	var opt = $.extend({}, qiao.bs.modaloptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	opt.btn = true;
	opt.title = '确认操作';
	
	// append
	$('body').append(qiao.bs.modalstr(opt));
	
	// init
	var $modal = $('#bsmodal'); 
	$modal.modal(opt);
	
	// bind
	qiao.on('button.bsok', 'click', function(){
		if(ok) ok();
		$modal.modal('hide');
	});
	qiao.on('button.bscancel', 'click', function(){
		if(cancel) cancel();
		$modal.modal('hide');
	});
	qiao.on('#bsmodal', 'hidden.bs.modal', function(){
		$modal.remove();
	});
	
	// show
	$modal.modal('show');
};
qiao.bs.dialog = function(options, func){
	// options
	var opt = $.extend({}, qiao.bs.modaloptions, options);
	opt.big = true;
	// append
	$('body').append(qiao.bs.modalstr(opt));
	
	// ajax page
	var html = qiao.ajax({url:options.url, dataType:'html'});
	$('#bsmodal div.modal-body').empty().append(html);
	
	// init
	var $modal = $('#bsmodal'); 
	$modal.modal(opt);
	
	// bind
	qiao.on('button.bsok', 'click', function(){
		var flag = true;
		if(func){
			flag = func();
		}
		
		if(flag){
			$modal.modal('hide');
		}
	});
	qiao.on('#bsmodal', 'hidden.bs.modal', function(){
		$modal.remove();
	});
	
	// show
	$modal.modal('show');
};
qiao.bs.msgoptions = {
	msg  : 'msg',
	type : 'info',
	time : 2000
};
qiao.bs.msgstr = function(msg, type){
	return '<div class="alert alert-'+type+' alert-dismissible" role="alert" style="display:none;position:fixed;top:0;left:0;width:100%;z-index:2001;margin:0;text-align:center;" id="bsalert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+msg+'</div>';
};
qiao.bs.msg = function(options){
	var opt = $.extend({},qiao.bs.msgoptions);
	
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	
	$('body').prepend(qiao.bs.msgstr(opt.msg,opt.type));
	$('#bsalert').slideDown();
	setTimeout(function(){
		$('#bsalert').slideUp(function(){
			$('#bsalert').remove();
		});
	},opt.time);
};
qiao.bs.initimg = function(){
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
qiao.bs.bstrooptions = {
	width 	: '500px',
	html 	: 'true',
	nbtext	: '下一步',
	place 	: 'bottom',
	title 	: '网站使用引导',
	content : 'content'
};
qiao.bs.bstroinit = function(selector, options, step){
	if(selector){
		var $element = $(selector);
		if($element.length > 0){
			var opt = $.extend({}, qiao.bs.bstrooptions, options);
			if(typeof options == 'string'){
				opt.content = options;
			}else{
				$.extend(opt, options);
			}
			
			$element.each(function(){
				$(this).attr({
					'data-bootstro-width'			: opt.width, 
					'data-bootstro-title' 			: opt.title, 
					'data-bootstro-html'			: opt.html,
					'data-bootstro-content'			: opt.content, 
					'data-bootstro-placement'		: opt.place,
					'data-bootstro-nextButtonText'	: opt.nbtext,
					'data-bootstro-step'			: step
				}).addClass('bootstro');
			});
		}
	}
};
qiao.bs.bstroopts = {
	prevButtonText : '上一步',
	finishButton : '<button class="btn btn-lg btn-success bootstro-finish-btn"><i class="icon-ok"></i>完成</button>',
	stopOnBackdropClick : false,
	stopOnEsc : false
};
qiao.bs.bstro = function(bss, options){
	if(bss && bss.length > 0){
		for(var i=0; i<bss.length; i++){
			qiao.bs.bstroinit(bss[i][0], bss[i][1], i);
		}
		
		var opt = $.extend({}, qiao.bs.bstroopts);
		if(options){
			if(options.hasOwnProperty('pbtn')){
				opt.prevButtonText = options.pbtn;
			}
			if(options.hasOwnProperty('obtn')){
				if(options.obtn == ''){
					opt.finishButton = '';
				}else{
					opt.finishButton = '<button class="btn btn-mini btn-success bootstro-finish-btn"><i class="icon-ok"></i>'+options.obtn+'</button>';
				}
			}
			if(options.hasOwnProperty('stop')){
				opt.stopOnBackdropClick = options.stop;
				opt.stopOnEsc = options.stop;
			}
			if(options.hasOwnProperty('exit')){
				opt.onExit = options.exit;
			}
		}
		
		bootstro.start('.bootstro', opt);
	}
};
qiao.bs.spy = function(target,body){
	var $body = 'body';
	var $target = '.scrolldiv';
	
	if(body) $body = body;
	if(target) $target = target;
	
	$($body).scrollspy({target:$target});
};

/**
 * crud相关方法
 * 1.crud
 * 2.index
 */
qiao.crud = {};
qiao.crud.url = '';
qiao.crud.init = function(){
	// menu click
	qiao.on('.menus', 'click', function(){
		var url = $(this).qdata().url;
		if(url){
			qiao.crud.url = url;
			qiao.crud.reset();
		}
	});
	qiao.crud.bindcrud();
	qiao.crud.bindpage();
};
qiao.crud.bindcrud = function(){
	qiao.on('.allcheck','change', function(){$('.onecheck').prop('checked',$(this).prop('checked'));});
	qiao.on('.addBtn', 'click', function(){qiao.crud.savep('添加')});
	qiao.on('.editbtn','click', function(){qiao.crud.savep('修改',$(this).parents('tr').qdata().id)});
	qiao.on('.queBtn', 'click', function(){qiao.crud.savep('查询')});
	qiao.on('.relBtn', 'click', function(){qiao.crud.reset();});
	qiao.on('.delBtn', 'click', function(){qiao.crud.del();});
	qiao.on('.delbtn', 'click', function(){qiao.crud.del($(this).parents('tr').qdata().id);});
};
qiao.crud.listopt = {pageNumber:1};
qiao.crud.list = function(data){
	var opt = {url : qiao.crud.url + 'index'};
	if(data) $.extend(qiao.crud.listopt, data);
	opt.data = qiao.crud.listopt;
	
	qiao.html(opt);
};
qiao.crud.reset = function(){
	qiao.crud.listopt = {pageNumber:1};
	qiao.crud.list();
};
qiao.crud.savep = function(title, id){
	if(title == '查询'){
		qiao.bs.dialog({title:title,url:qiao.crud.url + 'savep'}, function(){
			qiao.crud.list($('#bsmodal').find('form').qser());
			return true;
		});
	}else{
		var url = id ? (qiao.crud.url + 'savep?id=' + id) : (qiao.crud.url + 'savep');
		qiao.bs.dialog({title:title,url:url}, function(){
			return qiao.crud.save();
		});
	}
};
qiao.crud.save = function(){
	var res = qiao.ajax({url:qiao.crud.url+'save',data:$('#bsmodal').find('form').qser()});
	qiao.bs.msg(res);

	if(res && res.type == 'success'){
		qiao.crud.list();
		return true;
	}else{
		return false;
	}
};
qiao.crud.del = function(id){
	var ids = [];
	
	if(id){
		ids.push(id);
	}else{
		$('.onecheck:checked').each(function(){ids.push($(this).parents('tr').qdata().id);});
	}
	
	if(!ids.length){
		qiao.bs.alert('请选择要删除的记录！');
	}else{
		qiao.bs.confirm('确认要删除所选记录吗（若有子记录也会同时删除）？',function(){
			var res = qiao.ajax({url:qiao.crud.url+'del',data:{ids:ids.join(',')}});
			qiao.bs.msg(res);
			qiao.crud.list();
		});
	}
};
qiao.crud.bindpage = function(){
	qiao.on('.crudfirst', 'click', function(){
		if(!$(this).parent().hasClass('disabled')){
			qiao.crud.reset();
		}
	});
	qiao.on('.crudprev', 'click', function(){
		if(!$(this).parent().hasClass('disabled')){
			qiao.crud.list({pageNumber:qiao.crud.listopt.pageNumber - 1});
		}
	});
	qiao.on('.crudnext', 'click', function(){
		if(!$(this).parent().hasClass('disabled')){
			qiao.crud.list({pageNumber:qiao.crud.listopt.pageNumber + 1});
		}
	});
	qiao.on('.crudlast', 'click', function(){
		if(!$(this).parent().hasClass('disabled')){
			qiao.crud.list({pageNumber:$(this).qdata().page});
		}
	});
	qiao.on('.cruda', 'click', function(){
		if(!$(this).parent().hasClass('disabled')){
			qiao.crud.list({pageNumber:parseInt($(this).text())});
		}
	});
	qiao.on('.crudgo', 'click', function(){
		var page = parseInt($('.crudinput').val());
		var total = parseInt($(this).qdata().page);
		if(page >= 1 && page <= total){
			qiao.crud.list({pageNumber:page});
		}
	});
};