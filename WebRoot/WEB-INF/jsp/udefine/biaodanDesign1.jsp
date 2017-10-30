<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="<%=path %>/ud/editor_config.js"></script>
<script type="text/javascript" src="<%=path %>/ud/editor_all_min.js"></script>
<script type="text/javascript" src="<%=path %>/ud/uparse.js"></script>
<title>吉林大学协同办公系统</title>


	<script type="text/javascript">
window.UEDITOR_HOME_URL = "<%=path %>/ud";
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
     UE.getEditor('editor', {
    	initialFrameWidth : '1024',
		minFrameHeight:570,
        initialFrameHeight: 95
    });

</script>
 
	</head>
<body>
   <script id="editor" type="text/plain" style="width:1024px;height:650px;">1234</script>

</body>


</html>