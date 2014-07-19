<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head 'bs'>
<title>uikoo9.com</title>
</@head>

<body style="background-color:#eee;padding-top:30px;">
	<div class="container">
		<div class="row">
			jarpath:<h1>${test}</h1>
		</div>
		<div class="row">
			filelist:
			<#list files as file>
				<p>${file}</p>
			</#list>
		</div>
	</div>
	<@js 'bs'></@js>
</body>
</@html>