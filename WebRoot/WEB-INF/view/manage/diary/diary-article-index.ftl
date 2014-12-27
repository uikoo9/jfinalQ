<#include "/WEB-INF/view/inc/inc.ftl"/>

<@bslist qpage=qpage>
	<@bstable>
		<thead>
			<tr>
		        <th><input type="checkbox" class="allcheck"/></th>
				<th>日记类型</th>
				<th>日记标题</th>
				<th>日记阅读次数</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
				    <td>${(row.tname)!}</td>				    
					<td>${(row.diary_article_title)!}</td>				    
					<td>${(row.diary_article_readtimes)!}</td>				    
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