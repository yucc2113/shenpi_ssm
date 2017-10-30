<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.io.*,java.sql.*" %>
<%@ include file="connectionInfo.jsp"%>
<%@ include file="FilePathInfo.jsp"%>
<%@ include file="../inc/tld.inc"%>
<%
boolean isNewFile ;
String filetype="";
String fileId="";
String fileName="";
String fileUrl="";
String attachFileName="";
String attachFileDescribe="";
String attachFileUrl="";
String templateFileUrl="templateFile/";//新建文档模板url
String otherData="";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
fileId = request.getParameter("FileId")==null?"":request.getParameter("FileId").toString().trim();
filetype = "word";
String filename = (String)request.getAttribute("filename");

String uploadfilepath = "";
if(null != filename &&filename.length()>0){
	uploadfilepath = "uploadOfficeFile/"+filename+".doc";
}else{
	uploadfilepath = "templateFile/newWordTemplate.doc";
}
if(fileId=="")
{isNewFile = true;}
else
{isNewFile = false;}
if(isNewFile)
{
	filetype=request.getParameter("fileType")==null?"":request.getParameter("fileType").trim();//如果filetype参数为空,默认为word文档.
	if(filetype.equalsIgnoreCase("excel"))
	{	
		fileName="新建Excel文档.xls";
		templateFileUrl=templateFileUrl+"newExcelTemplate.xls";
	}
	else if(filetype.equalsIgnoreCase("word")){
		fileName="新建word文档.doc";
		templateFileUrl= path + "/templateFile/newWordTemplate.doc";
	}
	else if(filetype.equalsIgnoreCase("ppt"))
	{
		fileName="新建ppt文档.ttp";
		templateFileUrl=templateFileUrl+"newPptTemplate.ppt";	
	}else{
		filetype="word";
		fileName="新建word文档.doc";
		templateFileUrl=uploadfilepath;
	}
	fileUrl=templateFileUrl;//如果是新文档，控件打开新建模板文档
}
else
{
	try
	{Class.forName(DBDriver);}
	catch(java.lang.ClassNotFoundException e)
	{out.println("Error:" + e.getMessage());}
	try
	{
		conn = DriverManager.getConnection(ConnStr,userName,userPasswd);    
		stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	} 
	catch(SQLException e)
	{out.println("Error:" + e.getMessage());}
	rs = stmt.executeQuery("select * from "+officeFileInfoTableName+" where id="+fileId); 
	if(rs.next())
	{
		fileName = rs.getString("FILENAME");	
		fileUrl = relativeOfficeFileUrl+rs.getString("FILENAMEDISK");
		otherData = rs.getString("OTHERDATA");
		filetype=rs.getString("filetype");
		if(filetype.equalsIgnoreCase("Word.Document"))
		{filetype="word";}
		else if(filetype.equalsIgnoreCase("Excel.Sheet"))
		{filetype="excel";}
		else if(filetype.equalsIgnoreCase("PowerPoint.Show"))
		{filetype="ppt";}
		else{filetype="othertype";}
		attachFileDescribe = rs.getString("ATTACHFILEDESCRIBE")==null?"":rs.getString("ATTACHFILEDESCRIBE").trim();
		attachFileName = rs.getString("ATTACHFILENAMEDISK")==null?"":rs.getString("ATTACHFILENAMEDISK").trim();
		attachFileUrl=attachFileName.equalsIgnoreCase("")?"":(relativeAttachFileUrl+attachFileName);
	}
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	if(conn != null)conn.close();	
}
	/***************************************************************
	计算印章列表的字符串
	***************************************************************/
									String espFilesList="";
                  class Filter implements FilenameFilter   
								  {   
									  String extension;      
									  Filter(String extension)   
									  {   
									  	this.extension = extension;   
									  }    
									  public boolean accept(File myFile,String filename)   
									  {   
									  	return filename.endsWith("."+extension);   
									  }   
								  }   
									File espPath = new File(absoluteSecSignFileDir);   
				          File[] fileList;     
				          fileList=espPath.listFiles(new Filter("esp"));   
							if(null != fileList){
				          for(int i=0;i<fileList.length;i++) 
				          {
				          	espFilesList+=" <option value=\""+relativeSecSignFileDir+fileList[i].getName()+"\">"+fileList[i].getName()+"</option>";
				          }
						  }
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="IE=7" http-equiv="X-UA-Compatible" /> 
		<!--设置缓存-->
		<meta http-equiv="cache-control" content="no-cache,must-revalidate">
		<meta http-equiv="pragram" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link href="<%=path %>/official/StyleSheet.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
		<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="<%=path %>/js/formValid/jquery_last.js" type="text/javascript"></script>
		<script src="<%=path %>/js/formValid/formValidator.js" type="text/javascript" charset="UTF-8"></script>
		<script src="<%=path %>/js/formValid/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
		<script src="<%=path %>/js/formValid/DateTimeMask.js" type="text/javascript"></script>
		<script src="<%=path %>/official/OfficeContorlFunctions.js" type="text/javascript" ></script>
		<title></title>
		<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
