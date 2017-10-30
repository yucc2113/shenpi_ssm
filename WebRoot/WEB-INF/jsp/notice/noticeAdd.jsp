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


<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<title>吉林大学协同办公系统</title>
<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>

<script type="text/javascript">
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content"]', {
			cssPath : '../js/kindeditor/plugins/code/prettify.css',
			uploadJson : '../js/kindeditor/upload_json.jsp',
			fileManagerJson : '../js/kindeditor/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			},
			afterBlur:function(){   
                   this.sync();   
             } 
		});
		prettyPrint();
	});


$(document).ready(function() {

	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	$.formValidator.initConfig({formid:"noticeAddform",onerror:function(msg){return false}});
	
	$("#title").formValidator({onshow:"请输入标题",onfocus:"请输入标题",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "请输入标题!"});
	$("#content").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
	$("#usersName").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
	/* $("#img1").click(function(){
		if(jQuery.formValidator.pageIsValid("1")){
				document.forms.noticeAddform.action="${pageContext.request.contextPath}/notice/noticeSave.action";
				document.forms.noticeAddform.submit();		
		}
	}) */
});
function toSubmit(){

	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.noticeAddform.action="${pageContext.request.contextPath}/notice/noticeSave.action";
		document.forms.noticeAddform.submit();
	}
}
function toUpdate(){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.noticeAddform.action="${pageContext.request.contextPath}/notice/noticeUpdateSave.action";
		document.forms.noticeAddform.submit();
	}
}
function toReturn(){
	document.forms.noticeAddform.action="${pageContext.request.contextPath}/notice/noticeList.action";
	document.forms.noticeAddform.submit();
}

function chooseUser(){
	var usersId = $("#usersId").val();
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '${pageContext.request.contextPath}/user/searchUser.action',width:'300', height:'485',cover: true });
}

function selectnum(){ 
	    $.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/user/selectnum.action",
			data:"usersId="+$("#usersId").val(),
			success: function(result) {
 			    var str=result.split("+"); 
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
		<div class="menu_div"><ul class="menu_title">当前位置： 通知管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form name="noticeAddform"  validate="true" theme="simple" id="noticeAddform" method="post">
			<input type="hidden" id="id" name="id" value="${noticeCustom.id }"/>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="8%" />
				<col width="82%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>标题:</th>
					<td  style="border-right-style:none">
						<input type="text" name="title" id="title" style="width:700px;" value="${noticeCustom.title }"/>
					</td>
					<td style="border-left-style:none">
					<div id="titleTip" style="width:100px"/>
					</td>
				</tr>
				<tr>
					<th>通知内容:</th>
					<td  style="border-right-style:none">
						<textarea name="content" id="content" cols="100" rows="8" style="width:700px;height:230px;visibility:hidden;">${noticeCustom.content }</textarea>
					</td>
					<td style="border-left-style:none">
					<div id="contentTip" style="width:100px"/>
					</td>
				</tr>
				 <tr>
                  <th>通知人员：</th>
                  <td style="border-right-style:none">
                      <textarea name="usersName" id="usersName" rows="5"  style="width:700px;" readonly="true" >${noticeCustom.usersName }</textarea>
						<input type="hidden" name="usersId" id="usersId" value="${noticeCustom.usersId }"/>
						<a href="#" onclick="chooseUser()" >选择通知人员</a>&nbsp;&nbsp;&nbsp;
                  </td>
                  <td style="border-left-style:none">
                  <div id="usersNameTip" style="width:100px;height:19px" /></td>
              </tr>
				<tr>
					<th>人数:</th>
					<td  style="border-right-style:none">
					<input type="text" id="num" name="num" readonly="true" style="width:700px;" value="${noticeCustom.num }"/>
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
