<#include "/WEB-INF/view/inc.ftl"/>
<thead>
    <tr>
        <th>text</th>
        <th>url</th>
    </tr>
</thead>
<tbody>
    <#list rows?if_exists as row>
	    <tr>
	        <td>${row.text}</td>
	        <td>${row.url}</td>
	    </tr>
    </#list>
</tbody>