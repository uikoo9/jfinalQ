<#include "/WEB-INF/view/base/inc-com.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='项目名称' name='row.pro_name' value='${(row.pro_name)!}'/>
	<@bsinput title='项目地址' name='row.pro_url'	 value='${(row.pro_url)!}'/>
	<@bsinput title='源码地址' name='row.pro_src'  value='${(row.pro_src)!}'/>
	<@bsinput title='项目类型' input=false>
		<select class="form-control" name='row.pro_type'>
			<#list types as type>
				<option value="${type.value}" <#if row?? && row.pro_type == type.value>selected</#if>>${type.text}</option>
			</#list>
		</select>
	</@bsinput>
</form>