<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head></@head>

<@bsbody row=false js='project.min'>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<#if details??>
					<#list details as detail>
						<@bspanel>
							<p><strong>项目名称：</strong>${detail.pro_name}</p>
							<p><strong>创建时间：</strong>${detail.cdate}</p>
							<#if detail.pro_url??>
								<p><strong>项目地址：</strong><a href="${detail.pro_url}" target="_blank">${detail.pro_url}</a></p>
							</#if>
							<#if detail.pro_src??>
								<p><strong>项目源码地址：</strong><a href="${detail.pro_src}" target="_blank">${detail.pro_src}</a></p>
							</#if>
							<p><strong>项目描述：</strong>${detail.pro_desc}</p>
							<p>
								<strong>版本迭代：</strong>
								<ul>
									<#list detail.versions()?if_exists as v>
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
				</#if>
			</div>
		</div>
	</div>
</@bsbody>
</@html>