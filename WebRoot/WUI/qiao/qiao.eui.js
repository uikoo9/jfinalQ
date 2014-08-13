/**
 * 对easyui的封装
 * 01.easyui parser
 * 02.easyui easyloader
 * 03.easyui draggable
 * 04.easyui droppable
 * 05.easyui resizable
 * 06.easyui pagination
 * 07.easyui searchbox
 * 08.easyui progressbar
 * 09.easyui tooltip
 * 10.easyui panel
 * 11.easyui tabs
 * 12.easyui accordion
 * 13.easyui layout
 * 14.easyui menu
 * 15.easyui linkbutton
 * 16.easyui menubutton
 * 17.easyui splitbutton
 * 18.easyui form
 * 19.easyui validatebox
 * 20.easyui combo
 * 21.easyui combobox
 * 22.easyui combotree
 * 23.easyui combogrid
 * 24.easyui numberbox
 * 25.easyui datebox
 * 26.easyui datetimebox
 * 27.easyui calendar
 * 28.easyui spinner
 * 29.easyui numberspinner
 * 30.easyui timespinner
 * 31.easyui slider
 * 32.easyui window
 * 33.easyui dialog
 * 34.easyui messager
 * 35.easyui datagrid
 * 36.easyui propertygrid
 * 37.easyui tree
 * 38.easyui treegrid
 * @version 0.0.6.20140614
 */
