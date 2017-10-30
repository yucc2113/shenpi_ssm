<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*,java.io.*"%>
<%@page import="java.net.*" %>

<%
	String filepath = request.getRealPath("/printer") + "\\";
	String filename = request.getParameter("filename");
	 //String name=new String(request.getParameter("oldname").getBytes("ISO-8859-1"),"GB2312");
	byte b[] = new byte[600];
	File files = new File(filepath + filename);
	if (!files.exists()) {
%>
<script> 
parent.ymPrompt.alert({title:'信息提示',message:'下载文件不存在',width:250,height:160});
window.history.back();
</script>
<%
	} else {
		OutputStream outStream = response.getOutputStream();
		response.setContentType("application/x-msdownload;charset=utf-8");

		String down=URLEncoder.encode(filename);
		//System.out.println(down);
		response.setHeader("content-disposition",
				"attachment;filename=" + down);
		FileInputStream in = new FileInputStream(files);
		int n = 0;
		while ((n = in.read(b)) != -1) {
			outStream.write(b, 0, n);
		}
		in.close();
		outStream.flush();
		outStream.close();
		out.clear();
		out = pageContext.pushBody();

	}
%>


