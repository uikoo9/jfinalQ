/**
 * 对bootstrap的封装
 * 1.alert
 * 2.confirm
 * 3.dialog
 * 4.msg
 * @author qiaowenbin
 * @version 0.0.4.20140824
 */
define(function(require, exports){
	var $ = require('jquery');
	var qiao = require('qiao');
	
	exports.modaloptions = {
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
	exports.modalstr = function(opt){
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
		
		return start + head + body + foot + end;
	};
	exports.alert = function(options, func){
		// options
		var opt = $.extend({}, exports.modaloptions);
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, options);
		}
		opt.title = '提示';
		
		// add
		$('body').append(exports.modalstr(opt));
		
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
	exports.confirm = function(options, ok, cancel){
		// options
		var opt = $.extend({}, exports.modaloptions);
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, options);
		}
		opt.btn = true;
		opt.title = '确认操作';
		
		// append
		$('body').append(exports.modalstr(opt));
		
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
	exports.dialog = function(options, func){
		// options
		var opt = $.extend({}, exports.modaloptions, options);
		
		// append
		$('body').append(exports.modalstr(opt));
		
		// ajax page
		var html = qiao.ajax({url:options.url, dataType:'html'});
		$('#bsmodal div.modal-body').empty().append(html);
		
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
	exports.msgoptions = {
		msg  : 'msg',
		type : 'info',
		time : 2000
	};
	exports.msgstr = function(msg, type){
		return '<div class="alert alert-'+type+' alert-dismissible" role="alert" style="display:none;margin:0;text-align:center;" id="bsalert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+msg+'</div>';
	};
	exports.msg = function(options){
		var opt = $.extend({},exports.msgoptions);
		
		if(typeof options == 'string'){
			opt.msg = options;
		}else{
			$.extend(opt, exports.msgoptions);
		}
		
		$('body').prepend(exports.msgstr(opt.msg,opt.type));
		$('#bsalert').slideDown();
		setTimeout(function(){
			$('#bsalert').slideUp(function(){
				$('#bsalert').remove();
			});
		},opt.time);
	};
});