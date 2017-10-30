<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.base.common.util.StringUtil"%>
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
function toReturn(){
  var flag=$("#flag").val();
  if(flag ==2){
		document.forms.newsForm.action = "${pageContext.request.contextPath}/news/myList.action";
	    document.forms.newsForm.submit();
	}if(flag ==3){
		document.forms.newsForm.action = "${pageContext.request.contextPath}/main/init.action";
	    document.forms.newsForm.submit();
	}else{
	    document.forms.newsForm.action = "${pageContext.request.contextPath}/news/newsList.action";
	    document.forms.newsForm.submit();
	}
	
}
</script>
</head>
<body>
<div id="right">
<input type="hidden" id="flag" name="flag" value="${flag}"/> 
<form  name="newsForm"  validate="true" theme="simple" id="newsForm" method="post">
	<input type="hidden" name="id" id="id"/>
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-任务详细</ul></div>
	</div>
	
	<div id="contant">
		<div class="com_contant">
		
	       <div id="newscontant" style='min-height:350px;'>
		       <div class="details">
				<h2>${news.title}</h2>
				<p>${news.content }</p>
				<p class="ar">${news.createdate}</p>
		      </div>
	     </div>	
	     
	     <div class="project_21btn fl" style="background-color:fff;">
		   <a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
	     </div>	
	     	
	 </div>
   </div>
</form>		
</div>
</body>
</html>
