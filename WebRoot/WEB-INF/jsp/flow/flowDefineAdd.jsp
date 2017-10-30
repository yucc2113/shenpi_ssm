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
	
		$.formValidator.initConfig({formid:"flowdefineForm",onerror:function(msg){return true}});
		$("#flowName").formValidator({onshow:"请输入流程名称",onfocus:"流程名必须输入!",oncorrect:""}).inputValidator({min:1,max:100,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "流程名输入错误!"});
		$("#flowDesc").formValidator({onshow:"请输入流程描述",onfocus:"请输入流程描述",oncorrect:""}).inputValidator({min:1,onerror:"请输入流程描述"});
		$("#deptname").formValidator({onshow:"请选择部门",onfocus:"请选择部门!",oncorrect:""}).inputValidator({min:1,max:100,empty:{leftempty:false,rightempty:false,emptyerror:"请选择部门"},onerror: "请选择部门!"});
		
	});
function toSave(){
   if(jQuery.formValidator.pageIsValid("1")){
		document.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/save.action";
		document.flowdefineForm.submit();
	}
}
function toUpdateSave(){
   if(jQuery.formValidator.pageIsValid("1")){
		document.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/updateSave.action";
		document.flowdefineForm.submit();
	}
}

function LimitTextUserArea(field){
    maxlimit=100;
    if (field.value.length > maxlimit)
    field.value = field.value.substring(0, maxlimit);
  }
function toReset(){
		document.flowdefineForm.reset();
	}
function toBack(){
		document.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/list.action";
		document.flowdefineForm.submit();
	}
function chooseDept(){
	var deptids = $("#deptids").val();
	J.dialog.get('dept',{ id: 'dept',  title: '选择部门', page: '../user/searchDept.action',width:'300', height:'485',cover: true });
}
</script>
</head>
<body>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 首页-系统管理-流程管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			 <form  method="post" id="flowdefineForm" name="flowdefineForm"  validate="true" theme="simple">
				<input type="hidden" name="id" id="id" value="${flowDefine.id }"/>
				<input type="hidden" hidden name="tag" id="tag"/>
                <div class="cl">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="流程定义管理添加">
                        <caption>
                        </caption>
                        <colgroup>
                        <col width="20%" />
                        <col width="55%" />
                        <col width="25%" />
                        </colgroup>
                        <tr>
                            <th>流程名称：</th>
                            <td><input type="text" name="flowName" id="flowName" class="text_500" value="${flowDefine.flowName }"/></td>
                            <td><div id="flowNameTip" style="width:100px;height:19px" /></td>
                        </tr>
                        <tr>
                            <th>流程描述：</th>
                            <td>
								<textarea name="flowDesc" id="flowDesc"   rows="5" style="width:500px" > ${flowDefine.flowDesc }</textarea>
                            </td>
                            <td><div id="flowDescTip" /></td>
                        </tr>
                        <tr>
                            <th>部&nbsp;&nbsp;&nbsp;&nbsp;门：</th>
                            <td>
                           <input type="text" name="deptname" id="deptname" readonly="true" class="text_500" value="${flowDefine.deptname }"/>
                           		<input type="hidden" name="deptids"  id="deptids" value="${flowDefine.deptids }"/>
								<a href="#" onclick="chooseDept()">选择部门</a>&nbsp;&nbsp;&nbsp;
                            </td>
                            <td><div id="deptnameTip" style="width:100px"/></td>
                        </tr>
                        <tr>
                            <th>是否可用：</th>
                            <td>
                               <select id="isEnabled" name="isEnabled" style="width:500px" >
                               
                                   <option value="1">可用</option>
                                   <c:if test="${flowDefine.isEnabled==2 }">
                                       <option value="2" selected="selected">不可用</option>
                                   </c:if>
                                    <c:if test="${flowDefine.isEnabled!=2 }">
                                        <option value="2" >不可用</option>
                                    </c:if>
                                  
                               </select>
                            </td>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="project_21btn">
                
                   <c:if test="${id==null }">
					  <a href="#" onclick="toSave();return false;"><img src="<%=path %>/images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
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
