<#include "/WEB-INF/view/inc.ftl"/>
<@html>
	<div class="container">
		<div class="row">
			<@bsueditor/>
			<form class="form-horizontal" role="form" id="addDiaryForm">
				<input type="hidden" name="row.id" value="${(diary.id)!}"/>
				<@bsinput title='日记标题' name='row.article_title' value='${(diary.article_title)!}'/>
				<@bsinput title='日记内容' input=false>
					<script id="ueditor" name="row.article_content" type="text/plain">${(diary.article_content)!}</script>
				</@bsinput>
			</form>
			<p class="text-right">
				<button type="button" class="btn btn-primary addDiary" data-loading-text="保存中。。。">保存</button>
			</p>
		</div>
	</div>
	
	<@js web=true>$(function(){web.diaryadd.init();});</@js>
</@html>