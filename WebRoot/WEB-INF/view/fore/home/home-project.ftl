<#include "/WEB-INF/view/inc/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9" data-spy="scroll" data-target=".scrolldiv">
				<#list proDetails as pro>
					<@bspanel id='panel'+pro.id>
						<p><strong>项目名称：</strong>${pro.project_name}</p>
						<p><strong>创建时间：</strong>${pro.cdate}</p>
						<#if pro.project_url??>
							<p><strong>项目地址：</strong><a href="${pro.project_url}" target="_blank">${pro.project_url}</a></p>
						</#if>
						<#if pro.project_src??>
							<p><strong>项目源码地址：</strong><a href="${pro.project_src}" target="_blank">${pro.project_src}</a></p>
						</#if>
						<p><strong>项目描述：</strong>${pro.project_desc}</p>
						<p>
							<strong>版本迭代：</strong>
							<ul>
								<#list pro.versions()?if_exists as v>
									<li>
										<dl>
											<dt>${v.project_version_code}</dt>
											<dd>${v.project_version_desc}</dd>
										</dl>
									</li>
								</#list>
							</ul>
						</p>
					</@bspanel>
				</#list>
			</div>
			<div class="hidden-xs col-sm-3 col-md-3 col-lg-3">
				<div class="scrolldiv" style="position:fixed;top:70px;">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<#list proDetails as pro>
							<li role="presentation"><a href="#panel${pro.id}" class="list-group-item">${pro.project_name}</a></li>
						</#list>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<@backtotop/>
	<@js>$(function(){qiao.bs.spy();});</@js>
</@html>