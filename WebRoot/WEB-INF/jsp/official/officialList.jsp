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
			url : '${pageContext.request.contextPath}/official/ajaxOfficialList.action',
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
				    if( result.state==1){
				    	html += "<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' />";
				    }
				       state="待审批";
				    if( result.state==2){
				  
				       state="审批通过";
				      html += "<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' disabled='disabled'/>";
				         }
				    if( result.state==3){
				        state="审批未通过";  
				        html += "<tr><td><input name='ids' type='checkbox' value='" + result.id+"' class='input' disabled='disabled'/>";
				    }
				    	
				    
					html += "</td><td>" +result.filename
					        +"</td><td>" +result.wenhao
			    			+ "</td><td style='white-space: nowrap;overflow:hidden;text-overflow:ellipsis;'>" +result.usersName
			    			+ "</td><td>" +result.createname
							+ "</td><td>" + longDate(createdate)
							+ "</td><td>" +  state
						
							+ "</td><td><a href='#' onclick='toLook("+result.id +")' >查看公文</a>"
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

function toAdd(){
	 document.forms.OfficialForm.action="${pageContext.request.contextPath}/official/officialAdd.action";
	 document.forms.OfficialForm.submit();
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
			document.forms.OfficialForm.action="${pageContext.request.contextPath}/official/update.action?id="+id;
			document.forms.OfficialForm.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDelete(){
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.OfficialForm.action="${pageContext.request.contextPath}/official/delete.action";
				document.forms.OfficialForm.submit();
				return true;
			}else{
				return false;
			}},width:250,height:160});
	}else{
		ymPrompt.alert({title:'信息提示',message:'请选择记录进行删除！',width:250,height:160});
		return false;
	}
}





function toLook(id){
	 document.forms.OfficialForm.action="${pageContext.request.contextPath}/official/detail.action?id="+id;
	 document.forms.OfficialForm.submit();
}


function toSaveUser(userids){
	var byId = $("#byId").val();
	document.forms.OfficialForm.action="official!toSaveUser.action?userids="+userids+"&byId"+byId;
	document.forms.OfficialForm.submit();
}


function chooseUser(id){
	var userids = $("#userids").val();
	$("#byId").val(id);
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '${pageContext.request.contextPath}/user/searchOfficialUser.action?zhuId='+id,width:'300', height:'485',cover: true });
}
function selectUser(id){ 
      	    $.ajax({
			type : "post",
		
			url : "${pageContext.request.contextPath}/official/selectUser.action",
			data:"id="+id+"&usersId="+$("#usersId").val(),
			success: function(result) {
			$("#names").html(result);
 				return;
			}
		});
		
	}

</script>
</head>
<body>
<input type="hidden" id="pages" value="${commonPage.pages }"/>
<input type="hidden" id="pageNo" value="${commonPage.pageNo }"/>
<input type="hidden" id="total" value="${commonPage.total }"/>
<form  validate="true" id="OfficialForm" theme="simple" method="post">
<input type="hidden" id="tag" name="tag"/>
<input type="hidden" id="byId" name="byId"/>
<input type="hidden" id="userids" name="userids"/>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 公文管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			<div class="cl">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b" summary="会议基本信息表">
					<caption>会议基本信息</caption>
					<colgroup>
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					<col width="10%" />
					<col width="23%" />
					</colgroup>
					<tr>
						<th>公文名称:</th>
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
			<div class="project_3btn">
				<img src="<%=path %>/images/btn/btn_03.gif" alt="新增"  onclick="toAdd();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdate();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDelete();return false;"style="cursor:pointer" />
			</div>
			
			 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="4%" />
                    <col width="15%" />
					<col width="15%" />

					<col width="20%" />
					<col width="8%" />
					<col width="20%" />
					<col width="10%" />
					<col width="*" />
                    </colgroup>
                    <tr>
                        <th>选择</th>
                        <th>公文名称</th>
                        <th>文号</th>
                        
                        <th>人员</th>
                         <th>创建人</th>
                        <th>创建时间</th>
                        <th>审批状态</th>
                         <th>查看</th>
                    </tr>
                    <tbody id="dataList">
                    <c:forEach var="data" items="${commonPage.dataList }">
                      <tr>
                            <td> 
                               <c:if test="${(data.state==2) ||(data.state==3)}">
                                  <input name="ids" type="checkbox" value="${data.id }" class="input" disabled="disabled"/></td>
                               </c:if>  
                                <c:if test="${(data.state!=2) && (data.state!=3)}">
                                  <input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
                               </c:if> 
                              </td>  
							<td>${data.filename}</td>
							<td>${data.wenhao}</td>	
							<td style="white-space: nowrap;overflow:hidden;text-overflow:ellipsis;">${data.usersName}</td>
							<td>${data.createname}</td>
							<td><fmt:formatDate value="${data.createdate}" pattern="yyyy-MM-dd HH:mm:ss EEEE"/></td>
							<td> 
							   <c:if test="${data.state==1 }">待审批</c:if>
							   <c:if test="${data.state==2}">审批通过</c:if>
							   <c:if test="${data.state==3}">审批未通过</c:if>
							</td>
							<td><a href="#" onclick="toLook(${data.id });return false;">查看公文</a> </td>
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
