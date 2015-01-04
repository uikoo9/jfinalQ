<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:10px;">
					<#if blog.blog_article_code?contains('alert')>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert1'>普通提示框</@bsbutton>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert2'>自定义提示框</@bsbutton>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='alert3'>带回调提示框</@bsbutton>
					</#if>
					<#if blog.blog_article_code?contains('confirm')>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm1'>普通确认框</@bsbutton>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm2'>自定义确认框</@bsbutton>
						<@bsbutton type='primary' size='lg' style='margin-bottom:5px;' id='confirm3'>带回调确认框</@bsbutton>
					</#if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive" style="margin-bottom:20px;">
					${blog.blog_article_content}
				</div>
			</div>
		</div>
		
		<@backtotop/>
		<@js>
			$(function(){
				qiao.bs.initimg();
				
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
				
			});
		</@js>
	</@bsbody>
</@html>