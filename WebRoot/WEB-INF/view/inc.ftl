<#include "/com/uikoo9/util/ucenter/view/inc.ftl"/>

<#-- js -->
<#macro js >
	<#nested>
</#macro>

<#-- bshead -->
<#macro bshead pos='top' sname='uikoo9.com' shref='http://uikoo9.com/home'>
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
						<#if user.user_type == '010101'>
							<li><a href="${base}/ac">首页</a></li>
							<li class="menus" data="url:/ac/detail/;"><a href="javascript:void(0);">收支明细</a></li>
							<li class="menus" data="url:/ac/account/;"><a href="javascript:void(0);">账户管理</a></li>
						</#if>
						<#if user.user_type == '010102'>
							<#list menus as menu>
								<li class="menus" data="url:${menu.menu_url};"><a href="javascript:void(0);">${menu.menu_title}</a></li>
							</#list>
						</#if>
					<#else>
						<li><a href="${base}/home">首页</a></li>
						<li><a href="${base}/home/project">项目</a></li>
						<li><a href="${base}/home/blogs">博客</a></li>
						<li><a href="${base}/home/version">技术架构&版本更新</a></li>
						<li><a href="#">关于我</a></li>
					</#if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<#if user??>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">${user.user_name}<span class="caret"></span></a>
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

<#-- bsfoot -->
<#macro bsfoot>
    <div id="footer">
		<div class="container">
			<p class="text-muted" style="margin: 20px 0;">
				<a target="_blank" href="http://uikoo9.com/home" >uikoo9.com</a>&nbsp;&nbsp;&nbsp;
				<a target="_blank" href="http://www.miibeian.gov.cn/">京ICP备14036391号</a>
			</p>
		</div>
	</div>
</#macro>