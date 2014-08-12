define(function(require,exports){
	var $ = require('jquery');
	
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