<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:20px;">
					<#if blog.blog_article_code?contains('alert')>
						<@bsbutton type='primary' size='lg' id='alert1'>普通文字提示</@bsbutton>
						<@bsbutton type='primary' size='lg' id='alert2'>自定义提示</@bsbutton>
						<@bsbutton type='primary' size='lg' id='alert3'>带回调的提示</@bsbutton>
					</#if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 table-responsive">
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
					qiao.bs.alert('普通文字提示！');
				});
				qiao.on('#alert2', 'click', function(){
					qiao.bs.alert({
						okbtn	: '自定义文字等',
						msg		: '自定义提示',
						big		: true
					});
				});
				qiao.on('#alert3', 'click', function(){
					qiao.bs.alert('带回调的提示！',function(){
						alert('点击了确定！');
					});
				});
			});
		</@js>
	</@bsbody>
</@html>