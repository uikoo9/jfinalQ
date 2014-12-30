<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		<@ueditor js=false parseid='.ueparse'/>
		
		<div class="container" style="margin-bottom:20px;">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ueparse">
					${(blog.blog_article_content)!}
				</div>
			</div>
		</div>
		
		<@backtotop/>
	</@bsbody>
</@html>