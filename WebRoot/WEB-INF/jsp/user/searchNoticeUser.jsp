<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tld.inc"%>
<style type="text/css">
.add {
                background-image:url(${pageContext.request.contextPath}/images/user.gif) !important;  
   }
.add1 {
                background-image:url(${pageContext.request.contextPath}/images/grid.gif) !important;  
   }
</style>
<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
	$("#usersId").html(D.document.getElementById('usersId').value);
	$("#usersName").html(D.document.getElementById('usersName').value);
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
    
    
}

var usersId= D.document.getElementById('usersId').value;
var get_tree = null;
var SelectTree = function() {
	return {
        init: function() {
        	Ext.form.Field.prototype.msgTarget = "side";
        	Ext.BLANK_IMAGE_URL = "<%=path %>/extjs/resources/images/default/s.gif";
        	
        	 var user_root = new Ext.tree.AsyncTreeNode({
		        id: '-1',
		         text:'选择人员'
		    });
		    
		     get_tree = new Ext.tree.TreePanel({
		    	renderTo:'get_tree',
				useArrows:true,
		    	autoScroll:true,
		    	width: 258,
		    	height: 398,
		    	animate:true,
		    	enableDD:true,
		    	checkModel: 'cascade',   //对树的级联多选   
			    //onlyLeafCheckable: true,//对树所有结点都可选
		    	frame: false,
		    	border:true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'notice!chooseUser.action',
		        	listeners: {
			            beforeload: function(treeLoader,node) {
			        		treeLoader.dataUrl = '${pageContext.request.contextPath}/user/getUserTreeWithDept.action?deptId='+node.attributes.id;
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
				toValue1(node,checked);
				});
        	
        }
	 }   
}();
Ext.onReady(SelectTree.init, SelectTree);	

function toValue1(node,checked){
 
				var ids = '';
				var names = '';
            	selNodes = get_tree.getChecked();
            	
                Ext.each(selNodes, function(node1){
                    
                    var temp=node1.id+"";
               
                    if(temp.indexOf("2")==0){
                       var tempId=temp.substring(1);             
                       if(ids.length>0){
                          ids += ',';
                          names +=',';
                       }   
                        ids += tempId;
                        names += node1.text;
                    }
                   
                });		
$("#usersId").html(ids);
$("#usersName").html(names);
}
 
function setValue(){
	    var id = $("#usersId").html();
	    var name = $("#usersName").html();
	    D.document.getElementById('usersId').value=id;
	    D.document.getElementById('usersName').value=name;
	    D.selectnum();
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
	<div id="usersName" style="display:none;"></div>	
	<div id="usersId" style="display:none;"></div>
	<div id="num" style="display:none;"></div>
	
<div id="get_tree" style=" display:block; margin:10px; overflow:auto; width:260px;text-align: left; height:400px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
</div>


		
<!--
right end-->
</body>
