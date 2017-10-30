<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
</head>
<script>
function updatePsw(){
J.dialog.get('updatePsw',{ id: 'updatePsw',  title: '修改个人密码', page: '${pageContext.request.contextPath}/user/toUpdatePsw.action',width:'500', height:'250', rang: true});
}
</script>
<body>
<div id="header">
	<h1><a href="#"></a></h1>
	<p><a href="${pageContext.request.contextPath}/logout.action" target="_top"><img src="<%=path %>/images/3_05.gif" alt="退出"  width="28%" height="100%" style="cursor:pointer"/>&nbsp;&nbsp;退出</a></p>
	<p><a href="${pageContext.request.contextPath}/logout.action" target="_top"><img src="<%=path %>/images/3_03.gif" alt="重新登录"  width="18%" height="100%" style="cursor:pointer"/>&nbsp;&nbsp;重新登录</a></p>
	<p><img src="<%=path %>/images/3_07.gif" alt="修改密码"  width="18%" height="100%" onclick="updatePsw()" style="cursor:pointer"/><a href="#" onclick="updatePsw()">&nbsp;&nbsp;修改密码&nbsp;&nbsp;</a></p>
</div>
</body>
</html>
