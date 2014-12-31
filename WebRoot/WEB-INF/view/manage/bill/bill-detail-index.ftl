<#include "/WEB-INF/view/inc/inc.ftl"/>

<@bslist qpage=qpage>
	<@bstable>
		<thead>
			<tr>
		        <th><input type="checkbox" class="allcheck"/></th>
				<th>账户</th>
        		<th>收支明细</th>
        		<th>收支备注</th>
        		<th>创建时间</th>
        		<th>操作</th>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
				    <td>${(row.aname)!}</td>
		        	<td>${(row.bill_detail_shouzhi)!}</td>
		        	<td>${(row.bill_detail_remark)!}</td>
		        	<td>${(row.cdate)!}</td>
		        	<td>
			        	<@bsbutton size='xs' icon='pencil' class='editbtn'/>
			        	<@bsbutton size='xs' icon='remove' class='delbtn'/>
			        </td>
		    </#list>
		</tbody>
	</@bstable>
</@bslist>