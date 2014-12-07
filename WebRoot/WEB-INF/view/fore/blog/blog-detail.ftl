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
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<#if blog.comments()?size gt 0>
						<@bspanel title='评论区'>
							<#list blog.comments() as comment>
								<blockquote>
								  <p>${comment.blog_comment_content}</p>
								  <footer>
								  	by <strong>${comment.blog_comment_uname}</strong>，于<strong>${comment.cdate}</strong>，
								  	<a href="javascript:void(0);" class="readda" data="id:${comment.id};">回复</a>
								  </footer>
								</blockquote>
								<#list comment.comments()?if_exists as item>
									<blockquote style="margin-left:40px;">
									  <p>${item.blog_comment_content}</p>
									  <footer>by <strong>${item.blog_comment_uname}</strong>，于<strong>${item.cdate}</strong></footer>
									</blockquote>
								</#list>
							</#list>
						</@bspanel>
					</#if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a href="#commentadd" role="tab" data-toggle="tab" class="taba">评论</a>
						</li>
						<li role="presentation">
							<a href="#commentreadd" role="tab" data-toggle="tab" class="taba">回复</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="commentadd">
							<@bspanel>
								<form class="form-horizontal" role="form">
									<input type="hidden" name="row.blog_id" value="${blog.id}"/>
									<@bsinput title='评论昵称' name='row.blog_comment_uname'/>
									<@bsinput title='评论内容' input=false>
										<textarea class="form-control" rows="5" style="resize:none;" name='row.blog_comment_content'></textarea>
									</@bsinput>
								</form>
								<p class="text-right">
									<button type="button" class="btn btn-primary addComment" data-loading-text="保存中。。。">评论</button>
								</p>
							</@bspanel>
						</div>
						<div role="tabpanel" class="tab-pane" id="commentreadd">
							<@bspanel>
								<form class="form-horizontal" role="form">
									<fieldset disabled="disabled">
										<input type="hidden" name="row.blog_id" value="${blog.id}"/>
										<input type="hidden" name="row.blog_comment_parent_id"/>
										<@bsinput title='评论昵称' name='row.blog_comment_uname'/>
										<@bsinput title='评论内容' input=false>
											<textarea class="form-control" rows="5" style="resize:none;" name='row.blog_comment_content'></textarea>
										</@bsinput>
									</fieldset>
								</form>
								<p class="text-right">
									<button type="button" class="btn btn-primary addComment" data-loading-text="保存中。。。" disabled="disabled">回复</button>
								</p>
							</@bspanel>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<@js web=true>$(function(){web.blog.init();});</@js>
	</@bsbody>
</@html>