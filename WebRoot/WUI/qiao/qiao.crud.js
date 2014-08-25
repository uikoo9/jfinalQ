/**
 * crud相关方法
 * 1.crud
 * 2.index
 */
define(function(require, exports){
	var $ = require('jquery');
	var qiao = require('qiao');
	var qiaobs = require('qiaobs');
	
	exports.crud = function(){
		qiao.on('.menus', 'click', function(){
			var $this = $(this);
			var url = $this.qdata().url;
			
			$this.siblings().removeClass('active').end().addClass('active');
			if(url) exports.index(url);
		});
		
		qiao.on('#addBtn', 'click', function(){
			qiaobs.dialog({title:'添加',url:$(this).qdata().url},exports.save);
		});
	};
	exports.index = function(url, target){
		var obj = target ? target : '#cruddiv';
		$(obj).empty().append(qiao.ajax({url:url,dataType:'html'}));
		
		exports.list(target);
	};
	exports.list = function(target){
		var obj = target ? target : '#cruddiv';
		
		var $list = $(obj).find('table');
		if($list.length > 0){
			var listurl = $list.qdata().url;
			$list.empty().append(qiao.ajax({url:listurl,dataType:'html'}));
		}
	};
	exports.save = function(){
		var $form = $('#crudform');
		
		var res = qiao.ajax({url:$form.qdata().url,data:$form.qser()});
		exports.list();
	};
});