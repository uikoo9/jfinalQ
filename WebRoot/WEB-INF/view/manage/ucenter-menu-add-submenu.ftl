<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.menu_parent_id" value="${(menu_parent_id)!}"/>
	<@bsinput title='菜单名称' name='row.menu_title' value='${(row.menu_title)!}'/>
	<@bsinput title='菜单地址' name='row.menu_url'  value='${(row.menu_url)!}'/>
	<@bsinput title='菜单序号' name='row.menu_sn'   value='${(row.menu_sn)!}'/>
</form>