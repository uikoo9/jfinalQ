<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head 'bs'>
<title>uikoo9.com</title>
<style type="text/css">
body {
	background-color: #eee;
	padding-top: 40px;
}
div.row {
	padding: 10px;
}
</style>
<script src="${base}/UIS/web/js/pro-md5.js"></script>
</@head>

<@body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
						<input class="form-control input-lg" type="text" id="md5Input" name="code" required placeholder="Enter code">
					</div>
					<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
						<input class="btn btn-primary btn-block btn-lg" type="submit" value="MD5"/>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="panel panel-default" style="display:none;">
				<div class="panel-body">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 resdiv">
						加密前：<span></span>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 resdiv">
						加密后：<span><strong></strong></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</@body>
</@html>