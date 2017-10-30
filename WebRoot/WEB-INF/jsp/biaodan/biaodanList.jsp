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
<script type="text/javascript" src="<%=path%>/js/myself/DateFormat.js"></script>

<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<script  src="<%=path %>/js/myself/DateFormat.js" type="text/javascript"></script>

<script type="text/javascript">
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
			url : '${pageContext.request.contextPath}/flowBiaodan/ajaxList.action',
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
				     var state="";
				     if(result.state==1) state="未处理";
				     if(result.state==2) state="处理中...";
				     if(result.state==3) state="已通过";
				     if(result.state==4) state="未通过";
                     if(result.state==1) {
                        html+="<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' />"
                     }else{
                         html+="<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' disabled='disabled' />"
                     }
					html += "</td><td><a href='#' onclick='searchDetail("+result.id+")' >"+result.mingchen+"</a>"
							+ "</td><td>" + result.createname
							+ "</td><td>" + simpleDate(createdate)
							+ "</td><td>" + state
							+ "<a href='#' onclick='toChakanLiucheng("+result.id+")'><img src='${pageContext.request.contextPath}/images/chajie.png' height='20' width='20'  alt='查看任务进程' /></a>"
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
	
	
function searchDetail(id){
	document.forms.biaodanFrom.action="${pageContext.request.contextPath}/flowBiaodan/detail.action?id="+id;
	document.forms.biaodanFrom.submit();	
}
function toAdd(){
	document.forms.biaodanFrom.action="biaodan!myinit.action";
	document.forms.biaodanFrom.submit();	
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
			document.forms.biaodanFrom.action="${pageContext.request.contextPath}/flowBiaodan/update.action?id="+id;
			document.forms.biaodanFrom.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toChakanLiucheng(id){
	J.dialog.get('user',{ id: 'user',  title: '查看进程', page: 'biaodan!liuchengdetail.action?id='+id,width:'700', height:'200',cover: true });
}

function toDelete(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.biaodanFrom.action="${pageContext.request.contextPath}/flowBiaodan/delete.action";
				document.forms.biaodanFrom.submit();	
			}else{
				return false;
			}},width:250,height:160});
	}else{
		ymPrompt.alert({title:'信息提示',message:'请选择记录进行删除！',width:250,height:160});
		return false;
	}
}


</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form   validate="true" id="biaodanFrom" theme="simple" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 我的任务-任务列表</ul></div>
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
							<input type="text" name="searchName" id="searchName" class="text_casepian7" maxlength="200"/>
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
				<div class="project_3btn">
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
						<col width="25%" />
                    </colgroup>
	                    <tr>
	                        <th>选择</th>
	                        <th>标题</th>
	                        <th>创建人员</th>
	                        <th>创建时间</th>
	                        <th>状态</th>
	                    </tr>
	               <tbody id="dataList"> 
                      <c:forEach var="data" items="${commonPage.dataList}">
                        <tr>
                            <c:if test="${data.state==1 }"><td><input name="ids" type="checkbox" value="${data.id }" /></td></c:if>
							 <c:if test="${data.state!=1 }"><td><input name="ids" type="checkbox" value="${data.id }" disabled="disabled"/></td></c:if>
							<td><a href="#" onclick="searchDetail(${data.id})" >${data.mingchen }</a></td>
							<td> ${data.createname}</td>
							<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd"/></td>
							<td>
								<c:if test="${data.state==1 }">未处理</c:if>
								<c:if test="${data.state==2 }">处理中...</c:if>
								<c:if test="${data.state==3 }">已通过</c:if>
					     		<c:if test="${data.state==4 }">未通过</c:if>
                    			<a href="#" onclick="toChakanLiucheng(${data.id})" >
									<img src="<%=path %>/images/chajie.png" height="20" width="20"  alt="查看任务进程" />
								</a>
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
