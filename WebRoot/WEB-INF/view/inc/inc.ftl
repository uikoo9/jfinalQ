<#include "/com/uikoo9/util/jfinal/view/common/inc.ftl"/>

<#-- bshead -->
<#macro bshead pos='top' sname='QBloger' shref='http://qbloger.duapp.com/'>
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
					<#if user??>
						<#if user.ucenter_user_type == '010102'>
							<li><a href="${base}/">首页</a></li>
							<li><a href="${base}/blog/list">博客</a></li>
							<li><a href="${base}/blog/edit">写博客</a></li>
							<li><a href="${base}/version">版本更新</a></li>
							<li><a href="http://uikoo9.com/donate" target="_blank">捐助</a></li>
							<li><a href="http://uikoo9.com/me" target="_blank">关于我</a></li>
						</#if>
						<#if user.ucenter_user_type == '010101'>
							<#list menus as menu>
								<#if menu.submenus()?size gt 0>
									<li class="dropdown">
										<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">${menu.ucenter_menu_title}<span class="caret"></span></a>
										<ul class="dropdown-menu" role="menu">
											<#list menu.submenus() as item>
												<li role="presentation" class="menus" data="url:${item.ucenter_menu_url};"><a role="menuitem" tabindex="-1" href="javascript:void(0);">${item.ucenter_menu_title}</a></li>
											</#list>
										</ul>
									</li>
								<#else>
									<li class="menus" data="url:${menu.ucenter_menu_url};"><a href="javascript:void(0);">${menu.ucenter_menu_title}</a></li>
								</#if>
							</#list>
						</#if>
					<#else>
						<li><a href="${base}/">首页</a></li>
						<li><a href="${base}/blog/list">博客</a></li>
						<li><a href="${base}/version">版本更新</a></li>
						<li><a href="http://uikoo9.com/donate" target="_blank">捐助</a></li>
						<li><a href="http://uikoo9.com/me" target="_blank">关于我</a></li>
					</#if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<#if user??>
						<#if msgcount??>
							<li><a href="${base}/blog/msg">新的评论<span class="badge">${msgcount}</span></a></li>
						</#if>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">${user.ucenter_user_name}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" class="modifyPwd">修改密码</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/login/logout">退出系统</a></li>
							</ul>
						</li>
					<#else>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">登录<span class="caret"></span></a>
							<div class="dropdown-menu" role="menu" style="width:250px;height;250px;padding:20px;">
								<@bsform class='loginform'>
									<@bsinput col=false name='username' title='用户名' value='${username!}'/>
									<@bsinput col=false name='password' title='密码' type='password'/>
									<div class="form-group"><input class="btn btn-lg btn-primary btn-block loginbtn" type="button" value="登录"/></div>
									<div class="form-group"><h5 class="text-danger"></h5></div>
								</@bsform>
							</div>	
						</li>
					</#if>
				</ul>
			</div>
		</div>
	</nav>
</#macro>