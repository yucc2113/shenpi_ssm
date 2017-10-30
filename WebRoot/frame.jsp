<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="inc/tld.inc"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>企业协同办公管理平台</title>
</head>

 
<frameset name="mainFrame" id="mainFrame" cols="*" rows="55,*,30" border="0" framespacing="0">
  <frame noresize="noresize" src="<%=path%>/inc/top.jsp" scrolling="no" noresize="noresize" title="topFrame" frameborder="0" />
  <frameset id="leftFrame" name="leftFrame" rows="*" cols="210,*" frameborder="0">
    <frame src="<%=path%>/menu/initMenu.action"  title="leftFrame" id="leftmenu" name="leftmenu" scrolling="no"/>
    <frame src="<%=path%>/main/init.action" title="mainFrame"  id="bodyframe" name="centerFrame" />
  </frameset>
  <frame  src="<%=path%>/inc/bottom.jsp" scrolling="no" noresize="noresize" title="footerFrame" frameborder="0" />
 </frameset> 
  <noframes>
<body>
</body>
</noframes>
</html>

