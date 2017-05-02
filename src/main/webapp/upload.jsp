<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/metro/easyui.css">
<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" href="component/uploadify/uploadify.css">

<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="component/uploadify/jquery.uploadify.min.js" ></script>


<script type="text/javascript">
$(function() {
    $("#file_upload_1").uploadify({
        height        : 30,
        swf           : 'component/uploadify/uploadify.swf',
        uploader      : 'component/uploadify/uploadify.php',
        width         : 120
    });
});
</script>
</head>
<body>
	<div id="file_upload_1" >
		
	</div>

</body>
</html>