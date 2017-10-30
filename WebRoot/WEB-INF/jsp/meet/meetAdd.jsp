<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.base.common.util.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
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

	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	$.formValidator.initConfig({formid:"meetAddform",onerror:function(msg){return false}});
	$("#name").formValidator({onshow:"请输入会议名称",onfocus:"请输入会议名称",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "请输入会议名称!"});
	$("#meetDate").formValidator({onshow:"请选择会议时间",onfocus:"请选择会议时间",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"请选择会议时间!"});
	$("#didian").formValidator({onshow:"请选择会议地点",onfocus:"请选择会议地点",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "请选择会议地点!"});
	$("#usersName").formValidator({onshow:"请选择会议人员",onfocus:"请选择会议人员",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "请选择会议人员!"});
	$("#img1").click(function(){
		if(jQuery.formValidator.pageIsValid("1")){
				document.forms.meetAddform.action="${pageContext.request.contextPath}/meet/meetSave.action";
				document.forms.meetAddform.submit();		
		}
	})
});

	function toSubmit() {
		if (jQuery.formValidator.pageIsValid("1")) {
			document.forms.meetAddform.action = "${pageContext.request.contextPath}/meet/meetSave.action";
			document.forms.meetAddform.submit();
		}
	}
	function toUpdate() {
		if (jQuery.formValidator.pageIsValid("1")) {
			document.forms.meetAddform.action = "${pageContext.request.contextPath}/meet/meetUpdateSave.action";
			document.forms.meetAddform.submit();
		}
	}
	function toReturn() {
		document.forms.meetAddform.action = "${pageContext.request.contextPath}/meet/meetList.action";
		document.forms.meetAddform.submit();
	}

	function chooseUser() {
		var usersId = $("#usersId").val();
		J.dialog.get('user', {
			id : 'user',
			title : '选择人员',
			page : '${pageContext.request.contextPath}/user/searchUser.action',
			width : '300',
			height : '485',
			cover : true
		});
	}
	function selectnum() {

		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/user/selectnum.action",
			data : "usersId=" + $("#usersId").val(),
			success : function(result) {
				var str = result.split("+");
				$("#num").val(str[0]);
				$("#usersName").val(str[1]);

			}
		});
	}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 会议管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form name="meetAddform"  validate="true" theme="simple" id="meetAddform" method="post" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${id }"/>
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="70%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>会议名称:</th>
					<td  style="border-right-style:none">
						<input type="text" name="name" id="name" style="width:460px" value="${meetCustom.name }"/>
					</td>
					<td style="border-left-style:none">
					<div id="nameTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>会议时间:</th>
					<td  style="border-right-style:none">
						<input type="text" name="meetDate" id="meetDate" readonly="true" styleClass="Wdate" style="width:460px"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})"   value="${meetCustom.meetDateStr}" />
					</td>
					<td style="border-left-style:none">
					<div id="meetDateTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>会议地点:</th>
					<td  style="border-right-style:none">
						<input type="text" name="didian" id="didian" style="width:460px" value="${meetCustom.didian }" />
					</td>
					<td style="border-left-style:none">
					<div id="didianTip" style="width:100px;height:19px" />
					</td>
				</tr>
				 <tr>
                  <th>会议人员：</th>
                  <td style="border-right-style:none">
                     <textarea name="usersName" id="usersName" rows="5" cols="56" maxlength="400" readonly="true" >${meetCustom.usersName }</textarea>
						<input type="hidden" name="usersId" id="usersId" value="${meetCustom.usersId }"/>
						<a href="#" onclick="chooseUser()">选择会议人员</a>&nbsp;&nbsp;&nbsp;
                  </td>
                  <td style="border-left-style:none"><div id="usersNameTip" style="width:100px;height:19px" /></td>
              </tr>
				<tr>
					<th>会议人数:</th>
					<td  style="border-right-style:none">
					<input type="text" id="num" name="num" readonly="true" style="width:460px" value=" ${meetCustom.num }"/>
					</td>
					<td style="border-left-style:none">
					</td>
				</tr>
				<tr>
					<th>会议材料上传:</th>
					<td  style="border-right-style:none">
					<input type="text" id="oldfilename"  name="oldfilename" value="${meetCustom.oldfilename }" style="width:465px"/>
					<input type="hidden" id="newfilename"  name="newfilename" value="${meetCustom.newfilename }" style="width:465px"/>
					<input type="file" name="file" id="file"   onchange="$('#oldfilename').val(this.value)" />
					</td>
					<td style="border-left-style:none">
					</td>
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
