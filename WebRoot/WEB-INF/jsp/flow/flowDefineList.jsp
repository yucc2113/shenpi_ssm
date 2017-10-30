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
<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<script  src="<%=path %>/js/myself/DateFormat.js" type="text/javascript"></script>

<script type="text/javascript">
/**
    *定义全局变量
   */
	var pageNo;
	var pages;
	var total;
    var searchName;
    var isEnabled;
	$(document).ready(
	
	function() {
		  $('#right').height($(window).height());
		  $(window).resize(function() {
		      $('#right').height($(window).height());
	      });
		  pageNo = $("#pageNo").val();
		  pages = $("#pages").val();
		  total = $("#total").val();
		  searchName = $("#searchName").val();
		  var options=$("#isEnabled option:selected");  //获取选中的项
		  isEnabled=options.val() //拿到选中项的值
		kkpager.generPageHtml({
				
	        //当前页
	     	pno : pageNo,
			//总页码
			total : pages,
			//总数据条数
			totalRecords : total,
	    	mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				ajaxSubmit(n, searchName,isEnabled);
				this.selectPage(n);
				return false;
			},
			
	   }, true);

});


function ajaxSubmit(pageNum, searchName, isEnabled) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/flowdefine/ajaxList.action',
			data : {
				pageNum : pageNum,
				searchName : searchName,
				isEnabled: isEnabled
			},
			success : function(data) {
				$("#pageNo").val(data.pageNo);
		    	$("#pages").val(data.pages);
				$("#total").val(data.total);
				pages = data.pages;
				pageNo = data.pageNo;
				total = data.total;
				$("#dataList").html("");
				$("#kkpager").html("");
				var html = "";
				
				$.each(data.dataList, function(i, result) {	
	                var isEnable="";
				    if( result.isEnabled==1)
				       isEnable="可用";
				    if( result.isEnabled==2)
				       isEnable="不可用";
             
					html += "<tr><td><input name='ids' type='checkbox' value='"+result.id+"' class='input' />"
					        +"</td><td>" +result.id
			    			+ "</td><td><a href='#' onclick='toLook("+result.id+")'>"+result.flowName+"</a>" 
			    			+ "</td><td>" +result.flowDesc
							+ "</td><td>" + result.deptname
							
							+ "</td><td><a href='#' onclick='updateFlow("+result.id +")' >设计步骤</a>"
							+            " &nbsp;&nbsp;<a href='#' onclick='addBiaodan("+result.id+")'>选择表单</a>"
							+ "</td><td>" + isEnable
							+ "</td></tr>"; 
				});
				$("#dataList").html(html);
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n, searchName,isEnabled);
								this.selectPage(n);
								return false;
						},
											
		          }, true);

		      },
		});
	}

function toSearch() {
		pageNo = $("#pageNo").val();
		pages = $("#pages").val();
		total = $("#total").val();
		searchName = $("#searchName").val();
		 var options=$("#isEnabled option:selected");  //获取选中的项
		 isEnabled=options.val() //拿到选中项的值
	  
		ajaxSubmit(null, searchName, isEnabled);
		
	}
	


	function toReset(){
		$("#searchName").val('');
		$("#isEnabled").val('-1');
	}
	
	function toAdd(){
	   
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/add.action";
		document.forms.flowdefineForm.submit();
	}
	function toEdit(){
		var number = checkIds('ids');
		if(number==1){
		    var id;
			var ids = document.getElementsByName("ids");
			for(var i=0 ;i<ids.length;i++){
				if(ids[i].checked){
					id = ids[i].value;
				}
			}	
			document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/update.action?id="+id;
			document.forms.flowdefineForm.submit();
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行修改编辑!',width:250,height:160});
		}	
	}
	
	function toLook(id){
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/detail.action?id="+id;
		document.forms.flowdefineForm.submit();
	}
	function toDelete(){
		var number = checkIds('ids');
		if(number>0){
			 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
				if(tp=='ok'){
					document.flowdefineForm.action="flowdefine!flowDefineDelete.action";
					ajaxAnywhere.submitAJAX();
					return true;
				}else{
					return false;
				}},width:250,height:160});
		}else{
			ymPrompt.alert({title:'信息提示',message:'请选择记录删除！',width:250,height:160});
		}
	}
	

	function updateFlow(id){
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowstep/list.action?flowId="+id;
		document.forms.flowdefineForm.submit();
	}
	
	function addBiaodan(id){
		document.forms.flowdefineForm.action="${pageContext.request.contextPath}/flowdefine/addBiaodan.action?id="+id;
		document.forms.flowdefineForm.submit();
	}
	
	function loadFlow(id){
		window.location.href="flowstep!flowStepLoadTu.action?flowId="+id;
	}
	
</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form   validate="true" id="flowdefineForm" theme="simple" method="post">
<input type="hidden" id="error" name="error"/>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 首页-系统管理-流程管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="人员基本信息表">
					<caption>人员基本信息</caption>
					<colgroup>
						<col width="20%" />
                        <col width="30%" />
                        <col width="20%" />
                        <col width="30%" />
					</colgroup>
					<tr>
						<th>流程名称</th>
						<td>
							<input type="text" name="searchName" id="searchName" class="text_318"/>
						</td>
						<th>是否可用</th>
						<td>
							<select id="isEnabled" name="isEnabled" class="select_318">
							   <option value="-1">请选择</option>
							   <option value="1">可用</option>
							   <option value="2">不可用</option>
							</select>
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
     				<img src="<%=path %>/images/btn/btn_14.gif" alt="添加" style="cursor:pointer"  onclick="toAdd()"/>
     				&nbsp;&nbsp;
					<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑" style="cursor:pointer"  onclick="toEdit()"/>
			</div>
			
			<input type="hidden" id="fenye" name="fenye"/>
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="流程定义管理列表">
                        <caption>
                   		     流程列表
                        </caption>
                        <colgroup>
                        <col width="5%" />
                        <col width="10%" />
                        <col width="20%" />
                        <col width="20%" />
                        <col width="15%" />
                        <col width="20%" />
                        <col width="*" />
                        </colgroup>
                        <tr>
                            <th>选择</th>
                            <th>流程ID</th>
                            <th>流程名称</th>
                            <th>流程描述</th>
                            <th>部门</th>
                            <th>操作</th>
                            <th>是否可用</th>                            
                        </tr>
                        
                    <tbody id="dataList">
                      <c:forEach var="data" items="${commonPage.dataList }">
                        <tr>
							<td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
							<td>${data.id}</td>
                            <td><a href="#" onclick="toLook(${data.id});return false;">${data.flowName}</a></td>
                            <td>${data.flowDesc}</td>
                            <td>${data.deptname}</td>
						    <td><a href="#" onclick="updateFlow(${data.id})" >设计步骤</a>
						        &nbsp;&nbsp;<a href="#" onclick="addBiaodan(${data.id})" >选择表单</a>
						    </td>
							
							<td>
                            	<c:if test="${data.isEnabled==1}">可用</c:if>
                            	<c:if test="${data.isEnabled==2}">不可用</c:if>
                            </td>           
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
