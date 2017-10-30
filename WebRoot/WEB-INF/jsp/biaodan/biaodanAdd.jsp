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
<script src="<%=path %>/js/ajaxanywhere.js"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>

<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<title>吉林大学协同办公系统</title>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	$.formValidator.initConfig({formid:"shenpiform",onerror:function(msg){return false}});
	$("#dealIdea").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
});
function toAudit(type){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.shenpiform.action="shenpi!audit.action?type="+type;
		document.forms.shenpiform.submit();
	}
}
function toSubmit(){
	var id = document.getElementById("id").value;
	alert("id="+id);
	if(id==''){
		document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/save.action";
		document.forms.biaodanform.submit();
	}else{
		document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/updateSave.action";
		document.forms.biaodanform.submit();
	}
}

function clearNoNum(obj){
		obj.value = obj.value.replace(/[^\d.]/g,"");
		obj.value = obj.value.replace(/^\./g,"");
		obj.value = obj.value.replace(/\.{2,}/g,".");
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}

</script>
</head>
<body style=" background:#fff;">
<div id="right">
<form name="biaodanform"  validate="true" theme="simple" id="biaodanform" method="post">
	<input type="hidden" name="id" id="id" value="${id }"/>
	<input type="hidden" name="flowId" id="flowId" value="${flowId }"/>
	<input type="hidden" name="biaoId" id="biaoId" value="${biaoId }"/>
	<input type="hidden" name="mingchen" id="mingchen" value="${mingchen }"/>
<!-- 	<input type="hidden" name="dcontent" id="dcontent" /> -->
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-表单添加</ul></div>
	</div>
		<div class="com_contant">
		</br>
			${dcontent!=null?dcontent:"无表单" }
			 
		</br></br>	 
		  <div class="project_21btn fl">
		 	    <c:if test="${dcontent!=null }">  
				    <a href="#"  onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_69.gif" alt="提交" /></a>&nbsp;
			   </c:if>
			</div>
	</div>
</form>		
</div>
</body>
</html>
