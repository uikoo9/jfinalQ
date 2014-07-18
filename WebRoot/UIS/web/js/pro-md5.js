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
 * 1.qiao.ajax(options);
 */
var qiao = $.extend({}, qiao);
qiao.ajax = function(options){
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
 * 常用方法
 * 1.qiao.ajax(options);
 */
var qiao = $.extend({}, qiao);
qiao.ajax = function(options){
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

// pro-md5.js
$(function(){
	$input 	= $('#md5input');
	$submit = $('#md5btn');
	$panel 	= $('div.panel');
	
	// auto focus
	$input.focus();
	
	// bind
	$(document).off('focus', '#md5input').on('focus', '#md5input', resetInput);
	$(document).off('keydown', '#md5input').on('keydown', '#md5input', md5keydown);
	$(document).off('click', '#md5btn').on('click', '#md5btn', md5code);
	
	// tooltip
	$input.tooltip({
		title : 'please enter code!',
		trigger : 'manual',
		container : 'body',
		placement : 'top'
	});
	
	// ajax status
	$(document).ajaxStart(function(){
		$input.attr('disabled',	'disabled');
		$submit.text('MD5...').attr('disabled','disabled');
	});
	$(document).ajaxStop(function(){
		$input.attr('disabled',	null);
		$submit.text('MD5').attr('disabled',null);
	});
});


// reset input
function resetInput(){
	$('.inputdiv').removeClass('has-error');
	$input.tooltip('hide');
}

// key down
function md5keydown(e){
	if(e.keyCode == 13) md5code();
}

// submit code
function md5code(){
	$panel.hide();
	
	var code = $.trim($input.val());
	if(!code){
		$('.inputdiv').addClass('has-error');
		$input.tooltip('show');
	}else{
		resetInput();
		
		var res = qiao.ajax({
			url : 'md5/md5',
			data : {code:code}
		});
		
		if(res && res.success){
			$('p.resp:eq(0) span').html('<strong>' + code + '</strong>');
			$('p.resp:eq(1) span').html('<strong>' + res.msg + '</strong>');
			$panel.slideDown();
		}else{
			alert('ajax fail!');
		}
	}
}