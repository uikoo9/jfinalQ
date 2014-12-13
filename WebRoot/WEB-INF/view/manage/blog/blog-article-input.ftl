<#include "/WEB-INF/view/inc.ftl"/>

<@ueditor init=false>ue = UE.getEditor('ueditor',{zIndex:1100});</@bsueditor>
<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='文章类型' input=false>
		<select class="form-control" name='row.type_id'>
			<#list blogTypes as item>
				<option value="${item.id}" <#if row?? && row.type_id == item.id>selected</#if>>${item.type_name}</option>
			</#list>
		</select>
	</@bsinput>
	<@bsinput title='文章编码' name='row.article_code' value='${(row.article_code)!}'/>
	<@bsinput title='文章标题' name='row.article_title' value='${(row.article_title)!}'/>
	<@bsinput title='文章内容' input=false>
		<script id="ueditor" name="row.article_content" type="text/plain">${(row.article_content)!}</script>
	</@bsinput>
</form>