<#include "/WEB-INF/view/base/inc.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='用户名' 	 name='row.username' value='${(row.username)!}'/>
	<@bsinput title='用户密码' name='row.password' value='${(row.password)!}' type='password'/>
</form>