/**
 * 封装一些常用的js方法
 * @author qiaowenbin
 * @version 0.0.1.20140715
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

var qiao = $.extend({}, qiao);
/**
 * 常用方法
 * 1.qiao.ajax(options);
 * 2.qiao.to(url);
 * 3.qiao.con(obj);
 * 6.qiao.on(obj, event, func);
 * 7.qiao.forbidden(obj, events);
 * 8.qiao.page
 * 9.qiao.event
 * 10.qiao.browser;
 */
console.log('some qiao method');
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

/**
 * window.location.href的封装
 * @param url
 */
qiao.to = function(url){
	if(url){
		window.location.href = url;
	}else{
		alert('need url');
	}
};

/**
 * console.log的封装
 */
qiao.con = function(obj){
	console.log(obj);
};

/**
 * 禁用某事件
 */
qiao.forbidden = function(obj, events){
	for(var i=0; i<events.length; i++){
		qiao.event.addHandler(obj, events[i], function(event){
			qiao.event.preventDefault(qiao.event.getEvent(event));
		})
	}
};

/**
 * 事件封装
 */
qiao.event = {
	addHandler: function(element, type, handler){
	    if (element.addEventListener){
	        element.addEventListener(type, handler, false);
	    } else if (element.attachEvent){
	        element.attachEvent("on" + type, handler);
	    } else {
	        element["on" + type] = handler;
	    }
	},
	
	getButton: function(event){
	    if (document.implementation.hasFeature("MouseEvents", "2.0")){
	        return event.button;
	    } else {
	        switch(event.button){
	            case 0:
	            case 1:
	            case 3:
	            case 5:
	            case 7:
	                return 0;
	            case 2:
	            case 6:
	                return 2;
	            case 4: return 1;
	        }
	    }
	},
	
	getCharCode: function(event){
	    if (typeof event.charCode == "number"){
	        return event.charCode;
	    } else {
	        return event.keyCode;
	    }
	},
	
	getClipboardText: function(event){
	    var clipboardData =  (event.clipboardData || window.clipboardData);
	    return clipboardData.getData("text");
	},
	
	getEvent: function(event){
	    return event ? event : window.event;
	},
	
	getRelatedTarget: function(event){
	    if (event.relatedTarget){
	        return event.relatedTarget;
	    } else if (event.toElement){
	        return event.toElement;
	    } else if (event.fromElement){
	        return event.fromElement;
	    } else {
	        return null;
	    }
	
	},
	
	getTarget: function(event){
	    return event.target || event.srcElement;
	},
	
	getWheelDelta: function(event){
	    if (event.wheelDelta){
	        return (client.engine.opera && client.engine.opera < 9.5 ? -event.wheelDelta : event.wheelDelta);
	    } else {
	        return -event.detail * 40;
	    }
	},
	
	preventDefault: function(event){
	    if (event.preventDefault){
	        event.preventDefault();
	    } else {
	        event.returnValue = false;
	    }
	},
	
	removeHandler: function(element, type, handler){
	    if (element.removeEventListener){
	        element.removeEventListener(type, handler, false);
	    } else if (element.detachEvent){
	        element.detachEvent("on" + type, handler);
	    } else {
	        element["on" + type] = null;
	    }
	},
	
	setClipboardText: function(event, value){
	    if (event.clipboardData){
	        event.clipboardData.setData("text/plain", value);
	    } else if (window.clipboardData){
	        window.clipboardData.setData("text", value);
	    }
	},
	    
	stopPropagation: function(event){
	    if (event.stopPropagation){
	        event.stopPropagation();
	    } else {
	        event.cancelBubble = true;
	    }
	}
};

/**
 * 得到页面的高度和宽度
 */
qiao.page = function(){
    var pageWidth = window.innerWidth;
    var pageHeight = window.innerHeight;
    
	if (typeof pageWidth != "number"){
	    if (document.compatMode == "CSS1Compat"){
	        pageWidth = document.documentElement.clientWidth;
	        pageHeight = document.documentElement.clientHeight;
	    } else {
	        pageWidth = document.body.clientWidth;
	        pageHeight = document.body.clientHeight;
	    }
	}

	return {
		height : pageHeight,
		width  : pageWidth
	};
};

/**
 * 得到浏览器版本
 */
