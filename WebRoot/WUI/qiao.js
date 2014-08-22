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
	 * 2.to
	 * 3.con
	 * 4.on
	 */
	exports.ajax = function(options){
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
			doptions.url = base + doptions.url;
			
			var res;
			$.ajax(doptions).done(function(obj){
				res = obj;
			});
			
			return res;
		}
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
	 * crud相关方法
	 * 1.html
	 */
	exports.crud = function(url, target){
		var obj = target ? target : '#cruddiv';
		$(obj).empty().append(exports.ajax({url:url,dataType:'html'}));
		
		var $list = $(obj).find('table');
		if($list.length > 0){
			var listurl = $list.qdata().url;
			$list.empty().append(exports.ajax({url:listurl,dataType:'html'}));
		}
	};
});