<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form method="post" encType="multipart/form-data" action="cc/sys/core/controller/fileUploadController/upload">
		<p>浏览<input name="file" type="file"/></p>${url }
		<p><input type="submit" value="上传"></p>
	</form>
</body>
</html>