qiao.broswer = function(){
	var client = function(){
		// 呈现引擎
		var engine = {
			ie : 0,
			gecko : 0,
			webkit : 0,
			kthml : 0,
			opera : 0,
			
			ver : null
		};
		
		// 浏览器
		var browser = {
			ie : 0,
			firefox : 0,
			safari : 0,
			konq : 0,
			opera : 0,
			chrome : 0,
			
			ver : null
		};
		
		// 平台，设备和操作系统
		var system = {
			win : false,
			mac : false,
			x11 : false,
			
			// 移动设备
			iphone : false,
			ipod : false,
			ipad : false,
			ios : false,
			android : false,
			nokiaN : false,
			winMobile : false,
			
			// 游戏系统
			wii : false,
			ps : false
		};
		
		// 检测呈现引擎和浏览器
		var ua = navigator.userAgent;
		if(window.opera){
			engine.ver = browser.ver = window.opera.version();
			engine.opera = browser.opera = parseFloat(engine.ver);
		}else if(/AppleWebkit\/(\S+)/.test(ua)){
			engine.ver = RegExp['$1'];
			engine.webkit = parseFloat(engine.ver);
			
			// 确定是chrome还是safari
			if(/Chrome\/(\S+)/.test(ua)){
				browser.ver = RegExp['$1'];
				browser.chrome = parseFloat(browser.ver);
			}else if(/Version\/(\S+)/.test(ua)){
				browser.ver = RegExp['$1'];
				browser.safari = parseFloat(browser.ver);
			}else{
				// 近似地确定版本
				var safariVersion = 1;
				if(engine.webkit < 100){
					safariVersion = 1;
				}else if(engine.webkit < 312){
					safariVersion = 1.2;
				}else if(engine.webkit < 412){
					safariVersion = 1.3;
				}else{
					safariVersion = 2;
				}
				
				browser.safari = browser.ver = safariVersion;
			}
		}else if(/KHTML\/(\S+)/.test(ua) || /Konqueror\/([^;]+)/.test(ua)){
			engine.ver = browser.ver = RegExp['$1'];
			engine.khtml = browser.konq = parseFloat(engine.ver);
		}else if(/rv:([^\)]+)\) Gecko\/\d{8}/.test(ua)){
			engine.ver = RegExp['$1'];
			engine.gecko = parseFloat(engine.ver);
			
			// 确定是不是Firefox
			if(/Firefox\/(\S+)/.test(ua)){
				browser.ver = RegExp['$1'];
				browser.firefox = parseFloat(browser.ver);
			}
		}else if(/MSIE ([^;]+)/.test(ua)){
			engine.ver = browser.ver = RegExp['$1'];
			engine.ie = browser.ie = parseFloat(engine.ver);
		}
		
		// 检测浏览器
		browser.ie = engine.ie;
		browser.opera = engine.opera;
		
		// 检测平台
		var p = navigator.platform;
		system.win = p.indexOf('win') == 0;
		system.mac = p.indexOf('Mac') == 0;
		system.x11 = (p == 'X11') || (p.indexOf('Linux') == 0);
		
		// 检测Windows操作系统
		if(system.win){
			if(/Win(?:dows )?([^do]{2})\s?(\d+\.\d+)?/.test(ua)){
				if(RegExp('$1') == 'NT'){
					switch(RegExp('$2')){
						case '5.0' : 
							system.win = '2000';
							break;
						case '5.1' : 
							system.win = 'XP';
							break;
						case '6.0' : 
							system.win = 'Vista';
							break;
						case '6.1' : 
							system.win = '7';
							break;
						default : 
							system.win = 'NT';
							break;
					}
				}else if(RegExp['$1'] == '9x'){
					system.win = 'ME';
				}else{
					system.win = RegExp['$1'];
				}
			}
		}
		
		// 移动设备
		system.iphone = ua.indexOf('iPhone') > -1;
		system.ipod = ua.indexOf('iPod') > -1;
		system.ipad = ua.indexOf('iPad') > -1;
		system.nokiaN = ua.indexOf('NokiaN') > -1;
		
		// windows mobile
		if(system.win == 'CE'){
			system.winMobile = system.win;
		}else if(system.win == 'Ph'){
			if(/Winodw Phone OS (\d+.\d+)/.test(ua)){
				system.win = 'Phone';
				system.winMobile = parseFloat(RegExp['$1']);
			}
		}
		
		// 检测iOS版本
		if(system.mac && ua.indexOf('Mobile') > -1){
			if(/CPU (?:iPhone )?OS (\d+_\d+)/.test(ua)){
				system.ios = parseFloat(RegExp.$1.replace('_', '.'));
			}else{
				system.ios = 2;// 不能正真检测出来，所以只能猜测
			}
		}
		
		// 检测Android版本
		if(/Android (\d+\.\d+)/.test(ua)){
			system.android = parseFloat(RegExp.$1);
		}
		
		// 游戏系统
		system.wii = ua.indexOf('Wii') > -1;
		system.ps = /playstation/i.test(ua);
		
		// 返回这些对象
		return {
			engine : engine,
			browser : browser,
			system : system
		};
	}();
	
	var res = {
		name : null,
		ver  : null
	};
	
	var browser = client.browser;
	if(browser.ver){
		if(browser.ie != 0){
			res.name = 'ie';
			res.ver  = browser.ver;
		}
		if(browser.firefox != 0){
			res.name = 'firefox';
			res.ver  = browser.ver;
		}
		if(browser.safari != 0){
			res.name = 'safari';
			res.ver  = browser.ver;
		}
		if(browser.konq != 0){
			res.name = 'konq';
			res.ver  = browser.ver;
		}
		if(browser.opera != 0){
			res.name = 'opera';
			res.ver  = browser.ver;
		}
		if(browser.chrome != 0){
			res.name = 'chrome';
			res.ver  = browser.ver;
		}
	}else{
		res.name = 'other';
		res.ver  = 'other';
	}
	
	return res;
};

