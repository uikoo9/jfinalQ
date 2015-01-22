<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>
		<div class="container">
			<div class="row">
				<div class="jumbotron" style="text-align:center;padding-top:60px;padding-bottom:60px;">
					<div class="container">
						<h1>BootstrapQ</h1>
						<p style="margin:0;">
							1.Bootstrap组件封装<br>
							2.Bootstrap组件增强<br>
							3.Bootstrap周边组件<br>
							4.压缩后仅8.3k
						</p>
					</div>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="margin-bottom:10px;">
					<@bsbutton type='primary' size='lg' class='btn-block' icon='book' href='${base}/bootstrapQ/docs#bootstrapq-alert'>文档</@bsbutton>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="margin-bottom:10px;">
					<@bsbutton type='primary' size='lg' class='btn-block' icon='cloud-download' href='https://github.com/uikoo9/bootstrapQ/archive/master.zip'>下载</@bsbutton>
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
	</@bsbody>
</@html>