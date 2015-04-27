CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_blog`;

/*Table structure for table `t_blog_article` */

DROP TABLE IF EXISTS `t_blog_article`;

CREATE TABLE `t_blog_article` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_type_id` int(10) NOT NULL COMMENT '博客类型',
  `blog_article_code` varchar(200) NOT NULL COMMENT '博客编码',
  `blog_article_title` varchar(2000) NOT NULL COMMENT '文章标题',
  `blog_article_content` text NOT NULL COMMENT '文章内容',
  `blog_article_read_times` int(10) NOT NULL DEFAULT '0' COMMENT '博客阅读次数',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_article` */

insert  into `t_blog_article`(`id`,`blog_type_id`,`blog_article_code`,`blog_article_title`,`blog_article_content`,`blog_article_read_times`,`cdate`,`cuser_id`,`cuser_name`) values (32,10,'default-blog','默认博客（不可编辑，不可评论）','<p>这个是默认blog，展示一些基本的功能</p><p><br/></p><p>例如，图片：</p><p><img alt=\"20150108145947.jpg\" src=\"http://qbloger.duapp.com/UPLOAD/images/20150126/1422261773891011388.jpg\" title=\"1422261773891011388.jpg\"/></p><p><br/></p><p>例如，代码块：</p><pre class=\"brush:js;toolbar:false\">qiao.con&nbsp;=&nbsp;function(obj){\r\n&nbsp;&nbsp;&nbsp;&nbsp;console.log(obj);\r\n};</pre><p><br/></p><p>例如，表格：</p><table width=\"-234\"><tbody><tr class=\"firstRow\"><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">列1<br/></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">列2<br/></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">列3<br/></td></tr><tr><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">01<br/></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">name1<br/></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">age1<br/></td></tr><tr><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">02<br/></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\"><p>name2<br/></p></td><td style=\"word-break: break-all;\" valign=\"top\" width=\"214\">age2<br/></td></tr></tbody></table><p><br/></p>',9,'2015-01-26 16:44:43',4,'test');

/*Table structure for table `t_blog_comment` */

DROP TABLE IF EXISTS `t_blog_comment`;

CREATE TABLE `t_blog_comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` int(10) NOT NULL COMMENT '博客id',
  `blog_comment_uname` varchar(200) NOT NULL COMMENT '博客评论昵称',
  `blog_comment_content` text NOT NULL COMMENT '博客评论内容',
  `blog_comment_parent_id` int(10) NOT NULL COMMENT '博客评论父id',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_comment` */

insert  into `t_blog_comment`(`id`,`blog_id`,`blog_comment_uname`,`blog_comment_content`,`blog_comment_parent_id`,`cdate`,`cuser_id`,`cuser_name`) values (17,32,'测试评论','<p>除了这两条测试评论，其他评论会不定期清空~<br/></p>',0,'2015-01-26 17:23:55',4,'test'),(18,32,'测试','<p>知道了<br/></p>',17,'2015-01-26 17:24:14',4,'test');

/*Table structure for table `t_blog_type` */

DROP TABLE IF EXISTS `t_blog_type`;

CREATE TABLE `t_blog_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_type_name` varchar(200) NOT NULL COMMENT '类型名称',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_type` */

insert  into `t_blog_type`(`id`,`blog_type_name`,`cdate`,`cuser_id`,`cuser_name`) values (10,'默认分类','2015-01-22 19:16:58',2,'admin');

/*Table structure for table `t_ucenter_menu` */

DROP TABLE IF EXISTS `t_ucenter_menu`;

CREATE TABLE `t_ucenter_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_menu_title` varchar(200) NOT NULL COMMENT '菜单名称',
  `ucenter_menu_url` varchar(200) DEFAULT '--' COMMENT '菜单地址',
  `ucenter_menu_sn` char(2) NOT NULL COMMENT '菜单序号',
  `ucenter_menu_type` char(6) NOT NULL COMMENT '菜单类型',
  `ucenter_menu_parent_id` int(10) NOT NULL DEFAULT '0' COMMENT '菜单父id',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_menu` */

