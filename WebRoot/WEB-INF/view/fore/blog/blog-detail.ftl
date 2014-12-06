<#include "/WEB-INF/view/inc.ftl"/>
<@html s=false>
	<@head t=blog.article_title/>
	<@bsbody>
		<@bsueditor js=false parseid='.ueparse'/>
		<div class="container" style="margin-top:-20px;">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h3 class="text-center">${blog.article_title}</h3>
					<@bspanel type='primary' style='margin-top:20px;' class='ueparse'>${blog.article_content}</@bspanel>
					<@bspanel type='primary' style='margin-top:20px;' title='评论'>
						<form class="form-horizontal" role="form" id="blogCommentForm">
							<input type="hidden" name="row.blog_id" value="${blog.id}"/>
							<@bsinput title='评论昵称' name='row.blog_comment_uname'/>
							<@bsinput title='评论内容' input=false>
								<textarea class="form-control" rows="5" style="resize:none;" name='row.blog_comment_content'></textarea>
							</@bsinput>
						</form>
						<p class="text-right">
							<button type="button" class="btn btn-primary" data-loading-text="保存中。。。" id="addCommentBtn">评论</button>
						</p>
					</@bspanel>
				</div>
			</div>
		</div>
		
		<@js web=true>$(function(){web.blog.init();});</@js>
	</@bsbody>
</@html>