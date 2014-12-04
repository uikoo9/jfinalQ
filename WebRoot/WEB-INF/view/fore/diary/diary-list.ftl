<#include "/WEB-INF/view/inc.ftl"/>
<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
				<#list diarys as diary>
					<blockquote style="border-left-color:#5bc0de;">
					  <p><a href="${base}/diary/detail/${diary.id}" target="_blank">${diary.article_title}</a></p>
					  <footer>阅读<strong>${diary.article_times}</strong>次，创作于${diary.cdate}，<a href="${base}/diary/edit/${diary.id}">编辑</a></footer>
					</blockquote>
				</#list>
			</div>
		</div>
	</div>
	<@js web=true>$(function(){});</@js>
</@html>