insert  into `t_ucenter_menu`(`id`,`ucenter_menu_title`,`ucenter_menu_url`,`ucenter_menu_sn`,`ucenter_menu_type`,`ucenter_menu_parent_id`,`cdate`,`cuser_name`,`cuser_id`) values (1,'菜单管理','/ucenter/menu','01','000101',18,'2014-09-11 00:00:00','uikoo9',1),(8,'用户管理','/ucenter/user','02','000101',18,'2014-09-11 00:00:00','uikoo9',1),(13,'博客类型管理','/blog/type','01','000101',21,'2014-11-19 16:54:32','admin',2),(14,'博客文章管理','/blog/article','02','000101',21,'2014-11-19 16:54:59','admin',2),(17,'博客评论管理','/blog/comment','03','000101',21,'2014-12-07 16:14:26','admin',2),(18,'auth','--','01','000101',0,'2014-12-10 15:26:52','admin',2),(67,'博客-列表','/blog/list','05','000102',26,'2015-01-04 17:12:56','admin',2),(126,'前端-首页','/','02','000102',26,'2015-04-27 22:20:26','admin',2),(21,'blog','--','03','000101',0,'2014-12-10 15:38:21','admin',2),(23,'角色管理','/ucenter/role','03','000101',18,'2014-12-11 20:32:55','admin',2),(26,'fore','--','99','000102',0,'2014-12-18 15:49:47','admin',2),(30,'博客-编辑','/blog/edit','06','000102',26,'2014-12-18 16:21:42','admin',2),(34,'login','--','00','000102',26,'2014-12-18 16:26:13','admin',2),(35,'login-修改密码页面','/login/modifyPwdp','01','000102',34,'2014-12-18 16:26:38','admin',2),(36,'login-修改密码','/login/modifyPwd','02','000102',34,'2014-12-18 16:26:58','admin',2),(57,'编辑','/blog/comment/savep','01','000101',17,'2014-12-18 17:21:10','admin',2),(58,'保存','/blog/comment/save','02','000101',17,'2014-12-18 17:21:23','admin',2),(59,'删除','/blog/comment/del','03','000101',17,'2014-12-18 17:21:36','admin',2),(60,'编辑','/blog/article/savep','01','000101',14,'2014-12-18 17:22:02','admin',2),(61,'保存','/blog/article/save','02','000101',14,'2014-12-18 17:22:14','admin',2),(62,'删除','/blog/article/del','03','000101',14,'2014-12-18 17:22:24','admin',2),(63,'编辑','/blog/type/savep','01','000101',13,'2014-12-18 17:22:44','admin',2),(64,'保存','/blog/type/save','02','000101',13,'2014-12-18 17:22:59','admin',2),(65,'删除','/blog/type/del','03','000101',13,'2014-12-18 17:23:11','admin',2),(87,'login-退出登录','/login/logout','3','000101',34,'2015-03-12 13:35:53','uikoo9',0),(88,'管理-首页','/manage','01','000102',26,'2015-03-12 13:36:16','uikoo9',0),(89,'博客-详情','/blog/detail','08','000102',26,'2015-03-12 13:46:06','uikoo9',0),(90,'添加','/ucenter/menu/add','1','000101',1,'2015-03-12 13:51:57','uikoo9',0),(91,'编辑','/ucenter/menu/savep','2','000101',1,'2015-03-12 13:52:12','uikoo9',0),(92,'保存','/ucenter/menu/save','3','000101',1,'2015-03-12 13:52:24','uikoo9',0),(93,'删除','/ucenter/menu/del','4','000101',1,'2015-03-12 13:52:39','uikoo9',0),(94,'编辑','/ucenter/user/savep','1','000101',8,'2015-03-12 13:53:08','uikoo9',0),(95,'保存','/ucenter/user/save','2','000101',8,'2015-03-12 13:53:23','uikoo9',0),(96,'删除','/ucenter/user/del','3','000101',8,'2015-03-12 13:53:37','uikoo9',0),(97,'编辑','/ucenter/role/savep','1','000101',23,'2015-03-12 13:54:42','uikoo9',0),(98,'保存','/ucenter/role/save','2','000101',23,'2015-03-12 13:55:26','uikoo9',0),(99,'删除','/ucenter/role/del','3','000101',23,'2015-03-12 13:55:37','uikoo9',0),(100,'设置用户','/ucenter/role/setUser','4','000101',23,'2015-03-12 13:56:16','uikoo9',0),(101,'添加用户','/ucenter/role/addUser','5','000101',23,'2015-03-12 13:56:37','uikoo9',0),(102,'移除用户','/ucenter/role/removeUser','6','000101',23,'2015-03-12 13:57:05','uikoo9',0),(103,'设置权限','/ucenter/role/setUrl','7','000101',23,'2015-03-12 13:57:42','uikoo9',0),(104,'保存权限','/ucenter/role/saveUrl','8','000101',23,'2015-03-12 13:57:59','uikoo9',0),(109,'其他-捐助','/donate','12','000102',26,'2015-03-24 09:00:08','admin',2),(110,'其他-关于我','/me','13','000102',26,'2015-03-24 09:00:38','admin',2);

