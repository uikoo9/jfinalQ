<#include "/WEB-INF/view/inc.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="id" value="${(row.id)!}"/>
	<@bsinput title='菜单名称' name='text' value='${(row.text)!}'/>
	<@bsinput title='菜单地址' name='url'  value='${(row.url)!}'/>
</form>