[jfinalQ2.0](http://uikoo9.com/jfinalQ)
==========================================
1. 基于[jfinal2.0](http://www.jfinal.com/)，易学，开发快速，功能强大
2. 基于[bootstrap3.x](http://v3.bootcss.com/)，简洁美观，完美适配移动端
3. [jfinalQ-gencode](https://github.com/uikoo9/jfinalQ-gencode)：jfinalQ自带代码生成工具
4. [jfinalQ-encrypt](https://github.com/uikoo9/jfinalQ-encrypt)：jfinalQ自带tomcat加密部署工具
5. [bootstrapQ](http://uikoo9.com/bootstrapQ)：jfinalQ自带bootstrap增强组件

jfinalQ2.0
---
官网：http://uikoo9.com/jfinalQ

教程：http://uikoo9.com/book/detail/7

更新说明

	1. qiao-util.jar
		1.1 将jfinal的封装代码从qiao-util.jar中移出到项目中
		1.2 将ucenter模块的代码从qiao-util.jar中移出到项目中
		1.3 将其他文件（qiao.js, contants.properties等等）从qiao-util.jar中移出到项目中
		1.4 由于以上文件都从qiao-util.jar中移出，所以将jfinal-render.jar（修改过源码使得可以直接访问jar中的ftl）替换为jfinal官网的jar
	2. qiao.js
		2.1 之前uikoo9.com线上的qiao.js和开源的bootstrapQ.js（https://github.com/uikoo9/bootstrapQ）用的不是一套代码，这里做了统一
		2.2 将bootstrapQ整理为了qiao.bs.js
		2.3 将常用工具js整理为了qiao.util.js
		2.4 将qiao.util.js和qiao.bs.js整合为qiao.js，并开源到github上：https://github.com/uikoo9/qiao.js，还添加了使用示例
	3. 使用教程
		3.1 更新了详细的使用教程
		3.2 地址：
				http://uikoo9.com/book/detail/7
		3.3 代码生成相关：
				http://uikoo9.com/book/chapterDetail/32
				http://uikoo9.com/book/chapterDetail/34
		3.4 加密部署相关：
				http://uikoo9.com/book/chapterDetail/36
		3.5 jfinalQ,qiao-util.jar,qiao.js：
				http://uikoo9.com/book/detail/7  （4-10讲）
	4. 新增
		4.1 新增了对定时任务cron4j的支持
		4.2 将搜索页面单独出来

捐助
---
希望得到您的捐助：

（支付宝捐助）

![zhifubao](http://uikoo9.qiniudn.com/@/img/donate/zhifu2.png)

（微信捐助）

![weixin](http://uikoo9.qiniudn.com/@/img/donate/zhifu1.png)


