<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.io.*,java.sql.*" %>
<%@ page import="java.util.*"%>

<%@ include file="../../../inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {

var myDate = new Date();
var mytime= myDate.toLocaleTimeString();
var a=mytime.split(":");
var times = a[0]*60*60*1000+a[1]*60*1000+a[2]*1000;
$('#filenames').val(times);
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
});


function toReturn(){
    var tag=$("#tag").val();
    if(tag==2){
       document.forms.officialForm.action="${pageContext.request.contextPath}/official/myList.action";
	   document.forms.officialForm.submit();
    }else{
        document.forms.officialForm.action="${pageContext.request.contextPath}/official/officialList.action";
	    document.forms.officialForm.submit();
    }
	
}


</script>
</head>
<%-- <body onload='intializePage("<%=fileUrl%>")' > --%>
<body>

<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 公文管理</ul></div>
	</div>
		<div class="com_contant">
			</br>
			
		   <input type="hidden" id="tag" name="tag" value="${tag}"/>
			<form id="officialForm" name="officialForm" validate="true" theme="simple" style="padding:0px;margin:0px;" enctype="multipart/form-data"  method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="*%" />
				
				</colgroup>
				<tr>
					<th>公文名称:</th>
					<td >
					  <a class="icon" href="${pageContext.request.contextPath}/official/download.action?id=${official.id }&newfilename=${official.filenamedisk}"><span>${official.filename}</span></a>
				    </td>		
				</tr>
				<tr>
					<th>文号:</th>
					<td> ${official.wenhao }</td>
				</tr>
				
				<tr>
					<th>人员:</th>
					<td >${usersName } </td>
			       
				</tr>
			
				
			
		  </table>
		</form>
		
			
			
         <div class="project_21btn fl">		
				<a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
		 </div>
	
			
			
			
	</div>
</div>
</body>
</html>
