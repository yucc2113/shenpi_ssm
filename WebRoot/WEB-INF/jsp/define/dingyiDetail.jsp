<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/ajaxanywhere.js"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/jquery.js"></script>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<title>吉林大学协同办公系统</title>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	$.formValidator.initConfig({formid:"shenpiform",onerror:function(msg){return false}});
	$("#dealIdea").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
});
function toAudit(type){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.shenpiform.action="shenpi!audit.action?type="+type;
		document.forms.shenpiform.submit();
	}
}
</script>
<script>
	KindEditor.ready(function(K) {
	var editor = K.create('textarea[name="content"]', {
				readonlyMode : true
			});
	});
</script>
</head>
<body>
<div id="right">
<s:form action="shenpi!add.action" name="shenpiform"  validate="true" theme="simple" id="shenpiform" >
	<s:hidden name="id" id="id"/>
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-表单详细</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增">
				<colgroup>
				<col width="15%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>流 程</th>
					<td>
						 <s:property value="flowName"/>
					</td>
				</tr>
				<tr>
					<th>表单名称</th>
					<td>
						 <s:property value="title"/>
					</td>
				</tr>
				 <s:iterator id='data' value='neirongList'>
					<tr>
						<th><s:property value="mingcheng"/></th>
						<s:if test="leidanleixing==1">
							<td><input type='text' name="wenben" id='reshipdateStr1' class='text_318'/></td>
						</s:if>
						<s:elseif test="leidanleixing==2">
							<td><input type='text' name="shuzi" id='reshipdateStr2' class='text_318' onkeyup='javascript:clearNoNum(this);'/></td>
						</s:elseif>
						<s:elseif test="leidanleixing==3">
							<td><input type='text' name="shijian" id='reshipdateStr3'  onclick='WdatePicker()' class='Wdate'/></td>
						</s:elseif>
						<s:elseif test="leidanleixing==4">
							<td><textarea name="duofenwen" cols='100' rows='8' style='width:450px;height:100px;' id='reshipdateStr4"+addtr_id+"'></textarea></td>
						</s:elseif>
					</tr>	
				</s:iterator>	
		  </table>
	</div>
</s:form>		
</div>
</body>
</html>
