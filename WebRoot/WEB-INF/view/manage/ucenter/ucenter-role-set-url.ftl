<#include "/WEB-INF/view/inc.ftl"/>

<input type="hidden" name="roleid" value="${roleid}"/>
<div class="row">
	<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5" style="height:400px;overflow-y:auto;">
		<p>已分配Url</p>
		<table class="table table-bordered table-hover intable">
			<#if inurls?? && inurls?size gt 0>
				<#list inurls as url>
					<tr class="mytr intr" style="cursor:pointer;" data="${url}">
						<td>${url}</td>
					</tr>
				</#list>
			</#if>
		</table>
	</div>
	<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
		<div style="positoin:absolute;top:50%;height:100px;margin-top:50px;">
			<@bsbutton type="primary" icon="arrow-left"  href='javascript:web.role.addUrl();'/>
			<@bsbutton type="primary" icon="arrow-right" href='javascript:web.role.removeUrl();'/>
		</div>
	</div>
	<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5" style="height:400px;overflow-y:auto;">
		<p>未分配Url</p>
		<table class="table table-bordered table-hover outtable">
			<#if outurls?? && outurls?size gt 0>
				<#list outurls as url>
					<tr class="mytr outtr" style="cursor:pointer;" data="${url}">
						<td>${url}</td>
					</tr>
				</#list>
			</#if>
		</table>
	</div>
</div>