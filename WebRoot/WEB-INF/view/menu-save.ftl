<#include "/WEB-INF/view/inc.ftl"/>
<form class="form-horizontal" role="form" data="url:/menu/save;"id="crudform">
	<input type="hidden" name="id"/>
	<@bsinput title='菜单名称' name='text'/>
	<@bsinput title='菜单地址' name='url' />
</form>