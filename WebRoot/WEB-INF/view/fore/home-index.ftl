<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<@bslun 'demo1.jpg','demo2.jpg'></@bslun>
		</div>
	</div>
</@html>

<#-- 
首页块
<div class="jumbotron" style="text-align:center;padding-top:60px;padding-bottom:60px;">
	<div class="container">
		<h1 id="test">uikoo9.com</h1>
		<p>ideas + coder = ?</p>
	</div>
</div>
去掉javase项目
<#if pro.project_type == '020102'>
	<#if pro.project_url??>
		<@bsbutton type='primary' href=pro.project_url>访问</@bsbutton>
	<#else>
		<@bsbutton type='primary' dis=true>访问</@bsbutton>
	</#if>
</#if>
<#if pro.project_type == '020101'>
	<#if pro.project_src??>
		<@bsbutton type='primary' href=pro.project_src>源码</@bsbutton>
	<#else>
		<@bsbutton type='primary' dis=true>源码</@bsbutton>
	</#if>
</#if>
去掉项目明细
<#list proDetails?if_exists as pro>
	<#if pro_index % 3 == 0><div class="row"></#if>
		<@bsnail title=pro.pro_name>
			<#if pro.project_url??>
				<@bsbutton type='primary' href=pro.project_url>访问</@bsbutton>
			<#else>
				<@bsbutton type='primary' dis=true>访问</@bsbutton>
			</#if>
			<@bsbutton type='primary' href='${base}/home/project/${pro.id}'>详情</@bsbutton>
		</@bsnail>
	<#if pro_index % 3 == 2></div></#if>
</#list>
-->