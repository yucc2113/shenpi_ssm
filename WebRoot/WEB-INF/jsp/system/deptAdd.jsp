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
	$("#deptname").formValidator({onshow:"请输入部门名称",onfocus:"请输入部门名称",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "原密码输入错误!"});
	$("#img1").click(function(){
		if(jQuery.formValidator.pageIsValid("1")){
			ymPrompt.confirmInfo({title:'信息确认',message:'确认要保存部门？',handler: function(tp){
			if(tp=='ok'){
			    var deptId=$("#id").val();
				var parentid = $("#parentid").val();
				document.forms.deptAddform.action="${pageContext.request.contextPath}/dept/deptSave.action?parentid="+parentid+"&deptId="+deptId;
				document.forms.deptAddform.submit();
				P.cancel();
				D.reloadExt();
				
			}else{
				return false;
			}},width:250,height:160});
		
		}
	})
	});

function toClear(){
	document.deptAddform.reset();
}



</script>
</head>
<body>

<div id="right">
	<div class="right_box">
		<div class="menu_div"></div>
	</div>
		<div class="com_contant">
			<br />
			<form name="deptAddform"  validate="true" theme="simple" id="deptAddform" method="post">
			<input type="hidden" id="parentid" name="parentid" value="${dept.parentid }"/>
			<input type="hidden" id="id" name="id" value="${dept.id }"/>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="20%" />
				<col width="35%" />
				<col width="25%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>部&nbsp;门&nbsp;名&nbsp;称:</th>
					<td colspan="2"  style="border-right-style:none">
						<input type="text" name="deptname" id="deptname" style="width:250px" value="${dept.deptname }"/>
					</td>
					<td style="border-left-style:none">
					<div id="deptnameTip" style="width:100px"/>
					</td>
				</tr>
				
		  </table>
		  
		  
		  </form>
			<div class="project_21btn cl">
				<div class="project_21btn fl">
					<a href="#"><img id ="img1" src="<%=request.getContextPath()%>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					&nbsp;&nbsp;
					<a href="#" onclick="toClear();return false;"><img src="<%=request.getContextPath()%>/images/btn/btn_04.gif" alt="清空" /></a>&nbsp;&nbsp;
			</div>
			</div>
	</div>	
</div>
</body>
</html>
