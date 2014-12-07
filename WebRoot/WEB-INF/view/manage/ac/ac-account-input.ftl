<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='账户名称' name='row.account_name' value='${(row.account_name)!}'/>
	<@bsinput title='账户描述' name='row.acocunt_desc' value='${(row.acocunt_desc)!}'/>
</form>