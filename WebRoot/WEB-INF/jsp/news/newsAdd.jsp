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
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	$.formValidator.initConfig({formid:"newsForm",onerror:function(msg){return false}});
	$("#title").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
	$("#content").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});

	
});
function toSubmit(){

	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.newsForm.action="${pageContext.request.contextPath}/news/newsSave.action";
		document.forms.newsForm.submit();
	}
}
function toUpdate(){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.newsForm.action="${pageContext.request.contextPath}/news/newsUpdateSave.action";
		document.forms.newsForm.submit();
	}
}
function toReturn(){
	document.forms.newsForm.action="${pageContext.request.contextPath}/news/newsList.action";
	document.forms.newsForm.submit();
}
</script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content"]', {
		    //指定编辑器iframe document的CSS文件，用于设置可视化区域的样式。
			cssPath : '../js/kindeditor/plugins/code/prettify.css',
			//指定上传文件的服务器端程序。
			uploadJson : '../js/kindeditor/upload_json.jsp',
			//指定浏览远程图片的服务器端程序。
			fileManagerJson : '../js/kindeditor/file_manager_json.jsp',
			//true时显示浏览远程服务器按钮。
			allowFileManager : true,
			//设置编辑器创建后的回调函数
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
			//编辑器失去焦点(blur)时执行的回调函数。
			afterBlur:function(){   
                   this.sync();   
             } 
		});
		prettyPrint();
		editor1.html($("#content").val());
	});
</script>

</head>
<body>
<div id="right">
<form  name="newsForm"  validate="true" theme="simple" id="newsForm" method="post">
 <input type="hidden" name="id" id="id" value="${id }"/>
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 新闻管理-新增新闻</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增">
				<colgroup>
				<col width="15%" />
				<col width="45%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>标&nbsp;&nbsp;&nbsp;&nbsp;题</th>
					<td>
						 <input type="text" name="title" id="title" class="text_casepian7" maxlength="200" value="${news.title }"/>
					</td>
					<td style="border-left-style:none"> <div id="titleTip"/></td>
				</tr>
				<tr>
				<th>内&nbsp;&nbsp;&nbsp;&nbsp;容</th>
					<td>
						<textarea name="content" id="content" cols="100" rows="10" style="width:700px;height:350px;visibility:hidden;" >${news.content }</textarea>
					</td>
					<td style="border-left-style:none"> <div id="contentTip"/></td>
				</tr>
		  </table>
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
</form>		
</div>
</body>
</html>
