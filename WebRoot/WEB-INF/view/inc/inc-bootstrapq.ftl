<#include "/com/uikoo9/util/ucenter/view/inc.ftl"/>

<#-- bshead -->
<#macro bshead pos='top' sname='BootstrapQ' shref='http://uikoo9.com/bootstrapQ'>
	<nav role="navigation" class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button data-target="#bsnav" data-toggle="collapse" class="navbar-toggle" type="button">
					<span class="sr-only">导航条</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="${shref}" class="navbar-brand"><strong class="text-primary">${sname}</strong></a>
			</div>
			
			<div class="collapse navbar-collapse" id="bsnav">
				<ul class="nav navbar-nav">
					<li><a href="${base}/bootstrapQ">首页</a></li>
					<li><a href="${base}/bootstrapQ/docs">文档</a></li>
					<li><a href="${base}/bootstrapQ/download">下载</a></li>
					<li><a href="${base}/bootstrapQ/me">关于我</a></li>
				</ul>
			</div>
		</div>
	</nav>
</#macro>