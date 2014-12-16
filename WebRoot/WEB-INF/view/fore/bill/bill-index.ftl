<#include "/WEB-INF/view/inc.ftl"/>

<@html>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="cruddiv">
				<div class="row" style="margin-bottom:10px;">
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="margin-bottom:10px;">
						<@bsbutton type='primary' size='lg' class='btn-block shouzhi' icon='sort'>收支</@bsbutton>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="margin-bottom:10px;">
						<@bsbutton type='primary' size='lg' class='btn-block zhuan' icon='retweet'>转账</@bsbutton>
					</div>
				</div>
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
			</div>
		</div>
	</div>
	
	<@js web=true>$(function(){web.account.init();});</@js>
</@html>