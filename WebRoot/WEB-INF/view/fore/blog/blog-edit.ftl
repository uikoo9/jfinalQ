<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<@ueditor/>
			<form class="form-horizontal" role="form" id="addBlogForm">
				<input type="hidden" name="row.id" value="${(blog.id)!}"/>
				<@bsinput title='日记类型' input=false>
					<select class="form-control" name='row.type_id'>
						<#if blogTypes??>
							<#list blogTypes as item>
								<option value="${item.id}" <#if blog?? && blog.type_id == item.id>selected</#if>>${item.type_name}</option>
							</#list>
						</#if>
					</select>
				</@bsinput>
				<@bsinput title='日记标题' name='row.article_title' value='${(blog.article_title)!}'/>
				<@bsinput title='日记内容' input=false>
					<script id="ueditor" name="row.article_content" type="text/plain">${(blog.article_content)!}</script>
				</@bsinput>
			</form>
			<p class="text-right">
				<button type="button" class="btn btn-primary addBlog" data-loading-text="保存中。。。">保存</button>
			</p>
		</div>
	</div>
	
	<@js web=true>$(function(){web.blogedit.init();});</@js>
</@html>