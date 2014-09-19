<#include "/WEB-INF/view/base/inc-com.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='所属项目' input=false>
		<select class="form-control" name='row.pro_detail_id'>
			<#list prosDetails as item>
				<option value="${item.id}" <#if row?? && row.pro_detail_id == item.id>selected</#if>>${item.pro_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='版本代号' name='row.ver_code' value='${(row.ver_code)!}'/>
	<@bsinput title='版本详情' input=false>
		<textarea class="form-control" rows="5" style="resize:none;" name='row.ver_desc' placeholder='版本详情'>${(row.ver_desc)!}</textarea>
	</@bsinput>
</form>