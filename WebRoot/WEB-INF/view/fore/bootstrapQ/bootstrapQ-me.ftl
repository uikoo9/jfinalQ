<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>

		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					${diary.diary_article_content}
				</div>
			</div>
		</div>
		
		<@backtotop/>
		<@js>$(function(){qiao.bs.initimg();});</@js>
	</@bsbody>
</@html>