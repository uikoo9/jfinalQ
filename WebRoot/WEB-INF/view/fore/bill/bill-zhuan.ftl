<#include "/WEB-INF/view/inc/inc.ftl"/>

<form class="form-horizontal" role="form">
	<@bsinput title='转出账户' input=false>
		<select class="form-control" name='accountId1'>
			<#list accounts as item>
				<option value="${item.id}">${item.bill_account_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='转入账户' input=false>
		<select class="form-control" name='accountId2'>
			<#list accounts as item>
				<option value="${item.id}">${item.bill_account_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='收支明细' name='shouzhi'/>
	<@bsinput title='收支备注' name='remark'/>
</form>