//---------------------------------------------------------------------------qiao.crud..
/**
 * 增删改查相关的方法
 * 1.init		初始化
 * 2.osearch	打开搜索窗口
 * 3.search		搜索数据
 * 4.oadd		打开添加窗口
 * 5.oedit		打开修改窗口
 * 6.save		保存数据
 * 7.csave		关闭保存窗口
 * 8.del		删除数据
 * 9.toolbar	默认工具栏
 */
qiao.crud = {};

/**
 * 初始化
 * @param name
 */
qiao.crud.init = function(options){
	// sth is a must
	if(!options){
		qiao.eui.alert('need options');
		return;
	}
	if(!options.name){
		qiao.eui.alert('need name');
		return;
	}
	if(!options.method){
		qiao.eui.alert('need method');
		return;
	}
	
	// default
	qiao.crud.name 		= options.name;
	qiao.crud.method	= options.method;
	var columns			= [[]];
	var toolbar 		= qiao.crud.toolbar;
	var pagination		= true;

	// init
	if(options.hasOwnProperty('method'))  	qiao.crud.method 	= options.method;
	if(options.hasOwnProperty('columns'))	columns 			= options.columns;
	if(options.hasOwnProperty('toolbar'))	toolbar 			= toolbar.concat(options.toolbar);
	if(options.hasOwnProperty('pagination'))pagination 			= options.pagination;
	
	// choice method
	if(qiao.crud.method == 'jfinal'){
		qiao.crud.mlist = qiao.crud.name + '/list';
		qiao.crud.msave = qiao.crud.name + '/save';
		qiao.crud.mdel  = qiao.crud.name + '/del';
		qiao.crud.ids 	= qiao.crud.name + '_id';
	}
	if(qiao.crud.method == 'ssh'){
		qiao.crud.mlist = qiao.crud.name + '!list.action';
		qiao.crud.msave = qiao.crud.name + '!save.action';
		qiao.crud.mdel  = qiao.crud.name + '!del.action';
		qiao.crud.ids 	= 'obid';
	}
	if(qiao.crud.method == 'servlet'){
		qiao.crud.mlist = qiao.crud.name + '?m=l';
		qiao.crud.msave = qiao.crud.name + '?m=s';
		qiao.crud.mdel  = qiao.crud.name + '?m=d';
		qiao.crud.ids 	= qiao.crud.name + '_id';
	}
	
	// 初始化datagrid
	if($('#listTable').attr('data') == 'html'){
		$('#listTable').datagrid({
			url			: qiao.crud.mlist,
			fit 		: true,
			fitColumns 	: true,
			pagination 	: pagination,
			rownumbers 	: true,
			toolbar 	: toolbar
		});
	}else{
		$('#listTable').qtable({
			url 	: qiao.crud.mlist,
			fit 		: true,
			fitColumns 	: true,
			pagination 	: pagination,
			rownumbers 	: true,
			toolbar : toolbar,
			columns : columns
		});
	}
	
	// 初始化编辑dialog
	$('#saveDiv').dialog({
		closed		: true,
		width 		: parseInt($('#saveDiv table').css('width')) + 20,
		buttons		: [{
			text 	: '保存',
			iconCls : 'icon-save',
			handler : qiao.crud.save
		},{
			text 	: '关闭',
			iconCls : 'icon-cancel',
			handler : qiao.crud.csave
		}]
	});
	
	// 初始化搜索dialog
	$('#searchDiv').dialog({
		closed		: true,
		title		: '搜索数据',
		width 		: parseInt($('#searchDiv table').css('width')) + 20,
		buttons		: [{
			text 	: '搜索',
			iconCls : 'icon-search',
			handler : qiao.crud.search
		}]
	});
};	

