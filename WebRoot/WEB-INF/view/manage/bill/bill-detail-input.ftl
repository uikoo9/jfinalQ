<#include "/WEB-INF/view/inc/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='所属账户' input=false>
		<select class="form-control" name='row.bill_account_id'>
			<#list accounts as item>
				<option value="${item.id}" <#if row?? && row.bill_account_id == item.id>selected</#if>>${item.bill_account_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='支出分类' input=false>
		<@bsradios name='row.bill_detail_zhichu_type' ck='${(row.bill_detail_zhichu_type)!"030101"}' list=zhichutypes/>
	</@bsinput>
	<@bsinput title='收支明细' name='row.bill_detail_shouzhi' value='${(row.bill_detail_shouzhi)!}'/>
	<@bsinput title='收支备注' name='row.bill_detail_remark' value='${(row.bill_detail_remark)!}'/>
</form>