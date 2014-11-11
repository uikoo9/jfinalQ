<#include "/WEB-INF/view/base/inc.ftl"/>
<#-- head -->
<#macro head title='uikoo9.com' bs=true>
	<head>
		<!-- 编码 -->
		<meta charset="UTF-8" />
		
		<!-- ie -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
		
		<!-- for search-->
		<meta name="keywords" content="uikoo9.com" />
		<meta name="description" content="uikoo9.com" />
		<meta name="author" contect="qiaowenbin">
		<meta name="robots" contect="all">
		
		<!-- title -->
		<title>${title}</title>
		
		<!-- favicon.ico -->
		<link href="${base}/favicon.ico" type="image/x-icon" rel="bookmark"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="icon"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
		
		<!-- base -->
		<script type="text/javascript">var base = '${base}';</script>
		
		<!-- nprogress -->
		<link rel="stylesheet" href="${base}/WUI/nprogress/nprogress.css">

		<#if bs>
		<!-- bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.2.0/css/bootstrap.min.css">
		<!-- foot -->
		<style type="text/css">
			html,body{height: 100%;}
			#wrap{min-height: 100%;height: auto !important;height: 100%;margin: 0 auto -60px;}
			#push,#footer{height: 60px;}
			#footer{background-color: #f5f5f5;text-align:center;}
			@media ( max-width : 767px){#footer {margin-left: -20px;margin-right: -20px;padding-left: 20px;padding-right: 20px;}}
		</style>
		<!--[if lt IE 9]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		</#if>
		<#nested>
	</head>
</#macro>

<#-- rj -->
<#macro rj js>
	<script type="text/javascript" src="${base}/WUI/rj/require.js"></script>
	<script type="text/javascript">
		requirejs.config({
			baseUrl : '${base}/WUI',
		    paths : {
		    	jquery		: 'http://cdn.staticfile.org/jquery/1.11.1/jquery.min',
		        bootstrap 	: 'http://cdn.staticfile.org/twitter-bootstrap/3.2.0/js/bootstrap.min',
		        qiao		: 'qiao',
		        login		: 'web/js-src/login'
		    },
		    shim : {
			    bootstrap : {
		            deps : ['jquery'],
		            exports :'bs'
		        }
		    }
		});
	</script>
	<#if js?contains('.min')>
		<script type="text/javascript" src="${base}/WUI/web/js-min/${js}.js"></script>
	<#else>
		<script type="text/javascript" src="${base}/WUI/web/js-src/${js}.js"></script>
	</#if>
</#macro>

<#-- bshead -->
<#macro bshead pos='top' sname='uikoo9.com' shref='http://uikoo9.com/home'>
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
					<#if user??>
						<#if user.user_type == '010102'>
							<#list menus as menu>
								<li class="menus" data="url:${menu.menu_url};"><a href="javascript:void(0);">${menu.menu_title}</a></li>
							</#list>
						</#if>
						<#if user.user_type == '010103'>
							<li><a href="${base}/ac">首页</a></li>
							<li><a href="${base}/ac/details">收支明细</a></li>
						</#if>
					<#else>
						<li><a href="${base}/home">Home</a></li>
						<#if proDetails?size gt 0>
							<li class="dropdown">
								<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Ideas<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<#list proDetails?if_exists as pro>
										<li role="presentation" style="padding:10px;"><a role="menuitem" style="padding-left:10px;" tabindex="-1" href="${base}/home/project/${pro.id}">${pro.pro_name}</a></li>
									</#list>
								</ul>
							</li>
						</#if>
						<li><a href="#">Blogs</a></li>
						<li><a href="${base}/home/version">Version</a></li>
						<li><a href="#">About Me</a></li>
					</#if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<#if user??>
						<li><a href="${base}/login/logout">退出</a></li>
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

<#-- 
本地js
<link rel="stylesheet" href="${base}/WUI/bootstrap-3.2.0/bootstrap.min.css">
jquery		: 'jquery/jquery-1.11.1.min',
bootstrap 	: 'bootstrap-3.2.0/bootstrap.min',
cdn js
<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.2.0/css/bootstrap.min.css">
jquery		: 'http://cdn.staticfile.org/jquery/1.11.1/jquery.min',
bootstrap 	: 'http://cdn.staticfile.org/twitter-bootstrap/3.2.0/js/bootstrap.min',
百度统计,响应太慢
<style type="text/css">a[href*="tongji.baidu.com"]{position:fixed;bottom:0;left:0;}</style>
<script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F7117ec605df94953bcc641e344d24b95' type='text/javascript'%3E%3C/script%3E"));
</script>
-->