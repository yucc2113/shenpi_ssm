<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/tld.inc"%>
<style type="text/css" media="all">
@import url("css/layout.css");
@import url(".css/common.css");
@import url("css/layout_contents.css");
</style>
<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
}

function setValue(){
	    var title = document.getElementById('title').value;
	    var lexing = document.getElementById('lexing').value;
	    if(title==''){
	   		 ymPrompt.alert({title:'信息提示',message:'标题不能为空！',width:250,height:160});
			 return false;	
	    }
	    D.toTRName("intertable",title,lexing);
		P.cancel();
	
}
window.onunload = onunload_handler;   
function onunload_handler(){   
	P.cancel();
}   
</script>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程设置-自定义表单</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增">
				<colgroup>
				<col width="25%" />
				<col width="*" />
				</colgroup>
				<tr>
					<th>标&nbsp;&nbsp;&nbsp;&nbsp;题</th>
					<td>
						 <input type="text" name="title" id="title" class="text_200" maxlength="200"/>
					</td>
				</tr>
				<tr>
				<th>类&nbsp;&nbsp;&nbsp;&nbsp;型</th>
					<td>
						<select name="lexing" id="lexing" class="select_196">
							<option value="1">文本</opiton>
							<option value="2">数字</opiton>
							<option value="3">日期</opiton>
							<option value="4">富文本</opiton>
						</select>
					</td>
				</tr>
		  </table>
	</div>
</div>
</body>
