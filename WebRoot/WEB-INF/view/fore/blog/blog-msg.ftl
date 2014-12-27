<#include "/WEB-INF/view/inc/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<#list msgs?if_exists as msg>
					<#assign blog=msg.blog()>
					<blockquote style="border-left-color:#5bc0de;">
					  <p>
					  	<strong>${msg.blog_comment_uname}</strong>评论了：
					  	<a href="${base}/blog/detail/${blog.blog_article_code}" target="_blank">${blog.blog_article_title}</a></p>
					  <footer>${msg.cdate}</footer>
					</blockquote>
				</#list>
			</div>
		</div>
	</div>
	<@backtotop/>
</@html>