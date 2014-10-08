/**
 * 1.qiao.js
 * 2.qiao.bs.js
 * 3.qiao.crud.js
 * @author qiaowenbin
 * @version 0.0.5.20140905
 */
define(function(require, exports){
	var $ = require('jquery');
	var bs = require('bootstrap');
	
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
	exports.ajaxoptions = {
		url 	: '',
		data 	: {},
		type 	: 'post',
		dataType: 'json',
		async 	: false
	};
	exports.ajaxopt = function(options){
		var opt = $.extend({}, exports.ajaxoptions);
		if(typeof options == 'string'){
			opt.url = options;
		}else{
			$.extend(opt, options);
		}
		
		return opt;
	};
	exports.ajax = function(options){
		if(!options){
			alert('need options');
		}else{
			var opt = exports.ajaxopt(options);
			opt.url = base + opt.url;
			
			var res;
			$.ajax(opt).done(function(obj){res = obj;});
			return res;
		}
	};
	exports.html = function(options, target){
		var opt = exports.ajaxopt(options);
		opt.dataType = 'html';
		
		var obj = target ? target : '#cruddiv';
		$(obj).empty().append(exports.ajax(opt));
	};
	exports.ajaxinit = function(){
		qmask.qhide();
    	$(document).ajaxStart(function(){
    		qmask.qmask();
    	});
    	$(document).ajaxStop(function(){
    		qmask.qhide();
    	});
	};
	exports.to = function(url){
		if(url){
			window.location.href = url;
		}else{
			alert('need url');
		}
	};
	exports.con = function(obj){
		console.log(obj);
	};
	exports.on = function(obj, event, func){
		$(document).off(event, obj).on(event, obj, func);
	};
	
	/**
	 * 对bootstrap的封装
	 * 1.alert
	 * 2.confirm
	 * 3.dialog
	 * 4.msg
	 */
	exports.bs = {};
	exports.bs.modaloptions = {
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
		keyboard: true
	};
	exports.bs.modalstr = function(opt){
		var start = '<div class="modal '+opt.fade+'" id="bsmodal" tabindex="-1" role="dialog" aria-labelledby="bsmodaltitle" aria-hidden="true" style="position:fixed;top:20px;">';
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
	exports.bs.alert = function(options, func){
		// options
		var opt = $.extend({}, exports.bs.modaloptions);
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, options);
		}
		opt.title = '提示';
		
		// add
		$('body').append(exports.bs.modalstr(opt));
		
		// init
		var $modal = $('#bsmodal'); 
		$modal.modal(opt);
		
		// bind
		exports.on('button.bsok', 'click', function(){
			if(func) func();
			$modal.modal('hide');
		});
		exports.on('#bsmodal', 'hidden.bs.modal', function(){
			$modal.remove();
		});
		
		// show
		$modal.modal('show');
	};
	exports.bs.confirm = function(options, ok, cancel){
		// options
		var opt = $.extend({}, exports.bs.modaloptions);
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, options);
		}
		opt.btn = true;
		opt.title = '确认操作';
		
		// append
		$('body').append(exports.bs.modalstr(opt));
		
		// init
		var $modal = $('#bsmodal'); 
		$modal.modal(opt);
		
		// bind
		exports.on('button.bsok', 'click', function(){
			if(ok) ok();
			$modal.modal('hide');
		});
		exports.on('button.bscancel', 'click', function(){
			if(cancel) cancel();
			$modal.modal('hide');
		});
		exports.on('#bsmodal', 'hidden.bs.modal', function(){
			$modal.remove();
		});
		
		// show
		$modal.modal('show');
	};
	exports.bs.dialog = function(options, func){
		// options
		var opt = $.extend({}, exports.bs.modaloptions, options);
		
		// append
		$('body').append(exports.bs.modalstr(opt));
		
		// ajax page
		var html = exports.ajax({url:options.url, dataType:'html'});
		$('#bsmodal div.modal-body').empty().append(html);
		
		// init
		var $modal = $('#bsmodal'); 
		$modal.modal(opt);
		
		// bind
		exports.on('button.bsok', 'click', function(){
			var flag = true;
			if(func){
				flag = func();
			}
			
			if(flag){
				$modal.modal('hide');
			}
		});
		exports.on('#bsmodal', 'hidden.bs.modal', function(){
			$modal.remove();
		});
		
		// show
		$modal.modal('show');
	};
	exports.bs.msgoptions = {
		msg  : 'msg',
		type : 'info',
		time : 2000
	};
	exports.bs.msgstr = function(msg, type){
		return '<div class="alert alert-'+type+' alert-dismissible" role="alert" style="display:none;position:fixed;top:0;left:0;width:100%;z-index:2001;margin:0;text-align:center;" id="bsalert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+msg+'</div>';
	};
	exports.bs.msg = function(options){
		var opt = $.extend({},exports.bs.msgoptions);
		
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, options);
		}
		
		$('body').prepend(exports.bs.msgstr(opt.msg,opt.type));
		$('#bsalert').slideDown();
		setTimeout(function(){
			$('#bsalert').slideUp(function(){
				$('#bsalert').remove();
			});
		},opt.time);
	};
	
	/**
	 * crud相关方法
	 * 1.crud
	 * 2.index
	 */
	exports.crud = {};
	exports.crud.url = '';
	exports.crud.init = function(){
		// menu click
		exports.on('.menus', 'click', function(){
			var url = $(this).qdata().url;
			if(url){
				exports.crud.url = url;
				exports.crud.list();
			}
		});
		exports.crud.bindcrud();
		exports.crud.bindpage();
	};
	exports.crud.bindcrud = function(){
		exports.on('.allcheck','change', function(){$('.onecheck').prop('checked',$(this).prop('checked'));});
		exports.on('.addBtn', 'click', function(){exports.crud.savep('添加')});
		exports.on('.editbtn','click', function(){exports.crud.savep('修改',$(this).parents('tr').qdata().id)});
		exports.on('.queBtn', 'click', function(){exports.crud.savep('查询')});
		exports.on('.relBtn', 'click', function(){exports.crud.reset();});
		exports.on('.delBtn', 'click', function(){exports.crud.del();});
		exports.on('.delbtn', 'click', function(){exports.crud.del($(this).parents('tr').qdata().id);});
	};
	exports.crud.listopt = {pageNumber:1};
	exports.crud.list = function(data){
		var opt = {url : exports.crud.url + 'index'};
		if(data) $.extend(exports.crud.listopt, data);
		opt.data = exports.crud.listopt;
		
		exports.html(opt);
	};
	exports.crud.reset = function(){
		exports.crud.listopt = {pageNumber:1};
		exports.crud.list();
	};
	exports.crud.savep = function(title, id){
		if(title == '查询'){
			exports.bs.dialog({title:title,url:exports.crud.url + 'savep'}, function(){
				exports.crud.list($('#bsmodal').find('form').qser());
				return true;
			});
		}else{
			var url = id ? (exports.crud.url + 'savep?id=' + id) : (exports.crud.url + 'savep');
			exports.bs.dialog({title:title,url:url}, function(){
				return exports.crud.save();
			});
		}
	};
	exports.crud.save = function(){
		var res = exports.ajax({url:exports.crud.url+'save',data:$('#bsmodal').find('form').qser()});
		exports.bs.msg(res);

		if(res && res.type == 'success'){
			exports.crud.list();
			return true;
		}else{
			return false;
		}
	};
	exports.crud.del = function(id){
		var ids = [];
		
		if(id){
			ids.push(id);
		}else{
			$('.onecheck:checked').each(function(){ids.push($(this).parents('tr').qdata().id);});
		}
		
		if(!ids.length){
			exports.bs.alert('请选择要删除的记录！');
		}else{
			exports.bs.confirm('确认要删除所选记录吗？',function(){
				var res = exports.ajax({url:exports.crud.url+'del',data:{ids:ids.join(',')}});
				exports.bs.msg(res);
				exports.crud.list();
			});
		}
	};
	exports.crud.bindpage = function(){
		exports.on('.crudfirst', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.crud.reset();
			}
		});
		exports.on('.crudprev', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.crud.list({pageNumber:exports.crud.listopt.pageNumber - 1});
			}
		});
		exports.on('.crudnext', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.crud.list({pageNumber:exports.crud.listopt.pageNumber + 1});
			}
		});
		exports.on('.crudlast', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.crud.list({pageNumber:$(this).qdata().page});
			}
		});
		exports.on('.cruda', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.crud.list({pageNumber:parseInt($(this).text())});
			}
		});
		exports.on('.crudgo', 'click', function(){
			var page = parseInt($('.crudinput').val());
			var total = parseInt($(this).qdata().page);
			if(page >= 1 && page <= total){
				exports.crud.list({pageNumber:page});
			}
		});
	};
});