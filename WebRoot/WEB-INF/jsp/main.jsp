<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/sub.css" rel="stylesheet" type="text/css">
<%@ include file="../../../inc/tld.inc"%>
<title>吉林大学协同办公系统</title>
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.table tr:odd').css('background', '#fff');
	$('.table tr:even').css('background', '#f8f8f8');
	$('.table tr:odd').hover(function(){
		$(this).css('background', '#fffdeb');
	},function(){
		$(this).css('background', '#fff');
	});
	$('.table tr:even').hover(function(){
		$(this).css('background', '#fffdeb');
	},function(){
		$(this).css('background', '#f8f8f8');
	});
});
</script>
<script type="text/javascript">
$(document).ready(function() {
	$('.btn_list').click(function(event) {
		var event = event || window.event;
		event.preventDefault();
		$(this).blur();
		var sn = $(this).attr('var');
		$('.btn_list').removeClass('selected');
		$(this).addClass('selected');
		$('.div_list').hide();
		$('#div_list' + sn).show();
	});
});
</script>

<script type="text/javascript">
function toXinwenDetail(id){
	document.forms.mainForm.action="${pageContext.request.contextPath}/news/newsDetail.action?id="+id+"&flag="+3;
	document.forms.mainForm.submit();	
}

function toNoticeDetail(id){
	document.forms.mainForm.action="${pageContext.request.contextPath}/notice/noticeDetail.action?id="+id+"&flag="+3;
	document.forms.mainForm.submit();
}

function toMeetDetail(id){
	document.forms.mainForm.action="${pageContext.request.contextPath}/meet/meetDetail.action?id="+id+"&tag="+3;
	document.forms.mainForm.submit();
}
function toFlowBiaodanDetail(id){
	document.forms.mainForm.action="${pageContext.request.contextPath}/flowBiaodan/detail.action?id="+id+"&flag="+3;;
	document.forms.mainForm.submit();	
}

function toDaishenpis(id,workId){
	document.forms.mainForm.action="biaodan!detail.action?id="+id+"&workId="+workId;
	document.forms.mainForm.submit();	
}

