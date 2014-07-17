/**
 * 封装一些常用的js方法
 * @author qiaowenbin
 * @version 0.0.2.20140717
 */ 
console.log('qiao.js');

/**
 * 扩展一些js默认的方法
 * 1.string.contains
 * 2.string.startWith
 * 3.string.endWith
 * 4.string.inArray
 */
console.log('add some javascript method');
/**
 * 判断string是否包含s
 * @param s
 * @returns {Boolean}
 */
String.prototype.contains = function(s){
	return this.indexOf(s) != -1;
};

/**
 * 判断string是否以s开头
 * @param s
 * @returns {Boolean}
 */
String.prototype.startWith=function(s){  
    if(this && s && this.length > s.length){
    	if(this.substr(0,s.length)==s){  
    		return true;
    	}  
    }
    
    return false;
};

/**
 * 判断string是否以s结尾
 * @param s
 * @returns {Boolean}
 */
String.prototype.endWith=function(s){  
    if(this && s && this.length > s.length){
    	if(this.substring(this.length-s.length)==s){
    		return true;
    	}
    }
    
    return false;
};

/**
 * 判断string是否在一个array内
 * @param array
 * @returns {Boolean}
 */
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
console.log('add some jquery method');
/**
 * 将表单序列化为一个js对象
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
console.log('some qiao method');
var qiao = $.extend({}, qiao);
/**
 * 对$.ajax等封装
 * ajax封装,默认为非异步,可以传递url或者obj
 */
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