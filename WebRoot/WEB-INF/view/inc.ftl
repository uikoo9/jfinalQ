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
		<link rel="stylesheet" href="${base}/WUI/bootstrap/bootstrap-3.2.0.min.css">
			</#if>
		</#list>
		
		<!-- mine -->
		<#nested>
	</head>
</#macro>

<#-- js -->
<#macro js main>
	<!-- require.js -->
	<script type="text/javascript" src="${base}/WUI/requirejs/require.js"></script>
	<script type="text/javascript">
	requirejs.config({
	    baseUrl: 'WUI',
	    paths:{
	        jquery : 'jquery/jquery-1.11.0.min',
	        bootstrap : 'bootstrap/bootstrap-3.2.0.min',
	        uikoo9 : 'uikoo9/uikoo9'
	    },
	    shim:{
		    bootstrap: {
	            deps: ['jquery'],
	            exports: 'bs'
	        },
	    }
	});
	</script>
	<script type="text/javascript" src="${main}"></script>
	<#nested>
</#macro>