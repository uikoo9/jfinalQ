<#include "/WEB-INF/view/inc.ftl"/>
<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9" data-spy="scroll" data-target=".scrolldiv">
				<#list proDetails as pro>
					<@bspanel id='panel'+pro.id>
						<p><strong>项目名称：</strong>${pro.pro_name}</p>
						<p><strong>创建时间：</strong>${pro.cdate}</p>
						<#if pro.pro_url??>
							<p><strong>项目地址：</strong><a href="${pro.pro_url}" target="_blank">${pro.pro_url}</a></p>
						</#if>
						<#if pro.pro_src??>
							<p><strong>项目源码地址：</strong><a href="${pro.pro_src}" target="_blank">${pro.pro_src}</a></p>
						</#if>
						<p><strong>项目描述：</strong>${pro.pro_desc}</p>
						<p>
							<strong>版本迭代：</strong>
							<ul>
								<#list pro.versions()?if_exists as v>
									<li>
										<dl>
											<dt>${v.ver_code}</dt>
											<dd>${v.ver_desc}</dd>
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
							<li role="presentation"><a href="#panel${pro.id}" class="list-group-item">${pro.pro_name}</a></li>
						</#list>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<@js web=true>$(function(){web.project.init();});</@js>
</@html>