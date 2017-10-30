<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/ajaxanywhere.js"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/js/calendar/lhgcalendar.js"></script>
<title>吉林大学协同办公系统</title>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	$.formValidator.initConfig({formid:"dingyiform",onerror:function(msg){return false}});
	$("#title").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
	$("#flowId").formValidator({onshow:"必选项",onfocus:"必选项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必选项"});
});
function chooseAdd(){
	J.dialog.get('user',{ id: 'user',  title: '自定义表单', page: '../user/setLeixing.jsp',width:'400', height:'250',cover: true });
}

function clearNoNum(obj){
		obj.value = obj.value.replace(/[^\d.]/g,"");
		obj.value = obj.value.replace(/^\./g,"");
		obj.value = obj.value.replace(/\.{2,}/g,".");
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}

var temp = 1;
var addtr_id=100;
function toTRName(id,title,flag){
	temp++;
	tr_id=1;
	tr_id++;
	addtr_id=addtr_id+1;
	var addtr = "";
	if(flag==1){
		addtr = "<td><input type='text' name=\"wenben\" id='reshipdateStr1"+addtr_id+"' class='text_318'/></td>";
	}else if(flag==2){
		addtr = "<td><input type='text' name=\"shuzi\" id='reshipdateStr2"+addtr_id+"' class='text_318' onkeyup='javascript:clearNoNum(this);'/></td>";
	}else if(flag==3){
		addtr = "<td><input type='text' name=\"shijian\" id='reshipdateStr3"+addtr_id+"'  onclick='WdatePicker()' class='Wdate'/></td>";
	}else if(flag==4){
		addtr = "<td><textarea name=\"duofenwen\" cols='100' rows='8' style='width:450px;height:100px;' id='reshipdateStr4"+addtr_id+"'/></td>";
	}
	str = "<tr id = '"+tr_id+"'>"+
			"<th>"+title+"<input type='hidden' name=\"wenbenvalue\" id='reshipdateStr11"+addtr_id+"' value=' "+title+"'/><input type='hidden' name=\"flagvalue\" id='reshipdateStr12"+addtr_id+"' value='"+flag+"' />"+"</th>"+
			addtr+
			"<td><input type='image' src='images/btn/btn_01.gif' alt='删除' onclick='delRow(\"intertable\")' /></td></tr>";
	$('#'+id).append(str);
}
function delRow(table){    
	 var otable = document.getElementById(table);      
	 var rowIndex = event.srcElement.parentElement.parentElement.parentElement.rowIndex;      
	 var rowIndex =event.srcElement.parentElement.parentElement.rowIndex      
	 otable.deleteRow(rowIndex);    
}
function toSubmit(){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.dingyiform.action="dingyi!add.action";
		document.forms.dingyiform.submit();
	}
}
</script>
</head>
<body>
<div id="right">
<s:form action="dingyi!add.action" name="dingyiform"  validate="true" theme="simple" id="dingyiform" >
<s:hidden name="id" id="id" />
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-表单新增</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<a href="#" onclick="chooseAdd();return false;"><img src="images/btn/btn_101.gif" alt="新增" /></a><br />&nbsp;
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增" id="intertable">
				<colgroup>
				<col width="10%" />
				<col width="30%" />
				<col width="10%" />
				<col width="10%" />
				<col width="30%" />
				<col width="10%" />
				</colgroup>
				<tr>
	   				<th>流&nbsp;&nbsp;&nbsp;&nbsp;程</th>
			        <td><s:select list="flowList" id="flowId"  name="flowId" listKey="id" listValue="flowName" theme="simple"  headerKey="-1" headerValue="--请选择--" cssClass="select_318" ></s:select></td>
					<td style="border-left-style:none"> <div id="flowIdTip"/></td>
					<th>表单名称</th>
					<td>
						 <input type="text" name="title"  id="title" cssClass="text_318" maxlength="200"/>
					</td>
					<td style="border-left-style:none"> <div id="titleTip"/></td>
				</tr>
		  </table>
			<div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
			</div>
	</div>
</s:form>		
</div>
</body>
</html>
