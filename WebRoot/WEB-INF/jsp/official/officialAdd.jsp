<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.io.*,java.sql.*" %>
<%@ page import="java.util.*"%>

<%@ include file="../../../inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {

var myDate = new Date();
var mytime= myDate.toLocaleTimeString();
var a=mytime.split(":");
var times = a[0]*60*60*1000+a[1]*60*1000+a[2]*1000;
$('#filenames').val(times);

	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	$.formValidator.initConfig({formid:"officialForm",onerror:function(msg){return false}});
	$("#filename").formValidator({onshow:"输入公文名称",onfocus:"输入公文名称",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "输入公文名称!"});
	$("#wenhao").formValidator({onshow:"输入文号",onfocus:"输入文号",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "输入文号!"});
	
});

function toSubmit(){

	if(jQuery.formValidator.pageIsValid("1")){
				alert("hi");
				document.forms.officialForm.action="${pageContext.request.contextPath}/official/save.action";
				document.forms.officialForm.submit();
    }
}
function toUpdate(){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.officialForm.action="${pageContext.request.contextPath}/official/updateSave.action";
		document.forms.officialForm.submit();
	}
}
    <%--   function submitNTKO(tag){
          var saveURL = "<%=path%>/upload";
          var result = OFFICE_CONTROL_OBJ.saveToURL(saveURL,"ntkoFile","",tag,0 );
      } --%>

function toClear(){
	document.officialForm.reset();
}
function toReturn(){
	document.forms.officialForm.action="${pageContext.request.contextPath}/official/officialList.action";
	document.forms.officialForm.submit();
}

function chooseUser(){
	var usersId = $("#usersId").val();
	$("#byId").val(id);
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '${pageContext.request.contextPath}/user/searchOfficialUser.action',width:'300', height:'485',cover: true });
}
function selectUser(id){ 
      	    $.ajax({
			type : "post",
		
			url : "${pageContext.request.contextPath}/official/selectUser.action",
			data:"id="+id+"&usersId="+$("#usersId").val(),
			success: function(result) {
			$("#names").html(result);
 				return;
			}
		});
		
	}

</script>
</head>
<%-- <body onload='intializePage("<%=fileUrl%>")' > --%>
<body>

<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 公文管理</ul></div>
	</div>
		<div class="com_contant">
			</br>
			
		
			<form id="officialForm" name="officialForm" validate="true" theme="simple" style="padding:0px;margin:0px;" enctype="multipart/form-data"  method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="75%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>公文名称:</th>
					
					
					<td  style="border-right-style:none">
					   <input type="text" id="filename"  name="filename"  style="width:540px" readonly="readonly" value="${official.filename }"/>
					   <input type="hidden" id="filenamedisk"  name="filenamedisk"  style="width:360px"/>
					   <input type="file" name="file" id="file"   onchange="$('#filename').val(this.value)" />
					</td>
					
					<!-- <td  style="border-right-style:none">
						<input type="text" name="filename" id="filename" style="width:460px"/>
					</td> -->
					<td style="border-left-style:none">
					<div id="filenameTip" style="width:200px"/>
					</td>
				</tr>
				
				
				
				<tr>
					<th>文号:</th>
					<td  style="border-right-style:none">
					    <input type="hidden" name="id" id="id" value="${id }"/>
						<input typr="text" name="wenhao" id="wenhao" style="width:540px" value="${wenhao }" readonly="readonly" value="${official.wenhao }"/>
					</td>
					<td style="border-left-style:none">
					    <div id="wenhaoTip" style="width:200px"/>
					</td>
				</tr>
				
				<tr>
					<th>人员:</th>
					<td >
							    <input type="hidden" name="usersId" id="usersId" value="${usersId }"/>
							    <!-- <input type="hidden"  name="usersName" id="usersName"/> -->
							  
							   <textarea rows="5" cols="80" id="usersName" name="usersName" >${usersName } </textarea>
							     <a href="#" onclick="chooseUser();return false">选择人员</a> 
				    </td>
			        <td></td>
				</tr>
			
				
			
		  </table>
		</form>
		
			
			
         <div class="project_21btn fl">
			    <c:if test="${id==null }">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
				</c:if>
				<c:if test="${id!=null }">
					<a href="#" onclick="toUpdate();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
				</c:if>
								
				<a href="#" onclick="toReturn();return false;"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
			</div>
	
			
			
			
	</div>
</div>
</body>
</html>
