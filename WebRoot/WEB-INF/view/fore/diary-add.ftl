<#include "/WEB-INF/view/inc.ftl"/>
<@html>
	<div class="container">
		<div class="row">
			<@bsueditor/>
			<form class="form-horizontal" role="form" id="addDiaryForm">
				<@bsinput title='日记标题' name='row.article_title'/>
				<@bsinput title='日记内容' input=false>
					<script id="ueditor" name="row.article_content" type="text/plain"></script>
				</@bsinput>
			</form>
			<p class="text-right">
				<button type="button" class="btn btn-primary addDiary" data-loading-text="保存中。。。">添加</button>
			</p>
		</div>
	</div>
	
	<@js web=true>$(function(){web.diaryadd.init();});</@js>
</@html>