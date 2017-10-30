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
	

function searchDetail(id){
	document.forms.defineBiaodanFrom.action="dingyi!detail.action?id="+id;
	document.forms.defineBiaodanFrom.submit();	
}
function toAdd(){
	document.forms.defineBiaodanFrom.action="${pageContext.request.contextPath}/udefineBiaodan/biaodanAdd.action";
	document.forms.defineBiaodanFrom.submit();	
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
			document.forms.defineBiaodanFrom.action="udingyi!updatedetail.action?id="+id;
			document.forms.defineBiaodanFrom.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}
function toDelete(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.defineBiaodanFrom.action="dingyi!delete.action";
				document.forms.defineBiaodanFrom.submit();	
			}else{
				return false;
			}},width:250,height:160});
	}else{
		ymPrompt.alert({title:'信息提示',message:'请选择记录进行删除！',width:250,height:160});
		return false;
	}
}

function updatebiaodan(id){
	document.forms.defineBiaodanFrom.action="udingyi!updatebiaodan.action?id="+id;
	document.forms.defineBiaodanFrom.submit();	
}

</script>
</head>
<body>
<form validate="true" id="defineBiaodanFrom" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 流程管理-定义表单</ul></div>
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
							<input type="text" name="title" id="title" cssClass="text_casepian7" maxlength="200"/>
						</td>
						<th>开始时间:</th>
						<td>
							 <input type="text" name="beginDate" id="beginDate" cssClass="text_casepian7" maxlength="200"/>
						</td>
						<th>结束时间:</th>
						<td>
							 <input type="text"name="endDate" id="endDate" cssClass="text_casepian7" maxlength="200"/>
						</td>
					</tr>
				</table>
				<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path %>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
				</div>
				<div class="project_3btn">
					<img src="<%=path %>/images/btn/btn_03.gif" alt="编辑"  onclick="toAdd();return false;" style="cursor:pointer" />
					&nbsp;
					<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdate();return false;" style="cursor:pointer" />
					&nbsp;
					<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDelete();return false;"style="cursor:pointer" />
				</div>
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b11" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
					<col width="30%" />
					<col width="15%" />
					<col width="25%" />
                    </colgroup>
                    <tr>
                        <th>选择</th>
                        <th>标题</th>
                        <th>创建人员</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    <tbody id="dataList">
                        <c:forEach var="data" items="${commonPage.dataList }">
                          <tr>
							<td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
							<td><a href="#" onclick="searchDetail(${data.id})" >${data.mingchen }</a></td>
							<td> ${data.createname}</td>
							<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd" /></td>
							<td><a href="#" onclick="updatebiaodan(${data.id})" >设计表单</a></td>
						</tr>	
                        </c:forEach>
                    
                    </tbody>
                    
                   
             </table>
		 </div>
	</div>	
</div>
</s:form>  
</body>
</html>
