<#include "/WEB-INF/view/inc.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='所属账户' input=false>
		<select class="form-control" name='row.account_id'>
			<#list accounts as item>
				<option value="${item.id}" <#if row?? && row.account_id == item.id>selected</#if>>${item.account_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='收支明细' name='row.detail_shouzhi' value='${(row.detail_shouzhi)!}'/>
	<@bsinput title='收支备注' name='row.detail_remark' value='${(row.detail_remark)!}'/>
</form>