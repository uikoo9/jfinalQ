<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container" style="margin-top:-20px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<h3 class="text-center">${diary.diary_article_title}</h3>
			</div>
		</div>
		<div class="row">
			<div class="hidden-xs hidden-sm col-md-12 col-lg-12" style="margin-bottom:3px;">
				<#if prevDiary.id == 0>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-left'  data='id:${prevDiary.id};' dis=true>上一篇：${prevDiary.diary_article_title}</@bsbutton>
				<#else>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-left'  data='id:${prevDiary.id};'>上一篇：${prevDiary.diary_article_title}</@bsbutton>
				</#if>
				<#if nextDiary.id == 0>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-right' data='id:${nextDiary.id};' pos='right' style="position:absolute;right:15px;" dis=true>下一篇：${nextDiary.diary_article_title}</@bsbutton>
				<#else>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-right' data='id:${nextDiary.id};' pos='right' style="position:absolute;right:15px;">下一篇：${nextDiary.diary_article_title}</@bsbutton>
				</#if>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<@bspanel type='primary' style='margin-top:20px;'>${diary.diary_article_content}</@bspanel>
			</div>
		</div>
		<div class="row">
			<div class="hidden-xs hidden-sm col-md-12 col-lg-12" style="margin-bottom:15px;">
				<#if prevDiary.id == 0>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-left'  data='id:${prevDiary.id};' dis=true>上一篇：${prevDiary.diary_article_title}</@bsbutton>
				<#else>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-left'  data='id:${prevDiary.id};'>上一篇：${prevDiary.diary_article_title}</@bsbutton>
				</#if>
				<#if nextDiary.id == 0>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-right' data='id:${nextDiary.id};' pos='right' style="position:absolute;right:15px;" dis=true>下一篇：${nextDiary.diary_article_title}</@bsbutton>
				<#else>
					<@bsbutton type='primary' size='xs' class='godiary' icon='arrow-right' data='id:${nextDiary.id};' pos='right' style="position:absolute;right:15px;">下一篇：${nextDiary.diary_article_title}</@bsbutton>
				</#if>
			</div>
		</div>
	</div>
	
	<@js web=true>$(function(){web.diary.init();});</@js>
</@html>