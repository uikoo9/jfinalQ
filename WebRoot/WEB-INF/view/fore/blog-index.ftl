<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head></@head>

<@bsbody js='blog'>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
				<#list blogs as blog>
					<blockquote>
					  <p><a href="${base}/blog/fore/${blog.id}">${blog.article_title}</a></p>
					  <footer><strong>${blog.cdate}</strong></footer>
					</blockquote>
				</#list>
			</div>
			<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
				<div class="list-group">
					<a href="${base}/blog/fore" class="list-group-item">所有文章</a>
					<#list blogTypes as type>
						<a href="${base}/blog/fore/${type.id}" class="list-group-item">${type.type_name}</a>
					</#list>
				</div>
			</div>
		</div>
	</div>
</@bsbody>
</@html>