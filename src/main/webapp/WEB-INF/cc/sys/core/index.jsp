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
	function testNoPageHelper(){
		window.open("${url }testNoPageHelper");
	}
	function insertBatch(){
		window.open("${url }insert");
	}
	
	function removeAllCache(){
		window.open("${url }removeAllCache");
	}
	function start_A_Task(){
		window.open("${url }start_A_Task");
	}
	function stop_the_started_Task(){
		window.open("${url }stop_the_started_Task");
	}
	function sendEmail(){
		alert("${url }sendEmail");
		window.open("${url }sendEmail");
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
	测试mybatis不分页<a href="javascript:void(0)" onclick="testNoPageHelper();" >测试mybatis不分页</a>
	<br>
	批量插入带测事务,该功能链接插入肯定失败(请查看后台源码),主要测试插入过长的字符是否会导致事务回滚<a href="javascript:void(0)" onclick="insertBatch();" >批量插入测试数据</a>
	<br>
	清空redis缓存<a href="javascript:void(0)" onclick="removeAllCache();" >清空redis缓存</a>
	<br>
	<form action="${url }changeExcutionTime" method="post"  >
		<input type="text" title="定时表达式" name="excutionTime" ><input type="submit" value="改变调度时间">表达式举例：0/10 * * * * * *   （秒 分 时 天 星期 月 年）
	</form>
	<br>
	启动调度<a href="javascript:void(0)" onclick="start_A_Task();" >启动调度</a>
	<br>
	关闭调度<a href="javascript:void(0)" onclick="stop_the_started_Task();" >关闭调度</a>
	<br>
	发送右键(发送目标在 properties文件中配置)<a href="javascript:void(0)" onclick="sendEmail();" >发送邮件</a>
	<br>
	文件上传案例<a href="cc/sys/core/controller/fileUploadController/uploadFile" >文件上传</a>
</body>
</html>