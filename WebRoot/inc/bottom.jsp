<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ccgj.database.beans.Users,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../inc/tld.inc"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common.css" rel="stylesheet" type="text/css">
<link href="../css/sub.css" rel="stylesheet" type="text/css">
<title>吉林大学协同办公系统</title>
</head>
<body>
<%
com.ccgj.database.beans.Users user  = (com.ccgj.database.beans.Users)request.getSession(true).getAttribute(com.base.common.util.GlobalDefine.USER);
%>
<div id="footer">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="al" width="30%">登录人：<%=user.getUsername() %></td>
			
			<td class="ar" width="30%">当前日期:<%=new Date().toLocaleString() %></td>
		</tr>
	</table>
</div>
</body>
</html>
