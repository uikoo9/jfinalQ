<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head></@head>

<@bsbody row=false js='project'>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-2 col-md-3 col-lg-3">
				<ul class="list-group">
					<#if details??>
						<#list details as detail>
							<li class="list-group-item" style="cursor:pointer;">${detail.pro_name}</li>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-10 col-md-9 col-lg-9">
				<#if details??>
					<#list details as detail>
						<@bspanel>
							<@bsrow title='项目名称'>${detail.pro_name}</@bsrow>
							<@bsrow title='创建时间'>${detail.cdate}</@bsrow>
							<#if detail.pro_url??>
								<@bsrow title='项目地址'>
									<a href="${detail.pro_url}" target="_blank">${detail.pro_url}</a>
								</@bsrow>
							</#if>
							<#if detail.pro_src??>
								<@bsrow title='项目源码地址'>
									<a href="${detail.pro_src}" target="_blank">${detail.pro_src}</a>
								</@bsrow>
							</#if>
							<@bsrow title='项目描述'>${detail.pro_desc}</@bsrow>
						</@bspanel>
					</#list>
				</#if>
			</div>
		</div>
	</div>
</@bsbody>
</@html>