/*Table structure for table `t_ucenter_role` */

DROP TABLE IF EXISTS `t_ucenter_role`;

CREATE TABLE `t_ucenter_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_name` varchar(200) NOT NULL COMMENT '角色名称',
  `ucenter_role_login_url` varchar(200) NOT NULL COMMENT '角色跳转地址',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role` */

insert  into `t_ucenter_role`(`id`,`ucenter_role_name`,`ucenter_role_login_url`,`cdate`,`cuser_id`,`cuser_name`) values (4,'普通用户','/','2014-12-11 17:21:26',2,'admin'),(7,'超级管理员','/manage','2015-03-12 13:20:45',0,'uikoo9');

/*Table structure for table `t_ucenter_role_r_menu` */

DROP TABLE IF EXISTS `t_ucenter_role_r_menu`;

CREATE TABLE `t_ucenter_role_r_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_id` int(10) NOT NULL COMMENT '角色id',
  `ucenter_menu_id` int(10) NOT NULL COMMENT '菜单id',
  `ucenter_menu_url` varchar(200) NOT NULL COMMENT '菜单url',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1044 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role_r_menu` */

insert  into `t_ucenter_role_r_menu`(`id`,`ucenter_role_id`,`ucenter_menu_id`,`ucenter_menu_url`,`cdate`,`cuser_id`,`cuser_name`) values (1039,4,67,'/blog/list','2015-04-27 22:30:30',2,'admin'),(1040,4,30,'/blog/edit','2015-04-27 22:30:30',2,'admin'),(1041,4,89,'/blog/detail','2015-04-27 22:30:30',2,'admin'),(1042,4,109,'/donate','2015-04-27 22:30:30',2,'admin'),(1043,4,110,'/me','2015-04-27 22:30:30',2,'admin'),(1002,7,88,'/manage','2015-04-27 22:08:24',2,'admin'),(1001,7,87,'/login/logout','2015-04-27 22:08:24',2,'admin'),(1000,7,36,'/login/modifyPwd','2015-04-27 22:08:24',2,'admin'),(999,7,35,'/login/modifyPwdp','2015-04-27 22:08:24',2,'admin'),(998,7,34,'--','2015-04-27 22:08:24',2,'admin'),(997,7,59,'/blog/comment/del','2015-04-27 22:08:24',2,'admin'),(1038,4,126,'/','2015-04-27 22:30:30',2,'admin'),(996,7,58,'/blog/comment/save','2015-04-27 22:08:24',2,'admin'),(995,7,57,'/blog/comment/savep','2015-04-27 22:08:24',2,'admin'),(994,7,17,'/blog/comment','2015-04-27 22:08:24',2,'admin'),(993,7,62,'/blog/article/del','2015-04-27 22:08:24',2,'admin'),(992,7,61,'/blog/article/save','2015-04-27 22:08:24',2,'admin'),(991,7,60,'/blog/article/savep','2015-04-27 22:08:24',2,'admin'),(990,7,14,'/blog/article','2015-04-27 22:08:24',2,'admin'),(989,7,65,'/blog/type/del','2015-04-27 22:08:24',2,'admin'),(988,7,64,'/blog/type/save','2015-04-27 22:08:24',2,'admin'),(987,7,63,'/blog/type/savep','2015-04-27 22:08:24',2,'admin'),(986,7,13,'/blog/type','2015-04-27 22:08:24',2,'admin'),(985,7,21,'--','2015-04-27 22:08:24',2,'admin'),(984,7,104,'/ucenter/role/saveUrl','2015-04-27 22:08:24',2,'admin'),(983,7,103,'/ucenter/role/setUrl','2015-04-27 22:08:24',2,'admin'),(982,7,102,'/ucenter/role/removeUser','2015-04-27 22:08:24',2,'admin'),(981,7,101,'/ucenter/role/addUser','2015-04-27 22:08:24',2,'admin'),(980,7,100,'/ucenter/role/setUser','2015-04-27 22:08:24',2,'admin'),(979,7,99,'/ucenter/role/del','2015-04-27 22:08:24',2,'admin'),(978,7,98,'/ucenter/role/save','2015-04-27 22:08:24',2,'admin'),(977,7,97,'/ucenter/role/savep','2015-04-27 22:08:24',2,'admin'),(1037,4,87,'/login/logout','2015-04-27 22:30:30',2,'admin'),(1036,4,36,'/login/modifyPwd','2015-04-27 22:30:30',2,'admin'),(1035,4,35,'/login/modifyPwdp','2015-04-27 22:30:30',2,'admin'),(1034,4,34,'--','2015-04-27 22:30:30',2,'admin'),(1033,4,58,'/blog/comment/save','2015-04-27 22:30:30',2,'admin'),(1032,4,61,'/blog/article/save','2015-04-27 22:30:30',2,'admin'),(976,7,23,'/ucenter/role','2015-04-27 22:08:24',2,'admin'),(975,7,96,'/ucenter/user/del','2015-04-27 22:08:24',2,'admin'),(974,7,95,'/ucenter/user/save','2015-04-27 22:08:24',2,'admin'),(973,7,94,'/ucenter/user/savep','2015-04-27 22:08:24',2,'admin'),(972,7,8,'/ucenter/user','2015-04-27 22:08:24',2,'admin'),(971,7,93,'/ucenter/menu/del','2015-04-27 22:08:24',2,'admin'),(970,7,92,'/ucenter/menu/save','2015-04-27 22:08:24',2,'admin'),(969,7,91,'/ucenter/menu/savep','2015-04-27 22:08:24',2,'admin'),(968,7,90,'/ucenter/menu/add','2015-04-27 22:08:24',2,'admin'),(967,7,1,'/ucenter/menu','2015-04-27 22:08:24',2,'admin'),(966,7,18,'--','2015-04-27 22:08:24',2,'admin');

