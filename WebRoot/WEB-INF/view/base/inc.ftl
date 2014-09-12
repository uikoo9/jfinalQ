<#-- html -->
<#macro html>
	<!DOCTYPE html>
	<html>
		<#nested>
	</html>
</#macro>

<#-- bsmenu -->
<#macro bsmenu menus=''>
	<#if menus != ''>
		<div class="list-group">
			<#list menus as menu>
				<a href="javascript:void(0);" class="list-group-item menus" data="url:${menu.url};">${menu.text}</a>
			</#list>
		</div>
	</#if>
</#macro>

<#-- bslun -->
<#macro bslun pics...>
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-bottom:20px;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<#list pics as pic>
				<li data-target="#carousel-example-generic" data-slide-to="${pic_index}" <#if pic_index == 0>class="active"</#if>></li>
			</#list>
		</ol>
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<#list pics as pic>
				<div class="item <#if pic_index == 0>active</#if>">
					<img src="${base}/WUI/web/css/img/${pic}.jpg" alt="${pic}">
				</div>
			</#list>
		</div>
		
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</#macro>

<#-- bsnail -->
<#macro bsnail src='' alt='' title='' desc=''>
	<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="text-align:center;">
		<div class="thumbnail" style="height:190px;">
			<#if src != ''>
				<img src="${src}" alt="${alt}">
			</#if>
			<div class="caption">
				<#if title != ''><h1>${title}</h1></#if>
				<#if desc != ''><p>${desc}</p></#if>
				<p><#nested></p>
			</div>
		</div>
	</div>
</#macro>

<#-- bsbutton -->
<#macro bsbutton dis=false type="primary" href='javascript:void(0);' size='' icon='' class='' data='' id='' >
	<a 	<#if id!=''>id="${id}"</#if> 
		<#if data!=''>data="${data}"</#if>
		<#if dis>disabled="disabled"</#if> 
		<#if href!='javascript:void(0);'>target="_blank"</#if>
		href="${href}" 
		class="btn btn-${type} <#if size != ''>btn-${size}</#if> <#if class!=''>${class}</#if>" 
	>
		<@bsicon icon=icon></@bsicon>
		<#nested>
	</a>
</#macro>

<#-- bsicon -->
<#macro bsicon icon=''>
	<#if icon != ''>
		<span class="glyphicon glyphicon-${icon}"></span>
	</#if>
</#macro>

<#-- bspanel -->
<#macro bspanel type='default' title='' id=''>
	<div class="panel panel-${type}" style="height:100%;">
		<#if title!=''><div class="panel-heading">${title}</div></#if>
		<div class="panel-body" <#if id!=''>id="${id}"</#if>>
			<#nested>
		</div>
	</div>
</#macro>

<#-- bstable -->
<#macro bstable url=''>
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover" <#if url!=''>data="url:${url}"</#if>>
			<#nested>
		</table>
	</div>
</#macro>

<#-- bsform -->
<#macro bsform h=false l=false class='' data='' id='' action=''>
	<form class="form<#if h>-horizontal</#if><#if l>-inline</#if> <#if class!=''>${class}</#if>" 
		role="form" method="post" 
		<#if data!=''>data="${data}"</#if> 
		<#if id!=''>id="${id}"</#if> 
		<#if action!=''>action="${action}"</#if>
	>
		<#nested>
	</form>
</#macro>

<#-- bsinput -->
<#macro bsinput type='text' title='title' name='name' value='' lg=false col=true input=true>
	<#if input>
		<div class="form-group">
			<label for="id-${name}" class="control-label <#if col>col-xs-12 col-sm-2 col-md-2 col-lg-2</#if>">${title}</label>
			<div class="<#if col>col-xs-12 col-sm-10 col-md-10 col-lg-10</#if>">
				<input type="${type}" name="${name}" value="${value}" placeholder="${title}" class="form-control <#if lg>input-lg</#if>" id="id-${name}">
			</div>
		</div>
	<#else>
		<div class="form-group">
			<label class="control-label <#if col>col-xs-12 col-sm-2 col-md-2 col-lg-2</#if>">${title}</label>
			<div class="<#if col>col-xs-12 col-sm-10 col-md-10 col-lg-10</#if>">
				<#nested>
			</div>
		</div>
	</#if>
