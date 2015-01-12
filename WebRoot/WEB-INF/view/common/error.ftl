<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
	<title>${title}</title>
	<style>
		*{margin:0;padding:0}
		body{font-family:"微软雅黑";background:#DAD9D7}
		img{border:none}
		.bg{width:100%;background:url("${base}/WUI/web/error/img/bg.jpg") no-repeat center top #DAD9D7;position:absolute;top:0;left:0;height:600px;overflow:hidden}
		.cont{margin:0 auto;width:500px;line-height:20px;}
		.c1{height:360px;text-align:center}
		.c1 .img1{margin-top:180px}
		.cont h1{text-align:center;color:#999;font-size:22px;font-weight:normal;height:35px}
		.cont h2{text-align:center;color:#555;font-size:18px;font-weight:normal;height:35px}
	</style>
	<script type="text/javascript">
		setTimeout(function(){
			location.href="${base}";
		},3000);
	</script>
</head>
<body>
	<div class="bg">
		<div class="cont">
			<div class="c1"><img src="${base}/WUI/web/error/img/face.png" class="img1" /></div>
			<h1>您没有访问权限，3秒后跳转到<a href="${base}">首页</a>~</h1>
		</div>
	</div>
</body>
</html>