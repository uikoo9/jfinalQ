<!DOCTYPE html>
<html>
	<head>
		<!-- 编码 -->
		<meta charset="UTF-8" />
		
		<!-- ie -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1"/>
		
		<!-- for mobile -->
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- for search-->
		<meta name="keywords" content="uikoo9.com"/>
		<meta name="description" content="uikoo9.com"/>
		<meta name="author" contect="qiaowenbin"/>
		<meta name="robots" contect="all"/>
		
		<!-- title -->
		<title>uikoo9.com</title>
		
		<!-- favicon.ico -->
		<link href="${base}/favicon.ico" type="image/x-icon" rel="bookmark"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="icon"/> 
		<link href="${base}/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
		
		<!-- jquery -->
		<script type="text/javascript" src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
		
		<!-- bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.2.0/css/bootstrap.min.css">
		<script type="text/javascript" src="http://cdn.staticfile.org/twitter-bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<!--[if lt IE 9]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		
		<!-- fullpage -->
		<script src="http://uikoo9.qiniudn.com/@/js/jquery-ui/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="http://uikoo9.qiniudn.com/@/js/fullpage/jquery.fullPage.css" />
		<script type="text/javascript" src="http://uikoo9.qiniudn.com/@/js/fullpage/jquery.fullPage.min.js"></script>

		<style>
			.section{
				color: #fff;
				text-align:center;
				padding: 6% 0 0 0;
			}
			#part1{
				background-size: cover;
				background-image: url(http://uikoo9.qiniudn.com/@/img/bg/bg1.jpg);
			}
			h4{
				top: 130%;
				position:relative;
			}
		</style>
	</head>
	<body>
		<div id="fullpage">
			<div class="section" id="part1"></div>
			<div class="section" id="part2">
				<h4>
					<img src="http://uikoo9.qiniudn.com/@/img/me/face1.jpg" class="img-circle" style="width:200px;height:200px;">
					<br/><br/><br/>
				</h4>
				<h4>乔文斌，男，27岁</h4>
				<h4>签名：随心，坚定，self</h4>
				<h4>邮箱：uikoo9@qq.com</h4>
			</div>
			<div class="section" id="part3">
				<h4>喜欢啥？<h4>
				<h4>敲代码，睡觉<br/>篮球，台球，乒乓球<br/>看美女，看小说，看综艺<br/><br/></h4>
				<h4>会做啥？<h4>
				<h4>
					移动端：<a target="_blank" href="http://uikoo9.com/dishi/download">滴石</a>
				</h4>
				<h4>
					后端：<a target="_blank" href="http://uikoo9.com/jfinalQ">jfinalQ</a>
				</h4>
				<h4>
					前端：<a target="_blank" href="http://uikoo9.com/bootstrapQ">bootstrapQ</a>
				</h4>
				<h4>网站：<a target="_blank" href="http://uikoo9.com">http://uikoo9.com</a></h4>
				<h4>csdn：<a target="_blank" href="http://blog.csdn.net/uikoo9">http://blog.csdn.net/uikoo9</a></h4>
				<h4>github：<a target="_blank" href="https://github.com/uikoo9">https://github.com/uikoo9</a></h4>
				<h4>gitosc：<a target="_blank" href="http://git.oschina.net/uikoo9">http://git.oschina.net/uikoo9</a></h4>
			</div>
		</div>
		<audio autoplay="autoplay" loop="loop" preload="auto">
			<source src="http://uikoo9.qiniudn.com/@/audio/me/summer.ogg" type="audio/ogg">
			<source src="http://uikoo9.qiniudn.com/@/audio/me/summer.mp3" type="audio/mpeg">
		</audio>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#fullpage').fullpage({
					verticalCentered: false,
					navigation: true,
					navigationPosition: 'right',
					sectionsColor: ['none', '#4BBFC3', '#1BBC9B'],
					afterLoad: function(anchorLink, index){
						$('h4').stop(true,true).css({top:'130%'});
						if(index == 2) easing({top:'0%'}, $('#part2 h4:eq(0)'));
						if(index == 3) easing({top:'0%'}, $('#part3 h4:eq(0)'));
					}
				});
			});
			
			function easing(style,$this){
				if($this.length > 0){
					$this.animate(style, 800, 'easeOutExpo', function(){
						easing(style, $this.next('h4'));
					});
				}
			}
		</script>
	</body>
</html>