define(function(require,exports){
	var $ 		= require('jquery');
	var easyui 	= require('easyui'); 
	var easyuizh= require('easyuizh'); 
	var qiao	= require('qiao');
	
	/**
	 * 01.easyui parser
	 * options :
	 * 	method : $.parser.parse
	 * 	events : $.parser.onComplete
	 * 	properties : $.parser.auto
	 * eg:
	 * 	exports.parser == $.parser.parse()
	 * 	exports.parser('#id') == $.parser.parse('#id')
	 * 	exports.parser({auto:false,ok:function(){}})
	 */
	exports.parser = function(options){
		if(!options){
			$.parser.parse();
		}else if(typeof options == 'string'){
			$.parser.parse(options);//解析子节点
		}else{
			if(options.hasOwnProperty('auto')){
				$.parser.auto = options.auto;
			}
			if(options.hasOwnProperty('ok')){
				$.parser.onComplete = options.ok;
			}
		}
	};

	/**
	 * 02.easyui easyloader
	 * options :
	 * 	method : load
	 * 	events : onProgress,onLoad
	 *  properties : modules,locales,base,theme,css,locale,timeout
	 * eg:
	 * 	exports.loader('messager', func) == easyloader.load('messager', func)
	 * 	exports.loader('jquery.js', func) == using('jquery.js', func)
	 * 	exports.loader({base:'./'}) == easyloader.base = './'
	 * @param options
	 * @param func
	 * @returns
	 */
	exports.loader = function(options, func){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.endWith('.js') || options.endWith('.css')){
				using(options, func);
			}else{
				easyloader.load(options, func);
			}
		}else{
			if(options.hasOwnProperty('modules')){
				return easyloader.modules;
			}
			if(options.hasOwnProperty('locales')){
				return easyloader.locales;
			}
			if(options.hasOwnProperty('base')){
				easyloader.base = options.base;
			}
			if(options.hasOwnProperty('theme')){
				easyloader.theme = options.theme;
			}
			if(options.hasOwnProperty('css')){
				easyloader.css = options.css;
			}
			if(options.hasOwnProperty('locale')){
				easyloader.locale = options.locale;
			}
			if(options.hasOwnProperty('timeout')){
				easyloader.timeout = options.timeout;
			}
			if(options.hasOwnProperty('onProgress')){
				easyloader.onProgress = options.onProgress;
			}
			if(options.hasOwnProperty('onLoad')){
				easyloader.onLoad = options.onLoad;
			}
		}
	};

	/**
	 * 03.easyui draggable
	 * options :
	 * 	method : options,proxy,enable,disable
	 * 	events : onBeforeDrag,onStartDrag,onDrag,onStopDrag
	 * 	properties : proxy,revert,cursor,deltaX,deltaY,handle,disabled,edge,axis
	 * eg :
	 * 	<div id="dd" style="width:100px;height:100px;border:1px solid black;"></div>
	 * 	$('#dd').qdrag('cr');
	 */
	$.fn.qdrag = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){// methods or some properties
			if(options.inArray(['options','proxy'])){
				return $(this).draggable(options);
			}else if(options.inArray(['disable','enable'])){
				$(this).draggable(options);
			}else{
				var res = {};
				
				if(options.contains('c')){
					res.proxy = 'clone';
				}
				if(options.contains('r')){
					res.revert = true;
				}
				if(options.contains('d')){
					res.disabled = true;
				}
				if(options.contains('v')){
					res.axis = 'v';
				}
				if(options.contains('h')){
					res.axis = 'h';
				}
				
				$(this).draggable(res);
			}
		}else{// events and properties
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.draggable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).draggable(defaultOptions);
		}
	};

	/**
	 * 04.easyui droppable
	 * options :
	 * 	method : options,enable,disable
	 * 	events : onDragEnter,onDragOver,onDragLeave,onDrop
	 * 	properties : accept,disabled
	 * eg :
	 * 	<div id="dd" style="width:100px;height:100px;border:1px solid black;"></div>
	 * 	$('#dd').qdrop('#test');
	 */
	$.fn.qdrop = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){// methods or accept
			if(options == 'options'){
				return $(this).droppable(options);
			}else if(options.inArray(['disable','enable'])){
				$(this).droppable(options);
			}else{
				$(this).droppable({accept : options});
			}
		}else{// events and properties
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.droppable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).droppable(defaultOptions);
		}
	};

	/**
	 * 05.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};

	/**
	 * 06.easyui pagination
	 * options : 
	 * 	method : options,loading,loaded,refresh,select
	 *  events : onSelectPage,onBeforeRefresh,onRefresh,onChangePageSize
	 *  properties : total,pageSize,pageNumber,pageList,loading,buttons,layout,links,showPageList,showRefresh,beforePageText,afterPageText,displayMsg
	 * eg:
	 * 	<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div>
	 * 	$('#pp').qpage();
	 */
	$.fn.qpage = function(options, args){
		if(!options){
			$(this).pagination();
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).pagination(options);
			}else if(options.inArray('refresh','select')){
				$(this).pagination(options, args);
			}else{
				$(this).pagination(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.pagination.defaults);
			$.extend(defaultOptions, options);
			
			$(this).pagination(defaultOptions);
		}
	};

	/**
	 * 07.easyui searchbox
	 * options : 
	 * 	method : options,menu,textbox,getValue,setValue,getName,selectName,destroy,resize,disable,enable,clear,reset
	 *  properties : width,height,prompt,value,menu,searcher,disabled
	 * eg:
	 * 	<input id="ss"></input>
	    <div id="mm" style="width:120px">
		    <div data-options="name:'all',iconCls:'icon-ok'">All News</div>
		    <div data-options="name:'sports'">Sports News</div>
	    </div>
	 * 	$('#ss').qsearch('#mm','input sth', function(value, name){
			alert(value + '-' + name);
		});
	 */
	$.fn.qsearch = function(options, args, func){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.inArray(['options','menu','textbox','getValue','getName'])){
				return $(this).searchbox(options);
			}else if(options.inArray(['setValue','selectName','resize'])){
				$(this).searchbox(options, args);
			}else if(options.inArray(['destroy','disable','enable','clear','reset'])){
				$(this).searchbox(options);
			}else{
				$(this).searchbox({
					menu 		: options,
					prompt 		: args,
					searcher 	: func
				});
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.searchbox.defaults);
			$.extend(defaultOptions, options);
			
			$(this).searchbox(defaultOptions);
		}
	};

	/**
	 * 08.easyui progressbar
	 * options : 
	 * 	method : options,resize,getValue,setValue
	 *  events : onChange
	 *  properties : width,height,value,text
	 * eg:
	 * 	<div id="p"></div>
	 * 	$('#p').qpro(50);
	 */
	$.fn.qpro = function(options, args){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.inArray(['options','getValue'])){
				return $(this).progressbar(options);
			}else{
				$(this).progressbar(options,args);
			}
		}else if(typeof options == 'number'){
			if(args){
				$(this).progressbar({
					value 	: options,
					text	: args
				});
			}else{
				$(this).progressbar({
					value 	: options,
					text	: '正在加载中。。。'
				});
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.progressbar.defaults);
			$.extend(defaultOptions, options);
			
			$(this).progressbar(defaultOptions);
		}
	};

	/**
	 * 09.easyui tooltip
	 * options : 
	 * 	method : options,tip,arrow,show,hide,update,reposition,destroy
	 *  events : onShow,onHide,onUpdate,onPosition,onDestroy
	 *  properties : position,content,trackMouse,deltaX,deltaY,showEvent,hideEvent,showDelay,hideDelay
	 * eg:
	 * 	<a id="dd" href="javascript:void(0)">Click here</a>
	 * 	$('#dd').qtip('test');
	 */
	$.fn.qtip = function(options, args){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.inArray(['options','tip','arrow'])){
				return $(this).tooltip(options);
			}else if(options.inArray(['show','hide','update'])){
				$(this).tooltip(options, args);
			}else if(options.inArray(['reposition','destroy'])){
				$(this).tooltip(options);
			}else{
				$(this).tooltip({
					content : options
				});
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.tooltip.defaults);
			$.extend(defaultOptions, options);
			
			$(this).tooltip(defaultOptions);
		}
	};

	/**
	 * 10.easyui panel
	 * options : 
	 * 	method : options,panel,header,body,setTitle,open,close,destroy,refresh,resize,move,maximize,minimize,restore,collapse,expand
	 *  events : onBeforeLoad,onLoad,onLoadError,onBeforeOpen,onOpen,onBeforeClose,onClose,onBeforeDestroy,onDestroy,onBeforeCollapse,onCollapse,onBeforeExpand,onExpand,onResize,onMove,onMaximize
	 *  properties : id,title,iconCls,width,height,left,top,cls,headerCls,bodyCls,style,fit,border,doSize,noheader,content,collapsible,minimizable,maximizable,closable,tools,collapsed,minimized,maximized,closed,href,cache,loadingMessage,extractor,method,queryParams,loader
	 * eg:
	 * 	<div id="p"></div>
	 * 	$('#p').qpanel('qt:test','hello');
	 */
	$.fn.qpanel = function(options, args){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.inArray(['options','panel','header','body'])){
				return $(this).panel(options);
			}else if(options.inArray(['maximize','minimize','restore'])){
				$(this).panel(options);
			}else if(options.startWith('qt:')){
				if(args){
					var title = options.substr(3);
					if(args.startWith('href:')){
						$(this).panel({
							title 	: title,
							href	: args.substr(5)
						});
					}else{
						$(this).panel({
							title 	: title,
							content	: args
						});
					}
				}
			}else{
				$(this).panel(options,args);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.panel.defaults);
			$.extend(defaultOptions, options);
			
			$(this).panel(defaultOptions);
		}
	};
	/**
	 * panel对应的数据结构
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

	/**
	 * 11.easyui tabs
	 * options : 
	 * 	method : options,tabs,resize,add,close,getTab,getTabIndex,getSelected,select,unselect,showHeader,hideHeader,exists,update,enableTab,disableTab,scrollBy
	 *  events : onLoad,onSelect,onUnselect,onBeforeClose,onClose,onAdd,onUpdate,onContextMenu
	 *  properties : width,height,plain,fit,border,scrollIncrement,scrollDuration,tools,toolPosition,tabPosition,headerWidth,tabWidth,tabHeight,selected,showHeader
	 * eg:
	 * 	<div id="tt"></div>
	 * 	$('#tt').qtab({
			fit : true,
		});
		
		$('#tt').qtab('add', exports.panel($('#tt'), 'test', 'href:login'));
	 */
	$.fn.qtab = function(options, args){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options.inArray(['options','tabs'])){
				return $(this).tabs(options);
			}else if(options.inArray(['resize','getSelected','showHeader','hideHeader'])){
				$(this).tabs(options);
			}else{
				$(this).tabs(options, args);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.tabs.defaults);
			$.extend(defaultOptions, options);
			
			$(this).tabs(defaultOptions);
		}
	};
	/**
	 * tabs中常用方法addTab的封装，需要title和href
	 * eg:
	 * 	$('#tt').qaddTab('test', 'login');
	 */
	$.fn.qaddTab = function(title, href){
		var $tabs = $(this);
		$tabs.qtab('add', exports.tab($tabs, title, 'href:' + href));
	};
	/**
	 * 配合tabs使用的panel数据结构
	 */
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

	/**
	 * 12.easyui accordion
	 * options : 
	 * 	method : options,panels,resize,getSelected,getSelections,getPanel,getPanelIndex,select,unselect,add,remove
	 *  events : onSelect,onUnselect,onAdd,onBeforeRemove,onRemove
	 *  properties : width,height,fit,border,animate,multiple,selected
	 * eg:
	 * 	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
	 * 	$('#aa').qbaiye();
	 */
	$.fn.qbaiye = function(options, args){
		if(!options){
			$(this).accordion();
		}else if(typeof options == 'string'){
			if(options.inArray(['resize','panels'])){
				$(this).accordion(options);
			}else if(options.inArray(['select','unselect','add','remove'])){
				$(this).accordion(options, args);
			}else if(options.inArray(['getPanel','getPanelIndex'])){
				return $(this).accordion(options, args);
			}else if(options.inArray(['options','panels','getSelected','getSelections'])){
				return $(this).accordion(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.accordion.defaults);
			$.extend(defaultOptions, options);
			
			console.log(defaultOptions);
			
			$(this).accordion(defaultOptions);
		}
	};

	/**
	 * 13.easyui layout
	 * options : 
	 * 	method : resize,panel,collapse,expand,add,remove
	 *  properties : fit||title,region,border,split,iconCls,href,collapsible,minWidth,minHeight,maxWidth,maxHeight
	 * eg:
	 * 	$('body').qlayout('init', [
			exports.layout('center','href:login'),
			exports.layout('north','href:login', 'test'),
			exports.layout('south','href:login'),
			exports.layout('west','href:login')
		]);
	 */
	$.fn.qlayout = function(options, args){
		if(!options){
			$(this).layout();
		}else if(typeof options == 'string'){
			if(options == 'panel'){
				return $(this).layout(options, args);
			}else if(options == 'resize'){
				$(this).layout(options);
			}else if(options == 'init'){
				var $this = $(this);
				
				$this.layout();
				for(var i=0; i<args.length; i++){
					$this.layout('add', args[i]);
				}
			}else{
				$(this).layout(options, args);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.layout.defaults);
			$.extend(defaultOptions, layout);
			
			$(this).layout(defaultOptions);
		}
	};
	/**
	 * 配合layout使用的数据结构
	 */
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

	/**
	 * 14.easyui menu
	 * options : 
	 * 	method : options,show,hide,destroy,getItem,setText,setIcon,findItem,appendItem,removeItem,enableItem,disableItem
	 *  events : onShow,onHide,onClick
	 *  item   : id,text,iconCls,href,disabled,onclick
	 *  properties : zIndex,left,top,minWidth,hideOnUnhover
	 * eg:
	 * 	<div id="mm" class="easyui-menu" style="width:120px;">
		    <div>New</div>
		    <div>
			    <span>Open</span>
			    <div style="width:150px;">
				    <div><b>Word</b></div>
				    <div>Excel</div>
				    <div>PowerPoint</div>
		    	</div>
	    	</div>
		    <div data-options="iconCls:'icon-save'">Save</div>
		    <div class="menu-sep"></div>
		    <div>Exit</div>
	    </div>
	 * 	$('#mm').qmenu('show', {
		    left: 200,
		    top: 100
	    });
	 */
	$.fn.qmenu = function(options, args){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).menu(options);
			}else if(options.inArray(['getItem','findItem'])){
				return $(this).menu(options, args);
			}else if(options.inArray(['hide','destroy'])){
				$(this).menu(options);
			}else{
				$(this).menu(options, args);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.menu.defaults);
			$.extend(defaultOptions, options);
			
			$(this).menu(defaultOptions);
		}
	};

	/**
	 * 15.easyui linkbutton
	 * options : 
	 * 	method : options,disable,enable,select,unselect
	 * 	events : onClick
	 * 	properties : id,disabled,toggle,selected,group,plain,text,iconCls,iconAlign,size
	 * eg : 
	 * 	<a id="test">111</a>
	 * 	$('#test').qbutton('icon-add', test, 'p');	
	 */
	$.fn.qbutton = function(options, func, sth){
		if(!options){
			$(this).linkbutton();
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).linkbutton(options);
			}else if(options.inArray(['disable','enable','select','unselect'])){
				$(this).linkbutton(options);
			}else{
				$(this).linkbutton({iconCls : options});
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.linkbutton.defaults);
			$.extend(defaultOptions, options);
			
			$(this).linkbutton(defaultOptions);
		}
		
		if(func){
			$(this).linkbutton({onClick : func});
		}
		
		if(sth){
			var res = {};
			if(sth.contains('d')){
				res.disabled = true;
			}
			if(sth.contains('tg')){
				res.toggle = true;
			}
			if(sth.contains('s')){
				res.selected = true;
			}
			if(sth.contains('p')){
				res.plain = true;
			}
			if(sth.contains('lg')){
				res.size = 'large';
			}
			if(sth.contains('l')){
				res.iconAlign = 'left';
			}
			if(sth.contains('r')){
				res.iconAlign = 'right';
			}
			if(sth.contains('t')){
				res.iconAlign = 'top';
			}
			if(sth.contains('b')){
				res.iconAlign = 'bottom';
			}
			
			$(this).linkbutton(res);
		}
	};

	/**
	 * 16.easyui menubutton
	 * options : 
	 * 	method : options,enable,disable,destroy
	 *  properties : plain,menu,menuAlign,duration
	 * eg:
	 * 	<a href="javascript:void(0);" id="mb">test</a>
		<div id="mm" style="width:150px;">
			<div data-options="iconCls:'icon-undo'">Undo</div>
			<div data-options="iconCls:'icon-redo'">Redo</div>
			<div class="menu-sep"></div>
			<div>Cut</div>
			<div>Copy</div>
			<div>Paste</div>
			<div class="menu-sep"></div>
			<div data-options="iconCls:'icon-remove'">Delete</div>
			<div>Select All</div>
		</div>
	 * 	$('#mb').qmbutton({menu:'#mm',iconCls:'icon-edit'});
	 */
	$.fn.qmbutton = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).menubutton(options);
			}else{
				$(this).menubutton(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.menubutton.defaults);
			$.extend(defaultOptions, options);

			$(this).menubutton(defaultOptions);
		}
	};

	/**
	 * 17.easyui splitbutton
	 * options : 
	 * 	method : options,enable,disable,destroy
	 *  properties : plain,menu,duration
	 * eg:
	 * 	<a href="javascript:void(0);" id="sb">test</a>
		<div id="mm" style="width:150px;">
			<div data-options="iconCls:'icon-undo'">Undo</div>
			<div data-options="iconCls:'icon-redo'">Redo</div>
			<div class="menu-sep"></div>
			<div>Cut</div>
			<div>Copy</div>
			<div>Paste</div>
			<div class="menu-sep"></div>
			<div data-options="iconCls:'icon-remove'">Delete</div>
			<div>Select All</div>
		</div>
	 * 	$('#sb').qsbutton({menu:'#mm',iconCls:'icon-edit'});
	 */
	$.fn.qsbutton = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).splitbutton(options);
			}else{
				$(this).splitbutton(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.splitbutton.defaults);
			$.extend(defaultOptions, options);

			$(this).splitbutton(defaultOptions);
		}
	};

	/**
	 * 18.easyui form
	 * options : 
	 * 	method : submit,load,clear,reset,validate,enableValidation,disableValidation
	 *  events : onSubmit,success,onBeforeLoad,onLoadSuccess,onLoadError
	 *  properties : novalidate,ajax,queryParams,url
	 * eg:
	 * 	<form id="ff" method="post"></form>
	 * 	$('#ff').qform(url, function(data){alert(data);});
	 */
	$.fn.qform = function(options, success){
		if(!options){
			alert('need options');
		}else{
			if(success){
				var defaultOptions = {};
				$.extend(defaultOptions, $.fn.form.defaults);
				defaultOptions.url 		= options;
				defaultOptions.success 	= success;
				defaultOptions.onSubmit = function(){
					if(!$(this).form('validate')) return false;
				};
				
				$(this).form(defaultOptions);
			}else{
				if(typeof options == 'string'){
					if(options == 'validate'){
						return $(this).form(options);
					}else{
						$(this).form(options);
					}
				}else{
					var defaultOptions = {};
					$.extend(defaultOptions, $.fn.form.defaults);
					$.extend(defaultOptions, options);
					
					$(this).form(defaultOptions);
				}
			}
		}
	};
	
	/**
	 * 19.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 20.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 21.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 22.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 23.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 24.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 25.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 26.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 27.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 28.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 29.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 30.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 31.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 32.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 33.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 34.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 35.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 36.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
	/**
	 * 37.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};

	/**
	 * 38.easyui resizable
	 * options : 
	 * 	method : options,enable,disable
	 *  events : onStartResize,onResize,onStopResize
	 *  properties : disabled,handles,minWidth,minHeight,maxWidth,maxHeight,edge
	 * eg:
	 * 	<div id="test" style="height:20px; width:20px; border:1px solid black;"></div>
	 * 	$('#test').qresize();
	 */
	$.fn.qresize = function(options){
		if(!options){
			alert('need options');
		}else if(typeof options == 'string'){
			if(options == 'options'){
				return $(this).resizable(options);
			}else{
				$(this).resizable(options);
			}
		}else{
			var defaultOptions = {};
			$.extend(defaultOptions, $.fn.resizable.defaults);
			$.extend(defaultOptions, options);
			
			$(this).resizable(defaultOptions);
		}
	};
});