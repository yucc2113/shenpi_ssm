<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<title>吉林大学协同办公系统</title>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
//	var id = $("#id").val();
//	if(id>0){
//		var parent=document.getElementById("parentId");
//  		parent.onclick = function() {     
//  		 var index = this.selectedIndex;     
//          this.onchange = function() {     
//             this.selectedIndex = index;     
// 	  };     
//   	};  
//	}
});

function toSubmit(){
	document.forms.roleAddForm.action="${pageContext.request.contextPath}/role/roleSave.action";
	document.forms.roleAddForm.submit();
}
function toClear(){
   $("#rolename").val('');

}
function toReturn(){
	document.forms.roleAddForm.action="${pageContext.request.contextPath}/role/roleList.action";
	document.forms.roleAddForm.submit();
}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 角色管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form  name="roleAddForm"  validate="true" theme="simple" id="roleAddForm" >
			<input  type="hidden" name="id" value="${role.id }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="20%" />
				<col width="35%" />
				<col width="25%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>名&nbsp;&nbsp;&nbsp;&nbsp;称:</th>
					<td colspan="3">
						<input type="text" name="rolename" id="rolename" cssClass="text_257" value="${role.rolename }"/>
					</td>
				</tr>
				
		  </table>
		  </form>
			<div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					&nbsp;&nbsp;
					<a href="#" onclick="toClear();return false;"><img src="<%=path %>/images/btn/btn_04.gif" alt="清空" /></a>&nbsp;&nbsp;
					&nbsp;&nbsp;
					<a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
			</div>
	</div>	
</div>
</body>
</html>
