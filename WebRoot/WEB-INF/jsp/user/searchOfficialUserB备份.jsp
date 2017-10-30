<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tld.inc"%>

<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
	$("#usersId").html(D.document.getElementById('usersId').value);
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
    
    
}

var userids= D.document.getElementById('userids').value;
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
			   // onlyLeafCheckable: false,//对树所有结点都可选
		    	frame: false,
		    	border:true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'meet!chooseUser.action',
		        	listeners: {
			            beforeload: function(treeLoader,node) {
			        		treeLoader.dataUrl = 'official!chooseUser.action?userids='+userids+"&deptId="+node.attributes.id;
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
				var ids = '', 
            	selNodes = get_tree.getChecked();
                Ext.each(selNodes, function(node){
                    if(ids.length>0){
                        ids += ',';
                    }
                    ids += node.id;
                });		
$("#userids").html(ids);
}
	
function toValue(node,checked){
	//SelectTree.getChildModeId(get_tree.getRootNode());

	var ids = "";
	var names= "";
	
	var ids1="";
	var names1 ="";
	
   	if(checked){
	   	if($("#userids").html()==""){
	   	  ids = node.id;
	   	}else{
	   	  ids = $("#userids").html()+","+node.id;	
	   	}
	   	
	   	if($("#usernames").html()==""){
	   	  names = node.text;
	   	}else{
	   	  names = $("#usernames").html()+","+node.text;	
	   	}
		 $("#userids").html(ids);
	     $("#usernames").html(names);
   	}else{
   		var userids = $("#userids").html().split(",");
   		var usernames = $("#usernames").html().split(",");
   		
   		for(i=0;i<userids.length;i++){
				if(node.id!=userids[i]){
					if(ids1==""){
					ids1 = userids[i] ;
					}else{
					ids1 = ids1+","+userids[i] ;
					}
				}
			}
			
		for(i=0;i<usernames.length;i++){
				if(node.text!=usernames[i]){
					if(names1==""){
					names1 = usernames[i] ;
					}else{
					names1 = names1+","+usernames[i] ;
					}
				}
			}
		$("#userids").html(ids1);
	    $("#usernames").html(names1);
   	}
}
function setValue(){
	    var id = $("#userids").html();
	    D.toSaveUser(id),
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
<input type="hidden" name="byId" id="byId" value="<%=request.getParameter("byId")%>" />
<input type="hidden" name="name" id="name" value="<%=request.getParameter("name")%>" />
	<div id="usernames" style="display:none;"></div>	
	<div id="userids" style="display:none;"></div>
	<div id="byId" style="display:none;"></div>
	
<div id="get_tree" style=" display:block; margin:10px; overflow:auto; text-align: left; width:260px; height:400px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
</div>


		
<!--
right end-->
</body>
