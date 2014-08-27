<#-- inc-common ----------------------------------------------------------------------------------------------->
<#-- html -->
<#macro html>
	<!DOCTYPE html>
	<html>
		<#nested>
	</html>
</#macro>

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
		
		<#if bs>
		<!-- bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.2.0/css/bootstrap.min.css">
		</#if>
		
		<!-- base -->
		<script type="text/javascript">base = '${base}';baseurl = '${baseurl}';</script>
		
		<!-- qmask -->
		<script type="text/javascript" src="${base}/WUI/qmask/qmask.min.js"></script>
		<#nested>
	</head>
</#macro>

<#-- rj -->
<#macro rj js>
	<script type="text/javascript" src="http://cdn.staticfile.org/require.js/2.1.14/require.min.js"></script>
	<script type="text/javascript" src="${base}/WUI/rj/config.js"></script>
	<#if js?contains('.min')>
		<script type="text/javascript" src="${base}/WUI/web/js-min/${js}.js"></script>
	<#else>
		<script type="text/javascript" src="${base}/WUI/web/js-src/${js}.js"></script>
	</#if>
</#macro>

<#-- inc-bs ----------------------------------------------------------------------------------------------->
<#-- bsbody -->
<#macro bsbody style='' class='' head=true foot=true js=''>
<body <#if style != ''>style="${style}"</#if> <#if class != ''>class="${class}"</#if>>
	<script type="text/javascript">var qmask = new Qmask(); qmask.qmask();</script>

	<#if head><@bshead/></#if>

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="cruddiv">
				<#nested>
			</div>
		</div>
	</div>
	
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
					<#if (session.user)??>
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

<#-- bsmenu -->
<#macro bsmenu menus=''>
	<#if menus != ''>
		<div class="list-group">
			<#list menus as menu>
				<a href="javascript:void(0);" class="list-group-item menus" data="url:${menu.url};">${menu.text}</a>
			</#list>
		</div>
	</#if>
</#macro>

<#-- bslun -->
<#macro bslun pics...>
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-bottom:20px;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<#list pics as pic>
				<li data-target="#carousel-example-generic" data-slide-to="${pic_index}" <#if pic_index == 0>class="active"</#if>></li>
			</#list>
		</ol>
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<#list pics as pic>
				<div class="item <#if pic_index == 0>active</#if>">
					<img src="${base}/WUI/web/css/img/${pic}.jpg" alt="${pic}">
				</div>
			</#list>
		</div>
		
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</#macro>

<#-- bsnail -->
<#macro bsnail src='' alt='' title='' desc=''>
	<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="text-align:center;">
		<div class="thumbnail" style="height:190px;">
			<#if src != ''>
				<img src="${src}" alt="${alt}">
			</#if>
			<div class="caption">
				<#if title != ''><h1>${title}</h1></#if>
				<#if desc != ''><p>${desc}</p></#if>
				<p><#nested></p>
			</div>
		</div>
	</div>
</#macro>

<#-- bsbutton -->
<#macro bsbutton dis=false type="primary" href='javascript:void(0);' size='' icon='' class='' data='' id='' >
	<a 	<#if id!=''>id="${id}"</#if> 
		<#if data!=''>data="${data}"</#if>
		<#if dis>disabled="disabled"</#if> 
		<#if href!='javascript:void(0);'>target="_blank"</#if>
		href="${href}" 
		class="btn btn-${type} <#if size != ''>btn-${size}</#if> <#if class!=''>${class}</#if>" 
	>
		<@bsicon icon=icon></@bsicon>
		<#nested>
	</a>
</#macro>

<#-- bsicon -->
<#macro bsicon icon=''>
	<#if icon != ''>
		<span class="glyphicon glyphicon-${icon}"></span>
	</#if>
</#macro>

<#-- bspanel -->
<#macro bspanel title='' id=''>
	<div class="panel panel-default" style="height:100%;">
		<#if title!=''><div class="panel-heading">${title}</div></#if>
		<div class="panel-body" <#if id!=''>id="${id}"</#if>>
			<#nested>
		</div>
	</div>
