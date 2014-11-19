<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='文章类型' input=false>
		<select class="form-control" name='row.type_id'>
			<#list blogTypes as item>
				<option value="${item.id}" <#if row?? && row.type_id == item.id>selected</#if>>${item.type_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='文章标题' name='row.article_title' value='${(row.article_title)!}'/>
	<@bsinput title='文章内容' name='row.article_content' value='${(row.article_content)!}'/>
</form>