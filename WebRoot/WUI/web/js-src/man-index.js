//require(['jquery', 'bootstrap', 'qiao', 'qiaocrud'], function($, bs, qiao, crud){
//	$(function(){
//		crud.crud();
//		qmask.qhide();
//	});
//});

// 修改为这样?
define(function(require, exports){
	var $ = require('jquery');
	var bs = require('bootstrap');
	var qiao = require('qiao');
	var qiaocrud = require('qiaocrud');
	
	$(function(){
		crud.crud();
		qmask.qhide();
	});
});