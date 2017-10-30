<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tld.inc"%>

<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
	$("#deptids").html(D.document.getElementById('deptids').value);
	$("#deptname").html(D.document.getElementById('deptname').value);
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
    
    
}

var deptids= D.document.getElementById('deptids').value;
var get_tree = null;
var SelectTree = function() {
	return {
        init: function() {
        	Ext.form.Field.prototype.msgTarget = "side";
        	Ext.BLANK_IMAGE_URL = "<%=path %>/extjs/resources/images/default/s.gif";
        	
        	 var user_root = new Ext.tree.AsyncTreeNode({
		        id: '-1',
		         text:'选择部门'
		    });
		    
		     get_tree = new Ext.tree.TreePanel({
		    	renderTo:'get_tree',
				useArrows:true,
		    	autoScroll:true,
		    	width: 258,
		    	height: 398,
		    	animate:true,
		    	enableDD:true,
	    		onlyLeafCheckable: true,//对树所有结点都可选
		    	frame: false,
		    	border:true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'flowdefine!chooseDept.action',
		        	listeners: {
			            beforeload: function(treeLoader,node) {
			        		treeLoader.dataUrl = '${pageContext.request.contextPath}/dept/getDeptTree.action?deptId='+node.attributes.id;
			            }
			        },
			        	baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI }
		        }),
		        root:user_root
		    });
		     get_tree.expandAll();
		 
		     get_tree.on('checkchange',function(node, checked){
				
				toValue(node,checked);
				});
        	
        }
	 }   
}();
Ext.onReady(SelectTree.init, SelectTree);	
	
	
function toValue(node,checked){
	
	
             	var ids = '';
				var names = '';
            	selNodes = get_tree.getChecked();
            	
                Ext.each(selNodes, function(node1){
            
                       if(ids.length>0){
                          ids += ',';
                          names +=',';
                        }   
                        ids += node1.id;
                        names += node1.text;         
                });	
		$("#deptids").html(ids);
	    $("#deptname").html(names);
}
function setValue(){
         
	    var id = $("#deptids").html();
	    var name = $("#deptname").html();
        D.document.getElementById('deptids').value=id;
	    D.document.getElementById('deptname').value=name;
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
	<div id="deptname" style="display:none;"></div>	
	<div id="deptids" style="display:none;"></div>
	
<div id="get_tree" style=" display:block; margin:10px; text-align: left;overflow:auto; width:260px; height:400px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
</div>


		
<!--
right end-->
</body>
