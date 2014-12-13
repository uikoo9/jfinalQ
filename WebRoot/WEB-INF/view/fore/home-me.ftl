<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container" style="margin-top:-20px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<@bspanel type='primary' style='margin-top:20px;'>${diary.diary_article_content}</@bspanel>
			</div>
		</div>
	</div>
	
	<@backtotop/>
	<@js>$(function(){qiao.bs.initimg();});</@js>
</@html>