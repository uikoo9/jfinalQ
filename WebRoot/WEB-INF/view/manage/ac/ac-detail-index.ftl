<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@bslist qpage=qpage>
	<@bstable>
		<thead>
			<tr>
		        <th><input type="checkbox" class="allcheck"/></th>
							    			        		<th>账户id</th>
		        								    			        		<th>收支明细</th>
		        								    			        		<th>收支备注</th>
		        								    			        		<th>创建时间</th>
		        								    								    								</tr>
		</thead>
		<tbody>
		    <#list qpage.list?if_exists as row>
			    <tr data="id:${row.id};">
			        <td><input type="checkbox" class="onecheck"/></td>
				    				    					        	<td>${(row.account_id)!}</td>
				        									    					        	<td>${(row.detail_shouzhi)!}</td>
				        									    					        	<td>${(row.detail_remark)!}</td>
				        									    					        	<td>${(row.cdate)!}</td>
				        									    										    									    </tr>
		    </#list>
		</tbody>
	</@bstable>
</@bslist>