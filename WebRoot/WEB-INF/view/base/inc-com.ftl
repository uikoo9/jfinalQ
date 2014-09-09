<#include "/WEB-INF/view/base/inc.ftl"/>
<#-- bsbody -->
<#macro bsbody style='' class='' head=true foot=true row=true js=''>
<body <#if style != ''>style="${style}"</#if> <#if class != ''>class="${class}"</#if>>
	<script type="text/javascript">var qmask = new Qmask(); qmask.qmask();</script>

	<#if head><@bshead/></#if>

	<#if row>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="cruddiv">
					<#nested>
				</div>
			</div>
		</div>
	<#else>
		<#nested>
	</#if>
	
	<#if foot><@bsfoot/></#if>
	
	<#if js!=''><@rj js=js/></#if>
</body>
</#macro>

<#-- bshead -->
<#macro bshead pos='top' sname='uikoo9.com' shref='http://uikoo9.com/'>
	<nav role="navigation" class="navbar navbar-default" style="margin-bottom:20px;">
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
					<li><a href="#">JavaSE</a></li>
					<li><a href="#">JavaEE</a></li>
					<li><a href="#">Blogs</a></li>
					<li><a href="#">About Me</a></li>
					<#if (session.user)?? && menus??>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">后台管理<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<#list menus as menu>
									<li role="presentation" style="padding:10px;" class="menus" data="url:${menu.url};"><a role="menuitem" style="padding-left:10px;" tabindex="-1" href="javascript:void(0);">${menu.text}</a></li>
								</#list>
							</ul>
						</li>
					</#if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<#if (session.user)??>
						<li><a href="${base}/ucenter/login/logout">退出</a></li>
					<#else>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">登录</a>
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
<#macro bsfoot height='60' color='#f5f5f5'>
	<div class="footer" style="width:100%;height:${height}px;background-color:${color};text-align:center;">
		<div class="container">
			<p class="text-muted" style="margin: 20px 0;">
				<a target="_blank" href="http://uikoo9.com/" >uikoo9.com</a>&nbsp;&nbsp;&nbsp;
				<a target="_blank" href="http://www.miibeian.gov.cn/">京ICP备14036391号</a>
			</p>
		</div>
	</div>
</#macro>