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
	 * 3.con
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
	exports.con = function(obj){
		console.log(obj);
	};
	
	/**
	 * easyui常用的数据结构
	 */
	exports.panel = function(title, href){
		var options = {
			id 			: null,
			cache 		: true,
			width 		: 'auto',
			height 		: 'auto',
			iconCls 	: null,
			closable 	: false,
			selected 	: false,
			collapsible : false
		};
		
		if(typeof title == 'string'){
			options.title = title;
			options.closable = true;
		}
		
		if(typeof title == 'object'){
			$.extend(options, title);
		}
		
		if(typeof href == 'string'){
			if(href.startWith('href:')){
				var hcontent = '<iframe src="' + href.substr(5) + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>';
				options.content = hcontent;
			}else{
				options.content = content;
			}
		}
		
		return options;
	};
	exports.layout = function(region, href, title){
		if(!region){
			alert('need region');
		}else{
			var options = exports.panel(title, href);
			$.extend(options,{
				split : true,
				closable : false,
				collapsible : true
			});
			
			if(typeof region == 'string'){
				options.region = region;
				if(region.inArray(['north','south'])) options.height = 100;
				if(region.inArray(['east','west'])) options.width = 150;
			}else{
				$.extend(options, region);
			}
			
			return options;
		}
	};
	exports.tab = function($tabs, title, href){
		if(!$tabs || !title){
			alert('need $tabs and title');
		}else{
			var options = exports.panel(title, href);
			
			options.tools = [{
				iconCls : 'icon-mini-refresh',
				handler : function(){
					var tab = $tabs.tabs('getTab', options.title);
					$tabs.tabs('update', {
						tab 	: tab,
						options : tab.panel('options')
					});
				}
			}];
			
			return options;
		}
	};
	exports.tree = function(text){
		var options = {
			id : 1,
			text : 'text',
			state : 'open',
			checked : false,
			iconCls : null,
			attributes : {},
			children : []
		};
		
		if(typeof text == 'string'){
			options.text = text;
		}else{
			$.extend(options, text);
		}
		
		return options;
	};
});