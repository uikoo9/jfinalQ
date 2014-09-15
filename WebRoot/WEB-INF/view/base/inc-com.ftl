<#include "/WEB-INF/view/base/inc.ftl"/>
<#-- head -->
<#macro head title='uikoo9.com' bs=true>
	<head>
		<!-- 编码 -->
		<meta charset="UTF-8" />
		
		<!-- ie -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
		
		<!-- 缓存关闭 -->
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<!-- for search-->
		<meta name="keywords" content="MD5,md5,查询" />
		<meta name="description" content="MD5在线免费查询" />
		<meta name="author" contect="uikoo9">
		<meta name="robots" contect="all">
		
		<!-- title -->
		<title>${title}</title>
		
		<!-- favicon.ico -->
		<link href="${base}/favicon.ico" type="image/x-icon" rel="bookmark"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="icon"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
		
		<!-- base -->
		<script type="text/javascript">base = '${base}';baseurl = '${baseurl}';</script>

		<#if bs>
		<!-- bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="${base}/WUI/bootstrap-3.2.0/bootstrap.min.css">
		<!--[if lt IE 9]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		</#if>
		
		<!-- qmask -->
		<script type="text/javascript" src="${base}/WUI/qmask/qmask.min.js"></script>
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
		    	jquery		: 'jquery/jquery-1.11.1.min',
		        bootstrap 	: 'bootstrap-3.2.0/bootstrap.min',
		        qiao		: 'qiao'
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
					<#if protypes??>
						<#list protypes as item>
							<li><a href="javascript:void(0);">${item.text}</a></li>
						</#list>
					</#if>
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
						<li><a href="${base}/login/logout">退出</a></li>
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