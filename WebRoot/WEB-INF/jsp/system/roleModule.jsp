<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tld.inc"%>
<script type="text/javascript">
var get_module_tree = null;
var get_role_tree = null;
var roleId=0;
//栏目
var moduleRole = function() {
	return {
        init: function() {
        	Ext.form.Field.prototype.msgTarget = "side";
        	Ext.BLANK_IMAGE_URL = "<%=path %>/extjs/resources/images/default/s.gif";
            var module_root = new Ext.tree.AsyncTreeNode({
		        id: '-1',
		        text:'栏目列表'
		    });
		    
		     get_module_tree = new Ext.tree.TreePanel({
		    	renderTo:'get_module_tree',
				useArrows:true,
		    	autoScroll:true,
		    	width: 348,
		    	height: 448,
		    	animate:true,
		    	enableDD:true,
		    	checkModel: 'cascade',   //对树的级联多选   
	    		onlyLeafCheckable: false,//对树所有结点都可选
		    	frame: false,
		    	border:true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: '${pageContext.request.contextPath}/roleModule/getModuleTree.action',
		        	listeners: {
			            beforeload: function(treeLoader,node) {
			        		treeLoader.dataUrl = '${pageContext.request.contextPath}/roleModule/getModuleTree.action?parentId='+node.attributes.id+"&roleId="+roleId;
			            }
			        },
			        	baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI }
		        }),
		        root:module_root
		    });
		     get_module_tree.expandAll();
		   //  module_root.expand();
		     get_module_tree.on('checkchange',function(node, checked){
				//setTimeout("clickModuleTree()","1000");
				clickModuleTree();
			});
			
	//角色			
	var role_root = new Ext.tree.AsyncTreeNode({
        id: '-1',
        text:'角色组'
    });
     get_role_tree = new Ext.tree.TreePanel({
    	renderTo:'get_role_tree',
    	width: 248,
		height: 348,
    	split: true,
       	checkModel: 'cascade',   //对树的级联多选   
   		onlyLeafCheckable: false,//对树所有结点都可选
       	animate:true,
       	border: true,
        loader: new Ext.tree.TreeLoader({
        	dataUrl: '${pageContext.request.contextPath}/roleModule/getRoleTree.action',
        	listeners: {
	            beforeload: function(treeLoader,node) {
	        		treeLoader.dataUrl = "${pageContext.request.contextPath}/roleModule/getRoleTree.action?parentId="+node.attributes.id+"&roleId="+roleId;
	            }
	        }
        }),
        root:role_root
    });
    role_root.expand();
    get_role_tree.on('click',function(node){
     	clickRoleTree(node.id);
		});
        }
	 }   
}();


Ext.onReady(moduleRole.init, moduleRole);
function clickModuleTree(){
	var ids = '';
    var selNodes = get_module_tree.getChecked();
    Ext.each(selNodes, function(node){
        if(ids.length > 0){
        	ids += ',';
        }
        
        ids +=  node.id;
    });
    document.getElementById("moduleIds").value=ids;
    }
 
function clickRoleTree(id){
document.getElementById("moduleIds").value="";
document.getElementById("byId").value=id;
	roleId = id; 
	get_module_tree.root.reload();
	get_module_tree.expandAll();
 }
    
$(document).ready(function() {
	$('#right').height($(window).height());
	$(window).resize(function() {
		$('#right').height($(window).height());
	});
});

function roleModuleSave(){
	document.forms.moduleRoleform.action="${pageContext.request.contextPath}/roleModule/roleModuleSave.action";
	document.forms.moduleRoleform.submit();
}
function toClear(){
    var selNodes = get_module_tree.getChecked();
    Ext.each(selNodes, function(node){
        if(ids.length > 0){
        	ids += ',';
        }
        
        ids +=  node.id;
    });
}

</script>
<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 权限管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<form  name="moduleRoleform"  validate="true" theme="simple" id="moduleRoleform" method="post">
			<input type="hidden" name="moduleIds" id="moduleIds"/>
			<input type="hidden" name="byId" id="byId"/>
			<div id="get_role_tree" layoutH="80" style=" float:left; text-align: left; display:block; margin:10px; overflow:auto; width:350px; height:350px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			</div>
			<div id="get_module_tree" layoutH="80" style=" float:left;text-align: left;  display:block; margin:10px; overflow:auto; width:350px; height:350px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			</div>
		  </form>
			<div class="project_21btn fl" style="margin-left:-65px;">
			<a href="#" onclick="roleModuleSave();return false;"><img src="../images/btn/btn_08.gif" alt="保存" /></a>&nbsp;
			</div>
	</div>	
</div>











