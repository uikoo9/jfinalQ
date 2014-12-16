<#include "/WEB-INF/view/inc.ftl"/>

<@ueditor init=false>ue = UE.getEditor('ueditor',{zIndex:1100});</@ueditor>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='所属项目' input=false>
		<select class="form-control" name='row.project_detail_id'>
			<#list proDetails as item>
				<option value="${item.id}" <#if row?? && row.project_detail_id == item.id>selected</#if>>${item.project_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='版本代号' name='row.project_version_code' value='${(row.project_version_code)!}'/>
	<@bsinput title='版本详情' input=false>
		<script id="ueditor" name="row.project_version_desc" type="text/plain">${(row.project_version_desc)!}</script>
	</@bsinput>
</form>