$(document).ready(function() {
var myDate = new Date();
var mytime= myDate.toLocaleTimeString();
var a=mytime.split(":");
var times = a[0]*60*60*1000+a[1]*60*1000+a[2]*1000;
$('#filenames').val(times);

	$('#right').height($(window).height()-2);
	$(window).resize(function() {
		$('#right').height($(window).height()-2);
	});
	
	$.formValidator.initConfig({formid:"officialAddform",onerror:function(msg){return false}});
	$("#filename").formValidator({onshow:"输入公文名称",onfocus:"输入公文名称",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "输入公文名称!"});
	$("#wenhao").formValidator({onshow:"输入文号",onfocus:"输入文号",oncorrect:" "}).inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"不能有空符号"},onerror: "输入文号!"});
	$("#img1").click(function(){
		if(jQuery.formValidator.pageIsValid("1")){
				//document.forms.officialAddform.action="official!officialSave.action";
				//document.forms.officialAddform.submit();	
				var filename = $('#filename').val();
				var filenames = $('#filenames').val();
				submitNTKO(filenames);
				document.forms.officialAddform.action="official!officialSave.action?states=1";
				document.forms.officialAddform.submit();
		}
	})
});


      function submitNTKO(tag){
          var saveURL = "<%=path%>/upload";
          var result = OFFICE_CONTROL_OBJ.saveToURL(saveURL,"ntkoFile","",tag,0 );
      }

function toClear(){
	document.officialAddform.reset();
}
function toReturn(){
	document.forms.officialAddform.action="official!mylist.action";
	document.forms.officialAddform.submit();
}

function chooseUser(){
	var userids = $("#userids").val();
	J.dialog.get('user',{ id: 'user',  title: '选择人员', page: '../user/searchofficialUser.jsp?userids='+userids,width:'300', height:'485',cover: true });
}
</script>
</head>
<body onload='intializePage("<%=fileUrl%>")' >


