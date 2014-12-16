<#include "/WEB-INF/view/inc.ftl"/>

<@bslist qpage=qpage>
	<@bstable>
		<thead>
		    <tr>
		        <th><input type="checkbox" class="allcheck"/></th>
		        <th>所属项目</th>
		        <th>版本号</th>
		        <th>创建时间</th>
		        <th>创建人</th>
		        <th>操作</th>
		    </tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
			        <td>${row.pname}</td>
			        <td>${row.project_version_code}</td>
			        <td>${row.cdate}</td>
			        <td>${row.cuser_name}</td>
			        <td>
			        	<@bsbutton size='xs' icon='pencil' class='editbtn'/>
			        	<@bsbutton size='xs' icon='remove' class='delbtn'/>
			        </td>
			    </tr>
		    </#list>
		</tbody>
	</@bstable>
</@bslist>