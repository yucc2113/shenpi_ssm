package com.base.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Logger;


public class FileUtil {
	static Logger logger = Logger.getLogger("com.cnt.common.util.FileUtil");
	public static boolean copy(String file1, String file2) {
		try {
			File file_in = new java.io.File(file1);
			File file_out = new java.io.File(file2);
			FileInputStream in1 = new FileInputStream(file_in);
			FileOutputStream out1 = new FileOutputStream(file_out);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = in1.read(bytes)) != -1) {
				out1.write(bytes, 0, c);
			}
			in1.close();
			out1.close();
			return (true); // if success then return true
		} catch (Exception exc) {
			exc.printStackTrace();
			return (false); //if fail then return false
		}
	}
	
	public static boolean delete(String dir) {
		try {
			File file = new java.io.File(dir);
			if(file.exists()) {
				String[] fileName = file.list();
				for(int i=0;i<fileName.length;i++) {
					File tFile = new File(dir+File.separator+fileName[i]);
					tFile.delete();
				}
				file.delete();
			}
			return (true); // if success then return true
		} catch (Exception exc) {
			exc.printStackTrace();
			return (false); 
			}
	}	
	
	public static void main(String[] args) {
		File file = new File("E:/chinabase/project/webapps/frtweb/WEB-INF/spring");
		File[] tFile = file.listFiles();
		for(int i=0;i<tFile.length;i++) {
			System.out.println("<value>/WEB-INF/enums/"+tFile[i].getName()+"</value>");
		}
	}
}
