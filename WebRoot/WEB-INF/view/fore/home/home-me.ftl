<#include "/WEB-INF/view/inc/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				${diary.diary_article_content}
			</div>
		</div>
	</div>
	
	<@backtotop/>
	<@js>$(function(){qiao.bs.initimg();});</@js>
</@html>