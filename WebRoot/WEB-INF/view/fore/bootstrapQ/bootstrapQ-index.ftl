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
							2.bootstro网站引导插件封装
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<@bsnail data='holder.js/400x150' title='文档'	href='${base}/bootstrapQ/docs'/>
				<@bsnail data='holder.js/400x150' title='下载' 	href='${base}/bootstrapQ/download'/>
				<@bsnail data='holder.js/400x150' title='关于我'	href='${base}/me'/>
			</div>
		</div>
	</@bsbody>
</@html>