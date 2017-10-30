<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.add {
                background-image:url(${pageContext.request.contextPath}/images/user.gif) !important;  
   }
.add1 {
                background-image:url(${pageContext.request.contextPath}/images/grid.gif) !important;  
   }
</style>
<%@ include file="../../../inc/tld.inc"%>
<script  src="<%=path %>/js/kkpager/jquery-1.10.2.min.js" type="text/javascript"></script>
<script  src="<%=path %>/js/kkpager/kkpager.js" type="text/javascript"></script>
<link  href="<%=path %>/js/kkpager/kkpager_blue.css" rel="stylesheet"   type="text/css" />
<script type="text/javascript">

var get_dept_tree = null;
var dept = function() {
	return {
        init: function() {
        	Ext.form.Field.prototype.msgTarget = "side";
        	Ext.BLANK_IMAGE_URL = "<%=path %>/extjs/resources/images/default/s.gif";
			
	//角色			
	var users_root = new Ext.tree.AsyncTreeNode({
        id: '-1',
        text:'组织结构'
    });
     get_dept_tree = new Ext.tree.TreePanel({
    	renderTo:'get_dept_tree',
    	id:'deptTree',
    	name:'deptTree',
    	width: 206,
    	collapsible: true, 
    	region: 'left',
		height:300,
    	split: true,
       	checkModel: 'cascade',   //对树的级联多选   
   		onlyLeafCheckable: true,//对树所有结点都可选
       	animate:true,
       	border: true,
       	autoScroll :true,
       	rootVisible:true,
        loader: new Ext.tree.TreeLoader({
        	dataUrl: 'dept!getDeptTree.action',
        	listeners: {
	            beforeload: function(treeLoader,node) {
	        		treeLoader.dataUrl = '${pageContext.request.contextPath}/dept/getDeptTree.action?deptId='+node.attributes.id;
	            }
	        }
        }),
        root:users_root
    });
    users_root.expand();
    get_dept_tree.on('click',function(node){
     	checkUser(node.id);
		});
        }
	 }   
}();


Ext.onReady(dept.init, dept);
$(document).ready(function() {
	$('#right').height($(window).height()+1400);
	$(window).resize(function() {
		$('#right').height($(window).height()+1400);
	});
	
});
	

function reloadExt(){
	Ext.getCmp('deptTree').root.reload();
}


function checkUser(id){
		$('#deptId').val(id);
		ajaxSubmit(null,id);
}


function toAddDept(){
	var deptId = $('#deptId').val();
	$('#state').val(1);
	if(deptId ==""){
		ymPrompt.alert({title:'信息提示',message:'请选择上级部门进行添加!',width:250,height:160});
	}else{
		J.dialog.get('toAddDept',{ id: 'toAddDept',  title: '部门添加', page: '${pageContext.request.contextPath}/dept/deptAdd.action?parentid='+deptId,width:'500', height:'250', rang: true});
	}
	
}


function toUpdateDept(){
	var deptId = $('#deptId').val();
	$('#state').val(2);
	
	if(deptId ==""){
		ymPrompt.alert({title:'信息提示',message:'请选择上级部门进行添加!',width:250,height:160});
	}else{
		J.dialog.get('toUpdateDept',{ id: 'toUpdateDept',  title: '部门修改', page: '${pageContext.request.contextPath}/dept/deptUpdate.action?deptId='+deptId,width:'500', height:'250', rang: true});
	}
}

function toDeleteDept(){
	var deptId = $('#deptId').val();
	ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除？',handler: function(tp){
			if(tp=='ok'){
			   $.ajax({
			      type : "post",
			      url : '${pageContext.request.contextPath}/dept/deptDelete.action',
		          data : {deptId :deptId},
		          success:function(data){
		             alert(data);
		             document.forms.deptFrom.action="${pageContext.request.contextPath}/user/init.action";
				     document.forms.deptFrom.submit();
		          }
		       });
							}else{
				return false;
			}},width:250,height:160});
}

function toAddUser(){
	var deptId = $('#deptId').val();
	if(deptId ==""){
		ymPrompt.alert({title:'信息提示',message:'请选择部门进行添加!',width:250,height:160});
	}else{
       document.forms.deptFrom.action="${pageContext.request.contextPath}/user/userAdd.action?deptId="+deptId;
       document.forms.deptFrom.submit();
    }

}

function toUpdateUser(){
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
			document.forms.deptFrom.action="${pageContext.request.contextPath}/user/userUpdate.action?id="+id;
			document.forms.deptFrom.submit();				
		}else{
			ymPrompt.alert({title:'信息提示',message:'选择一条记录进行编辑!',width:250,height:160});
		}
}

function toDeleteUser(){
			
	var number = checkIds('ids');
	if(number>0){
		 ymPrompt.confirmInfo({title:'信息确认',message:'确认要删除吗？',handler: function(tp){
			if(tp=='ok'){
				document.forms.deptFrom.action="${pageContext.request.contextPath}/user/userDelete.action";
				document.forms.deptFrom.submit();
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
		J.dialog.get('toUpdateDept',{ id: 'toUpdateDept',  title: '修改', page: 'dept!usersUpdate.action?byId='+id+"&deptIds="+id,width:'700', height:'350', rang: true});
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
		  deptId=$("deptId").val();
		 
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
			url : '${pageContext.request.contextPath}/user/ajaxUserList.action',
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
				
					html += "<tr><td><input name='ids' type='checkbox' value='"+result.id+"' class='input' />"
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
<form validate="true" id="deptFrom" theme="simple" method="post">
<input type="hidden" name="deptId" id = "deptId" />
<input type="hidden" name="state" id = "state" />
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置：部门管理</ul></div>
	</div>
	<div id="contant">
		<div class="com_contant">
			<br />
			
			
			<div class="project_4btn">
				<img src="<%=path %>/images/btn/1.gif" alt="新增"  onclick="toAddDept();return false;" style="cursor:pointer" />
				<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdateDept();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDeleteDept();return false;"style="cursor:pointer" />
			</div>
			<div class="project_3btn">
				<img src="<%=path %>/images/btn/2.gif" alt="新增人"  onclick="toAddUser();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_02.gif" alt="编辑"  onclick="toUpdateUser();return false;" style="cursor:pointer" />
				&nbsp;
				<img src="<%=path %>/images/btn/btn_01.gif" alt="删除" onclick="toDeleteUser();return false;"style="cursor:pointer" />
			</div>
			
			
			 <div id="get_dept_tree" layoutH="100" style="display:none; float:left; display:block;text-align: left; margin:0px; overflow:auto; width:18%; height:20%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			
			</div>
			<div layoutH="100" style="display:none; float:right; display:block;text-align: left; margin:0px; overflow:auto; width:80%; height:20%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
	
			  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_list_b1" summary="公告信息">
                    <caption>公告信息表</caption>
                    <colgroup>
                    <col width="5%" />
                    
					<col width="30%" />
					<col width="30%" />
					<col width="15%" />
					<col width="15%" />
                    </colgroup>
                    <tr>
                        <th></th>
                       
                        <th>名&nbsp;&nbsp;&nbsp;&nbsp;称</th>
                        <th>上级名称</th>
                        <th>角色</th>
                        <th>类&nbsp;&nbsp;&nbsp;&nbsp;别</th>
                    </tr>
                   	<tbody id="dataList">
					    <c:forEach var="data" items="${commonPage.dataList }" varStatus="index">
                 		  <tr>
                 		   <td><input name="ids" type="checkbox" value="${data.id }" class="input" /></td>
						
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
             </br>
             </br>
           
         
		 </div>
	</div>	
</div>
</form> 
</body>
</html>
