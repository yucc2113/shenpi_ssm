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
<title></title>
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />

<script type="text/javascript">
var pages  ;
var pageNo;
var total ;
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	pageNo = $("#pageNo").val();
	pages = $("#pages").val();
	total = $("#total").val();
	kkpager.generPageHtml({		
	     	pno : pageNo,
			total : pages,
			totalRecords : total,
	    	mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				ajaxSubmit(n);
				this.selectPage(n);
				return false;
			},
			
	   }, true);
	
	
});
   function ajaxSubmit(pageNo) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/role/ajaxRoleList.action',
			data : {pageNo : pageNo},
			success : function(data) {
				$("#pageNo").val(data.pageNo);
		    	$("#pages").val(data.pages);
				$("#total").val(data.total);
				pages = data.pages;
				pageNo = data.pageNo;
				total = data.total;
				$("#roledata").html("");
				$("#kkpager").html("");
				var html = "";
				$.each(data.dataList, function(i, role) {
					html += "<tr><td><input name='ids' type='checkbox' value='" + role.id+" class='input'/>"
							+ "</td><td><a href='#' onclick='toLook('" + role.id+");return false;'>"+role.rolename+"</a>"
							+ "</td></tr>";
				});
				$("#roledata").html(html);
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n);
								this.selectPage(n);
								return false;
						},
											
		          }, true);

		      },
		});
	}	
	
function toAdd(){
	 document.forms.roleForm.action="${pageContext.request.contextPath}/role/roleAdd.action";
	 document.forms.roleForm.submit();
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
			alert(id);
			document.forms.roleForm.action="${pageContext.request.contextPath}/role/roleUpdate.action?id="+id;
			document.forms.roleForm.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDelete(){
var number = checkIds('ids');
alert(number);
	if(number>0){
		ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
		if(tp=='ok'){
		    document.forms.roleForm.action="${pageContext.request.contextPath}/role/roleDelete.action";
			document.forms.roleForm.submit();
			return true;
		}else{
			return false;
		}},width:250,height:160});	
	}else{
			ymPrompt.alert({title:'信息提示',message:'选择至少一条记录进行删除!',width:250,height:160});
		}
}
function toLook(id){
	 document.forms.roleForm.action="${pageContext.request.contextPath}/role/roleUpdate.action?id="+id;
	 document.forms.roleForm.submit();
}
function toClear(){
	$("#prop").val('');
	$("#parentId").val('-1');
}

function toSearch(){
	document.forms.roleForm.action="role!roleList.action";
	document.forms.roleForm.submit();	
}
</script>

<style>
#kkpager{
   text-align:center;
   padding-left:150px;
}
</style>
</head>


<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>

<form  validate="true" id="roleForm" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 角色管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<br />
			<div class="project_3btn">
				<img src="<%=path %>/images/btn/btn_03.gif" alt="新增"  onclick="toAdd();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdate();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDelete();return false;"style="cursor:pointer" />
			</div>
			<br />
		
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="10%" />
					<col width="*" />
                    </colgroup>
                    <tr>
                        <th>选&nbsp;&nbsp;&nbsp;&nbsp;择</th>
                        <th>角色名称</th>
                    </tr>
                    <tbody id="roledata">
                       <c:forEach var="role" items="${commonPage.dataList}">
                        <tr>
							<td><input name="ids" type="checkbox" value="${role.id }" class="input" /></td>
							<td><a href="#" onclick="toLook(${role.id});return false;">${role.rolename }</a></td>
						</tr>	
                    </c:forEach>
                    </tbody>
                    
                   
             </table>
                  
            <!-- 底部分页按钮 -->  
             <div id="kkpager"></div>
                 
                 
                 
                 
		 </div>
	</div>	
</div>
 </form>  
</body>
</html>
