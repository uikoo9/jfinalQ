<#include "/com/uikoo9/util/jfinal/view/common/inc.ftl"/>

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
					<li><a href="${base}/bootstrapQ" id="bstro-home">首页</a></li>
					<li><a href="${base}/bootstrapQ/started">开始</a></li>
					<li><a href="${base}/bootstrapQ/docs">文档</a></li>
					<li><a href="${base}/bootstrapQ/me">关于我</a></li>
					<li><a href="https://github.com/uikoo9/bootstrapQ" target="_blank">GitHub</a></li>
					<li><a href="${base}/bootstrapQ/donate">捐助</a></li>
				</ul>
			</div>
		</div>
	</nav>
</#macro>

<#-- backtotop -->
<#macro backtotop right=40 bottom=15>
	<script type="text/javascript" src="http://uikoo9.qiniudn.com/@/js/backtotop/jquery.backtotop.js"></script>
	<div id="back-to-top" style="font-size:40px;z-index:1100;cursor:pointer;position:fixed;right:${right}px;bottom:${bottom}px;">
		<span class="glyphicon glyphicon-plane"></span>
	</div>
	<script type="text/javascript">$(function(){$("#back-to-top").backToTop();});</script>
</#macro>