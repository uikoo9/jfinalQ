<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='账户名称' name='row.bill_account_name' value='${(row.bill_account_name)!}'/>
	<@bsinput title='账户描述' name='row.bill_account_desc' value='${(row.bill_account_desc)!}'/>
</form>