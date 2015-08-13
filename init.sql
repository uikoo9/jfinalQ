/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.17 : Database - db_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_article` */

insert  into `t_blog_article`(`id`,`blog_type_id`,`blog_article_code`,`blog_article_title`,`blog_article_content`,`blog_article_read_times`,`cdate`,`cuser_id`,`cuser_name`) values (1,1,'blog','博客','<h1>标题</h1><p>内容</p><p><br/></p><p>代码</p><pre class=\"brush:js;toolbar:false\">/**\r\n&nbsp;*&nbsp;将表单转为js对象\r\n&nbsp;*/\r\n$.fn.qser&nbsp;=&nbsp;function(){\r\n&nbsp;&nbsp;&nbsp;&nbsp;var&nbsp;obj&nbsp;=&nbsp;{};\r\n&nbsp;&nbsp;&nbsp;&nbsp;\r\n&nbsp;&nbsp;&nbsp;&nbsp;var&nbsp;objs&nbsp;=&nbsp;$(this).serializeArray();\r\n&nbsp;&nbsp;&nbsp;&nbsp;if(objs.length&nbsp;!=&nbsp;0){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(var&nbsp;i=0;&nbsp;i&lt;objs.length;&nbsp;i++){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;obj[objs[i].name]&nbsp;=&nbsp;objs[i].value;\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\r\n&nbsp;&nbsp;&nbsp;&nbsp;}\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;obj;\r\n};</pre><p><br/></p><p>图片</p><p><img alt=\"1422261773891011388.jpg\" src=\"http://localhost:8080/blog/UPLOAD/images/20150813/1439436334144066934.jpg\" title=\"1439436334144066934.jpg\"/></p>',3,'2015-08-13 11:14:17',3,'test');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_comment` */

/*Table structure for table `t_blog_type` */

DROP TABLE IF EXISTS `t_blog_type`;

CREATE TABLE `t_blog_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_type_name` varchar(200) NOT NULL COMMENT '类型名称',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_type` */

insert  into `t_blog_type`(`id`,`blog_type_name`,`cdate`,`cuser_id`,`cuser_name`) values (1,'默认分类','2015-08-13 11:10:20',2,'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_menu` */

