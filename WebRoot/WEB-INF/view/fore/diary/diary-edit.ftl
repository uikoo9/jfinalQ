<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<@ueditor/>
			<form class="form-horizontal" role="form" id="addDiaryForm">
				<input type="hidden" name="row.id" value="${(diary.id)!}"/>
				<@bsinput title='日记类型' input=false>
					<select class="form-control" name='row.diary_type_id'>
						<#if diaryTypes??>
							<#list diaryTypes as item>
								<option value="${item.id}" <#if diary?? && diary.diary_type_id == item.id>selected</#if>>${item.diary_type_name}</option>
							</#list>
						</#if>
					</select>
				</@bsinput>
				<@bsinput title='日记标题' name='row.diary_article_title' value='${(diary.diary_article_title)!}'/>
				<@bsinput title='日记内容' input=false>
					<script id="ueditor" name="row.diary_article_content" type="text/plain">${(diary.diary_article_content)!}</script>
				</@bsinput>
			</form>
			<p class="text-right">
				<button type="button" class="btn btn-primary addDiary" data-loading-text="保存中。。。">保存</button>
			</p>
		</div>
	</div>
	
	<@js web=true>$(function(){web.diary.init();});</@js>
</@html>