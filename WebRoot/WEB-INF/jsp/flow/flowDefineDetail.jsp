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
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
});
function toBack(){
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/list.action";
		document.forms.flowdefineForm.submit();
	}
	
function searchStep(){
		var id = $("#id").val();
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowstep/list.action?flowId="+id;
		document.forms.flowdefineForm.submit();
	}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程定义管理详细信息</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form  method="post" id="flowdefineForm">
			<input type="hidden" name = "id" id= "id" value="${flowDefine.id }"/>
                <div class="cl">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="流程定义管理详细信息">
                        <caption>
                        </caption>
                        <colgroup>
                        <col width="20%" />
                        <col width="30%" />
                        <col width="20%" />
                        <col width="30%" />
                        </colgroup>
                        <tr>
                            <th>流程名称：</th>
                            <td>${flowDefine.flowName }</td>
                            <th>是否可用：</th>
                            <td>
                               <c:if test="${flowDefine.isEnabled==1}">可用</c:if>
                               <c:if test="${flowDefine.isEnabled==2}">不可用</c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>流程描述：</th>
                            <td>${flowDefine.flowDesc }</td>
                            <th>部门：</th>
                            <td>${flowDefine.deptname }</td>
                        </tr>
                    </table>
                </div>
                <div class="project_21btn">  
                   <img src="<%=path %>/images/btn/btn_27.gif" alt="跳转到流程步骤" style="cursor:hand" onclick="searchStep()"/>
                    &nbsp;&nbsp;           
                   <img src="<%=path %>/images/btn/btn_09.gif" alt="返回" style="cursor:hand" onclick="toBack()"/>
                </div>
           </form>
	</div>	
</div>
</body>
</html>
