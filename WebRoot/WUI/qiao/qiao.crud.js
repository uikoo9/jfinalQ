/**
 * crud相关方法
 * 1.crud
 * 2.index
 */
define(function(require, exports){
	var $ = require('jquery');
	var qiao = require('qiao');
	var qiaobs = require('qiaobs');
	
	exports.url = '';
	exports.crud = function(){
		// menu click
		qiao.on('.menus', 'click', function(){
			var url = $(this).qdata().url;
			if(url){
				$(this).siblings().removeClass('active').end().addClass('active');
				exports.url = url;
				exports.list();
			}
		});
		exports.bindcrud();
		exports.bindpage();
	};
	exports.bindcrud = function(){
		qiao.on('.allcheck','change', function(){$('.onecheck').prop('checked',$(this).prop('checked'));});
		qiao.on('.addBtn', 'click', function(){exports.savep('添加')});
		qiao.on('.editbtn','click', function(){exports.savep('修改',$(this).parents('tr').qdata().id)});
		qiao.on('.queBtn', 'click', function(){exports.savep('查询')});
		qiao.on('.relBtn', 'click', function(){exports.reset();});
		qiao.on('.delBtn', 'click', function(){exports.del();});
		qiao.on('.delbtn', 'click', function(){exports.del($(this).parents('tr').qdata().id);});
	};
	exports.listopt = {pageNumber:1};
	exports.list = function(data){
		var opt = {url : exports.url + 'index'};
		if(data) $.extend(exports.listopt, data);
		opt.data = exports.listopt;
		
		qiao.html(opt);
	};
	exports.reset = function(){
		exports.listopt = {pageNumber:1};
		exports.list();
	};
	exports.savep = function(title, id){
		if(title == '查询'){
			qiaobs.dialog({title:title,url:exports.url + 'savep'}, function(){
				exports.list($('#bsmodal').find('form').qser());	
			});
		}else{
			var url = id ? (exports.url + 'savep?id=' + id) : (exports.url + 'savep');
			qiaobs.dialog({title:title,url:url}, function(){
				exports.save();
			});
		}
	};
	exports.save = function(){
		var res = qiao.ajax({url:exports.url+'save',data:$('#bsmodal').find('form').qser()});
		qiaobs.msg(res.msg);
		exports.list();
	};
	exports.del = function(id){
		var ids = [];
		
		if(id){
			ids.push(id);
		}else{
			$('.onecheck').each(function(){
				if($(this).prop('checked')){
					ids.push($(this).parents('tr').qdata().id);
				}
			});
		}
		
		if(!ids.length){
			qiaobs.alert('请选择要删除的记录！');
		}else{
			qiaobs.confirm('确认要删除所选记录吗？',function(){
				var res = qiao.ajax({url:exports.url+'del',data:{ids:ids.join(',')}});
				qiaobs.msg(res.msg);
				exports.list();
			});
		}
	};
	exports.bindpage = function(){
		qiao.on('.crudfirst', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.reset();
			}
		});
		qiao.on('.crudprev', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.list({pageNumber:exports.listopt.pageNumber - 1});
			}
		});
		qiao.on('.crudnext', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.list({pageNumber:exports.listopt.pageNumber + 1});
			}
		});
		qiao.on('.crudlast', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.list({pageNumber:$(this).qdata().page});
			}
		});
		qiao.on('.cruda', 'click', function(){
			if(!$(this).parent().hasClass('disabled')){
				exports.list({pageNumber:parseInt($(this).text())});
			}
		});
		qiao.on('.crudgo', 'click', function(){
			var page = parseInt($('.crudinput').val());
			var total = parseInt($(this).qdata().page);
			if(page >= 1 && page <= total){
				exports.list({pageNumber:page});
			}
		});
	};
});