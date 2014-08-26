define(function(require, exports){
	var $ = require('jquery');
	
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
});