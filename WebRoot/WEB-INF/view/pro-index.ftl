<#include "/WEB-INF/view/inc.ftl"/>
<@html>
<@head 'bs'>
<title>uikoo9.com</title>
</@head>

<body style="padding-top:51px;">
	<@bsheader>
		<li><a href="#">JavaSE</a></li>
		<li><a href="#">JavaEE</a></li>
		<li><a href="#">About Me</a></li>
	</@bsheader>
	<div class="jumbotron">
		<div class="container">
		  <h1>uikoo9.com</h1>
		  <p>ideas + coder = ?</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h3>QLocker</h3>
				<p>Java实现的锁频软件，Windows XP下屏蔽所有按键。</p>
			</div>
			<div class="col-sm-3">
				<h3>QRunner</h3>
				<p>只需简单几步，让所有程序都从win+r启动~</p>
			</div>
			<div class="col-sm-3">
				<h3>QGcoder</h3>
				<p>JavaEE代码生成器，可以生成servlet+jsp，ssh2，jfinal等框架对应的代码。</p>
			</div>
			<div class="col-sm-3">
				<h3>QEncrypt</h3>
				<p>加密JavaEE项目，目前适用于非spring项目，可自定义加密解密算法，无需修改java环境。</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<h3>MD5</h3>
				<p>Message Digest Algorithm MD5（消息摘要算法）为计算机安全领域广泛使用的一种散列函数，用以提供消息的完整性保护。</p>
			</div>
			<div class="col-sm-3">
				<h3>DISC</h3>
				<p>DISC研究的是可辨认的正常的人类行为。</p>
			</div>
			<div class="col-sm-3">
				<h3>Success Dairy</h3>
				<p>成功日记，记录每次成功的瞬间！</p>
			</div>
			<div class="col-sm-3">
				<h3>QAccount</h3>
				<p>简单的记账系统，为您提供最简洁，最便于操作的记账系统。</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
			<div class="col-sm-3">
				<p>
					<button type="button" class="btn btn-primary">详情</button>
					<button type="button" class="btn btn-primary">访问 </button>
				</p>
			</div>
		</div>
	</div>
	
	<@js main='${base}/WUI/web/js/pro-index.js'></@js>
</body>
</@html>