/**
 * 打开搜索
 */	
qiao.crud.osearch = function(){
	$('#searchDiv').dialog('open');
};

/**
 * 搜索
 */
qiao.crud.search = function(){
	$('#searchDiv').dialog('close');
	$('#listTable').datagrid('load',qiao.ser('#searchDiv form'));
	$('#searchDiv :input').val('');
};

/**
 * 打开添加窗口
 */
qiao.crud.oadd = function(){
	$('#saveDiv').dialog('open').dialog('setTitle','添加数据');
};

/**
 * 打开修改窗口
 */
qiao.crud.oedit = function(){
	var rows = $('#listTable').datagrid('getSelections');
	var size = rows.length;
	
	if(size != 1){
		qiao.eui.alert('请选择一条要修改的数据！');
	}else{
		$('#saveDiv form').form('load',qiao.crud.objs(rows[0]));
		$('#saveDiv').dialog('open').dialog('setTitle','修改数据');
	}
};

/**
 * jfinal数据封装
 * @param obj
 * @returns
 */
qiao.crud.objs = function(obj){
	var res = {};
	if(qiao.crud.method == 'jfinal'){
		for(item in obj){
			res[qiao.crud.name + '.' + item] = obj[item];
		}

		return res;
	}
	
	return obj;
};

/**
 * 保存
 */
qiao.crud.save = function(){
	var msg = qiao.ajax({
		url 	: qiao.crud.msave,
		data 	: qiao.ser('#saveDiv form')
	});
	
	qiao.eui.alert(msg,function(){
		qiao.crud.csave();
		$('#listTable').datagrid('reload');
	});
};

/**
 * 关闭保存对话框
 */
qiao.crud.csave = function(){
	$('#saveDiv').dialog('close');
	$('#saveDiv :input').val('');
};

/**
 * 删除
 */
qiao.crud.del = function(){
	var rows = $('#listTable').datagrid('getSelections');
	var size = rows.length;
	
	if(size == 0){
		qiao.eui.alert('请选择要删除的数据！');
	}else{
		qiao.eui.confirm('您确定要删除这' + size + '条数据吗？',function(){
			var ids = [];
			for(var i=0; i<size; i++){
				ids.push(rows[i][qiao.crud.ids]);
			}
			
			var msg = qiao.ajax({
				url : qiao.crud.mdel,
				data : {
					ids : ids.join(",")	
				}
			});
			
			qiao.eui.alert(msg,function(){
				$('#listTable').datagrid('reload');
			});
		});
	}
};

/**
 * 默认工具栏
 */
qiao.crud.toolbar = [{
	text 	: '添加',
	iconCls : 'icon-add',
	handler : qiao.crud.oadd
},{
	text 	: '修改',
	iconCls : 'icon-edit',
	handler : qiao.crud.oedit
},{
	text 	: '删除',
	iconCls : 'icon-remove',
	handler : qiao.crud.del
},'-',{
	text 	: '搜索',
	iconCls : 'icon-search',
	handler : qiao.crud.osearch
},{
	text 	: '刷新',
	iconCls : 'icon-reload',
	handler : qiao.crud.search
}];