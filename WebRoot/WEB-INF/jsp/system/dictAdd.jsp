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
	document.forms.dictAddform.action="${pageContext.request.contextPath}/dict/dictSave.action";
	document.forms.dictAddform.submit();
}
function toClear(){
	document.dictAddform.reset();
}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 人员管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form name="dictAddform"  validate="true" theme="simple" id="dictAddform" method="post">
			<input type="hidden" id="id" name="id" value="${dict.id }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="20%" />
				<col width="35%" />
				<col width="25%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>上级名称:</th>
					<td colspan="3">
					      <select id="parentId" name="parentId" class="select_casepian">
						        <option value="-1">请选择</option>
						        <c:forEach var="top" items="${topList }">
						            <c:if test="${dict.parentid ==top.id}">
						              <option value="${top.id}" selected="selected">${top.prop }</option>
						           </c:if>
						           <c:if test="${dict.parentid !=top.id }">
						              <option value="${top.id}">${top.prop }</option>
						           </c:if>
						        </c:forEach>   
						    </select>
					</td>
				</tr>
				<tr>
					<th>名&nbsp;&nbsp;&nbsp;&nbsp;称:</th>
					<td colspan="3">
						<input type="text" name="prop" id="prop" class="text_casepian1" value="${dict.prop }"/>
					</td>
				</tr>
				
		  </table>
		  </form>
			<div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					<a href="#" onclick="toClear();return false;"><img src="<%=path %>/images/btn/btn_04.gif" alt="清空" /></a>&nbsp;&nbsp;
			</div>
	</div>	
</div>
</body>
</html>
