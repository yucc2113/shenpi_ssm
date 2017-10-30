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
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>

<title>吉林大学协同办公系统</title>

<script type="text/javascript">
$(document).ready(function() {

	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	/* $.formValidator.initConfig({formid:"usersAddform",onerror:function(msg){return false}}); */
	$.formValidator.initConfig({formid:"usersAddform",onerror:function(msg){return false}});
	$("#userno").formValidator({onshow:"请输入用户账号",onfocus:"请输入用户账号",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "请输入用户账号!"});
	$("#username").formValidator({onshow:"请输入用户姓名",onfocus:"请输入用户姓名",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"请输入用户姓名!"});
	$("#img1").click(function(){
	   
    
		if(jQuery.formValidator.pageIsValid("1")&&checkUser()){
				document.forms.usersAddform.action="${pageContext.request.contextPath}/user/userSave.action";
				document.forms.usersAddform.submit();		
		}
	})
});
function checkUser(){
  if(checkRole()&&checkPosition()){
    return true;
   }
   else return false;
}
function checkRole(){
  
        if($("#roleid").val()==0){
	     
	       $("#roleIdTip").html("选择角色");
	    }
	    else{
	      $("#roleIdTip").html("");
	    }
	     if($("#roleid").val()==0){
	      return false;
	    }
	    return true;
 }  
 function checkPosition(){     
	    if($("#positionid").val()==0){
	     
	       $("#positionIdTip").html("选择职位");
	    }else{
	      $("#positionIdTip").html("");
	    }
	 
	    if($("#positionid").val()==0){
	      return false;
	    }
	    return true;
}
function toClear(){
	document.usersAddform.reset();
}
function toReturn(){
    var deptId=$("#deptid").val();
	document.forms.usersAddform.action="${pageContext.request.contextPath}/user/init.action?deptId="+deptId;
	document.forms.usersAddform.submit();
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
			<form name="usersAddform"  validate="true" theme="simple" id="usersAddform" method="post">
			<input type="hidden" id="deptid" name="deptid" value="${deptId }"/>
			<input type="hidden" id="id" name="id" value="${user.id }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="25%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>人员编号:</th>
					<td  style="border-right-style:none">
						<input type="text" name="userno" id="userno" value="${user.userno }" style="width:300px"/>
					</td>
					<td style="border-left-style:none">
					<div id="usernoTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>姓&nbsp;&nbsp;&nbsp;&nbsp;名:</th>
					<td  style="border-right-style:none">
						<input type="text" name="username" id="username" value="${user.username }" style="width:300px"/>
					</td>
					<td style="border-left-style:none">
					<div id="usernameTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>性&nbsp;&nbsp;&nbsp;&nbsp;别:</th>
					<td  style="border-right-style:none">
					    <select id="sex" name="sex" style="width:300px">
					       <c:if test="${user==null||user.sex!=2 }">
					         <option value="1" selected="selected">男</option>
					         <option value="2">女</option>
					       </c:if> 
					        <c:if test="${user.sex==2 }">
					         <option value="1">男</option>
					         <option value="2" selected="selected">女</option>
					       </c:if> 
					     </select>
						
					</td>
					<td style="border-left-style:none">
					
					</td>
				</tr>
				<tr>
					<th>角&nbsp;&nbsp;&nbsp;&nbsp;色:</th>
					<td  style="border-right-style:none">
					    <select id="roleid" name="roleid" style="width:300px" onblur="checkRole()">
					        <option value="0">请选择</option>
					        <c:forEach var="role" items="${roleList }"> 
					              <c:if test="${user.roleid ==role.id}">
						              <option value="${role.id}" selected="selected">${role.rolename }</option>
						           </c:if>
						           <c:if test="${user.roleid!=role.id}">
						              <option value="${role.id}">${role.rolename }</option>
						           </c:if>
				
					        </c:forEach>
					    </select>
					</td>
					<td style="border-left-style:none">
					<div id="roleIdTip" style="width:100px"/>
					</td>
				</tr>
				
				<tr>
					<th>岗&nbsp;&nbsp;&nbsp;&nbsp;位:</th>
					<td  style="border-right-style:none">
					   <select id="positionid" name="positionid" style="width:300px" onblur="checkPosition()">
					        <option value="0">请选择</option>
					        <c:forEach var="position" items="${positionList }"> 
					            <c:if test="${user.positionid ==position.id}">
						              <option value="${position.id}" selected="selected">${position.name }</option>
						           </c:if>
						           <c:if test="${user.positionid!=position.id}">
						              <option value="${position.id}">${position.name }</option>
						           </c:if>
	
					        </c:forEach>
					    </select>
						
					</td>
					<td style="border-left-style:none">
					<div id=positionIdTip style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>联系电话:</th>
					<td  style="border-right-style:none">
						<input type="text" name="telcode" id="telcode" value="${user.telcode }" style="width:300px"/>
					</td>
					<td style="border-left-style:none">
					</td>
				</tr>
				
				
		  </table>
		  </form>
			<div class="project_21btn fl">
					<a href="#"><img id ="img1" src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					&nbsp;&nbsp;
					<a href="#" onclick="toClear();return false;"><img src="<%=path %>/images/btn/btn_04.gif" alt="清空" /></a>&nbsp;&nbsp;
					&nbsp;&nbsp;
					<a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
			</div>
	</div>	
</div>
</body>
</html>
