<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<h1>springMVC字节流输入上传文件</h1>
	<form name="form1" method="post" encType="multipart/form-data" action="cc/sys/core/controller/fileUploadController/upload">
		<p>浏览<input name="file" type="file" /></p>
		<p>
			<input type="submit" value="上传">
		</p>
	</form>
	<br>
	<br>
	<hr align="left" width="60%" color="#FF0000" size="3">
	<br>
	<br>
	<h1>springMVC包装类上传文件</h1>
	<form name="form2" method="post" encType="multipart/form-data" action="cc/sys/core/controller/fileUploadController/upload2">
		<p>
			文件1<input name="file1" type="file" />
			<br>
			文件2<input name="file2" type="file" />
			<br>
			文件3<input name="file3" type="file" />
			<br>
			文件4<input name="file4" type="file" />
			<br>
			文件5<input name="file5" type="file" />
		</p>
		<p>
			<input type="submit" value="上传">
		</p>
	</form>
</body>
</html>