function toMyNewsList(){
	document.forms.mainForm.action="${pageContext.request.contextPath}/news/myList.action";
	document.forms.mainForm.submit();	
}
function toBiaodan(){
	document.forms.mainForm.action="${pageContext.request.contextPath}/flowBiaodan/myList.action";
	document.forms.mainForm.submit();
}
</script>
</head>
<body>
<form  name="mainForm" theme="simple" id="mainForm" method="post">
<div id="right">
	<div class="right_box">
		<div class="menu_div">
			<div class="menu_div"><ul class="menu_title">当前位置： 任务管理-我的首页</ul></div>
			
	
		<div style=" float:left; width:49%; height:160px;" >
		<div style=" float:left;width:100%; height:124px; margin-top:20px;" >
		   <table  width="100%">
		     <tr>
		       <td align="left" valign="top">
		          <a href="#"><font size="2">&nbsp;&nbsp;&nbsp;<b>我的流程</b></font></a>
		       </td>
		      <c:forEach begin="0" end="2" var="data" items="${flowList }">
		        <td align="left">
					<p><img src="<%=path %>/images/img01.gif" alt="" /></p><a href="#"  onclick="toBiaodan(${data.id})" >${data.flowName }</a>
			    </td>
		      </c:forEach>
		
	          <td align="left" valign="bottom">
	            <a href="${pageContext.request.contextPath}/flowdefine/myList.action"><font size="2">&nbsp;&nbsp;&nbsp;更多</font></a>
	    	  </td>
		    </tr>
		  </table>	
		</div>
		</div>
		<div style="float:right; width:50%; height:130px;  margin-top:30px;">
		    <iframe allowtransparency="true" frameborder="0" width="565" height="98" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=1&v=0&d=3&k=&f=1&q=1&e=1&a=1&c=54511&w=565&h=98"></iframe>
		</div>
		
		
		<div style=" float:left; width:50%; height:240px; ">
	    	<div class="box01">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<colgroup>
					<col width="6" />
					<col width="*" />
					<col width="6" />
				</colgroup>
				<tr>
					<td class="l_bg"></td>
					<td valign="top">
						<h2 class="tit">我的新闻</h2>
						<div class="scroll">
							<div class="box01_1">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<colgroup>
										<col width="5" />
										<col width="*" />
										<col width="5" />
									</colgroup>
									<tr>
										<td class="l_bg01"></td>
										<td valign="top">
											<ul class="menu">
												<li class="selected btn_list" var="1"><a href="javascript:;"><span>我的新闻</span></a></li>													
												<li class="btn_list" var="2"><a href="javascript:;"><span>我的通知</span></a></li>													
												<li class="btn_list" var="3"><a href="javascript:;"><span>我的会议</span></a></li>	
												<li class="btn_list" var="4"><a href="#" onclick="toMyNewsList()"><span>更多</span></a></li>
											</ul>
										</td>
										<td class="r_bg01"></td>
									</tr>
								</table>
							</div>
							<div class="box01_2 div_list" id="div_list1">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<colgroup>
										<col width="5" />
										<col width="*" />
										<col width="5" />
									</colgroup>
									<tr>
										<td class="l_bg02"></td>
										<td class="c_bg02">
											<table border="0" cellpadding="0" cellspacing="0" width="100%" class="table_style table">
												<tbody>
													<tr class="ac">
														<th class="ac">新闻标题</th>
														<th class="ac">发布单位</th>
														<th class="ac">发布时间</th>
													</tr>
													<c:forEach var="data" items="${newsCommonPage.dataList }">
													   	<tr>
															<td><a href="#" onclick="toXinwenDetail(${data.id})">${data.title}</a></td>
															<td>${data.createname}</td>
															<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd"/></td>
														</tr>
													</c:forEach>
													
												</tbody>
											</table>
										</td>
										<td class="r_bg02"></td>
									</tr>
								</table>
							</div>
							<div class="box01_2 div_list" style="display:none;" id="div_list2">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<colgroup>
										<col width="5" />
										<col width="*" />
										<col width="5" />
									</colgroup>
									<tr>
										<td class="l_bg02"></td>
										<td class="c_bg02">
											<table border="0" cellpadding="0" cellspacing="0" width="100%" class="table_style table">
												<tbody>
													<tr class="ac">
														<th class="ac">标题</th>
														<th class="ac">创建人</th>
														<th class="ac">创建时间</th>
													</tr>
													<c:forEach var="data" items="${noticeCommonPage.dataList }">
													   	<tr>
															<td><a href="#" onclick="toNoticeDetail(${data.id})">${data.title}</a></td>
															<td>${data.createname}</td>
															<td><fmt:formatDate value="${data.createdate }" pattern="yyyy-MM-dd"/></td>
														</tr>
													</c:forEach>
													
												</tbody>
											</table>
										</td>
										<td class="r_bg02"></td>
									</tr>
								</table>
							</div>
							<div class="box01_2 div_list" style="display:none;" id="div_list3">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<colgroup>
										<col width="5" />
										<col width="*" />
										<col width="5" />
									</colgroup>
									<tr>
										<td class="l_bg02"></td>
										<td class="c_bg02">
											<table border="0" cellpadding="0" cellspacing="0" width="100%" class="table_style table">
												<tbody>
													<tr class="ac">
														<th class="ac">标题</th>
														<th class="ac">创建人</th>
														<th class="ac">创建时间</th>
													</tr>
													<c:forEach var="data" items="${meetCommonPage.dataList }" begin="0" end="4">
													   	<tr>
															<td><a href="#" onclick="toMeetDetail(${data.id})">${data.name}</a></td>
															<td>${data.createname}</td>
															<td><fmt:formatDate value="${data.meetDate }" pattern="yyyy-MM-dd"/></td>
														</tr>
													</c:forEach>
													
												</tbody>
											</table>
										</td>
										<td class="r_bg02"></td>
									</tr>
								</table>
							</div>
							<div class="box01_3">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<colgroup>
										<col width="5" />
										<col width="*" />
										<col width="5" />
									</colgroup>
									<tr>
										<td class="l_bg03"></td>
										<td valign="top"></td>
										<td class="r_bg03"></td>
									</tr>
								</table>
							</div>
						</div>
					</td>
					<td class="r_bg"></td>
				</tr>
			</table>
		</div>
		</div>
		<div style=" float:right; width:50%; height:240px;">
		<div class="box01">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<colgroup>
					<col width="6" />
					<col width="*" />
					<col width="6" />
				</colgroup>
				<tr>
					<td class="l_bg"></td>
					<td valign="top">
						<h2 class="tit">待办事务</h2>
						<div class="scroll">
							<table border="0" cellpadding="0" cellspacing="0" width="100%" class="table_style table">
								<tbody>
									<tr class="ac">
										<th class="ac">标题</th>
										<th class="ac">创建人</th>
										<th class="ac">时间</th>
									</tr>
									<c:forEach var="data" items="${auditList}">
										   	<tr>
												<td><a href="#" onclick="toFlowBiaodanDetail(${data.id})">${data.mingchen}</a></td>
												<td>${data.createname}</td>
												<td><fmt:formatDate value="${data.createdate}" pattern="yyyy-MM-dd"/></td>
											</tr>
									</c:forEach>
									
								</tbody>
							</table>
						</div>
					</td>
					<td class="r_bg"></td>
				</tr>
			</table>
		</div>
		
	</div>
	</div>
</div>
</form>
</body>
</html>

 