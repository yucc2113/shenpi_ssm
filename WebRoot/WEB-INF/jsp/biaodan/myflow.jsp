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

<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<title></title>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>


<style type="text/css">
.add_new li{width:12.5%; float:left; text-align:center; font-size:14px; font-weight:bold;}
.add_new li p{ display:block; clear:both; padding:10px 0;}
.add_new li p img{ width:60px;}
</style>
<script type="text/javascript">
function toBiaodan(flowId){
	document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/add.action?flowId="+flowId;
	document.forms.biaodanform.submit();
}
</script>
</head>
<body>
<div id="right">
<form name="biaodanform"  validate="true" theme="simple" id="biaodanform" method="post">
<input type="hidden" name="id" id="id" />
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的流程</ul></div>
	</div>
		<div class="com_contant"><div class="bg">
			<ul class="add_new">
			     <c:forEach var="data" items="${ dataList}">
			        	<li><p><img src="<%=path %>/images/img01.gif" alt="" /></p><a href="#"  onclick="toBiaodan(${data.id })" >${data.flowName }</a></li>
			     </c:forEach>	
			</ul>
		</div>
	</div>
</form>		
</div>
</body>
</html>
