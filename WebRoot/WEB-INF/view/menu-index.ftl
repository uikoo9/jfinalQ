<#include "/WEB-INF/view/inc.ftl"/>
<@bspanel>
	<p>
		<@bsbutton data='url:/menu/savep;'id='addBtn'>添加</@bsbutton>
		<@bsbutton>删除</@bsbutton>
		<@bsbutton type='success'>查询</@bsbutton>
	</p>
	<@bstable url='/menu/list'></@bstable>
</@bspanel>