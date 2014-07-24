define(function(require){
	var $ = require('jquery');
	
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
});