</#macro>

<#-- bsradios -->
<#--
like this:
<@bsradios name='row.pro_type' ck='${(row.pro_type)!"020101"}' list=types/>
-->
<#macro bsradios list name ck>
	<#list list as item>
		<label class="radio-inline">
			<input type="radio" name="${name}" value="${item.value}" <#if item.value == ck>checked</#if>>${item.text}
		</label>
	</#list>
</#macro>

<#-- bsselects -->
<#--
like this:
<@bsselects name='row.pro_type' ck='${(row.pro_type)!"020101"}' list=types/>
-->
<#macro bsselects list name ck>
	<select class="form-control" name="${name}">
		<#list list as item>
			<option value="${item.value}" <#if item.value == ck>selected</#if>>${item.text}</option>
		</#list>
	</select>
</#macro>

<#-- bspage -->
<#macro bspage page>
	<#assign pagenum = page.totalPage>
	<#if pagenum gt 1>
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
				<ul class="pagination" style="margin:0;">
					<li <#if page.pageNumber == 1>class="disabled"</#if>>
						<@bsbutton icon='step-backward' class='crud crudfirst'/>
					</li>
					<li <#if page.pageNumber == 1>class="disabled"</#if>>
						<@bsbutton icon='chevron-left' class='crud crudprev'/>
					</li>
					<#if pagenum lte 3>
						<#list 1..pagenum as pn>
							<li <#if page.pageNumber == pn>class="active"</#if>>
								<a href="javascript:void(0);" class="cruda">${pn}</a>
							</li>
						</#list>
					</#if>
					<#if pagenum gt 3>
						<#if page.pageNumber lt 2>
							<#list 1..pagenum as pn>
								<#if pn lt 3>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#list>
						</#if>
						<#if page.pageNumber gte 2>
							<#if page.pageNumber-1 gt 0>
								<li class="disabled">
									<a href="javascript:void(0);">...</a>
								</li>
							</#if>
							<#list 1..pagenum as pn>
								<#if (page.pageNumber-1 <= pn)&&(pn <= page.pageNumber+1)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
									
							</#list>
						</#if>
						<#if page.pageNumber+1 lt pagenum>
							<li class="disabled">
								<a href="javascript:void(0);">...</a>
							</li>
						</#if>
					</#if>
					
					<li <#if page.pageNumber == pagenum>class="disabled"</#if>>
						<@bsbutton icon='chevron-right' class='crud crudnext'/>
					</li>
					<li	<#if page.pageNumber == pagenum>class="disabled"</#if>>
						<@bsbutton icon='step-forward' class='crud crudlast' data='page:${pagenum};'/>
					</li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
				<div class="input-group">
					<input type="text" class="form-control crudinput">
					<span class="input-group-btn">
						<button class="btn btn-primary crudgo" type="button" data="page:${page.totalPage};">走你</button>
					</span>
				</div>
			</div>
		</div>
	</#if>
</#macro>

<#-- bslist -->
<#macro bslist btn=true qpage=''>
	<@bspanel>
		<#if btn>
			<p>
				<@bsbutton class='addBtn' icon='plus'>添加</@bsbutton>
				<@bsbutton class='delBtn' icon='remove'>删除</@bsbutton>
				<@bsbutton class='queBtn' icon='search'>查询</@bsbutton>
				<@bsbutton class='relBtn' icon='repeat'>重置</@bsbutton>
			</p>
		</#if>
		<p>${qpage.str}</p>
		<#nested>
		<@bspage page=qpage/>
	</@bspanel>
</#macro>

<#-- 
column 
这个布局相关，因为涉及到四种设备，所以还是手动写比较好
col-xs-12 col-sm-12 col-md-12 col-lg-12
-->