<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		<@ueditor js=false parseid='.ueparse'/>
		
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10" style="margin-bottom:10px;">
					<#list blogs?if_exists?sort_by('id') as blog>
						<#if blog.blog_article_code?contains('alert')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>提示框（alert）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert1'>普通提示框</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert2'>自定义提示框</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert3'>带回调提示框</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('confirm')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>确认框（confirm）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm1'>普通确认框</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm2'>自定义确认框</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm3'>带回调确认框</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('dialog')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>模态框（dialog）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='dialog1'>普通模态框</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='dialog2'>带回调模态框</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('msg')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>消息提示条（msg）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='msg1'>普通消息提示条</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='msg2'>自定义消息提示条</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('tooltip')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>提示（tooltip）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='tooltip1'>普通提示</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='tooltip2'>自定义提示</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('popover')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>烤饼（popover）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='popover1'>烤饼</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('tree')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1><strong>树（tree）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='bstree1'>加载普通tree</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='bstree2'>加载带复选框tree</@bsbutton>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='bstree3'>加载可编辑tree</@bsbutton>
									<p id="cruddiv"></p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
						<#if blog.blog_article_code?contains('bstro')>
							<div class="row" id="${blog.blog_article_code}">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h1 id="bstro-h1"><strong>网站引导（bstro）</strong></h1><hr/>
									<h2><strong>例子</strong></h2>
									<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='bstro1'>开始引导</@bsbutton>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive ueparse" style="margin-bottom:20px;">
									${blog.blog_article_content}
								</div>
							</div>
						</#if>
					</#list>
				</div>
				<div class="hidden-xs col-sm-2 col-md-2 col-lg-2">
					<div class="scrolldiv" style="position:fixed;top:70px;margin-right:20px;">
						<ul class="nav nav-pills nav-stacked" role="tablist">
							<#list blogs?if_exists?sort_by('id') as blog>
								<#if blog.blog_article_code?contains('alert')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('confirm')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('dialog')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('msg')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('tooltip')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('popover')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('tree')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
								<#if blog.blog_article_code?contains('bstro')>
									<li role="presentation"><a href="#${blog.blog_article_code}" class="list-group-item">${blog.blog_article_code?split('-')[1]}</a></li>
								</#if>
							</#list>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<@backtotop/>
		<@js>
			$(function(){
				qiao.bs.initimg();
				qiao.bs.spy();
				
				// alert
				qiao.on('#alert1', 'click', function(){
					qiao.bs.alert('普通提示框！');
				});
				qiao.on('#alert2', 'click', function(){
					qiao.bs.alert({
						okbtn	: '自定义文字等',
						msg		: '自定义提示框！',
						big		: true
					});
				});
				qiao.on('#alert3', 'click', function(){
					qiao.bs.alert('带回调提示框！',function(){
						alert('点击了确定！');
					});
				});
				
				// confirm
				qiao.on('#confirm1', 'click', function(){
					qiao.bs.confirm('普通确认框！');
				});
				qiao.on('#confirm2', 'click', function(){
					qiao.bs.confirm({
						okbtn	: '自定义文字等',
						msg		: '自定义确认框',
						big		: true
					});
				});
				qiao.on('#confirm3', 'click', function(){
					qiao.bs.confirm('带回调确认框！',function(){
						alert('点击了确定！');
					},function(){
						alert('点击了取消！');
					});
				});
				
				// dialog
				qiao.on('#dialog1', 'click', function(){
					qiao.bs.dialog({
						url : '/version.txt',
						title : '普通模态框'
					});
				});
				qiao.on('#dialog2', 'click', function(){
					qiao.bs.dialog({
						url : '/version.txt',
						title : '带回调模态框'
					},function(){
						alert('点击了确定！');
						return true;
					});
				});
				
				// msg
				qiao.on('#msg1', 'click', function(){
					qiao.bs.msg('普通消息提示条！');
				});
				qiao.on('#msg2', 'click', function(){
					qiao.bs.msg({
						msg  : '自定义消息提示条，警告，3秒消失',
						type : 'danger',
						time : 3000
					});
				});
				
				// tooltip
				$('#tooltip1').bstip('普通提示');
				$('#tooltip2').bstip({
					title		: '在右边的自定义提示',
					html		: true,
					placement	: 'right',
					trigger		: 'hover'
				});
				
				// popover
				$('#popover1').bspop({
					title		: '烤饼',
					content		: '烤饼内容，支持html内容'
				});
				
				// bstree
				qiao.on('#bstree1', 'click', function(){
					$('#cruddiv').bstree({url:'/other/menu'});
				});
				qiao.on('#bstree2', 'click', function(){
					$('#cruddiv').bstree({url:'/other/menu',checkbox:true});
				});
				qiao.on('#bstree3', 'click', function(){
					$('#cruddiv').bstree({url:'/other/menu',edit:true});
				});
				
				// bstro
				qiao.on('#bstro1', 'click', function(){
					qiao.bs.bstro([
						['#bstro-home','<h3 style="margin-top:10px;">效果不错吧~</h3>'],
						['#bstro-h1','<h3 style="margin-top:10px;">使用也是很简单滴~</h3>']
					]);
				});
			});
		</@js>
	</@bsbody>
</@html>