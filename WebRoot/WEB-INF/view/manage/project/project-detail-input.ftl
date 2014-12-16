<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='项目类型' input=false>
		<@bsradios name='row.project_type' ck='${(row.project_type)!"020101"}' list=protypes/>
	</@bsinput>
	<@bsinput title='项目名称' name='row.project_name' value='${(row.project_name)!}'/>
	<@bsinput title='项目地址' name='row.project_url'	 value='${(row.project_url)!}'/>
	<@bsinput title='源码地址' name='row.project_src'  value='${(row.project_src)!}'/>
	<@bsinput title='项目序号' name='row.project_sn'   value='${(row.project_sn)!}'/>
	<@bsinput title='项目详情' input=false>
		<textarea class="form-control" rows="5" style="resize:none;" name='row.project_desc' placeholder='项目详情'>${(row.project_desc)!}</textarea>
	</@bsinput>
</form>