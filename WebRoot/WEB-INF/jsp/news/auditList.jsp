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
    var title;
    var startDate;
    var endDate;
$(document).ready(function() {
		  $('#right').height($(window).height());
		  $(window).resize(function() {
		      $('#right').height($(window).height());
	      });
		  pageNo = $("#pageNo").val();
		  pages = $("#pages").val();
		  total = $("#total").val();
		  title = $("#title").val();
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
				ajaxSubmit(n, title,startDate, endDate);
				this.selectPage(n);
				return false;
			},
			
	   }, true);

});


function ajaxSubmit(pageNum, title, startDate, endDate) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/news/ajaxNewsList.action',
			data : {
				pageNum : pageNum,
				title : title,
				startDate : startDate,
				endDate : endDate,
				audit: 1,
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
				    var state="";
				   
				    if( result.state==1)
				       state="待审批";
				    if( result.state==2)
				       state="审批通过";
				    if( result.state==3)
				       state="审批未通过";  
					html += "<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' />"
			    			+ "</td><td><a href='#' onclick='searchAuditDetail("+ result.id +")' >"+result.title+"</a>"
							+ "</td><td>" + result.createname
							+ "</td><td>" + shortDate(createdate)
							+ "</td><td>"+ state
							+ "</td></tr>"; 
				});
				$("#dataList").html(html);
				kkpager.generPageHtml({		
						pno : pageNo,	
						total : pages,
                    	totalRecords : total,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n) {
                            	ajaxSubmit(n, title,startDate, endDate);
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
		title = $("#title").val();
		startDate = $("#startDate").val();
	    endDate = $("#endDate").val();
	  
		if (startDate == "")
			startDate = null;
		if (endDate == "") {
			endDate = null;
		}
		ajaxSubmit(null, title, startDate, endDate);
		
	}

    function toClear() {
		$("#title").val('');
		$("#startDate").val('');
		$("#endDate").val('');
	}

	

	

function searchAuditDetail(id){
	document.forms.newsForm.action="${pageContext.request.contextPath}/news/auditDetail.action?id="+id;
	document.forms.newsForm.submit();	
}



</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form   validate="true" id="newsForm" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 新闻审批</ul></div>
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
						<th>开始时间:</th>
						<td>
							 <input type="text"  name="startDate" id="startDate" class="Wdate"  readonly="readonly" style="width:90%;"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})"/>
						</td>
						<th>结束时间:</th>
						<td>
							 <input type="text"  name="endDate" id="endDate" class="Wdate"  readonly="readonly" style="width:90%;"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})"/>
						</td>
					</tr>
				</table>
				<div class="project_21btn">
				<img src="<%=path %>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path %>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
				</div>
				<br />
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b11" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
					<col width="35%" />
					<col width="20%" />
					<col width="20%" />
					<col width="10%" />
                    </colgroup>
                    <tr>
                        <th>选择</th>
                        <th>标题</th>
                        <th>创建人员</th>
                        <th>创建时间</th>
                        <th>审批状态</th>
                    </tr>
                     <tbody id="dataList">
                        <c:forEach var="data" items="${commonPage.dataList }">
                          <tr>
                            <td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
							<td><a href="#" onclick="searchAuditDetail(${data.id })" >${data.title }</a></td>
							<td> ${data.createname}</td>
							<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd"/></td>
							<td>
							   <c:if test="${data.state==1 }">待审批</c:if>
							   <c:if test="${data.state==2}">审批通过</c:if>
							   <c:if test="${data.state==3}">审批未通过</c:if>
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
