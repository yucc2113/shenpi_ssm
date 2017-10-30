<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
</style>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">

<title>企业协同办公管理平台</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/formValid/jquery_last.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ymPrompt/ymPrompt_source.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/ymPrompt/skin/simple/ymPrompt.css"></link>
<script type="text/javascript">
var COOKIE_NAME = 'JLChangChunLvShi_Cookie';
var local_cookie = $.cookie(COOKIE_NAME);	
var options = { path: '/', expires: 10 };
$(document).ready(function (){
	/* if (local_cookie != null)
	{
		$("#loginName").val(local_cookie);
	}	
	if($("#loginName").val()==''){
		$("#loginName").focus();
	}else{
		$("#loginPwd").focus();
	}
	
	$("#loginName").bind('keyup', function(e){
		if(e.keyCode == 13){
			$("#loginPwd").focus();
		}
	});
	
	$("#loginPwd").bind('keyup', function(e){
		if(e.keyCode == 13){
			var loginName = document.getElementById("loginName").value;
			var loginPwd = document.getElementById("loginPwd").value;
				if(loginName==''){
				ymPrompt.errorInfo({title:'',message:'用户名不能为空！',width:250,height:160});
				$("#loginName").focus();
				return false;
				}
				if(loginPwd==''){
					ymPrompt.errorInfo({title:'',message:'密码不能为空！',width:250,height:160});
					$("#loginPwd").focus();
					return false;
				}
			 document.forms.loginForm.action="user!login.action";
	 		 document.forms.loginForm.submit();
		}
	});	 */
	
});

function toLogin(){
	var loginName = document.getElementById("loginName").value;
	var loginPwd = document.getElementById("loginPwd").value;
	if(loginName==''){
		ymPrompt.errorInfo({title:'',message:'用户名不能为空！',width:250,height:160});
		$("#loginName").focus();
		return false;
	}
	if(loginPwd==''){
		ymPrompt.errorInfo({title:'',message:'密码不能为空！',width:250,height:160});
		$("#loginPwd").focus();
		return false;
	}
	   $.ajax({
	       type:"post",
	       url:'${pageContext.request.contextPath}/toLogin.action',
	       dataType:'json',
	       data:$("#loginForm").serialize(),
	       success: function(data) {
		      if(data.success=="true"){
                     $("#loginForm").submit();
              }else{
                  var msg1=data.success.substring(6);
               	  ymPrompt.errorInfo({title:'办公系统',message:msg1,width:250,height:160});
              }
            }  
        });
} 
function toReset(){
	$("#loginName").val('');
	$("#loginPwd").val('');
}
</script>

</head>
<body>
<div class="login_top png">
	<span class="png">企业</span>

</div>
<div class="login_a png">
<form action="login.action"  validate="true" id="loginForm" theme="simple">
	<div class="login_text png">
			<p id="skipToContent">企业协同办公管理平台<br />欢迎使用企业协同办公管理平台，请在右边输入用户名和密码登入系统。如账号登录遇到问题，请联系管理员。</p>
		</div>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td><p class="bg_p png"><span>帐号：</span><input name="loginName" id="loginName" type="text" value="" class="text" /></td>
		</tr>
		<tr>
			<td><p class="bg_p png"><span>密码：</span><input name="loginPwd" id="loginPwd" type="password" value="" class="text" /></td>
		</tr>
		<tr>
			<td>
				
				<a href="#" title="登录" class="btn png" onClick="toLogin()"></a>
				&nbsp;&nbsp;
				
			</td>
		</tr>
	</table>
</form>
</div>
<div class="login_foot png"</div>
</body>
</html>
