<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='角色名称' name='row.ucenter_role_name' value='${(row.ucenter_role_name)!}'/>	
	<@bsinput title='角色用户' name='row.ucenter_role_user_ids' value='${(row.ucenter_role_user_ids)!}'/>	
	<@bsinput title='角色地址' name='row.ucenter_role_urls' value='${(row.ucenter_role_urls)!}'/>	
</form>