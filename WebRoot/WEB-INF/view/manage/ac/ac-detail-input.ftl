<#include "/WEB-INF/view/base/inc-com.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
						<@bsinput title='账户id' name='row.account_id' value='${(row.account_id)!}'/>
								<@bsinput title='收支明细' name='row.detail_shouzhi' value='${(row.detail_shouzhi)!}'/>
								<@bsinput title='收支备注' name='row.detail_remark' value='${(row.detail_remark)!}'/>
												</form>