<#include "/WEB-INF/view/inc.ftl"/>
<@bspanel>
	<p>
		<@bsbutton class='addBtn' icon='plus'>添加</@bsbutton>
		<@bsbutton class='delBtn' icon='remove'>删除</@bsbutton>
		<@bsbutton class='queBtn' icon='search'>查询</@bsbutton>
		<@bsbutton class='relBtn' icon='repeat'>重置</@bsbutton>
	</p>
	<p>${qpage.str}</p>
	<@bstable>
		<thead>
		    <tr>
		        <th><input type="checkbox" class="allcheck"/></th>
		        <th>用户名</th>
		        <th>用户密码</th>
		        <th>操作</th>
		    </tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
			        <td>${row.username}</td>
			        <td>${row.password}</td>
			        <td>
			        	<@bsbutton size='xs' icon='pencil' class='editbtn'/>
			        	<@bsbutton size='xs' icon='remove' class='delbtn'/>
			        </td>
			    </tr>
		    </#list>
		</tbody>
	</@bstable>
	<@bspage page=qpage/>
</@bspanel>