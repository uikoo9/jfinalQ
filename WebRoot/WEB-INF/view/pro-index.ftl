<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head ui='bs'></@head>

<body style="padding-top:51px;">
	<@bsheader>
		<li><a href="#">JavaSE</a></li>
		<li><a href="#">JavaEE</a></li>
		<li><a href="#">Blogs</a></li>
		<li><a href="#">About Me</a></li>
	</@bsheader>
	<div class="jumbotron">
		<div class="container">
			  <h1>qiaowenbin.com</h1>
			  <p>ideas + coder = ?</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<@bstile title='MD5' desc='MD5在线查询'>
					<@bsbutton type='primary' href='http://qiaowenbin.com/md5'>访问</@bsbutton>
					<@bsbutton type='primary' dis=true>详情</@bsbutton>
				</@bstile>
			</div>
			<!-- 
			<div class="col-sm-4">
				<h3>QLocker</h3>
				<p>Java实现的锁频软件，Windows XP下屏蔽所有按键。</p>
			</div>
			<div class="col-sm-4">
				<h3>QRunner</h3>
				<p>只需简单几步，让所有程序都从win+r启动~</p>
			</div>
			-->
		</div>
		<!-- 
		<div class="row">
			<div class="col-sm-4">
				<h3>QGcoder</h3>
				<p>JavaEE代码生成器，可以生成servlet+jsp，ssh2，jfinal等框架对应的代码。</p>
			</div>
			<div class="col-sm-4">
				<h3>QEncrypt</h3>
				<p>加密JavaEE项目，目前适用于非spring项目，可自定义加密解密算法，无需修改java环境。</p>
			</div>
			<div class="col-sm-4">
				<h3>DISC</h3>
				<p>DISC研究的是可辨认的正常的人类行为。</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<h3>Success Dairy</h3>
				<p>成功日记，记录每次成功的瞬间！</p>
			</div>
			<div class="col-sm-4">
				<h3>QAccount</h3>
				<p>简单的记账系统，为您提供最简洁，最便于操作的记账系统。</p>
			</div>
		</div>
		-->
	</div>
	
	<#-- 
	<@js main='${base}/WUI/web/js/pro-index.js'></@js>
	-->
</body>
</@html>