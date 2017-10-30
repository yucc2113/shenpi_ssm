<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	$.formValidator.initConfig({formid:"udBiaodanform",onerror:function(msg){return false}});
});

function toSubmit(){
	
		document.forms.udBiaodanform.action="${pageContext.request.contextPath}/udefineBiaodan/flowSave.action";
		document.forms.udBiaodanform.submit();
	
}
</script>
</head>
<body>
<div id="right">
<form name="udBiaodanform"  validate="true" theme="simple" id="udBiaodanform" method="post">
<input type="hidden" name="id" id="id" value= "${udBiaodan.id}" />
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-选择流程</ul></div>
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
					<th>流&nbsp;&nbsp;&nbsp;&nbsp;程</th>
			        <td>
			           <select  id="flowid" name="flowid" class="select_318" >
			               <option value="-1">请选择</option>
			              
						   <c:forEach var="flow" items="${flowList }">
									<c:if test="${udBiaodan.flowid ==flow.id}">
										<option value="${flow.id}" selected="selected">${flow.flowName}</option>
									</c:if>
									<c:if test="${udBiaodan.flowid !=flow.id }">
						            <option value="${flow.id}">${flow.flowName }</option>
						        </c:if>
						      
						  </c:forEach>
			           </select>
			        </td>
					<td style="border-left-style:none"></td>
				</tr>
		  </table>
			<div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
			</div>
	</div>
</s:form>		
</div>
</body>
</html>
