<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/ajaxanywhere.js"></script>
<title></title>
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	var name = $('#name').val();
	$('#wenhao').html("例： "+name+"【"+new Date().getFullYear()+"】0001号");
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	
});
	

function toAdd(){
	 document.forms.OfficialForm.action="official!officialAdd.action";
	 document.forms.OfficialForm.submit();
}

function toUpdate(){
	var number = checkIds('ids');
	if(number==1){	
			var id;
			var ids = document.getElementsByName("ids");
			for(var i=0 ;i<ids.length;i++){
				if(ids[i].checked){
					id = ids[i].value;
				}
			}
			document.forms.OfficialForm.action="official!officialUpdate.action?id="+id;
			document.forms.OfficialForm.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDelete(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.OfficialForm.action="official!officialDelete.action";
				ajaxAnywhere.submitAJAX();
				return true;
			}else{
				return false;
			}},width:250,height:160});
	}else{
		ymPrompt.alert({title:'信息提示',message:'请选择记录进行删除！',width:250,height:160});
		return false;
	}
}


function toClear(){
	$("#name").val('');
}

function toSearch(){
	document.forms.OfficialForm.action="official!officialList.action";
	document.forms.OfficialForm.submit();	
}

function toLook(id){
	 document.forms.OfficialForm.action="official!officialdetail.action?id="+id;
	 document.forms.OfficialForm.submit();
}
function chooseUser(id){
	var userids = $("#userids").val();
	$("#byId").val(id);
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '../user/searchOfficialUser.jsp?userids='+userids,width:'300', height:'485',cover: true });
}

function toSaveUser(userids){
	var byId = $("#byId").val();
	document.forms.OfficialForm.action="official!toSaveUser.action?userids="+userids+"&byId"+byId;
	document.forms.OfficialForm.submit();
}

function selectuser(id){ 
	    $.ajax({
			type : "post",
			dataType : "text",
			url : "official!selectuser.action",
			data:"byId="+id,
			success: function(result) {
 				$("#userids").val(result);
			}
		});
		chooseUser(id);
	}
	
function changeWenhao(){
	var name = $('#name').val();
	var wenhao = "例： "+name+"【"+new Date().getFullYear()+"】0001号"; 
	$('#wenhao').html(wenhao);
}	



function toSubmit(){
	document.forms.OfficialForm.action="${pageContext.request.contextPath}/official/toSaveSet.action";
	document.forms.OfficialForm.submit();

}
</script>
</head>
<body>

<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 文号设定</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<form   validate="true" id="OfficialForm" theme="simple" method="post">
			<input type="hidden" id="tag" name="tag"/>
			<input type="hidden" id="byId" name="byId"/>
			<input type="hidden" id="userids" name="userids"/>
	
			<table width="90%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="20%" />
				<col width="50%" />
				<col width="30%" />
				</colgroup>
				<tr>
					<th>设定公文文号:</th>
					<td style="border-right-style:none">
						<input type="text" name="name" id="name" maxlength="400" style="width:100px" value="${officialset.name}"/>
						【<%=Calendar.getInstance().get(Calendar.YEAR) %>】0001号 
					</td>
					<td style="border-left-style:none">
						<div id="wenhao" style=" display:block; overflow:auto;text-align: left;background:#FFF;color:#FF0000">
    					 
    					</div>
					</td>
				</tr>
		  </table>
		    </form>  
           
 
             <div class="project_21btn fl">
					<a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
					<a href="#" onclick="toClear();return false;"><img src="<%=path %>/images/btn/btn_04.gif" alt="清空" /></a>&nbsp;&nbsp;
			</div>
	</div>	
</div>			
</body>
</html>
