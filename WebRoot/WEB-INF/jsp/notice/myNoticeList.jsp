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
    var startDate;
    var endDate;
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
		  startDate = $("#startDate").val();
		  endDate = $("#endDate").val();
		  if (startDate == "")
				startDate = null;
		  if (endDate == "") {
		      endDate = null;
	     }
		kkpager.generPageHtml({
				
	        //当前页
	     	pno : pageNo,
			//总页码
			total : pages,
			//总数据条数
			totalRecords : total,
	    	mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				ajaxSubmit(n, searchName,startDate, endDate);
				this.selectPage(n);
				return false;
			},
			
	   }, true);

});


function ajaxSubmit(pageNum, searchName, startDate, endDate) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/notice/ajaxMyList.action',
			data : {
				pageNum : pageNum,
				searchName : searchName,
				startDate : startDate,
				endDate : endDate,
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
					
				    var createdate = new Date(result.createdate);
				  
					html += "<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' />"
			    			+ "</td><td><a href='#' onclick='toLook("+ result.id +");return false' >"+result.title+"</a>"
							+ "</td><td>" + longDate(createdate)
							+ "</td><td>" + result.createname
							+ "</td><td style='white-space: nowrap;overflow:hidden;text-overflow:ellipsis;'>"+ result.usersName
							+ "</td></tr>"; 
				});
				$("#dataList").html(html);
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n, searchName,startDate, endDate);
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
		startDate = $("#startDate").val();
	    endDate = $("#endDate").val();
	  
		if (startDate == "")
			startDate = null;
		if (endDate == "") {
			endDate = null;
		}
		ajaxSubmit(null, searchName, startDate, endDate);
		
	}
	
	
	
	



function toClear(){
	$("#searchName").val('');
	$("#startDate").val('');
	$("#endDate").val('');
}



function toLook(id){
	 document.forms.noticeFrom.action="${pageContext.request.contextPath}/notice/noticeDetail.action?id="+id+"&flag="+2;
	 document.forms.noticeFrom.submit();
}
</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form  validate="true" id="noticeFrom" theme="simple" method="post">
<input type="hidden" id="tag" name="tag"/>
<input type="hidden" name="flag" id="flag"/>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的通知</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="通知基本信息表">
					<caption>通知基本信息</caption>
					<colgroup>
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					</colgroup>
					<tr>
						<th>通知:</th>
						<td>
							<input type="text" name="searchName" id="searchName"  class="text_casepian7"/>
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
			</div>
			<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path %>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
			</div>
			
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" style="table-layout:fixed"  summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
					<col width="35%" />
					<col width="20%" />
					<col width="15%" />
					<col width="*" />
                    </colgroup>
                    <tr>
                        <th>序&nbsp;&nbsp;&nbsp;&nbsp;号</th>
                        <th>标题</th>
                        <th>通知时间</th>
                        <th>创建人</th>
                        <th>参与人员</th>
                        
                    </tr>
                     <tbody id="dataList">
                         <c:forEach var="data" items="${commonPage.dataList }">
                            <tr>
							   <td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
							   <td><a href="#" onclick="toLook(${data.id});return false;">${data.title }</a></td>
							   <td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd HH:mm:ss EEEE"/></td>
							   <td>${data.createname}</td>
							   <td  style="white-space: nowrap;overflow:hidden;text-overflow:ellipsis;">${data.usersName}</td>
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
