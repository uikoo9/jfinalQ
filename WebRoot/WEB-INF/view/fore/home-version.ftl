<#include "/WEB-INF/view/base/inc-son.ftl"/>
<@html>
<@head></@head>

<@bsbody js='home.min'>
	<div class="container" style="margin-top:-20px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<h3>技术架构</h3>
<pre>
	1.前端ui		: 	<b>bootstrap3.0</b>
	2.后端ui		: 	<b>qui</b>, 基于bootstrap3.0二次开发ui, not easyui, dwz...
	3.js模块化	: 	<b>requirejs</b>, not seajs or include js...
	4.后端框架	: 	<b>qjfinal</b>, 基于jfinal二次开发框架, not ssh1, ssh2 or sprigmvc...
	5.日志记录	:	<b>slf4j+logback</b>, not log4j, apache common logging or java util logging...
	6.其他		: 	code generated, c3p0, ehcache, freemarker, ueditor, r.js, nprogress.js...
</pre>
				<h3>版本更新</h3>
				<pre>
					<#include "/version.txt"/>
				</pre>
			</div>
		</div>
	</div>
</@bsbody>
</@html>