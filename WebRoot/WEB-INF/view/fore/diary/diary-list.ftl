<#include "/WEB-INF/view/inc.ftl"/>

<@html j=true>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
				<#list diarys as diary>
					<blockquote style="border-left-color:#5bc0de;">
					  <p><a href="${base}/diary/detail/${diary.id}" target="_blank">${diary.diary_article_title}</a></p>
					  <footer>阅读<strong>${diary.diary_article_readtimes}</strong>次，创作于${diary.cdate}，<a href="${base}/diary/edit/${diary.id}">编辑</a></footer>
					</blockquote>
				</#list>
			</div>
			<div class="hidden-xs col-sm-3 col-md-3 col-lg-3">
				<div class="list-group" style="position:fixed;top:70px;">
					<a href="${base}/diary/list" class="list-group-item <#if !diaryTypeId??>active</#if>">所有文章</a>
					<#list diaryTypes as type>
						<a href="${base}/diary/list/${type.id}" class="list-group-item <#if diaryTypeId?? && diaryTypeId == type.id>active</#if>">${type.diary_type_name}</a>
					</#list>
				</div>
			</div>
		</div>
	</div>
</@html>