<div id="right">
	<div class="right_box">
		<div class="menu_div"><ul class="menu_title">当前位置： 公文管理</ul></div>
	</div>
		<div class="com_contant">
			<br />
			<div style=" float:left; width:45px;">
			</div>
			<div style=" float:right;  text-align: left;">
			<s:form id="officialAddform" action="official!officialList.action" name="officialAddform" validate="true" theme="simple" style="padding:0px;margin:0px;">
			<s:hidden name="id" id="id" />
			<table width="91.5%" border="0" cellspacing="0" cellpadding="0" class="data_list_b">
				<colgroup>
				<col width="10%" />
				<col width="20%" />
				<col width="20%" />
				<col width="10%" />
				<col width="20%" />
				<col width="20%" />
				</colgroup>
				<tr>
					<th>公文名称:</th>
					<td colspan="2">
						<s:hidden name="filenames" id="filenames"/>
						<s:property value="filename"/>
					</td>
					<th>文号:</th>
					<td colspan="2">
						<s:property value="wenhao"/>
					</td>
					</tr>
		  </table>
		</s:form>
		</div>	
			
			<form id="officialform" action="<%=path %>/official/upLoadOfficeFile.jsp" name="officialform" validate="true" theme="simple"   enctype="multipart/form-data" style="padding:0px;margin:0px;">
			<s:hidden id="id" name="id"/>
			 <div id="editmain" class="editmain">
       
        <div id="editmain_middle" class="editmain_middle">
        <div id="editmain_right" class="editmain_right">
               
                    <!--<b style="font-size:12px;color:red;">[以上为最基本的文档调用电子印章功能演示,如不能使用,请点击<a href="downLoadedFiles\NTKOSecHandSignDemoSetup.exe">这里</a>下载"安全签名印章系统"]</b><br>-->
                </div>
           
			
            
		  <div id="officecontrol">
		 <%-- 
             <script type="text/javascript" src="<%=path%>/official/ntkoofficecontrol.js"></script>
            --%>   
               
            <object id="TANGER_OCX" classid="clsid:A39F1330-3322-4a1d-9BF0-0BA2BB90E970" codebase="<%=path%>/official/OfficeControl.cab#version=5.0.2.2" width="100%" height="100%"> 
			<param name="IsUseUTF8URL" value="-1">
			<param name="IsUseUTF8Data" value="-1">
			<param name="BorderStyle" value="1">
			<param name="BorderColor" value="14402205">
			<param name="TitlebarColor" value="15658734">
			<param name="TitlebarTextColor" value="0">
			<param name="MenubarColor" value="14402205">
			<param name="MenuButtonColor" VALUE="16180947">
			<param name="MenuBarStyle" value="3">
			<param name="MenuButtonStyle" value="7">
			<param name="WebUserName" value="NTKO">
			<param name="Caption" value="">
			<SPAN STYLE="color:red">不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</SPAN>
			</object>
            <%-- 
			<object id="TANGER_OCX"  classid="clsid:C9BC4DFF-4248-4a3c-8A49-63A7D317F404"  codebase="<%=path %>/official/OfficeControl.cab#version=4,0,0,5" width="100%" height="100%">
			 --%>   
								<script language="JScript" for=TANGER_OCX event="OnDocumentClosed()">
									setFileOpenedOrClosed(false);
								</script>
								<script language="JScript" for="TANGER_OCX" event="OnDocumentOpened(TANGER_OCX_str,TANGER_OCX_obj)">
									
									OFFICE_CONTROL_OBJ.activeDocument.saved=true;//saved属性用来判断文档是否被修改过,文档打开的时候设置成ture,当文档被修改,自动被设置为false,该属性由office提供.
									//获取文档控件中打开的文档的文档类型
									switch (OFFICE_CONTROL_OBJ.doctype)
									{
										case 1:
											fileType = "Word.Document";
											fileTypeSimple = "wrod";
											break;
										case 2:
											fileType = "Excel.Sheet";
											fileTypeSimple="excel";
											break;
										case 3:
											fileType = "PowerPoint.Show";
											fileTypeSimple = "ppt";
											break;
										case 4:
											fileType = "Visio.Drawing";
											break;
										case 5:
											fileType = "MSProject.Project";
											break;
										case 6:
											fileType = "WPS Doc";
											fileTypeSimple="wps";
											break;
										case 7:
											fileType = "Kingsoft Sheet";
											fileTypeSimple="et";
											break;
										default :
											fileType = "unkownfiletype";
											fileTypeSimple="unkownfiletype";
									}
									setFileOpenedOrClosed(true);
								</script>
									<script language="JScript" for=TANGER_OCX event="BeforeOriginalMenuCommand(TANGER_OCX_str,TANGER_OCX_obj)">
									alert("BeforeOriginalMenuCommand事件被触发");
								</script>
								<script language="JScript" for=TANGER_OCX event="OnFileCommand(TANGER_OCX_str,TANGER_OCX_obj)">
									if (TANGER_OCX_str == 3) 
									{
										alert("不能保存！");
										CancelLastCommand = true;
									}
								</script>
								<script language="JScript" for=TANGER_OCX event="AfterPublishAsPDFToURL(result,code)">
									result=trim(result);
									alert(result);
									document.all("statusBar").innerHTML="服务器返回信息:"+result;
									if(result=="文档保存成功。")
									{window.close();}
								</script>
								<script language="JScript" for=TANGER_OCX event="OnCustomMenuCmd2(menuPos,submenuPos,subsubmenuPos,menuCaption,menuID)">
								alert("第" + menuPos +","+ submenuPos +","+ subsubmenuPos +"个菜单项,menuID="+menuID+",菜单标题为\""+menuCaption+"\"的命令被执行.");
								</script>
                </div>
		   </div>
        </div>
		  <form>
		  
		  <div class="project_21btn fl">
					
					<a href="#" onclick="toReturn();return false;"><img src="images/btn/btn_09.gif" alt="返回" /></a>&nbsp;&nbsp;
					</br>
			</div>
			
	</div>
</div>
</body>
</html>
