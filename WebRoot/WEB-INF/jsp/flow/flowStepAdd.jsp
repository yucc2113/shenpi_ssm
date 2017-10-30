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
<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function (){
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	$.formValidator.initConfig({formid:"flowstepForm",onerror:function(msg){return false}});
	$("#stepName").formValidator({onshow:"请输入步骤名称",onfocus:"步骤名称必须输入",oncorrect:""}).inputValidator({min:1,max:100,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "步骤名称输入错误!"});
	$("#libusername").formValidator({onshow:"计划划分为 必填项",onfocus:"计划划分为必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"计划划分为必填项"});
	
}); 

function toSubmit(){
    if(jQuery.formValidator.pageIsValid("1")){
		document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/save.action";
		document.forms.flowstepForm.submit();
	}
}
function toUpdateSave(){
    if(jQuery.formValidator.pageIsValid("1")){
		document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/updateSave.action";
		document.forms.flowstepForm.submit();
	}
}

	function check(){   
		if(document.flowstepForm.stepNo.value!="0"){
		    $.ajax({   
		        type:"POST",   
		        url:"flowStep!check.action",
		        dataType:"text",   
		        data:"flowId="+$("#flowId").val()+"&stepNo="+$("#stepNo").val(),   
		        beforeSend:function(XMLHttpRequest)   
		        {   
		        },   
		        success:function(msg)   
		        {   
		            if(msg=="1"){
		            	ymPrompt.alert({title:'信息提示',message:'步骤序号'+$("#stepNo").val()+'已经存在<br/>请选择一下序号!',width:250,height:160});
			            document.flowstepForm.stepNo.value = "0";
		            }
		        },   
		        complete:function(XMLHttpRequest,textStatus)   
		        {   
		        },   
		        error:function()   
		        {   
		        }   
		    });   
		}
	}   
	function toReset(){
		document.flowstepForm.reset();
	}
	function toBack(){
		document.forms.flowstepForm.action="${pageContext.request.contextPath}/flowstep/list.action";
		document.forms.flowstepForm.submit();
	}
function chooseUser(){
	var dealUser = $("#dealUser").val();
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '${pageContext.request.contextPath}/user/searchUserForStep.action',width:'300', height:'485',cover: true });
}
function chooseRole(){
	var dealRole = $("#dealRole").val();
	J.dialog.get('role',{ id: 'role',  title: '选择角色', page: '${pageContext.request.contextPath}/user/searchRole.action',width:'300', height:'485',cover: true });
}
function choosePosition(){
	var dealPosition = $("#dealPosition").val();
	J.dialog.get('role',{ id: 'role',  title: '选择岗位', page: '${pageContext.request.contextPath}/user/searchPosition.action',width:'300', height:'485',cover: true });
}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 首页-系统管理-流程步骤管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			 <form  method="post" id="flowstepForm" name="flowstepForm"  validate="true" theme="simple">
			    <input type="hidden" id="userIds" name="userIds"/>
			    <input type="hidden" id="flowId" name="flowId" value="${flowId }"/>
				<input type="hidden" name="id" id="id" value="${flowStep.id }"/>
                <div class="cl">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="流程步骤管理添加">
                        <caption>
                        </caption>
                        <colgroup>
                        <col width="20%" />
                        <col width="50%" />
                        <col width="30%" />
                        </colgroup>
                        
                        <tr>
                            <th>步骤名称：</th>
                            <td style="border-right-style:none">
                            	<input type="text" name="stepName" id="stepName" style="width:300px" value="${flowStep.stepName }"/>
                            </td>
                            <td style="border-left-style:none"><div id="stepNameTip" style="width:100px;height:19px" /></td>
                        </tr>
                        <tr>
							<th>类&nbsp;&nbsp;&nbsp;&nbsp;别:</th>
							<td  style="border-right-style:none">
								 <select id="leixing" name="leixing" style="width:304px">
								    <c:if test="${flowStep.leixing==1 }">
								         <option value="1" selected="selected">开始</option>
								    </c:if>
								     <c:if test="${flowStep.leixing!=1 }">
								         <option value="1">开始</option>
								    </c:if>
								     
								      <c:if test="${flowStep.leixing==2 }">
								          <option value="2" selected="selected">串行</option>
								      </c:if>
								       <c:if test="${flowStep.leixing!=2 }">
								          <option value="2">串行</option>
								      </c:if>
								      <c:if test="${flowStep.leixing==3 }">
								          <option value="3" selected="selected">并行</option>
								      </c:if>
								       <c:if test="${flowStep.leixing!=3 }">
								           <option value="3">并行</option>
								      </c:if>
								      <c:if test="${flowStep.leixing==4 }">
								          <option value="4" selected="selected">任务</option>
								      </c:if>
								       <c:if test="${flowStep.leixing!=4 }">
								         <option value="4">任务</option>
								      </c:if>
								      <c:if test="${flowStep.leixing==5 }">
								          <option value="5" selected="selected">结束</option>
								      </c:if>
								       <c:if test="${flowStep.leixing!=5 }">
								          <option value="5">结束</option>
								      </c:if>
								 </select>
							</td>
							<td style="border-left-style:none">
							</td>
						</tr>
						<tr>
							<th>条&nbsp;&nbsp;&nbsp;&nbsp;件:</th>
							<td  style="border-right-style:none">
							    <select id="conditions" name="conditions" style="width:304px">
							          <option value="-1">请选择</option>
							          
							           <c:if test="${flowStep.conditions==1 }">
								          <option value="1" selected="selected">大于</option>
								      </c:if>
								       <c:if test="${flowStep.conditions!=1 }">
								         <option value="1">大于</option>
								      </c:if>
							           <c:if test="${flowStep.conditions==2 }">
								          <option value="2" selected="selected">小于</option>
								      </c:if>
								       <c:if test="${flowStep.conditions!=2 }">
								          <option value="2">小于</option>
								      </c:if>
								      <c:if test="${flowStep.conditions==3 }">
								          <option value="3" selected="selected">等于</option>
								      </c:if>
								       <c:if test="${flowStep.conditions!=3 }">
								          <option value="3">等于</option>
								      </c:if>
								      <c:if test="${flowStep.conditions==4 }">
								          <option value="4" selected="selected">大于等于</option>
								      </c:if>
								       <c:if test="${flowStep.conditions!=4 }">
								          <option value="4">大于等于</option>
								      </c:if>
							           <c:if test="${flowStep.conditions==5 }">
								          <option value="5" selected="selected">小于等于</option>
								      </c:if>
								       <c:if test="${flowStep.conditions!=5 }">
								            <option value="5">小于等于</option>
								      </c:if>
						 
							    </select>
								
							</td>
							<td style="border-left-style:none">
							<div id="deptIdTip" style="width:100px"/>
							</td>
						</tr>
						<tr>
                            <th>条件内容：</th>
                            <td style="border-right-style:none">
                            	<input type="text" name="conditionmsg" id="conditionmsg" style="width:300px" value="${flowStep.conditionmsg }"/>
                            </td>
                            <td style="border-left-style:none"><div id="conditionmsgTip" style="width:100px;height:19px" /></td>
                        </tr>
						<tr>
                            <th>选择步骤：</th>
                            <td style="border-right-style:none">
                            	 <select  id="lastId" name="lastId"  style="width:304px">
                            	       <option value="-1">请选择</option>
                            	       <c:forEach var="last" items="${lastList }">
                            	           <c:if test="${last.id ==flowStep.lastId}">
                            	              <option value="${last.id }" selected="selected">${last.stepName }</option>
                            	           </c:if>
                            	            <c:if test="${last.id !=flowStep.lastId}">
                            	              <option value="${last.id }">${last.stepName }</option>
                            	           </c:if>
                            	       </c:forEach>
                            	 </select>上一步</br>
                            	 <select  id="nextId" name="nextId"  style="width:304px">
                            	       <option value="-1">请选择</option>
                            	       <c:forEach var="next" items="${nextList }">
                            	            <c:if test="${next.id ==flowStep.nextId}">
                            	                 <option value="${next.id }" selected="selected">${next.stepName }</option>
                            	           </c:if>
                            	            <c:if test="${next.id !=flowStep.nextId}">
                            	                <option value="${next.id }">${next.stepName }</option>
                            	           </c:if>
                            	        
                            	       </c:forEach>
                            	 </select>下一步</br>
                            	
                            </td>
                            <td style="border-left-style:none"></td>
                        </tr>
                        <tr>
                            <th>任务划分：</th>
                            <td style="border-right-style:none">
                           <input type="text" name="libusername" id="libusername" style="width:300px" readonly="true" value="${flowStep.libusername }"/>
                           		<input type="hidden" name="dealUser"  id="dealUser"/>
								<input type="hidden" name="dealRole" id="dealRole"/>
								<input type="hidden" name="dealPosition" id="dealPosition"/>
								<a href="#" onclick="chooseUser()">按人员选择</a>&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="chooseRole()">按角色选择</a>&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="choosePosition()">按岗位选择</a>&nbsp;&nbsp;&nbsp;
								<input type="hidden" name="stepType" id="stepType"/>
                            </td>
                            <td style="border-left-style:none"><div id="libusernameTip" style="width:100px"/></td>
                        </tr>
                    </table>
                </div>
                <div class="project_21btn">
                
                    <c:if test="${id==null }">
					  <a href="#" onclick="toSubmit();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
				   </c:if>
				   <c:if test="${id!=null }">
					   <a href="#" onclick="toUpdateSave();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
				   </c:if>
                   
                    &nbsp;
                    <img src="<%=path %>/images/btn/btn_72.gif" alt="重置" style="cursor:pointer" onclick="toReset()"/>
                    &nbsp;
                    <img src="<%=path %>/images/btn/btn_09.gif" alt="返回" style="cursor:pointer" onclick="toBack()"/>
                </div>
           </form>
	</div>	
</div>
</body>
</html>
