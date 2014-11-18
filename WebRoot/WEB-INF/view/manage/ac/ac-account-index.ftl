<#include "/WEB-INF/view/base/inc-son.ftl"/>
<@bslist qpage=qpage>
	<@bstable>
		<thead>
			<tr>
		        <th><input type="checkbox" class="allcheck"/></th>
				<th>账户名称</th>
        		<th>账户描述</th>
        		<th>创建时间</th>
		        <th>操作</th>
		      </tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
				    <td>${(row.account_name)!}</td>
		        	<td>${(row.acocunt_desc)!}</td>
		        	<td>${(row.cdate)!}</td>
		        	<td>
			        	<@bsbutton size='xs' icon='pencil' class='editbtn'/>
			        	<@bsbutton size='xs' icon='remove' class='delbtn'/>
			        </td>
				</tr>
		    </#list>
		</tbody>
	</@bstable>
</@bslist>