</#macro>

<#-- bstable -->
<#macro bstable url=''>
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover" <#if url!=''>data="url:${url}"</#if>>
			<#nested>
		</table>
	</div>
</#macro>

<#-- bsform -->
<#macro bsform h=false l=false class='' data='' id='' action=''>
	<form class="form<#if h>-horizontal</#if><#if l>-inline</#if> <#if class!=''>${class}</#if>" 
		role="form" method="post" 
		<#if data!=''>data="${data}"</#if> 
		<#if id!=''>id="${id}"</#if> 
		<#if action!=''>action="${action}"</#if>
	>
		<#nested>
	</form>
</#macro>

<#-- bsinput -->
<#macro bsinput type='text' title='title' name='name' value='' col=true>
	<div class="form-group">
		<label for="id-${name}" class="control-label <#if col>col-xs-3 col-sm-2 col-md-2 col-lg-2</#if>">${title}</label>
		<div class="<#if col>col-xs-9 col-sm-10 col-md-10 col-lg-10</#if>">
			<input type="${type}" name="${name}" value="${value}" placeholder="${title}" class="form-control" id="id-${name}">
		</div>
	</div>
</#macro>

<#-- inc-crud ----------------------------------------------------------------------------------------------->
<#-- list -->
<#macro list id='' importTable=true page=page>
	<#if importTable>
		<@table>
			<#nested>
		</@table>
	<#else>
		<#nested>
	</#if>
	<#if page!="">
		<#if page.items?size gt 0>
		<@pagination id=id page=page></@pagination>
		<#else>
		<ol class="breadcrumb">
	  		<li>没有数据！</li>
		</ol>
		</#if>
	</#if>
</#macro>

<#-- bspage -->
<#macro bspage page>
	<#assign pagenum = page.totalPage>
	<#if pagenum gt 1>
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
				<ul class="pagination" style="margin:0;">
					<li <#if page.pageNumber == 1>class="disabled"</#if>>
						<@bsbutton icon='step-backward' class='crud crudfirst'/>
					</li>
					<li <#if page.pageNumber == 1>class="disabled"</#if>>
						<@bsbutton icon='chevron-left' class='crud crudprev'/>
					</li>
					<#if pagenum lte 3>
						<#list 1..pagenum as pn>
							<li <#if page.pageNumber == pn>class="active"</#if>>
								<a href="javascript:void(0);" class="cruda">${pn}</a>
							</li>
						</#list>
					</#if>
					<#if pagenum gt 3>
						<#if page.pageNumber lt 2>
							<#list 1..pagenum as pn>
								<#if pn lt 3>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#list>
						</#if>
						<#if page.pageNumber gte 2>
							<#if page.pageNumber-1 gt 0>
								<li class="disabled">
									<a href="javascript:void(0);">...</a>
								</li>
							</#if>
							<#list 1..pagenum as pn>
								<#if (page.pageNumber-1 <= pn)&&(pn <= page.pageNumber+1)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
									
							</#list>
						</#if>
						<#if page.pageNumber+1 lt pagenum>
							<li class="disabled">
								<a href="javascript:void(0);">...</a>
							</li>
						</#if>
					</#if>
					
					<li <#if page.pageNumber == pagenum>class="disabled"</#if>>
						<@bsbutton icon='chevron-right' class='crud crudnext'/>
					</li>
					<li	<#if page.pageNumber == pagenum>class="disabled"</#if>>
						<@bsbutton icon='step-forward' class='crud crudlast' data='page:${pagenum};'/>
					</li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
				<div class="input-group">
					<input type="text" class="form-control crudinput">
					<span class="input-group-btn">
						<button class="btn btn-primary crudgo" type="button" data="page:${page.totalPage};">走你</button>
					</span>
				</div>
			</div>
		</div>
	</#if>
</#macro>

<#-- 
column 
这个布局相关，因为涉及到四种设备，所以还是手动写比较好
col-xs-12 col-sm-12 col-md-12 col-lg-12
-->