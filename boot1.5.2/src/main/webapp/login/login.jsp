<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="login/css/index.css" >
<script type="text/javascript" src="login/js/index.js"></script>
<script type="text/javascript">
	function toIndexPage(){
		window.open("cc/sys/core/controller/sysIndexController/index");
	}
</script>
</head>
<body >
	<h1 style="color: green">首页面!Index.jsp</h1>
	<a href="javascript:void(0);" onclick="toIndexPage();" >进入首页__IndexPage</a>
</body>
</html>