<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head></@head>

<@bsbody js='account.min'>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-inline" role="form">
							<div class="form-group">
								<label for="s_account_name">账户：</label>
								<select class="form-control" name='row.account_id'>
									<#list accounts as item>
										<option value="${item.id}">${item.account_name}</option>
									</#list>
								</select>
							</div>
							<div class="form-group">
								<label for="s_detail_shouzhi">收支大于：</label>
								<div class="input-group">
									<input type="text" class="form-control" id="s_detail_shouzhi" placeholder="100">
									<div class="input-group-addon">￥</div>
								</div>
							</div>
							<div class="form-group">
								<label for="s_detail_date1">日期：</label>
								<input type="text" class="form-control" id="s_detail_date1" placeholder="开始日期">
								<label for="s_detail_date2">至</label>
								<input type="text" class="form-control" id="s_detail_date2" placeholder="结束日期">
							</div>
							<@bsbutton icon='search'>查询</@bsbutton>
							<@bsbutton icon='refresh' type='default'>重置</@bsbutton>
						</form>
					</div>						
				</div>						
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>账户名称</th>
								<th>收支明细</th>
								<th>收支备注</th>
								<th>创建时间</th>
							</tr>
						</thead>
						<tbody>
							<#list accountDetails as item>
								<tr>
									<td>${item_index+1}</td>
									<td>${item.aname}</td>
									<td>${item.detail_shouzhi}</td>
									<td>${(item.detail_remark)!}</td>
									<td>${item.cdate}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</@bsbody>
</@html>