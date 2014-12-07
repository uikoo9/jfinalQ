<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='项目类型' input=false>
		<@bsradios name='row.pro_type' ck='${(row.pro_type)!"020101"}' list=protypes/>
	</@bsinput>
	<@bsinput title='项目名称' name='row.pro_name' value='${(row.pro_name)!}'/>
	<@bsinput title='项目地址' name='row.pro_url'	 value='${(row.pro_url)!}'/>
	<@bsinput title='源码地址' name='row.pro_src'  value='${(row.pro_src)!}'/>
	<@bsinput title='项目序号' name='row.pro_sn'   value='${(row.pro_sn)!}'/>
	<@bsinput title='项目详情' input=false>
		<textarea class="form-control" rows="5" style="resize:none;" name='row.pro_desc' placeholder='项目详情'>${(row.pro_desc)!}</textarea>
	</@bsinput>
</form>