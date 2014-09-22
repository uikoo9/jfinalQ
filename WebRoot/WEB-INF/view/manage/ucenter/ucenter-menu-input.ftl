<#include "/WEB-INF/view/base/inc-com.ftl"/>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='菜单名称' name='row.menu_text' value='${(row.menu_text)!}'/>
	<@bsinput title='菜单地址' name='row.menu_url'  value='${(row.menu_url)!}'/>
	<@bsinput title='菜单序号' name='row.menu_sn'   value='${(row.menu_sn)!}'/>
</form>