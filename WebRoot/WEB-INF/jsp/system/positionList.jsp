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
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>


<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<title></title>
<style>
#kkpager{
   text-align:center;
   padding-left:150px;
}
</style>
<script type="text/javascript">

var pageNo;
	var pages;
	var total;
    var searchName;
   
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
	
	
          pageNo = $("#pageNo").val();
		  pages = $("#pages").val();
		  total = $("#total").val();
		  searchName = $("#searchName").val();
		kkpager.generPageHtml({
				
	        //当前页
	     	pno : pageNo,
			//总页码
			total : pages,
			//总数据条数
			totalRecords : total,
	    	mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				ajaxSubmit(n, searchName);
				this.selectPage(n);
				return false;
			},
			
	   }, true);
});
	
	function ajaxSubmit(pageNum, searchName) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/position/ajaxPositionList.action',
			data : {
				pageNum : pageNum,
				searchName : searchName,
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
				 
					html += "<tr><td><input name='ids' type='checkbox' value=''" + result.id+"class='input'"
			    			+ "</td><td><a href='#' onclick='toLook(" + result.id+");return false;'>"+result.name+"</a>"			
							+ "</td></tr>";
				});
				$("#dataList").html(html);
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n, searchName);
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
		alert("hi");
		ajaxSubmit(null, searchName);
		
}
function toClear(){
	$("#searchName").val('');
}



function toAdd(){
	 document.forms.positionFrom.action="${pageContext.request.contextPath}/position/positionAdd.action";
	 document.forms.positionFrom.submit();
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
			document.forms.positionFrom.action="${pageContext.request.contextPath}/position/positionUpdate.action?id="+id;
			document.forms.positionFrom.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDelete(){
var number = checkIds('ids');
	if(number>0){
		ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
		if(tp=='ok'){
			 document.forms.positionFrom.action="${pageContext.request.contextPath}/position/positionDelete.action";
			document.forms.positionFrom.submit();
			return true;
		}else{
			return false;
		}},width:250,height:160});	
	}else{
			ymPrompt.alert({title:'信息提示',message:'选择至少一条记录进行删除!',width:250,height:160});
		}
}
function toLook(id){
	 document.forms.positionFrom.action="${pageContext.request.contextPath}/position/positionUpdate.action?id="+id;
	 document.forms.positionFrom.submit();
}


</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form  validate="true" id="positionFrom" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 岗位管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="岗位基本信息表">
					<caption>岗位基本信息</caption>
					<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="35%" />
					</colgroup>
					<tr>
						<th>岗&nbsp;位&nbsp;名&nbsp;称:</th>
						<td colspan="3">
							<input type="text" name="searchName" id="searchName" class="text_casepian7"/>
						</td>
					</tr>
				</table>
			</div>
			<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path %>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
			</div>
			<div class="project_3btn">
				<img src="<%=path %>/images/btn/btn_03.gif" alt="新增"  onclick="toAdd();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdate();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDelete();return false;"style="cursor:pointer" />
			</div>
			<br />
			
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <colgroup>
                    <col width="10%" />
					<col width="*" />
                    </colgroup>
                    <tr>
                        <th>选&nbsp;&nbsp;&nbsp;&nbsp;择</th>
                        <th>岗位名称</th>
                    </tr>
                    <tbody id="dataList">
                        <c:forEach var="data" items="${commonPage.dataList}">
                        <tr>
							<td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
							<td><a href="#" onclick="toLook(${data.id});return false;">${data.name }</a></td>
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
