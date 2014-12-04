<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='日记类型名称' name='row.diary_type_name' value='${(row.diary_type_name)!}'/>	
</form>