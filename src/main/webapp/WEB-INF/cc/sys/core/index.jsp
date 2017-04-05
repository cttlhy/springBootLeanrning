<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sayHello(){
		window.open("${url }hello");
	}
	function mybatis(){
		window.open("${url }testMybatis");
	}
	function mybatisPage(){
		window.open("${url }testPageHelper");
	}
	function insertBatch(){
		window.open("${url }insert");
	}
</script>
</head>
<body>
	<h1>欢迎你访问CCSYS 系统，欢迎您的到来!</h1>
	<h3>从后台接收到的地址是:</h3><%-- ${url } --%>
	<a href="javascript:void(0);" onclick="sayHello();">打招呼</a>
	<hr>
	测试mybatis<a href="javascript:void(0)" onclick="mybatis();" >测试mybatis</a>
	<br>
	测试mybatis分页<a href="javascript:void(0)" onclick="mybatisPage();" >测试mybatis分页</a>
	<br>
	批量插入带测事务<a href="javascript:void(0)" onclick="insertBatch();" >批量插入测试数据</a>
	<br>
</body>
</html>