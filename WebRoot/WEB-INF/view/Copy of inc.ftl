<#-- html -->
<#macro html>
	<!DOCTYPE html>
	<html>
		<#nested>
	</html>
</#macro>

<#-- head -->
<#macro head uis...>
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
		
		<!-- favicon.ico -->
		<link href="${base}/favicon.ico" type="image/x-icon" rel="bookmark"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="icon"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
		
		<!-- uis -->
		<#list uis as ui>
			<#if ui=='bs'>
		<!-- bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
			</#if>
		</#list>
		
		<!-- mine -->
		<#nested>
	</head>
</#macro>

<#-- js -->
<#macro js uis...>
	<!-- jquery -->
	<!--[if lt IE 9]>
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<![endif]-->
	<!--[if gte IE 9]>
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<![endif]-->
	<!--[if !IE]><!-->
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!--<![endif]-->
	
	<!-- uis -->
	<#list uis as ui>
		<#if ui=='bs'>
	<!-- bootstrap -->
	<!-- less than ie9 need some js -->
	<!--[if lt IE 9]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
		<script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
		</#if>
	</#list>
	
	<#nested>
</#macro>