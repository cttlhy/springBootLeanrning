<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function toLoginPage(){
		window.open("login/login.jsp");
	}
</script>
</head>
<body id="body" >
	<h1>此页面为拦截的错误页面!</h1>
	<a href="javascript:void(0);" onclick="toLoginPage();">返回登录页面</a>
</body>
</html>