/*Table structure for table `t_ucenter_role_r_user` */

DROP TABLE IF EXISTS `t_ucenter_role_r_user`;

CREATE TABLE `t_ucenter_role_r_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_id` int(10) NOT NULL COMMENT '角色id',
  `ucenter_user_id` int(10) NOT NULL COMMENT '用户id',
  `ucenter_user_name` varchar(200) NOT NULL COMMENT '用户姓名',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role_r_user` */

insert  into `t_ucenter_role_r_user`(`id`,`ucenter_role_id`,`ucenter_user_id`,`ucenter_user_name`,`cdate`,`cuser_id`,`cuser_name`) values (8,4,8,'test','2015-04-27 22:13:31',2,'admin'),(3,7,2,'admin','2015-03-12 13:20:58',0,'uikoo9');

/*Table structure for table `t_ucenter_user` */

DROP TABLE IF EXISTS `t_ucenter_user`;

CREATE TABLE `t_ucenter_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_user_name` varchar(200) NOT NULL COMMENT '用户名',
  `ucenter_user_key` varchar(200) NOT NULL COMMENT '用户密码',
  `ucenter_user_type` char(6) NOT NULL COMMENT '用户类型',
  `ucenter_user_mail` varchar(200) NOT NULL COMMENT '用户邮箱',
  `ucenter_user_mail_confirm` char(6) NOT NULL COMMENT '用户邮箱确认',
  `ucenter_user_sys_plan` char(6) DEFAULT NULL COMMENT '计划系统用户',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_user` */

insert  into `t_ucenter_user`(`id`,`ucenter_user_name`,`ucenter_user_key`,`ucenter_user_type`,`ucenter_user_mail`,`ucenter_user_mail_confirm`,`ucenter_user_sys_plan`,`cdate`,`cuser_name`,`cuser_id`) values (2,'admin','ISMvKXpXpadDiUoOSoAfww==','010101','','000102','000102','2014-10-09 14:55:38','uikoo9',0),(8,'test','CY9rzUYh03PK3k6DJie09g==','010102','test@test.com','000102','000102','2015-04-27 22:13:18','admin',2);

