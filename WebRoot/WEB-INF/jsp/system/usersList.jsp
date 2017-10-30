<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../../../inc/tld.inc"%>
<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<script type="text/javascript">
/* $(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	
	var tag = $('#tag').val();
	if(tag ==1){
		ymPrompt.alert({title:'信息提示',message:'密码重置成功！',width:250,height:160});
	}
	
}); */
	
function toAdd(){
	 document.forms.usersFrom.action="users!usersAdd.action";
	 document.forms.usersFrom.submit();
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
			document.forms.usersFrom.action="users!usersUpdate.action?id="+id;
			document.forms.usersFrom.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDelete(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.usersFrom.action="users!usersDelete.action";
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
	$("#roleId").val('-1');
	$("#searchName").val('');
	$("#deptId").val('-1');
}

function toSearch(){
	document.forms.usersFrom.action="users!usersList.action";
	document.forms.usersFrom.submit();	
}

function toReset(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要重置密码吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.usersFrom.action="users!usersReset.action";
				document.forms.usersFrom.submit();	
				return true;
			}else{
				return false;
			}},width:250,height:160});
	}else{
		ymPrompt.alert({title:'信息提示',message:'请选择记录进行密码重置！',width:250,height:160});
		return false;
	}
}
function toLook(id){
	 document.forms.usersFrom.action="users!usersUpdate.action?id="+id;
	 document.forms.usersFrom.submit();
}


  var pageNo;
	var pages;
	var total;
	var deptId;
    
	$(document).ready(function() {
		  $('#right').height($(window).height());
		  $(window).resize(function() {
		      $('#right').height($(window).height());
	      });
	    
	      
		  pageNo = $("#pageNo").val();
		  pages = $("#pages").val();
		  total = $("#total").val();
		  deptId=$("#deptId").val();
		 
		  kkpager.generPageHtml({
				
	        //当前页
	     	pno : pageNo,
			//总页码
			total : pages,
			//总数据条数
			totalRecords : total,
	    	mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				ajaxSubmit(n,deptId);
				this.selectPage(n);
				return false;
			},	
	   }, true); 

    });


function ajaxSubmit(pageNum,deptId) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/dept/ajaxDeptList.action',
			data : {
				pageNum : pageNum,
				deptId :deptId,
				
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
				  var index=(pageNo-1)*10+i+1;
				   
					html += "<tr><td>"+index
			    			+ "</td><td><a href='#' onclick='toLook(" +result.id+");return false;'>"+result.username+"</a></td>"
							+ "</td><td>" +result.deptname
							+ "</td><td>" +result.rolename
							+ "</td><td>人员"
							+ "</td></tr>";
				});
				$("#dataList").html(html);
				
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n,deptId);
								this.selectPage(n);
								return false;
						},
											
		        }, true);

		    }
		});
	}


</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<input type="hidden" id="deptId" />
<form action="users!usersList.action"  validate="true" id="usersFrom" theme="simple">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 人员管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			
			
				 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
					<col width="30%" />
					<col width="35%" />
					<col width="15%" />
					<col width="15%" />
                    </colgroup>
                    <tr>
                        <th>序&nbsp;&nbsp;&nbsp;&nbsp;号</th>
                        <th>名&nbsp;&nbsp;&nbsp;&nbsp;称</th>
                        <th>上级名称</th>
                        <th>角色</th>
                        <th>类&nbsp;&nbsp;&nbsp;&nbsp;别</th>
                    </tr>
                   	<tbody id="dataList">
					    <c:forEach var="data" items="${commonPage.dataList }" varStatus="index">
                 		  <tr>
							<td>${index.index+1 }</td>
							<td><a href="#" onclick="toLook(${data.id});return false;">${data.username }</a></td>
							<td>${data.deptname }</td>
							<td>${data.rolename }</td>
							<td>人员</td>
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
