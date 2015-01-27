-- --------------------------------------------------------

--
-- 表的结构 `t_blog_article`
--

DROP TABLE IF EXISTS `t_blog_article`;
CREATE TABLE IF NOT EXISTS `t_blog_article` (
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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- 转存表中的数据 `t_blog_article`
--

INSERT INTO `t_blog_article` (`id`, `blog_type_id`, `blog_article_code`, `blog_article_title`, `blog_article_content`, `blog_article_read_times`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(32, 10, 'default-blog', '默认博客（不可编辑，不可评论）', '<p>这个是默认blog，展示一些基本的功能</p><p><br/></p><p>例如，图片：</p><p><img alt="20150108145947.jpg" src="http://qbloger.duapp.com/UPLOAD/images/20150126/1422261773891011388.jpg" title="1422261773891011388.jpg"/></p><p><br/></p><p>例如，代码块：</p><pre class="brush:js;toolbar:false">qiao.con&nbsp;=&nbsp;function(obj){\r\n&nbsp;&nbsp;&nbsp;&nbsp;console.log(obj);\r\n};</pre><p><br/></p><p>例如，表格：</p><table width="-234"><tbody><tr class="firstRow"><td style="word-break: break-all;" valign="top" width="214">列1<br/></td><td style="word-break: break-all;" valign="top" width="214">列2<br/></td><td style="word-break: break-all;" valign="top" width="214">列3<br/></td></tr><tr><td style="word-break: break-all;" valign="top" width="214">01<br/></td><td style="word-break: break-all;" valign="top" width="214">name1<br/></td><td style="word-break: break-all;" valign="top" width="214">age1<br/></td></tr><tr><td style="word-break: break-all;" valign="top" width="214">02<br/></td><td style="word-break: break-all;" valign="top" width="214"><p>name2<br/></p></td><td style="word-break: break-all;" valign="top" width="214">age2<br/></td></tr></tbody></table><p><br/></p>', 10, '2015-01-26 16:44:43', 4, 'test');

-- --------------------------------------------------------

--
-- 表的结构 `t_blog_comment`
--

DROP TABLE IF EXISTS `t_blog_comment`;
CREATE TABLE IF NOT EXISTS `t_blog_comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` int(10) NOT NULL COMMENT '博客id',
  `blog_comment_uname` varchar(200) NOT NULL COMMENT '博客评论昵称',
  `blog_comment_content` text NOT NULL COMMENT '博客评论内容',
  `blog_comment_parent_id` int(10) NOT NULL COMMENT '博客评论父id',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- 转存表中的数据 `t_blog_comment`
--

INSERT INTO `t_blog_comment` (`id`, `blog_id`, `blog_comment_uname`, `blog_comment_content`, `blog_comment_parent_id`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(17, 32, '测试评论', '<p>除了这两条测试评论，其他评论会不定期清空~<br/></p>', 0, '2015-01-26 17:23:55', 4, 'test'),
(18, 32, '测试', '<p>知道了<br/></p>', 17, '2015-01-26 17:24:14', 4, 'test');

-- --------------------------------------------------------

--
-- 表的结构 `t_blog_type`
--

DROP TABLE IF EXISTS `t_blog_type`;
CREATE TABLE IF NOT EXISTS `t_blog_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_type_name` varchar(200) NOT NULL COMMENT '类型名称',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `t_blog_type`
--

INSERT INTO `t_blog_type` (`id`, `blog_type_name`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(10, '默认分类', '2015-01-22 19:16:58', 2, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_ucenter_menu`
--

DROP TABLE IF EXISTS `t_ucenter_menu`;
CREATE TABLE IF NOT EXISTS `t_ucenter_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_menu_title` varchar(200) NOT NULL COMMENT '菜单名称',
  `ucenter_menu_url` varchar(200) DEFAULT '--' COMMENT '菜单地址',
  `ucenter_menu_sn` char(2) NOT NULL COMMENT '菜单序号',
  `ucenter_menu_type` char(6) NOT NULL COMMENT '菜单类型',
  `ucenter_menu_parent_id` int(10) NOT NULL DEFAULT '0' COMMENT '菜单父id',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=74 ;

--
-- 转存表中的数据 `t_ucenter_menu`
--

INSERT INTO `t_ucenter_menu` (`id`, `ucenter_menu_title`, `ucenter_menu_url`, `ucenter_menu_sn`, `ucenter_menu_type`, `ucenter_menu_parent_id`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(1, '菜单管理', '/ucenter/menu', '01', '000101', 18, '2014-09-11 00:00:00', 1, 'uikoo9'),
(8, '用户管理', '/ucenter/user', '02', '000101', 18, '2014-09-11 00:00:00', 1, 'uikoo9'),
(13, '博客类型管理', '/blog/type', '01', '000101', 21, '2014-11-19 16:54:32', 2, 'admin'),
(14, '博客文章管理', '/blog/article', '02', '000101', 21, '2014-11-19 16:54:59', 2, 'admin'),
(17, '博客评论管理', '/blog/comment', '03', '000101', 21, '2014-12-07 16:14:26', 2, 'admin'),
(18, 'auth', '--', '01', '000101', 0, '2014-12-10 15:26:52', 2, 'admin'),
(21, 'blog', '--', '02', '000101', 0, '2014-12-10 15:38:21', 2, 'admin'),
(23, '角色管理', '/ucenter/role', '03', '000101', 18, '2014-12-11 20:32:55', 2, 'admin'),
(26, 'fore', '--', '12', '000102', 0, '2014-12-18 15:49:47', 2, 'admin'),
(30, '博客-编辑', '/blog/edit', '01', '000102', 26, '2014-12-18 16:21:42', 2, 'admin'),
(34, 'login', '--', '11', '000102', 0, '2014-12-18 16:26:13', 2, 'admin'),
(35, 'login-修改密码页面', '/login/modifyPwdp', '01', '000102', 34, '2014-12-18 16:26:38', 2, 'admin'),
(36, 'login-修改密码', '/login/modifyPwd', '02', '000102', 34, '2014-12-18 16:26:58', 2, 'admin'),
(57, '编辑', '/blog/comment/savep', '01', '000101', 17, '2014-12-18 17:21:10', 2, 'admin'),
(58, '保存', '/blog/comment/save', '02', '000101', 17, '2014-12-18 17:21:23', 2, 'admin'),
(59, '删除', '/blog/comment/del', '03', '000101', 17, '2014-12-18 17:21:36', 2, 'admin'),
(60, '编辑', '/blog/article/savep', '01', '000101', 14, '2014-12-18 17:22:02', 2, 'admin'),
(61, '保存', '/blog/article/save', '02', '000101', 14, '2014-12-18 17:22:14', 2, 'admin'),
(62, '删除', '/blog/article/del', '03', '000101', 14, '2014-12-18 17:22:24', 2, 'admin'),
(63, '编辑', '/blog/type/savep', '01', '000101', 13, '2014-12-18 17:22:44', 2, 'admin'),
(64, '保存', '/blog/type/save', '02', '000101', 13, '2014-12-18 17:22:59', 2, 'admin'),
(65, '删除', '/blog/type/del', '03', '000101', 13, '2014-12-18 17:23:11', 2, 'admin'),
(66, '博客-消息', '/blog/msg', '02', '000102', 26, '2014-12-23 12:25:28', 2, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_ucenter_role`
--

DROP TABLE IF EXISTS `t_ucenter_role`;
CREATE TABLE IF NOT EXISTS `t_ucenter_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_name` varchar(200) NOT NULL COMMENT '角色名称',
  `ucenter_role_login_url` varchar(200) NOT NULL COMMENT '角色跳转地址',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `t_ucenter_role`
--

INSERT INTO `t_ucenter_role` (`id`, `ucenter_role_name`, `ucenter_role_login_url`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(4, '普通用户', '/', '2014-12-11 17:21:26', 2, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_ucenter_role_r_menu`
--

DROP TABLE IF EXISTS `t_ucenter_role_r_menu`;
CREATE TABLE IF NOT EXISTS `t_ucenter_role_r_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_id` int(10) NOT NULL COMMENT '角色id',
  `ucenter_menu_id` int(10) NOT NULL COMMENT '菜单id',
  `ucenter_menu_url` varchar(200) NOT NULL COMMENT '菜单url',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=161 ;

--
-- 转存表中的数据 `t_ucenter_role_r_menu`
--

INSERT INTO `t_ucenter_role_r_menu` (`id`, `ucenter_role_id`, `ucenter_menu_id`, `ucenter_menu_url`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(158, 4, 36, '/login/modifyPwd', '2015-01-26 19:13:45', 2, 'admin'),
(157, 4, 35, '/login/modifyPwdp', '2015-01-26 19:13:45', 2, 'admin'),
(156, 4, 34, '--', '2015-01-26 19:13:45', 2, 'admin'),
(155, 4, 61, '/blog/article/save', '2015-01-26 19:13:45', 2, 'admin'),
(159, 4, 30, '/blog/edit', '2015-01-26 19:13:45', 2, 'admin'),
(160, 4, 66, '/blog/msg', '2015-01-26 19:13:45', 2, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_ucenter_role_r_user`
--

DROP TABLE IF EXISTS `t_ucenter_role_r_user`;
CREATE TABLE IF NOT EXISTS `t_ucenter_role_r_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_role_id` int(10) NOT NULL COMMENT '角色id',
  `ucenter_user_id` int(10) NOT NULL COMMENT '用户id',
  `ucenter_user_name` varchar(200) NOT NULL COMMENT '用户姓名',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `t_ucenter_role_r_user`
--

INSERT INTO `t_ucenter_role_r_user` (`id`, `ucenter_role_id`, `ucenter_user_id`, `ucenter_user_name`, `cdate`, `cuser_id`, `cuser_name`) VALUES
(3, 4, 4, 'test', '2015-01-22 19:12:59', 2, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_ucenter_user`
--

DROP TABLE IF EXISTS `t_ucenter_user`;
CREATE TABLE IF NOT EXISTS `t_ucenter_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ucenter_user_name` varchar(200) NOT NULL COMMENT '用户名',
  `ucenter_user_key` varchar(200) NOT NULL COMMENT '用户密码',
  `ucenter_user_type` char(6) NOT NULL COMMENT '用户类型',
  `cdate` datetime NOT NULL COMMENT '创建时间',
  `cuser_name` varchar(200) NOT NULL COMMENT '创建人姓名',
  `cuser_id` int(10) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `t_ucenter_user`
--

INSERT INTO `t_ucenter_user` (`id`, `ucenter_user_name`, `ucenter_user_key`, `ucenter_user_type`, `cdate`, `cuser_name`, `cuser_id`) VALUES
(2, 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '010101', '2014-10-09 14:55:38', 'admin', 0),
(4, 'test', 'CY9rzUYh03PK3k6DJie09g==', '010102', '2015-01-22 19:12:19', 'admin', 2);