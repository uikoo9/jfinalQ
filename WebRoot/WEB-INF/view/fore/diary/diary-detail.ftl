<#include "/WEB-INF/view/inc/inc.ftl"/>

<@html>
	<div class="container" style="margin-top:-20px;">
		<!-- title -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<h3 class="text-center">${diary.diary_article_title}</h3>
			</div>
		</div>
		
		<!-- prev,next -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:3px;">
				<@bsbutton type='primary' size='xs' class='godiary' data='id:${prevDiary.id};' dis=(prevDiary.id == 0)>上一篇：${prevDiary.diary_article_title}</@bsbutton>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:3px;">
				<@bsbutton type='primary' size='xs' class='godiary' data='id:${nextDiary.id};' dis=(nextDiary.id == 0)>下一篇：${nextDiary.diary_article_title}</@bsbutton>
			</div>
		</div>
		
		<!-- content -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<@bspanel type='primary' style='margin-top:20px;'>${diary.diary_article_content}</@bspanel>
			</div>
		</div>
		
		<!-- prev,next -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:3px;">
				<@bsbutton type='primary' size='xs' class='godiary' data='id:${prevDiary.id};' dis=(prevDiary.id == 0)>上一篇：${prevDiary.diary_article_title}</@bsbutton>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:15px;">
				<@bsbutton type='primary' size='xs' class='godiary' data='id:${nextDiary.id};' dis=(nextDiary.id == 0)>下一篇：${nextDiary.diary_article_title}</@bsbutton>
			</div>
		</div>
	</div>
	
	<@js web=true>$(function(){web.diary.init();});</@js>
</@html>