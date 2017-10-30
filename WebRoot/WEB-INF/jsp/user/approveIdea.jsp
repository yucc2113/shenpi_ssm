<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/tld.inc"%>

<script type="text/javascript">
var P = window.parent, D = P.setDialog();
window.onload = function()
{
    P.addBtn( 'next', '确定', setValue );  //创建一个下一步按钮
    
    
}


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
	
<div  style=" display:block; margin:10px; overflow:auto; text-align: left; width:300px; height:200px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
</div>


		
<!--
right end-->
</body>
