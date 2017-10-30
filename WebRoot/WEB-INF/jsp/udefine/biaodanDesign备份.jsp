<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
     <%@ include file="../../../inc/tld.inc"%>
   <link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path %>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=path %>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=path %>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=path %>/js/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/js/calendar/lhgcalendar.js"></script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=path %>/js/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=path %>/js/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" src="<%=path %>/js/ueditor/parse.js"></script>
     <script type="text/javascript" charset="utf-8" src="<%=path %>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
   
    <script type="text/javascript">
 function insertHtml(value) {
  alert("hi");
	    var strhtml = '';
	    idl++;
    	if(value=='textfield'){
    		strhtml = "<INPUT element_type=\'element_text\' TYPE='TEXT' name=\'dataElement\' id=\'dataElement\'/>";
    	}else if(value=='textarea'){
    		strhtml = "<textarea name=\'dataElement\' id=\'dataElement\' element_type=\'element_textarea\'></textarea>";
    	}else if(value=='shuzi'){
    		strhtml = "<input name=\'dataElement\' id=\'dataElement\' element_type=\'element_shuzi\' onkeyup='javascript:clearNoNum(this);'/>";
    	}else if(value=='shijian'){
    		strhtml = "<input name=\'dataElement\' id=\'dataElement\' element_type=\'element_shijian\' onclick='WdatePicker()'/>";
    	}else if(value=='dept'){
    		strhtml = "<input name=\'dataElement\' id=\'dataElement\' element_type=\'element_dept\' onclick='togetDept(this)' />";
    	}else if(value=='user'){
    		strhtml = "<input type=\'text\' name=\'dataElement\' id=\'dataElement\' element_type=\'element_user\' onclick='togetUser(this)' />";
    	}else if(value=='auto'){
    		strhtml = "<input type=\'text\' name=\'dataElement\' id=\'dataElement\' element_type='element_auto' />";
    	}
    	 alert(strhtml);
        UE.getEditor('editor').execCommand("inserthtml",strhtml);
    }
	function toUpdate(){
		var content = UE.getEditor('editor').getContent();
		var hasContents = UE.getEditor('editor').hasContents()
		if(hasContents==false){
			ymPrompt.alert({title:'信息提示',message:'内容不能为空!',width:250,height:160});
			return false;
		}else{
			document.getElementById("dataElements").value=content;
			document.forms.udingyiform.action="udingyi!update.action";
			document.forms.udingyiform.submit();
		}
	}
	
	function togetString(){
			document.forms.udingyiform.action="udingyi!togetString.action";
			document.forms.udingyiform.submit();
	}
	
	</script>
</head>

<body>
<div id="right">
<form  name="udingyiform"  validate="true" theme="simple" id="udingyiform" >
<input type="hidden" name="id" id="id"/>
<input  type="hidden" id="dataElements" name="dataElements"/>
<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-表单设计</ul></div>
</div>
</form>
	<table width="100%" class="TableBlock">
		<tr bgcolor="#ffffff">
			<td align="center" valign="top">
				<table width="120" border="0" cellpadding="0" cellspacing="0" class="TableBlock" align="center">
					<tbody>
						<tr class="TableHeader">
							<td align="left"><strong>&nbsp;&nbsp;表单控件</strong></td>
						</tr>
						<tr class="TableData">
							<td align="center">
							&nbsp;&nbsp;<a href="#" onclick="insertHtml('textfield');return false;"><img src="<%=path %>/images/01.gif" alt="单行输入" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('textarea');return false;"><img src="<%=path %>/images/02.gif" alt="多行输入" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('shuzi');return false;"><img src="<%=path %>/images/03.gif" alt="数字输入" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('shijian');return false;"><img src="<%=path %>/images/04.gif" alt="时间选择" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('dept');return false;"><img src="<%=path %>/images/05.gif" alt="部门选择" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('user');return false;"><img src="<%=path %>/images/06.gif" alt="人员选择" /></a><br />&nbsp;
							<a href="#" onclick="insertHtml('auto');return false;"><img src="<%=path %>/images/07.gif" alt="宏定义控件" /></a>
							</td>
						</tr>
					</tbody>
				</table>
				<table width="120" border="0" cellpadding="0" cellspacing="0" class="TableBlock btnControl" align="center">
				<tbody>
					<tr>
						<td align="left">&nbsp;</td>
					</tr>
					<tr class="TableHeader">
						<td align="left"><strong>&nbsp;&nbsp;保存与退出</strong></td>
					</tr>
					<tr class="TableData">
						<td align="center">
						&nbsp;&nbsp;<a href="#" onclick="toUpdate();return false;"><img src="<%=path %>/images/09.gif" alt="保存表单" /></a><br />&nbsp;
						<a href="#" onclick="togetString();return false;"><img src="<%=path %>/images/10.gif" alt="关闭设计器" /></a>
						
						<input type="hidden" id="editor_value" value="" />
						</td>
					</tr>
				</tbody>
				</table>
			</td>
			<td width="95%" style=" text-align:left;">
				<div style="width:100%;">
				    <script id="editor" type="text/plain" style="width:1180px;height:450px;">${udBiaodan.dcontent}</script>
				</div>
			</td>
		</tr>
	</table>
</div>	
</body>


<head>

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
     UE.getEditor('editor', {
    	initialFrameWidth : '1180',
		minFrameHeight:400,
        initialFrameHeight: 450
    });
	var idl = 0;

    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
	function myclose(){
			if(confirm('你确定要关闭当前窗口吗？')){
				window.close();
			}
		}
</script>
</head>

</html>