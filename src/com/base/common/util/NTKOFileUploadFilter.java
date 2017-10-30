package com.base.common.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Ausevil
 */
public class NTKOFileUploadFilter implements Filter {
    public NTKOFileUploadFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        String reqUrl = httpReq.getServletPath();
        reqUrl = reqUrl.endsWith("/") ? reqUrl.substring(0, reqUrl.length() - 1) : reqUrl;

        if (reqUrl.equals("/upload")) {
            upload(httpReq, httpRes);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void upload(HttpServletRequest rqust, HttpServletResponse rspns) {

        rspns.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = rspns.getWriter();
            rqust.setCharacterEncoding("UTF-8");
            StringBuilder sb = new StringBuilder();
            FileItem officeFileItem = null;//接收文档控件数据的FileItem类
            FileItem attachFileItem = null;//接收上传附件数据的FileItem类
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置最多只允许在内存中存储的数据,单位:字节
            factory.setSizeThreshold(4096);
            // 设置一旦文件大小超过setSizeThreshold()的值时数据存放在硬盘的目录
            factory.setRepository(new File("D:/tmp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置允许用户上传文件大小,单位:字节
            upload.setSizeMax(1024 * 1024 * 10);
            List fileItems = null;
            try {
                fileItems = upload.parseRequest(rqust);
            }catch (FileUploadException e) {
                out.println(e.getMessage());
            }
            if (fileItems == null) {
                return;
            }
            Iterator iter = fileItems.iterator();
            String filenames = "";
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                //打印提交的文本域和文件域名称
                if (item.isFormField()) {
                    if (item.getFieldName().equalsIgnoreCase("submitName")) {
                        String fileName = item.getString("utf-8").trim();
                        sb.append("文档名称:").append(fileName);
                    }
                    if (item.getFieldName().equalsIgnoreCase("fileType")) {
                        String fileType = item.getString("utf-8").trim();
                        sb.append("\n文档类型:").append(fileType);
                    }
                } else {
                    if (item.getFieldName().equalsIgnoreCase("attachFile")) {
                        attachFileItem = item;
                        sb.append("\n已经取得附件数据:").append(attachFileItem.getName());
                    }
                    if (item.getFieldName().equalsIgnoreCase("ntkoFile")) {
                        officeFileItem = item;
                        try {
							item.write(new File(rqust.getSession().getServletContext().getRealPath("/")+"uploadOfficeFile/"+item.getName()+".doc"));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
                        sb.append("\n已经取得文档控件中的文档数据！数据长度:").append(officeFileItem.getSize());
                    }
                }
            }
           // out.println(sb.toString());

        } catch (IOException ex) {
            out.println(ex);
        } finally {
            out.close();
        }
    }
    
   

    /**
     * Destroy method for this filter 
     */
    public void destroy() {
    }

    /**
     * Init method for this filter 
     */
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Return a String representation of this object.
     */
    public String toString() {
        return ("NTKOFileUploadFilter");
    }
    
}
