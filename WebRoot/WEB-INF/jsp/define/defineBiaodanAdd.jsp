<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/biaodanediot/editor/ckeditor.js"></script>
<script type="text/javascript" src="<%=path %>/biaodanediot/editor/ck_utility.js"></script>
<script type="text/javascript" src="<%=path %>/biaodanediot/editor/plugin_config.js"></script>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<title>吉林大学协同办公系统</title>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div id="right">
<form action="biaodan!add.action" name="biaodanform"  validate="true" theme="simple" id="biaodanform" >
	<input type="hidden" name="id" id="id"/>
	<input type="hidden" name="flowId" id="flowId"/>
	<input type="hidden" name="biaoId" id="biaoId"/>
	<input type="hidden"name="title" id="title"/>
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-表单添加</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增">
				<colgroup>
				<col width="15%" />
				<col width="65%" />
				<col width="*" />
				</colgroup>
				<textarea id="form_define" name="form_define"></textarea>
							<script type="text/javascript">
								var XD_FORM_EDITOR = CKEDITOR.replace( 'form_define' ,{
									
								});
								
								CKEDITOR.config.width = width - 145;
								CKEDITOR.config.height = height - 200;
								CKEDITOR.config.skin = 'office2003';
	
								CKEDITOR.config.toolbar =
								[
									{ name: 'document',    items : [ 'Source'] },
									{ name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
									{ name: 'editing',     items : [ 'Find','Replace','-','SelectAll','RemoveFormat' ] },
									{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-' ] },
									//{ name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
									'/',
									{ name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
									{ name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
									{ name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','SpecialChar' ] },
									'/',
									{ name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
									{ name: 'colors',      items : [ 'TextColor','BGColor' ] },
									{ name: 'tools',       items : [ 'Maximize', 'ShowBlocks'] }
								];
								
								var XD_FORM_DOCUMENT = new CKEDITOR.dom.document(document);
							</script>	
		  </table>
		  <div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
			</div>
	</div>
</s:form>		
</div>
</body>
</html>
