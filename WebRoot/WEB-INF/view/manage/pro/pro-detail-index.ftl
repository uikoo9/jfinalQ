<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@bslist qpage=qpage>
	<@bstable>
		<thead>
		    <tr>
		        <th><input type="checkbox" class="allcheck"/></th>
		        <th>项目类型</th>
		        <th>项目名称</th>
		        <th>项目地址</th>
		        <th>源码地址</th>
		        <th>创建时间</th>
		        <th>创建人</th>
		        <th>操作</th>
		    </tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
			        <td>${util.get(row.pro_type)}</td>
			        <td>${row.pro_name}</td>
			        <td>${(row.pro_url)!}</td>
			        <td>${(row.pro_src)!}</td>
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