insert  into `t_ucenter_menu`(`id`,`ucenter_menu_title`,`ucenter_menu_url`,`ucenter_menu_sn`,`ucenter_menu_type`,`ucenter_menu_parent_id`,`cdate`,`cuser_name`,`cuser_id`) values (1,'菜单管理','/ucenter/menu','01','000101',18,'2014-09-11 00:00:00','uikoo9',1),(8,'用户管理','/ucenter/user','02','000101',18,'2014-09-11 00:00:00','uikoo9',1),(13,'博客类型管理','/blog/type','01','000101',21,'2014-11-19 16:54:32','admin',2),(14,'博客文章管理','/blog/article','02','000101',21,'2014-11-19 16:54:59','admin',2),(17,'博客评论管理','/blog/comment','03','000101',21,'2014-12-07 16:14:26','admin',2),(18,'auth','--','01','000101',0,'2014-12-10 15:26:52','admin',2),(21,'blog','--','04','000101',0,'2014-12-10 15:38:21','admin',2),(23,'角色管理','/ucenter/role','03','000101',18,'2014-12-11 20:32:55','admin',2),(26,'fore','--','99','000102',0,'2014-12-18 15:49:47','admin',2),(30,'博客-编辑','/blog/edit','06','000102',26,'2014-12-18 16:21:42','admin',2),(34,'login','--','00','000102',26,'2014-12-18 16:26:13','admin',2),(35,'login-修改密码页面','/login/modifyPwdp','01','000102',34,'2014-12-18 16:26:38','admin',2),(36,'login-修改密码','/login/modifyPwd','02','000102',34,'2014-12-18 16:26:58','admin',2),(57,'编辑','/blog/comment/savep','01','000101',17,'2014-12-18 17:21:10','admin',2),(58,'保存','/blog/comment/save','02','000101',17,'2014-12-18 17:21:23','admin',2),(59,'删除','/blog/comment/del','03','000101',17,'2014-12-18 17:21:36','admin',2),(60,'编辑','/blog/article/savep','01','000101',14,'2014-12-18 17:22:02','admin',2),(61,'保存','/blog/article/save','02','000101',14,'2014-12-18 17:22:14','admin',2),(62,'删除','/blog/article/del','03','000101',14,'2014-12-18 17:22:24','admin',2),(63,'编辑','/blog/type/savep','01','000101',13,'2014-12-18 17:22:44','admin',2),(64,'保存','/blog/type/save','02','000101',13,'2014-12-18 17:22:59','admin',2),(65,'删除','/blog/type/del','03','000101',13,'2014-12-18 17:23:11','admin',2),(67,'博客-列表','/blog/listForUser','05','000102',26,'2015-01-04 17:12:56','admin',2),(88,'管理-首页','/manage','01','000102',26,'2015-03-12 13:36:16','uikoo9',0),(90,'添加','/ucenter/menu/add','1','000101',1,'2015-03-12 13:51:57','uikoo9',0),(91,'编辑','/ucenter/menu/savep','2','000101',1,'2015-03-12 13:52:12','uikoo9',0),(92,'保存','/ucenter/menu/save','3','000101',1,'2015-03-12 13:52:24','uikoo9',0),(93,'删除','/ucenter/menu/del','4','000101',1,'2015-03-12 13:52:39','uikoo9',0),(94,'编辑','/ucenter/user/savep','1','000101',8,'2015-03-12 13:53:08','uikoo9',0),(95,'保存','/ucenter/user/save','2','000101',8,'2015-03-12 13:53:23','uikoo9',0),(96,'删除','/ucenter/user/del','3','000101',8,'2015-03-12 13:53:37','uikoo9',0),(97,'编辑','/ucenter/role/savep','1','000101',23,'2015-03-12 13:54:42','uikoo9',0),(98,'保存','/ucenter/role/save','2','000101',23,'2015-03-12 13:55:26','uikoo9',0),(99,'删除','/ucenter/role/del','3','000101',23,'2015-03-12 13:55:37','uikoo9',0),(100,'设置用户','/ucenter/role/setUser','4','000101',23,'2015-03-12 13:56:16','uikoo9',0),(101,'添加用户','/ucenter/role/addUser','5','000101',23,'2015-03-12 13:56:37','uikoo9',0),(102,'移除用户','/ucenter/role/removeUser','6','000101',23,'2015-03-12 13:57:05','uikoo9',0),(103,'设置权限','/ucenter/role/setUrl','7','000101',23,'2015-03-12 13:57:42','uikoo9',0),(104,'保存权限','/ucenter/role/saveUrl','8','000101',23,'2015-03-12 13:57:59','uikoo9',0),(153,'login-修改昵称页面','/login/modifyNicknamep','03','000102',34,'2015-08-05 14:58:06','admin',2),(154,'login-修改昵称','/login/modifyNickname','04','000102',34,'2015-08-05 14:58:36','admin',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role` */

insert  into `t_ucenter_role`(`id`,`ucenter_role_name`,`ucenter_role_login_url`,`cdate`,`cuser_id`,`cuser_name`) values (7,'超级管理员','/manage','2015-03-12 13:20:45',0,'uikoo9'),(8,'普通用户','/','2015-03-24 08:59:18',2,'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=1915 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role_r_menu` */

insert  into `t_ucenter_role_r_menu`(`id`,`ucenter_role_id`,`ucenter_menu_id`,`ucenter_menu_url`,`cdate`,`cuser_id`,`cuser_name`) values (1869,7,18,'--','2015-08-13 10:40:17',2,'admin'),(1870,7,1,'/ucenter/menu','2015-08-13 10:40:17',2,'admin'),(1871,7,90,'/ucenter/menu/add','2015-08-13 10:40:17',2,'admin'),(1872,7,91,'/ucenter/menu/savep','2015-08-13 10:40:17',2,'admin'),(1873,7,92,'/ucenter/menu/save','2015-08-13 10:40:17',2,'admin'),(1874,7,93,'/ucenter/menu/del','2015-08-13 10:40:17',2,'admin'),(1875,7,8,'/ucenter/user','2015-08-13 10:40:17',2,'admin'),(1876,7,94,'/ucenter/user/savep','2015-08-13 10:40:17',2,'admin'),(1877,7,95,'/ucenter/user/save','2015-08-13 10:40:17',2,'admin'),(1878,7,96,'/ucenter/user/del','2015-08-13 10:40:17',2,'admin'),(1879,7,23,'/ucenter/role','2015-08-13 10:40:17',2,'admin'),(1880,7,97,'/ucenter/role/savep','2015-08-13 10:40:17',2,'admin'),(1881,7,98,'/ucenter/role/save','2015-08-13 10:40:17',2,'admin'),(1882,7,99,'/ucenter/role/del','2015-08-13 10:40:17',2,'admin'),(1883,7,100,'/ucenter/role/setUser','2015-08-13 10:40:17',2,'admin'),(1884,7,101,'/ucenter/role/addUser','2015-08-13 10:40:17',2,'admin'),(1885,7,102,'/ucenter/role/removeUser','2015-08-13 10:40:17',2,'admin'),(1886,7,103,'/ucenter/role/setUrl','2015-08-13 10:40:17',2,'admin'),(1887,7,104,'/ucenter/role/saveUrl','2015-08-13 10:40:17',2,'admin'),(1888,7,21,'--','2015-08-13 10:40:17',2,'admin'),(1889,7,13,'/blog/type','2015-08-13 10:40:17',2,'admin'),(1890,7,63,'/blog/type/savep','2015-08-13 10:40:17',2,'admin'),(1891,7,64,'/blog/type/save','2015-08-13 10:40:17',2,'admin'),(1892,7,65,'/blog/type/del','2015-08-13 10:40:17',2,'admin'),(1893,7,14,'/blog/article','2015-08-13 10:40:17',2,'admin'),(1894,7,60,'/blog/article/savep','2015-08-13 10:40:17',2,'admin'),(1895,7,61,'/blog/article/save','2015-08-13 10:40:17',2,'admin'),(1896,7,62,'/blog/article/del','2015-08-13 10:40:17',2,'admin'),(1897,7,17,'/blog/comment','2015-08-13 10:40:17',2,'admin'),(1898,7,57,'/blog/comment/savep','2015-08-13 10:40:17',2,'admin'),(1899,7,58,'/blog/comment/save','2015-08-13 10:40:17',2,'admin'),(1900,7,59,'/blog/comment/del','2015-08-13 10:40:17',2,'admin'),(1901,7,34,'--','2015-08-13 10:40:17',2,'admin'),(1902,7,35,'/login/modifyPwdp','2015-08-13 10:40:17',2,'admin'),(1903,7,36,'/login/modifyPwd','2015-08-13 10:40:17',2,'admin'),(1904,7,153,'/login/modifyNicknamep','2015-08-13 10:40:17',2,'admin'),(1905,7,154,'/login/modifyNickname','2015-08-13 10:40:17',2,'admin'),(1906,7,88,'/manage','2015-08-13 10:40:17',2,'admin'),(1907,8,61,'/blog/article/save','2015-08-13 10:46:38',2,'admin'),(1908,8,34,'--','2015-08-13 10:46:38',2,'admin'),(1909,8,35,'/login/modifyPwdp','2015-08-13 10:46:38',2,'admin'),(1910,8,36,'/login/modifyPwd','2015-08-13 10:46:38',2,'admin'),(1911,8,153,'/login/modifyNicknamep','2015-08-13 10:46:38',2,'admin'),(1912,8,154,'/login/modifyNickname','2015-08-13 10:46:38',2,'admin'),(1913,8,67,'/blog/listForUser','2015-08-13 10:46:38',2,'admin'),(1914,8,30,'/blog/edit','2015-08-13 10:46:38',2,'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_role_r_user` */

insert  into `t_ucenter_role_r_user`(`id`,`ucenter_role_id`,`ucenter_user_id`,`ucenter_user_name`,`cdate`,`cuser_id`,`cuser_name`) values (3,7,2,'admin','2015-03-12 13:20:58',0,'uikoo9'),(43,8,3,'test','2015-08-13 10:46:01',2,'admin');

/*Table structure for table `t_ucenter_user` */

DROP TABLE IF EXISTS `t_ucenter_user`;

CREATE TABLE `t_ucenter_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_user_name` varchar(200) NOT NULL COMMENT '用户名',
  `ucenter_user_nickname` varchar(200) NOT NULL COMMENT '用户昵称',
  `ucenter_user_key` varchar(200) NOT NULL COMMENT '用户密码',
  `ucenter_user_type` char(6) NOT NULL COMMENT '用户类型',
  `ucenter_user_mail` varchar(200) NOT NULL COMMENT '用户邮箱',
  `ucenter_user_mail_confirm` char(6) NOT NULL COMMENT '用户邮箱确认',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `t_ucenter_user` */

insert  into `t_ucenter_user`(`id`,`ucenter_user_name`,`ucenter_user_nickname`,`ucenter_user_key`,`ucenter_user_type`,`ucenter_user_mail`,`ucenter_user_mail_confirm`,`cdate`,`cuser_name`,`cuser_id`) values (2,'admin','admin','ISMvKXpXpadDiUoOSoAfww==','010101','admin','000101','2014-10-09 14:55:38','admin',0),(3,'test','test','CY9rzUYh03PK3k6DJie09g==','010103','uikoo9@qq.com','000101','2014-11-17 16:53:48','admin',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
