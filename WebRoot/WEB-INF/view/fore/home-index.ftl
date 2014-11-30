<#include "/WEB-INF/view/inc.ftl"/>
<@html s=false>
	<@head bstro=true/>
	<@bsbody>
		<div class="container">
			<div class="jumbotron" style="text-align:center;padding-top:60px;padding-bottom:60px;">
				<div class="container">
					<h1 id="test">uikoo9.com</h1>
					<p>ideas + coder = ?</p>
				</div>
			</div>
		</div>
		<@js web=true>
			$(function(){
				qiao.bs.bstro([
					['.jumbotron','<h3>你好</h3>'],
					['#test','<h3>你也好</h3>']
				]);
			});
		</@js>
	</@bsbody>
</@html>

<#-- 
去掉图片轮播
<div class="row">
	<@bslun 'demo1','demo2'></@bslun>
</div>
去掉javase项目
<#if pro.pro_type == '020102'>
	<#if pro.pro_url??>
		<@bsbutton type='primary' href=pro.pro_url>访问</@bsbutton>
	<#else>
		<@bsbutton type='primary' dis=true>访问</@bsbutton>
	</#if>
</#if>
<#if pro.pro_type == '020101'>
	<#if pro.pro_src??>
		<@bsbutton type='primary' href=pro.pro_src>源码</@bsbutton>
	<#else>
		<@bsbutton type='primary' dis=true>源码</@bsbutton>
	</#if>
</#if>
去掉项目明细
<#list proDetails?if_exists as pro>
	<#if pro_index % 3 == 0><div class="row"></#if>
		<@bsnail title=pro.pro_name>
			<#if pro.pro_url??>
				<@bsbutton type='primary' href=pro.pro_url>访问</@bsbutton>
			<#else>
				<@bsbutton type='primary' dis=true>访问</@bsbutton>
			</#if>
			<@bsbutton type='primary' href='${base}/home/project/${pro.id}'>详情</@bsbutton>
		</@bsnail>
	<#if pro_index % 3 == 2></div></#if>
</#list>
-->