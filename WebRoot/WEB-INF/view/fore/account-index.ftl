<#include "/WEB-INF/view/base/inc-com.ftl"/>
<@html>
<@head></@head>

<@bsbody js='account.min'>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading text-center">收支汇总</div>
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>账户名称</th>
									<th>账户余额</th>
								</tr>
							</thead>
							<tbody>
								<#list accountList as item>
									<tr>
										<td>${item_index+1}</td>
										<td>${item.aname}</td>
										<td>${item.asum}</td>
									</tr>
								</#list>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<@bsbutton size='lg' class='btn-block' icon='arrow-up'>支出</@bsbutton>
			</div>
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<@bsbutton size='lg' class='btn-block' icon='sort'>转账</@bsbutton>
			</div>
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<@bsbutton size='lg' class='btn-block' icon='arrow-down'>收入</@bsbutton>
			</div>
		</div>
		<div class="row" style="margin-top:20px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading text-center">收支明细</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<div class="panel-body">
								dsa
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
		</div>
	</div>
</@bsbody>
</@html>