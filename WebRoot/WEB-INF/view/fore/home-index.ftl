<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head></@head>

<@bsbody js='home.min'>
	<#-- 
		<div class="row">
			<@bslun 'demo1','demo2'></@bslun>
		</div>
	-->
	<div class="container">
		<div class="jumbotron" style="text-align:center;padding-top:60px;padding-bottom:60px;">
			<div class="container">
				<h1>uikoo9.com</h1>
				<p>ideas + coder = ?</p>
			</div>
		</div>
		<#list proDetails?if_exists as pro>
			<#if pro_index % 3 == 0><div class="row"></#if>
				<@bsnail title=pro.pro_name>
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
					
					<@bsbutton type='primary' href='${baseurl}/project/${pro.id}'>详情</@bsbutton>
				</@bsnail>
			<#if pro_index % 3 == 2></div></#if>
		</#list>
		
	</div>
</@bsbody>
</@html>