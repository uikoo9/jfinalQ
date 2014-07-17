<#-- html -->
<#macro html>
	<!DOCTYPE html>
	<html>
		<#nested>
	</html>
</#macro>

<#-- body -->
<#macro body class="">
	<body class="${class}">
		<#nested>
	</body>
</#macro>

<#-- head -->
<#macro head uis...>
	<head>
		<!-- 字体 -------------------------------------------------------------------------------------------->
		<meta charset="UTF-8" />
		
		<!-- ie -------------------------------------------------------------------------------------------->
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
		
		<!-- 缓存关闭 ----------------------------------------------------------------------------------------->
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<!-- favicon.ico ----------------------------------------------------------------------------------------->
		<link href="${base}/favicon.ico" type="image/x-icon" rel="bookmark"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="icon"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 

		<!-- js -------------------------------------------------------------------------------------------->
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
		
		<!-- qiao.js -->
		<script type="text/javascript" src="${base}/UIS/qiao/qiao-min.js"></script>
		
		<!-- uis -------------------------------------------------------------------------------------------->
		<#list uis as ui>
			<#if ui=='bs'>
				<!-- bootstrap -->
				<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
				<!-- less than ie9 need some js -->
				<!--[if lt IE 9]>
					<script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
					<script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
				<![endif]-->
				<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
				<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
			</#if>
		</#list>
		
		<!-- mine ------------------------------------------------------------------------------------------>
		<#nested>
	</head>
</#macro>