<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script type="text/javascript">

var P = window.parent, D = P.setDialog();

$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	
	$.formValidator.initConfig({formid:"usersform",onerror:function(msg){return false}});
	$("#oldpsw").formValidator({onshow:"请输入原密码",onfocus:"请输入原密码",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "原密码输入错误!"});
	$("#newpsw").formValidator({onshow:"请输入新密码",onfocus:"请输入新密码",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"新密码输入错误!"});
	$("#newpsw1").formValidator({onshow:"请输入重复密码",onfocus:"两次密码不一致",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码不能为空"},onerror:"重复密码不能为空"}).compareValidator({desid:"newpsw",operateor:"=",onerror:"两次密码不一致"});
	$("#img1").click(function(){
		if(jQuery.formValidator.pageIsValid("1")){
			ymPrompt.confirmInfo({title:'信息确认',message:'确认要修改密码？',handler: function(tp){
			if(tp=='ok'){
					$.ajax({
					type : "post",
					dataType : "text",
					url : "${pageContext.request.contextPath}/user/updatePsw.action",
					data:"oldpsw="+$("#oldpsw").val()+"&newpsw="+$("#newpsw").val(),
					success: function(result) {
						if(result=='-1'){
							ymPrompt.alert({title:'信息提示',message:'原密码填写不正确!',width:250,height:160});
						}else{
							ymPrompt.alert({title:'信息提示',message:'密码修改成功!',width:250,height:160});
							setTimeout(function(){
								P.cancel();
							}, 1000);
							
						}
					}
				});
			}else{
				return false;
			}},width:250,height:160});
		
		}
	})
	});



</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"></div>
	</div>
		<div class="com_contant">
			<br />
			<form  name="usersform"  validate="true" theme="simple" id="usersform" method="post">
			<input type="hidden" id="id" name="id"/>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="20%" />
				<col width="50%" />
				<col width="30%" />
				</colgroup>
				
				<tr>
					<th>当前密码:</th>
					<td style="border-right-style:none">
						<input type="password" name="oldpsw" id="oldpsw" class="text_casepian"/>
					</td>
					<td style="border-left-style:none">
					<div id="oldpswTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>新密码:</th>
					<td style="border-right-style:none">
						<input type="password" name="newpsw" id="newpsw" class="text_casepian"/>
					</td>
					<td style="border-left-style:none">
					<div id="newpswTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>确认新密码:</th>
					<td style="border-right-style:none">
						<input type="password" name="newpsw1" id="newpsw1" class="text_casepian"/>
					</td>
					<td style="border-left-style:none">
					<div id="newpsw1Tip" style="width:100px"/>
					</td>
				</tr>
		  </table>
		  
		  
		  </form>
			<div class="project_21btn cl">
					<a href="#"><img id ="img1" src="<%=request.getContextPath()%>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
			</div>
	</div>	
</div>
</body>
</html>
