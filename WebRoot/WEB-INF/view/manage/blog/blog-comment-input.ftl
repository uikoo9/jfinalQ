<#include "/WEB-INF/view/inc.ftl"/>

<form class="form-horizontal" role="form">
	<input type="hidden" name="row.id" value="${(row.id)!}"/>
	<@bsinput title='博客id' name='row.blog_id' value='${(row.blog_id)!}'/>	
	<@bsinput title='博客评论内容' name='row.blog_comment_content' value='${(row.blog_comment_content)!}'/>	
	<@bsinput title='父评论id' name='row.parent_id' value='${(row.parent_id)!}'/>	
		
		
		
		
</form>