<%!
	/******************************************
	说明:此文件是用来显示文件列表的
	*******************************************/
	//这儿需要修改成您的数据库连接信息
	
	public String userName="ccgj";//数据库用户名
	public String userPasswd="123456"; //密码
	public String dbName="shenpi";	   //数据库名
	
	public String officeFileInfoTableName = "shenpi.official";
	public String htmlFileInfoTableName = "shenpi.official"; //表名	
	public String pdfFileInfoTableName = "shenpi.official" ;

	public String DBDriver = "com.mysql.jdbc.Driver"; 
	public String ConnStr = "jdbc:mysql://192.168.0.6:3306/"+dbName+"?useUnicode=true&characterEncoding=utf-8&user="+userName+"&password="+userPasswd;

%>