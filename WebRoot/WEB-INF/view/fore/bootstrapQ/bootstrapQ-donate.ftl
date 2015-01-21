<#include "/WEB-INF/view/inc/inc-bootstrapq.ftl"/>

<@html s=false>
	<@head t='BootstrapQ'/>
	<@bsbody>
		<script type="text/javascript">qiao.ajaxinit();</script>

		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h3>很羞愧的是，我是一个习惯于用免费软件的人~</h3>
					<div class="row" style="text-align:center;margin-top:30px;">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="thumbnail">
								<img src="${base}/WUI/web/donate/img/zhifu5.png">
								<div class="caption">
									<h3>微信捐助</h3>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="thumbnail">
								<img src="${base}/WUI/web/donate/img/zhifu1.png">
								<div class="caption">
									<h3>支付宝捐助</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<#if donates??>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<@bstable>
							<thead>
								<tr>
							        <th><input type="checkbox" class="allcheck"/></th>
									<th>捐助人姓名</th>
									<th>捐助金额</th>
									<th>捐助类型</th>
									<th>捐助寄语</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							    <#list donates?if_exists as donate>
								    <tr>
									    <td>${(donate.other_donate_name)!}</td>				    
										<td>${(donate.other_donate_money)!}</td>				    
										<td>${(donate.other_donate_type)!}</td>				    
										<td>${(donate.other_donate_message)!}</td>				    
										<td>${(donate.cdate)!}</td>				    
								    </tr>
							    </#list>
							</tbody>
						</@bstable>
					</div>
				</div>
			</#if>
		</div>
	</@bsbody>
</@html>

