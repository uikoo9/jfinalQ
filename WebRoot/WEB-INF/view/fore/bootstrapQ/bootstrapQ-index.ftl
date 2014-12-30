<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head holder=true/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		<div class="container">
			<div class="row">
				<div class="jumbotron" style="text-align:center;padding-top:60px;padding-bottom:60px;">
					<div class="container">
						<h1>BootstrapQ</h1>
						<p style="margin:0;">
							1.bootstrap常用插件封装<br>
							2.bootstro网站引导插件封装<br>
							3.压缩后仅5.5k
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<@ueditor js=false parseid='.ueparse'/>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ueparse">
					${(blog.blog_article_content)!}
				</div>
			</div>
		</div>
		<@backtotop/>
		
		<@js>$(function(){qiao.bs.initimg();});</@js>
	</@bsbody>
</@html>