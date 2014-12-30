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
					<li><a href="${base}/bootstrapQ/started">开始</a></li>
					<li class="dropdown">
						<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">文档<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/alert">alert</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/confirm">confirm</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/dialog">dialog</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/msg">msg</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/tooltip">tooltip</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/popover">popover</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/tree">tree</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/bootstrapQ/docs/bstro">bstro</a></li>
						</ul>
					</li>
					<li><a href="https://github.com/uikoo9/bootstrapQ" target="_blank">GitHub</a></li>
					<li><a href="${base}/bootstrapQ/me">关于我</a></li>
				</ul>
			</div>
		</div>
	</nav>
</#macro>