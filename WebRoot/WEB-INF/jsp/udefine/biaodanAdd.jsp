<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>


<script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/js/calendar/lhgcalendar.js"></script>


<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	$.formValidator.initConfig({formid:"dingyiform",onerror:function(msg){return false}});
	$("#mingchen").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false},onerror:"必填项"});
});

function toSubmit(){
	if(jQuery.formValidator.pageIsValid("1")){
	var id = $("#id").val();
		if(id==''){
			document.forms.udefineBiaodanForm.action="${pageContext.request.contextPath}/udefineBiaodan/biaodanSave.action";
			document.forms.udefineBiaodanForm.submit();
		}else{
			document.forms.udefineBiaodanForm.action="${pageContext.request.contextPath}/udefineBiaodan/biaodanUpdatetSave.action?id="+id;
			document.forms.udefineBiaodanForm.submit();
		}
		
	}
}
function toReturn(){
	document.forms.udefineBiaodanForm.action="${pageContext.request.contextPath}/udefineBiaodan/biaodanList.action";
	document.forms.udefineBiaodanForm.submit();
}
</script>
</head>
<body>
<div id="right">
<form name="udefineBiaodanForm"  validate="true" theme="simple" id="udefineBiaodanForm" method="post">
<input type="hidden" name="id" id="id" value= "${id }" />
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-表单新增</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增" id="intertable">
				<colgroup>
				<col width="10%" />
				<col width="30%" />
				<col width="10%" />
				</colgroup>
				<tr>
					<th>表单名称</th>
					<td>
						 <input type="text" name="mingchen" id="mingchen" class="text_318" maxlength="200" value="${biaodan.mingchen }"/>
					</td>
					<td style="border-left-style:none"> <div id="mingchenTip"/></td>
				</tr>
		  </table>
			<div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					<a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
			</div>
	</div>
</form>		
</div>
</body>
</html>
