<#include "/com/uikoo9/util/ucenter/view/inc.ftl"/>

<#-- bshead -->
<#macro bshead pos='top' sname='uikoo9.com' shref='http://uikoo9.com/'>
	<nav role="navigation" class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button data-target="#bsnav" data-toggle="collapse" class="navbar-toggle" type="button">
					<span class="sr-only">导航条</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="${shref}" class="navbar-brand"><strong class="text-primary">${sname}</strong></a>
			</div>
			
			<div class="collapse navbar-collapse" id="bsnav">
				<ul class="nav navbar-nav">
					<#if user??>
						<#if user.ucenter_user_type == '010102'>
							<li><a href="${base}/bill">首页</a></li>
							<li class="menus" data="url:/bill/detail;"><a href="javascript:void(0);">收支明细</a></li>
							<li class="menus" data="url:/bill/account;"><a href="javascript:void(0);">账户管理</a></li>
							<li><a href="${base}/diary/list">看日记</a></li>
							<li><a href="${base}/diary/edit">写日记</a></li>
							<li><a href="${base}/blog/listForUser">看博客</a></li>
							<li><a href="${base}/blog/edit">写博客</a></li>
						</#if>
						<#if user.ucenter_user_type == '010101'>
							<#list menus as menu>
								<#if menu.submenus()?size gt 0>
									<li class="dropdown">
										<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">${menu.ucenter_menu_title}<span class="caret"></span></a>
										<ul class="dropdown-menu" role="menu">
											<#list menu.submenus() as item>
												<li role="presentation" class="menus" data="url:${item.ucenter_menu_url};"><a role="menuitem" tabindex="-1" href="javascript:void(0);">${item.ucenter_menu_title}</a></li>
											</#list>
										</ul>
									</li>
								<#else>
									<li class="menus" data="url:${menu.ucenter_menu_url};"><a href="javascript:void(0);">${menu.ucenter_menu_title}</a></li>
								</#if>
							</#list>
						</#if>
					<#else>
						<li><a href="${base}/">首页</a></li>
						<li><a href="${base}/blog/list">博客</a></li>
						<li><a href="${base}/version">版本更新</a></li>
						<li><a href="${base}/me">关于我</a></li>
						<li><a href="${base}/bootstrapQ">BootstrapQ</a></li>
					</#if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<#if user??>
						<#if msgcount??>
							<li><a href="${base}/blog/msg">新的评论<span class="badge">${msgcount}</span></a></li>
						</#if>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">${user.ucenter_user_name}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" class="modifyPwd">修改密码</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="${base}/login/logout">退出系统</a></li>
							</ul>
						</li>
					<#else>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">登录<span class="caret"></span></a>
							<div class="dropdown-menu" role="menu" style="width:250px;height;250px;padding:20px;">
								<@bsform class='loginform'>
									<@bsinput col=false name='username' title='用户名' value='${username!}'/>
									<@bsinput col=false name='password' title='密码' type='password'/>
									<div class="form-group"><input class="btn btn-lg btn-primary btn-block loginbtn" type="button" value="登录"/></div>
									<div class="form-group"><h5 class="text-danger"></h5></div>
								</@bsform>
							</div>	
						</li>
					</#if>
				</ul>
			</div>
		</div>
	</nav>
</#macro>

<#-- bspage -->
<#macro bspage page pagesizelist=['10','50','100']>
	<#assign pagenum = page.totalPage>
	<#if pagenum gt 1>
		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
				<#if pagenum lt 5>
					<ul class="pagination" style="margin:0;">
						<li <#if page.pageNumber == 1>class="disabled"</#if>>
							<@bsbutton icon='step-backward' class='crud crudfirst'/>
						</li>
						<li <#if page.pageNumber == 1>class="disabled"</#if>>
							<@bsbutton icon='chevron-left' class='crud crudprev'/>
						</li>
						<#list 1..pagenum as pn>
							<li <#if page.pageNumber == pn>class="active"</#if>>
								<a href="javascript:void(0);" class="cruda">${pn}</a>
							</li>
						</#list>
						<li <#if page.pageNumber == pagenum>class="disabled"</#if>>
							<@bsbutton icon='chevron-right' class='crud crudnext'/>
						</li>
						<li	<#if page.pageNumber == pagenum>class="disabled"</#if>>
							<@bsbutton icon='step-forward' class='crud crudlast' data='page:${pagenum};'/>
						</li>
						<li class="disabled">
							<a href="javascript:void(0);">共${pagenum}页，${page.totalRow}条</a>
						</li>
					</ul>
				<#else>
					<ul class="pagination" style="margin:0;">
						<li <#if page.pageNumber == 1>class="disabled"</#if>>
							<@bsbutton icon='step-backward' class='crud crudfirst'/>
						</li>
						<li <#if page.pageNumber == 1>class="disabled"</#if>>
							<@bsbutton icon='chevron-left' class='crud crudprev'/>
						</li>
						<li <#if page.pageNumber == 1>class="active"</#if>>
							<a href="javascript:void(0);" class="cruda">1</a>
						</li>
						<li class="disabled">
							<a href="javascript:void(0);" class="cruda">...</a>
						</li>
						<#list 1..pagenum as pn>
							<#if page.pageNumber==1>
								<#if (page.pageNumber+1 == pn) || (page.pageNumber+2 == pn) || (page.pageNumber+3 == pn)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#if>
							<#if page.pageNumber==2>
								<#if (page.pageNumber == pn) || (page.pageNumber+1 == pn) || (page.pageNumber+2 == pn)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#if>
							<#if page.pageNumber gt 2 && page.pageNumber+2 <= pagenum>
								<#if (page.pageNumber-1 == pn) || (page.pageNumber == pn) || (page.pageNumber+1 == pn)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#if>
							<#if page.pageNumber==pagenum-1>
								<#if (page.pageNumber == pn) || (page.pageNumber-1 == pn) || (page.pageNumber-2 == pn)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#if>
							<#if page.pageNumber==pagenum>
								<#if (page.pageNumber-1 == pn) || (page.pageNumber-2 == pn) || (page.pageNumber-3 == pn)>
									<li <#if page.pageNumber == pn>class="active"</#if>>
										<a href="javascript:void(0);" class="cruda">${pn}</a>
									</li>
								</#if>
							</#if>
						</#list>
						<li class="disabled">
							<a href="javascript:void(0);" class="cruda">...</a>
						</li>
						<li <#if page.pageNumber == pagenum>class="active"</#if>>
							<a href="javascript:void(0);" class="cruda">${pagenum}</a>
						</li>
						<li <#if page.pageNumber == pagenum>class="disabled"</#if>>
							<@bsbutton icon='chevron-right' class='crud crudnext'/>
						</li>
						<li	<#if page.pageNumber == pagenum>class="disabled"</#if>>
							<@bsbutton icon='step-forward' class='crud crudlast' data='page:${pagenum};'/>
						</li>
						<li class="disabled">
							<a href="javascript:void(0);">共${pagenum}页，${page.totalRow}条</a>
						</li>
					</ul>
				</#if>
			</div>
			<#if pagesizelist?? && pagesizelist?size gt 0>
				<div class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
					<div class="input-group">
						<div class="input-group-addon">每页</div>
						<select class="form-control pagesize" name="pagesize">
							<#list pagesizelist as l>
								<option value="${l}" <#if l == page.pageSize?c>selected</#if>>${l}条</option>
							</#list>
						</select>
					</div>
				</div>
			</#if>
		</div>
	</#if>
</#macro>