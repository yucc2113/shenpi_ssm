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
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<title></title>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	
});
function toReturn(){
   var tag = $("#tag").val();
  
   if(tag == 2){
      	 document.forms.meetAddform.action="${pageContext.request.contextPath}/meet/myList.action";
	    document.forms.meetAddform.submit();
    } if(tag == 3){
      	 document.forms.meetAddform.action="${pageContext.request.contextPath}/main/init.action";
	    document.forms.meetAddform.submit();
    }else{
	   document.forms.meetAddform.action="${pageContext.request.contextPath}/meet/meetList.action";
 	   document.forms.meetAddform.submit();
   }
	
}

</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的会议</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form name="meetAddform"  validate="true" theme="simple" id="meetAddform" >
			<input type="hidden" id="id" name="id" value="${meetCustom.id }"/>
			<input type="hidden" name="tag" id="tag" value="${tag }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="50%" />
				</colgroup>
				<tr>
					<th>会议名称:</th>
					<td>${meetCustom.name }</td>
				</tr>
				<tr>
					<th>会议时间:</th>
					<td>
						<fmt:formatDate value="${meetCustom.meetDate }" pattern="yyyy-MM-dd HH:mm:ss EEEE"/>
						</td>
				</tr>
				<tr>
					<th>会议地点:</th>
					<td>${meetCustom.didian }</td>
				</tr>
			   <tr>
                  <th>会议人员：</th>
                  <td>${meetCustom.usersName }</td>
              </tr>
				<tr>
					<th>会议人数:</th>
					<td>${meetCustom.num }人</td>
				</tr>
				<tr>
					<th>会议材料:</th>
					<td>
					<a class="icon" href="${pageContext.request.contextPath}/meet/download?id=${meetCustom.id }&newfilename=${meetCustom.newfilename }"><span>${meetCustom.oldfilename }</span></a>
				
					</td>
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
