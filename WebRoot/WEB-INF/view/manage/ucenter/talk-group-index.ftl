<#--
/****************************************************
 * Description: 讨论组的列表页面
 * Copyright:   Copyright (c) 2014
 * Company:     beiwaionline
 * @author      bfsu
 * @version     1.0
 * @see
	HISTORY
    *  2014-09-11 bfsu Create File
**************************************************/
-->
<#include "/templates/bs-inc.ftl"> 
<@html>
<@head>
<style type="text/css">
.mytr{
	cursor:pointer;
}
</style>
<script type="text/javascript">
// 打开设置讨论组成员的页面
function setMember(id){
	var url = PROJECT_HOME + '/learn/talkGroup/setMember/' + id;
	bfsu.dialog({url:url,title:'设置讨论组成员'});
	$('#bsmodal').find('.bsok').remove().end().find('.bscancel').text('关闭');
}

// 绑定讨论组成员tr的点击事件
bfsu.on('.mytr','click',function(){$(this).toggleClass('info');});

// 添加讨论组成员
function addMembers(){
	var groupid = $('input[name="setMemberGroupId"]').val();
	
	var ids = [];
	$('tr.outtr').each(function(){if($(this).hasClass('info')) ids.push($(this).attr('data'));});
	
	$.ajax({
		url : PROJECT_HOME + '/learn/talkGroup/addMembers',
		data : {
			ids : ids.join(','),
			groupid : groupid
		},
		type : 'post',
		dataType : 'json',
		async : false
	}).done(function(json){
		if(json && json.type == 'information'){
			$('tr.outtr').each(function(){
				if($(this).hasClass('info')) $(this).removeClass('outtr').addClass('intr').prependTo('table.intable');
			});
		}else{
			bfsu.msger('操作失败，请重试！');
		}
	});
}

// 移除讨论组成员
function removeMembers(){
	var ids = [];
	$('tr.intr').each(function(){if($(this).hasClass('info')) ids.push($(this).attr('data'));});
	
	$.ajax({
		url : PROJECT_HOME + '/learn/talkGroup/removeMembers',
		data : {ids:ids.join(',')},
		type : 'post',
		dataType : 'json',
		async : false
	}).done(function(json){
		if(json && json.type == 'information'){
			$('tr.intr').each(function(){
				if($(this).hasClass('info')) $(this).removeClass('intr').addClass('outtr').prependTo('table.outtable');
			});
		}else{
			bfsu.msger('操作失败，请重试！');
		}
	});
}
</script>
</@head>
<@body>

<@nav '爱课学习平台','讨论组'/>

<@content url="${base}/learn/talkGroup/list">
<@query>

	<#if Session[BfsuolConstants.SESSION_LOGININFO_KEY]?if_exists.userType==Constants.USER_TYPE_ADMIN>
		<@querygroup  title='项目'><@select id="project" list=projects name='' listKey="projectName" listValue="projectCode"></@select></@querygroup>
		<@querygroup  title='学习中心'><@ajaxselect id="studyCenterId"  pid="project"  name='studyCenterId' url="${base}/lms/centerCourse/studyCenterTreeJson/[project]" ></@ajaxselect></@querygroup>
		<@querygroup  title='班级'><@ajaxselect id="clazzId" pid="studyCenterId" name='clazzId' url="${base}/lms/clazzCourse/initClazzStandardTreeJsonByStudyCenter/[studyCenterId]" ></@ajaxselect></@querygroup>
	</#if>
	<#if Session[BfsuolConstants.SESSION_LOGININFO_KEY]?if_exists.userType==Constants.USER_TYPE_MANAGER>
		<@querygroup  title='学习中心'><@ajaxselect id="studyCenterId"  name="studyCenterId" url="${base}/lms/centerCourse/studyCenterTreeJsonByCenterId/${studyCenter.id}" ></@ajaxselect></@querygroup>
		<@querygroup  title='班级'><@ajaxselect id="clazzId" pid="studyCenterId" name='clazzId' url="${base}/lms/clazzCourse/initClazzStandardTreeJsonByStudyCenter/[studyCenterId]" ></@ajaxselect></@querygroup>
	</#if>
	<#if Session[BfsuolConstants.SESSION_LOGININFO_KEY]?if_exists.userType==Constants.USER_TYPE_TUTOR>
		<input type='hidden' name='studyCenterId' value=${studyCenter.id} />
  		<@querygroup title='班级'><@select id='clazzId' name='clazzId' list=clazzList listKey="className" listValue="id"/></@querygroup>
	</#if>
	

  	<@querygroup title='话题'><@ajaxselect id='topicId' pid='clazzId' name='topicId' url="${base}/learn/talkTopic/talkTopicByClazzId/[clazzId]"/>
  	</@querygroup><@querygroup title='讨论组名称'><input type='text' name='talkGroupName' class="form-control" placeholder="输入讨论组名称"></@querygroup></@query>

<@button icon="plus" 	type="primary" onclick="bfsu.add('${base}/learn/talkGroup/input','添加讨论组');">添加</@button>
<@button icon="pencil" 	type="primary" onclick="bfsu.edit('${base}/learn/talkGroup/input','修改讨论组');">修改</@button>
<@button icon="remove" 	type="primary" onclick="bfsu.del('${base}/learn/talkGroup/delete','删除讨论组？',true);">删除</@button>

</@content>

</@body>
</@html>