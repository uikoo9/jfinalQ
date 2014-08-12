<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head ui='eui'></@head>

<body>
	    <div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
    <div title="Tab1" style="padding:20px;display:none;">
    tab1
    </div>
    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
    tab2
    </div>
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
    tab3
    </div>
    </div>
	<@rj js='man'/>
</body>
</@html>