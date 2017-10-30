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
<script src="<%=path %>/js/jquery-1.3.2.min.js" type="text/javascript"></script>

<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<script  src="<%=path %>/js/myself/DateFormat.js" type="text/javascript"></script>
<style>
#kkpager{
   text-align:center;
   padding-left:150px;
}
</style>
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
	function toClear() {
		$("#searchName").val('');
		$("#startDate").val('');
		$("#endDate").val('');
	}

	function ajaxSubmit(pageNum, searchName, startDate, endDate) {
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/systemlog/ajaxLogList.action',
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
				    var creatdate = new Date(result.creatdate);
					html += "<tr><td>" + result.creatusername
			    			+ "</td><td>" + result.logcontent
							+ "</td><td>" + shortDate(creatdate)
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
</script>




</head>
<body>

<form action="systemlog/logList.action"  validate="true" id="systemlogFrom" theme="simple">
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 系统日志查看</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="人员基本信息表">
					<caption>人员基本信息</caption>
				   <colgroup>
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					</colgroup>
					<tr>
						<th>操作人:</th>
						<td>
						   <input type="text" name="searchName" id="searchName" class="text_casepian7"/>
							
						</td>
						<th>起始时间:</th>
						<td>
						    <input type="text" name="starDate" id="startDate" class="Wdate" readonly="readonly" style="width:90%;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})"/>
							
						</td>
						<th>结束时间:</th>
						<td>
						     <input type="text" name="endDate" id="endDate" class="Wdate" readonly="readonly" style="width:90%;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd  HH:mm:ss'})"/>
						
						</td>
					</tr>
				</table>
			</div>
			
			<div class="project_21btn">
				<img src="<%=path%>/images/btn/btn_05.gif" alt="查询" onclick="toSearch();return false;" style="cursor:pointer"/>
				&nbsp;
				<img src="<%=path%>/images/btn/btn_04.gif" alt="清空" onclick="toClear();return false;" style="cursor:pointer"/>
			</div>
			<ajaxanywhere:zone name="ajaxanywhere_dataList">
			<hidden id="fenye" name="fenye"/>
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                  
					<col width="10%" />
					<col width="*" />
					<col width="20%" />
                    </colgroup>
                    <tr>
                    	<th>操作人</th>
                        <th>操作内容</th>
                        <th>操作时间</th>
                    </tr>
                    <tbody id="dataList">
                      <c:forEach items="${commonPage.dataList }" var="data">
						<tr>
						
							<td>${data.creatusername}</a></td>
							<td>${data.logcontent}</td>
							<td> <fmt:formatDate value="${data.creatdate }" pattern="yyyy-MM-dd HH:mm:ss"/>  
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
<form>  
</body>

   
</html>
