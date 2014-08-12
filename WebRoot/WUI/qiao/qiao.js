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
	 * 封装一些常用方法
	 * 1.ajax
	 * 2.to
	 * 3.
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
});