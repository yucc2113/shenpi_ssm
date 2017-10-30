<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tld.inc"%>

<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
	$("#dealRole").html(D.document.getElementById('dealRole').value);
	$("#resultName").html(D.document.getElementById('libusername').value);
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
    
    
}

var userIds= D.document.getElementById('userIds').value;
var get_tree = null;
var SelectTree = function() {
	return {
        init: function() {
        	Ext.form.Field.prototype.msgTarget = "side";
        	Ext.BLANK_IMAGE_URL = "<%=path %>/extjs/resources/images/default/s.gif";
        	
        	 var user_root = new Ext.tree.AsyncTreeNode({
		        id: '-1',
		         text:'选择角色'
		    });
		    
		     get_tree = new Ext.tree.TreePanel({
		    	renderTo:'get_tree',
				useArrows:true,
		    	autoScroll:true,
		    	width: 248,
		    	height: 358,
		    	animate:true,
		    	enableDD:true,
		    	checkModel: "single",  
	    		onlyLeafCheckable: true,//对树所有结点都可选
		    	frame: false,
		    	border:true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'flowstep!chooseRole.action',
		        	listeners: {
			            beforeload: function(treeLoader,node) {
			        		treeLoader.dataUrl = '${pageContext.request.contextPath}/role/getRoleTree.action?';
			            }
			        },
			        	baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI }
		        }),
		        root:user_root
		    });
		     get_tree.expandAll();
		   //  module_root.expand();
		     get_tree.on('checkchange',function(node, checked){
				//setTimeout("clickModuleTree()","1000");
				toValue(node,checked);
				});
        	
        }
	 }   
}();
Ext.onReady(SelectTree.init, SelectTree);	
	
	
function toValue(node,checked){
	var ids = "";
	var names= "";
	
	var ids1="";
	var names1 ="";
	
   	if(checked){
	   	  ids = node.id;
	   	  names = node.text;
	   	
		 $("#dealRole").html(ids);
	     $("#resultName").html(names);
   	}else{
   		var dealRole = $("#dealRole").html().split(",");
   		var resultName = $("#resultName").html().split(",");
   		
   		for(i=0;i<dealRole.length;i++){
				if(node.id!=dealRole[i]){
					if(ids1==""){
					ids1 = dealRole[i] ;
					}else{
					ids1 = ids1+","+dealRole[i] ;
					}
				}
			}
			
		for(i=0;i<resultName.length;i++){
				if(node.text!=resultName[i]){
					if(names1==""){
					names1 = resultName[i] ;
					}else{
					names1 = names1+","+resultName[i] ;
					}
				}
			}
		$("#dealRole").html(ids1);
	    $("#resultName").html(names1);
   	
   	}
  
}
function setValue(){
	    var id = $("#dealRole").html();
	    var name = $("#resultName").html();
	    D.document.getElementById('dealRole').value=id;
	    D.document.getElementById('libusername').value=name;
	    D.document.getElementById('stepType').value='2';
		P.cancel();
	
}
window.onunload = onunload_handler;   
function onunload_handler(){   
	P.cancel();
}   
</script>
<body>
<!--right start
../user/selectUser.jsp?id=memberuserid&name=memberusername
more=1  只能选择一个人
id   表示主页面要赋值的用户ID变量名
name 表示主页面要赋值的用户Name变量名
-->
<input type="hidden" name="more" id="more" value="<%=request.getParameter("more")%>" />
<input type="hidden" name="id" id="id" value="<%=request.getParameter("id")%>" />
<input type="hidden" name="name" id="name" value="<%=request.getParameter("name")%>" />
	<div id="resultName" style="display:none;"></div>	
	<div id="dealRole" style="display:none;"></div>
	
<div id="get_tree" style=" display:block; margin:10px; overflow:auto;text-align: left; width:250px; height:360px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
</div>


		
<!--
right end-->
</body>
