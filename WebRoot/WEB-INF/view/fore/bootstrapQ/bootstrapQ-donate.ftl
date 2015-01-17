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
		</div>
	</@bsbody>
</@html>

