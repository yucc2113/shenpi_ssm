<%@ page contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="<%=path %>/ud/editor_config.js"></script>
<script type="text/javascript" src="<%=path %>/ud/editor_all.js"></script>
<script type="text/javascript" src="<%=path %>/ud/uparse.js"></script>
</head>
	<style type="text/css">
		html,body{width:100%;margin:0;}	
		button{
			margin:0;
		}	
		button.btnTool{
			width:100px;
			height:24px;
			text-align:left;
			font-size:9pt;
		}
		button.btnTool img{
			height:16px;
			width:16px;
			vertical-align:middle;
		}
		button.btnControl{
			width:120px;
			height:30px;
			text-align:center;
			font-weight:bold;
		}

		table.btnControl{
			margin-top:5px;
		}
		.clear {
				clear: both;
			}
	</style>
<body>
<input id="dataElements" name="dataElements" type="hidden" />
	<table width="100%" class="TableBlock">
		<tr bgcolor="#DDDDDD">
		   <td class="TableHeader" colspan="2" height="20">
			&nbsp;<img src="images/dot3.gif" align="absmiddle"> <font color="red">表单智能设计器</font></td>
		</tr>
		<tr bgcolor="#DDDDDD">
			<td align="center" valign="top">
				<table width="120" border="0" cellpadding="0" cellspacing="0" class="TableBlock" align="center">
					<tbody>
						<tr class="TableHeader">
							<td align="center">表单控件</td>
						</tr>
						<tr class="TableData">
							<td align="center">
							<button class="btnTool" onclick="insertHtml('textfield')">单行输入</button><br>
							<button class="btnTool" onclick="insertHtml('textarea')"> 多行输入</button><br>
							<button class="btnTool" onclick="insertHtml('shuzi')">数字输入</button><br>
							<button class="btnTool" onclick="insertHtml('shijian')">时间选择</button><br>
							<button class="btnTool" onclick="insertHtml('dept')">部门选择</button><br>
							<!--<button class="btnTool" onclick="insertHtml('radio')"><img src="images/radio.gif"> 单选按钮</button><br>
							<button class="btnTool" onclick="insertHtml('checkbox')"><img src="images/checkbox.gif"> 复选框</button><br>-->
							<button class="btnTool" onclick="insertHtml('user')">人员选择</button><br>
							<button class="btnTool" onclick="insertHtml('auto')">宏定义控件</button><br>
							<!--<button class="btnTool" onclick="exec_cmd('xd_listview')"><img src="images/listview.gif"> 列表控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_calendar')"><img src="images/calendar.gif"> 日历控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_calcu')"><img src="images/calc.gif"> 计算控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_sign')"><img src="images/sign.gif"> 签章控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_data_select')"><img src="images/data.gif"> 数据选择控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_data_fetch')"><img src="images/data.gif"> 表单数据控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_progressbar')"><img src="images/progressbar.gif"> 进度条控件</button><br>
							<button class="btnTool" onclick="exec_cmd('xd_imgupload')"><img src="images/imgupload.gif"> 图片上传控件</button><br>-->
							<button class="btnTool" onclick="getAllHtml()"><img src="images/qrcode.gif"> 二维码控件</button><br>
							</td>
						</tr>
					</tbody>
				</table>
				<table width="120" border="0" cellpadding="0" cellspacing="0" class="TableBlock btnControl" align="center">
				<tbody>
					<tr class="TableHeader">
						<td align="center">保存与退出</td>
					</tr>
					<tr class="TableData">
						<td align="center">
							<button class="btnTool" onclick="send()">保存表单</button><br>
							<button class="btnTool" onclick="myclose()">关闭设计器</button>
							<input type="hidden" id="editor_value" value="" />
						</td>
					</tr>
				</tbody>
				</table>
			</td>
			<td width="95%">
				<div style="width:100%;">
				    <script id="editor" type="text/plain" style="width:1024px;height:630px;"> </script>
				</div>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
     UE.getEditor('editor', {
    	initialFrameWidth : '1080',
		minFrameHeight:550,
        initialFrameHeight: 95
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
    function insertHtml(value) {
	    var strhtml = '';
	    idl++;
    	if(value=='textfield'){
    		strhtml = "<INPUT element_type='element_text' TYPE='TEXT' name='dataElement' id='dataElement' value='文本' /><INPUT value='element_text' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='textarea'){
    		strhtml = "<textarea name='dataElement' id='dataElement' element_type='element_textarea'>富文本</textarea><INPUT value='element_textarea' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='shuzi'){
    		strhtml = "<input name='dataElement' id='dataElement' element_type='element_shuzi' onclick='togetDept()'/><INPUT value='element_shuzi' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='shijian'){
    		strhtml = "<input name='dataElement' id='dataElement' element_type='element_shijian' onclick='togetDept()'/><INPUT value='element_shijian' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='dept'){
    		strhtml = "<input name='dataElement' id='dataElement' element_type='element_dept' onclick='togetDept()'/><INPUT value='element_dept' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='user'){
    		strhtml = "<input type='text' name='dataElement' id='dataElement' onclick='togetUser()'/><INPUT value='element_user' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}else if(value=='auto'){
    		strhtml = "<input type='text' name='dataElement' id='dataElement' element_type='element_auto' /><INPUT value='element_auto' style='width:0px;height:21px' type='hidden' name='dataElementvalue' id='dataElementvalue' />";
    	}
        UE.getEditor('editor').execCommand('insertHtml',strhtml);
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
</html>