<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>

<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/metro/easyui.css">
<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/icon.css">
<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>


</head>
<body>
	<div>
		<table class="easyui-datagrid" data-options="
										fitColumns:true,
										idField:'id',
										method:'get',
										url:'cc/sys/core/controller/sysIndexController/operation/testPageHelper',
										pageSize:'10',
										pageList:[10,20,30],
										pagination:true
		" >
			<thead>
				<tr>
					<th data-options="field:'id',width:100">ID</th>
					<th data-options="field:'name',width:100">����</th>
					<th data-options="field:'loginName',width:100">��¼��</th>
					<th data-options="field:'no',width:100">���</th>
					<th data-options="field:'secretLevel',width:100">�ܼ��ȼ�</th>
					<th data-options="field:'address',width:100">סַ</th>
				</tr>
			</thead>
		</table>


	</div>
</body>
</html>