<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head ui='eui'></@head>

<body>
	<form id="ff" method="post">
    <div>
    <label for="name">Name:</label>
    <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
    </div>
    <div>
    <label for="email">Email:</label>
    <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />
    </div>
    <input type="button" value="submit"/>
    </form>
	<@rj js='man'/>
</body>
</@html>