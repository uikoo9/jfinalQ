<#include "/WEB-INF/view/inc.ftl"/>
<@html>
	<div class="container" style="margin-top:-20px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<h3>技术架构</h3>
<pre>
	1.前端ui		: 	<b>bootstrap-3.0</b>
	2.后端ui		: 	<b>bootstrap-3.0-uikoo9</b>, not easyui, dwz...
	3.js模块化	: 	<b>requirejs</b>, not seajs or include js...
	4.后端框架	: 	<b>jfinal-1.9-uikoo9</b>, not ssh1, ssh2 or sprigmvc...
	5.日志记录	:	<b>slf4j+logback</b>, not log4j, apache common logging or java util logging...
	6.其他		: 	code generated, c3p0, ehcache, freemarker, ueditor, r.js, qmask.js...
</pre>
				<h3>版本更新</h3>
				<pre>
					<#include "/version.txt"/>
				</pre>
			</div>
		</div>
	</div>
	
	<@js web=true>$(function(){web.login.init();});</@js>
</@html>