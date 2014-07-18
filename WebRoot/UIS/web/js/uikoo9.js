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
    if(this && s && this.length > s.length){
    	if(this.substr(0,s.length)==s){  
    		return true;
    	}  
    }
    
    return false;
};
String.prototype.endWith=function(s){  
    if(this && s && this.length > s.length){
    	if(this.substring(this.length-s.length)==s){
    		return true;
    	}
    }
    
    return false;
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

/**
 * 常用方法
 * 1.uikoo9.ajax(options);
 */
var uikoo9 = $.extend({}, uikoo9);
uikoo9.ajax = function(options){
	if(!options){
		alert('need options');
	}else{
		var doptions = {
			url 	: '',
			data 	: {},
			type 	: 'post',
			dataType: 'json',
			async 	: false
		};
		
		if(typeof options == 'string'){
			doptions.url = options;
		}else{
			$.extend(doptions, options);
		}
		
		var res;
		$.ajax(doptions).done(function(obj){
			res = obj;
		});
		
		return res;
	}
};

/**
 * bs插件封装
 * 1.uikoo9.bs.alert
 * 2.uikoo9.bs.confirm
 * 3.uikoo9.bs.msg
 */ 
uikoo9.bs = {};
uikoo9.bs.msgoptions = {
	url 	: '',
	fade	: 'fade',
	close	: true,
	head	: true,
	title	: 'title',
	foot	: false,
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
// bs msg str
uikoo9.bs.msgstr = function(opt){
	var start = '<div class="modal '+opt.fade+'" id="bsmodal" tabindex="-1" role="dialog" aria-labelledby="bsmodaltitle" aria-hidden="true">';
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
	
	var modal = start;
	if(opt.head) modal += head;
	modal += body;
	if(opt.foot) modal += foot;
	modal += end;
	
	return modal;
};
//bs msg
uikoo9.bs.msg = function(options, ok, cancel){
	// options
	var opt = $.extend({}, uikoo9.bs.msgoptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	
	// append
	$('body').append(uikoo9.bs.msgstr(opt));
	
	// init
	var $modal = $('#bsmodal'); 
	$modal.modal(opt);
	
	// bind
	$(document).on('click', 'button.bsok', function(){
		if(ok) ok();
		$modal.modal('hide');
	});
	$(document).on('click', 'button.bscancel', function(){
		if(cancel) cancel();
		$modal.modal('hide');
	});
	$(document).on('hidden.bs.modal', '#bsmodal', function(){
		$modal.remove();
	});
	
	// show
	$modal.modal('show');
};
// bs msg alert
uikoo9.bs.alert = function(options, func){
	// options
	var opt = $.extend({}, uikoo9.bs.msgoptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	opt.foot = true;
	opt.btn  = true;
	opt.title = '提示';
	
	uikoo9.bs.msg(opt, func);
};
// bs msg confirm
uikoo9.bs.confirm = function(options, ok, cancel){
	// options
	var opt = $.extend({}, uikoo9.bs.msgoptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	opt.btn = true;
	opt.title = '确认操作';
	
	uikoo9.bs.msg(opt, ok, cancel);
};
// bs msg dialog
uikoo9.bs.dialog = function(options){
	// options
	var opt = $.extend({}, uikoo9.bs.msgoptions);
	if(typeof options == 'string'){
		opt.msg = options;
	}else{
		$.extend(opt, options);
	}
	opt.head = false;
	opt.foot = false;
	
	uikoo9.bs.msg(opt);
};