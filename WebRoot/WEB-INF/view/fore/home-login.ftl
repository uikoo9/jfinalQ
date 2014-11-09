<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head>
<style type="text/css">
body{
	padding-top: 60px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 500px;
	padding: 0px 30px 10px 30px;
	margin: 0 auto 0;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	   -moz-border-radius: 5px;
	        border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	   -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	        box-shadow: 0 1px 2px rgba(0,0,0,.05);
}
</style>
</@head>

<@bsbody np=false head=false foot=false>
	<div class="container">
		<form class="form-horizontal form-signin" role="form" action="${baseurl}/login/login" method="post">
			<h2 class="text-center" style="padding-bottom:10px;">uikoo9.com</h2>
			<@bsinput title='用户名' 	lg=true name='username' value='${username!}'/>
			<@bsinput title='密码' 	lg=true name='password' type='password'/>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary btn-lg btn-block" type="submit" value="登录"/>
				</div>
			</div>
			<div class="form-group">
				<#if errorMsg??>
					<div class="col-sm-offset-2 col-sm-10 text-danger"><strong>${errorMsg!}</strong></div>
				</#if>
			</div>
		</form>
	</div>
	<script type="text/javascript">document.getElementById('id-username').focus();</script>
</@bsbody>
</@html>