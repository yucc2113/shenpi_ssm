<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<script type="text/javascript" src="<%=path%>/js/lhgcore.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/lhgdialog.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
});
	var formName="ajaxAnywhere";
	ajaxAnywhere.formName="biaodanFrom";
	function ajaxPaginationInvoke(url)
	{
   		document.biaodanFrom.action=url;
   		//document.outFrom.submit();
   		ajaxAnywhere.submitAJAX();
	}
function searchDetail(id){
	document.forms.biaodanFrom.action="${pageContext.request.contextPath}/flowBiaodan/detail.action?id="+id;
	document.forms.biaodanFrom.submit();	
}
</script>
</head>
<body>
<form  validate="true" id="biaodanFrom" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-待办任务</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="人员基本信息表">
					<caption>人员基本信息</caption>
					<colgroup>
					<col width="15%" />
					<col width="15%" />
					<col width="15%" />
					<col width="15%" />
					<col width="15%" />
					<col width="15%" />
					</colgroup>
					<tr>
						<th>标题:</th>
						<td>
							<input type="text" name="title" id="title" class="text_casepian7" maxlength="200"/>
						</td>
						<th>起始时间:</th>
						<td>
							<input type="text" name="startDate" id="startDate" readonly="true" class="Wdate" style="width:90%;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})" />
						</td>
						<th>结束时间:</th>
						<td>
							<input type="text" name="endDate" id="endDate" readonly="true" class="Wdate" style="width:90%;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})" />
						</td>
					</tr>
				</table>
				<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path %>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
				</div>
		
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
					<col width="30%" />
					<col width="15%" />
					<col width="25%" />
                    </colgroup>
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>创建人员</th>
                        <th>创建时间</th>
                    </tr>
                  
                    <c:forEach var="data" items="${commonPage.dataList }" varStatus="status">
                       <tr>
							<td> ${ status.index + 1}</td>
							<td><a href="#" onclick="searchDetail(${data.id})"/>${data.mingchen}</a></td>
							<td>${data.createname }</td>
							<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd"/></td>
						</tr>	
                    </c:forEach>
             </table>
    
		 </div>
	</div>	
</div>
</form>  
</body>
</html>
