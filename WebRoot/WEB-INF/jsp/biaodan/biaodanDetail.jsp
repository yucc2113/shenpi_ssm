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
$(document).ready(function() {
	
	$.formValidator.initConfig({formid:"shenpiform",onerror:function(msg){return false}});
	$("#dealIdea").formValidator({onshow:"必填项",onfocus:"必填项",oncorrect:" "}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror:"必填项"});
});
function toAudit(type){
	if(jQuery.formValidator.pageIsValid("1")){
		document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/audit.action?type="+type;
		document.forms.biaodanform.submit();
	}
}
function toReturn(){
    var flag = $("#flag").val();
    if(flag == 3){
      	 document.forms.biaodanform.action="${pageContext.request.contextPath}/main/init.action";
	    document.forms.biaodanform.submit();
    }else{
		document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/list.action";
		document.forms.biaodanform.submit();
	}
}
function toReturnAudit(){
		document.forms.biaodanform.action="${pageContext.request.contextPath}/flowBiaodan/auditList.action";
		document.forms.biaodanform.submit();
}


</script>
</head>
<body>
<div id="right">
<form name="biaodanform"  validate="true" theme="simple" id="biaodanform" method="post">
	<input type="hidden" name="id" id="id" value="${uflowBiaodan.id }"/>
	<input type="hidden" name="flowId" id="flowId"/>
	<input type="hidden" name="biaoId" id="biaoId"/>
	<input type="hidden" name="workId" id="workId"/>
	<input type="hidden" name="flag" id="flag" value="${flag }"/>
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-任务详细</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="部门新增">
				${dcontent}
		  </table>
		  <br /><br /><br /><br />
		  <div style="width:90.5%; height:350px; margin-left:30px">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="报考博士申请表">
                       
                       <colgroup>
                       <col width="15%" />
                       <col width="25%" />
                       <col width="25%" />
                       <col width="*" />
                       </colgroup>
                       <c:if test="${detail_type==1 }">
                         <c:forEach var="data" items="${ideaList}">
                            <tr style="height:60px;">
	                            <th>意见</th>
	                            <td colspan="3">
	                            	${data.dealIdea}<br/>
	                            	<p align="right">主管领导：${data.dealName }&nbsp;&nbsp;时间:<fmt:formatDate value="${data.dealDate }" pattern="yyyy-MM-dd"/></p>
	                            </td>
	                        </tr>
                           </c:forEach>
	                    </c:if>   
                      <c:if test="${auditIdea==1}">
                       <tr> 
    						<th>意见</th>
                           <td>
                           	<textarea name="dealIdea" id="dealIdea" cols="100" rows="8" style="width:700px;height:100px;"></textarea>
                           </td>
                           <td nowrap="nowrap" class="r_line" colspan="2" style="width:35%;"><div id="dealIdeaTip"></div></td>
                       </tr>
                       </c:if>
					
                   </table>
                   <div class="project_21btn fl">
						<c:if test="${ auditIdea==1}">
						<a href="#" onclick="toAudit(1);return false;"><img src="<%=path %>/images/btn/btn_10.gif" alt="通过" /></a>&nbsp;
						<a href="#" onclick="toAudit(2);return false;"><img src="<%=path %>/images/btn/btn_11.gif" alt="未通过" /></a>&nbsp;
						<a href="#" onclick="toReturnAudit();"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;
						</c:if>	
						<c:if test="${ auditIdea!=1}">
						  <a href="#" onclick="toReturn();"><img src="<%=path %>/images/btn/btn_09.gif" alt="返回" /></a>&nbsp;
					    </c:if>
					</div>
              </div>     
					
	</div>
</form>		
</div>
</body>
</html>
