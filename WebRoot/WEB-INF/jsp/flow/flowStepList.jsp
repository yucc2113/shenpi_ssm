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
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	
});
	function toReset(){
		$("#searchName").val('');
	}
	function toSearch(){
	    var flowId=$("#flowId").val();
	    var searchName=$("#searchName").val();
	    $.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/flowstep/ajaxList.action',
			data : {
				flowId : flowId,
				searchName : searchName,
				
			},
			success :function(data) {
			    $("#dataList").html("");
			    var html = "";
			 
			    var dataArray=eval(data); 
			   
			  
			    $.each(dataArray, function(i, result) {	
			   
					html += "<tr><td><input name='ids' type='checkbox' value='"+result.id+"' class='input' />"
					        +"</td><td>" +result.leibiename
			    			+ "</td><td><a href='#' onclick='toLook("+result.id+")'>"+result.stepName+"</a>" 
			    			+ "</td><td>" +result.lastname
			    			+ "</td><td>" +result.nextname
							+ "</td><td>" + result.libusername
							+ "</td></tr>"; 
				}); 
				$("#dataList").html(html);
			}
		});	

	}
	function toAdd(){
	    var flowId=$("#flowId  option:selected").val();//选中的值
		document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/add.action?flowId="+flowId;
		document.forms.flowstepForm.submit();
	}
	function toEdit(){
	    var flowId = $('#flowId').val();
		var number = checkIds('ids');
		if(number==1){
		    var id;
			var ids = document.getElementsByName("ids");
			for(var i=0 ;i<ids.length;i++){
				if(ids[i].checked){
					id = ids[i].value;
				}
			}	
			document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/update.action?flowId="+flowId+"&id="+id;
			document.forms.flowstepForm.submit();
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行修改编辑!',width:250,height:160});
		}	
	}
	function toDelete(){
		var number = checkIds('ids');
		if(number>0){
			 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
				if(tp=='ok'){
					document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/delete.action";
					document.forms.flowstepForm.submit();
					return true;
				}else{
					return false;
				}},width:250,height:160});
		}else{
			ymPrompt.alert({title:'信息提示',message:'请选择记录删除！',width:250,height:160});
		}
	}
function toLook(id){
var flowId = $('#flowId').val();
			document.flowstepForm.action="flowstep!flowSetpEdit_load.action?ids="+id+"&flowIds="+flowId;
			document.flowstepForm.submit();
}
</script>
</head>
<body>

<form  validate="true" id="flowstepForm" theme="simple" method="post">

<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 首页-系统管理-流程步骤管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="流程步骤管理列表" id="search_table">
                        <caption>
                        </caption>
                        <colgroup>
                        <col width="10%" />
                        <col width="40%" />
                        <col width="10%" />
                        <col width="40%" />
                        </colgroup>
                        <tr>
                            <th>流程名称：</th>
                            <td>
                            	<select  id="flowId" name="flowId" class="select_318" >
						          <c:forEach var="flow" items="${flowList }">	
						              <c:if test="${flow.id==flowId }">
										  <option value="${flow.id}" selected="selected">${flow.flowName}</option>				  
						              </c:if> 
						              <c:if test="${flow.id!=flowId }">
										  <option value="${flow.id}" >${flow.flowName}</option>				  
						              </c:if> 
						        
						         </c:forEach>
			                  </select>
                            </td>
                            <th>步骤名称：</th>
                            <td>
                            	<input type="text" name="searchName" id="searchName" class="text_197"/>
                            </td>
                        </tr>
                    </table>
			</div>
			<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询"  style="cursor:pointer"  onclick="toSearch()"/>
            	&nbsp;&nbsp;
            	<img src="<%=path %>/images/btn/btn_04.gif" style="cursor:hand"  alt="清空" onclick="toReset()"/>
			</div>
			<div class="project_3btn">
					<a href="#" onclick="toAdd()"><img src="<%=path %>/images/btn/btn_14.gif" alt="添加" /></a>&nbsp;&nbsp;
					<a href="#" onclick="toEdit()"><img name="imageField" id="imageField" src="<%=path %>/images/btn/btn_02.gif" alt="编辑" /></a>&nbsp;&nbsp;
					<a href="#" onclick="toDelete()"><img name="imageField" id="imageField" src="<%=path %>/images/btn/btn_01.gif" alt="删除" /></a>
			</div>
			
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="流程定义管理列表">
                      <caption>
                        </caption>
                        <colgroup>
                        <col width="5%" />
                        <col width="10%" />
                        <col width="30%" />
                        <col width="20%" />
                        <col width="20%" />
                         <col width="15%" />
                        </colgroup>
                        <tr>
                            <th>选择</th>
                            <th>类别</th>
                            <th>步骤名称</th>
                            <th>上级步骤</th>
                            <th>下级步骤</th>
                            <th>办理人</th> 
                        </tr>
                        <tbody id="dataList">
                      
                        <c:forEach var="data" items="${stepCustomList }">
                        <tr>
                            <td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
                            <td>${data.leibiename}</td>
                            <td><a href="#" onclick="toLook(${data.id});return false;">${data.stepName }</a></td>
                            <td>${data.lastname}</td>
                            <td>${data.nextname}</td>
                            <td>${data.libusername}</td>
                        </tr>
                       </c:forEach>
                      </tbody>
             </table>
              
              
              
              
		 </div>
	</div>	
</div>
</form> 
</body>
</html>
