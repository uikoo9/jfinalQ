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
			<div class="col-xs-12 col-sm-10 col-md-9 col-lg-9">1
			</div>
		</div>
	</div>
</@bsbody>
</@html>