<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cc.sys.core.util.ViewUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=ViewUtil.getRequestPath(request)%>">
<!-- easyui lib -->
<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/metro/easyui.css">
<link rel="stylesheet" href="component/jquery-easyui-1.5.1/themes/icon.css">
<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="component/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<!-- end -->

<!-- 门户JS扩展 -->
<link rel="stylesheet" href="component/jquery-easyui-portal/portal.css">
<script type="text/javascript" src="component/jquery-easyui-portal/jquery.portal.js"></script>
<!-- end -->

<!-- 工具JS -->
<script type="text/javascript" src="js_third/SerializeObject.js"></script>
<!-- 自定义JS -->

<script type="text/javascript" src="js/index.js"></script>
<!-- end -->

<style type="text/css">
#loginAndReg a {
	color: #fff
}

#loginPanel tr{
	height: 40px
}
#registPanel tr{
	height: 40px
}
#registPanel td{
	text-align: right;
}

</style>

<script type="text/javascript">
	$(function() {
		var portal = $("#portal").portal();
		var portals = $("div[name='portal_panel']").portal();
		$.each(portals,function(index,item){
			var p = $(item).panel({
				height:400,
				content:'<iframe src="datagrid.jsp" style="width:98%;height:98%;border:none" ></iframe>'
			});
			portal.portal('add',{
				panel:p,
				columnIndex:index
			});
		});
		
		/**树加载*/
		$("#tree").tree({
			url:'data.json'
		});
		
		Index.login.init("#loginPanel");
		Index.regist.init("#registPanel");
	})
	//登录
	function login(){
		Index.login.login(SerializeObject($("#loginForm")));
	}
	//注册
	function regist(){
		Index.regist.regist(SerializeObject($("#registPanel")));
	}
	
	//已有帐号登录
	function havaAccount(){
		Index.regist.close();
		Index.login.show();
	}
	
	//忘记密码
	function forgetPassword(){
		Index.forget();
	}
	
</script>

</head>


<body>
	<div id="cc" class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height: 66px; padding: 5px; background-color: #2d3e50; color: #fff">
			<div style="float: left; clear: left;">
				<div style="float: left;" ><img style="height: 50px;width: 200px" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493015577&di=4d51f57d019dafb4dc82fed7257c1dd8&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.lxway.com%2Fupload%2F3%2F4a%2F34af412918d7400d482088a1ee447c9f_thumb.jpg" alt="SpringBoot" /></div>
				<div style="float: left;" ><h2>Spring-boot!</h2></div>
			</div>
			<div style="float: right; margin: 10px 50px" id="loginAndReg">
				<a href="javascript:void(0);" onClick="Index.login.show();">登录</a> 
				&nbsp;&nbsp; 
				<a href="javascript:void(0);" onClick="Index.regist.show();">注册</a>
			</div>
		</div>

		<div data-options="region:'west',width:300,">
			<ul id="tree"></ul>
		</div>
		<div data-options="region:'center',border:false" style="padding: 3px">
			<div id="tt" class="easyui-tabs" fit="true" data-options="border:false">

				<div title="首页" id="tab-index">
					<div id="portal" style="border-style: none">
						<div style="width: 50%"></div>
						<div style="width: 50%"></div>
					</div>

					<div name="portal_panel" class="easyui-panel" title="门户小页A"></div>
					<div name="portal_panel" class="easyui-panel" title="门户小页B"></div>
				</div>
			</div>
		</div>


		<div id="loginPanel" style="display: none">
			<form id="loginForm" class="easyui-form">
				<table style="margin: 0 auto;border: thin;" >
					<tr>
						<td>帐号:</td>
						<td><input type="text" name="name"></td>
						<td></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="password"></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" onclick="login();" value="登录">
							<button onclick="Index.login.close();">取消</button>
							<a href="javascript:void(0);" onclick="forgetPassword();" >忘记密码？</a>
						</td><td></td>
					</tr>

				</table>
			</form>
		</div>
		
		<div id="registPanel" style="display: none">
			<form id="loginForm" class="easyui-form">
				<table style="margin: 0 auto;border: thin;" >
					<tr>
						<td>帐号:</td>
						<td><input type="text" name="name"></td>
						<td></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="password"></td>
						<td></td>
					</tr>
					<tr>
						<td>重复密码:</td>
						<td><input type="password" name="rePassword"></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" onclick="regist();" value="注册">
							<button onclick="Index.regist.close();">取消</button>
							<a href="javascript:void(0);" onclick="havaAccount();" >已有帐号登录？</a>
						</td><td></td>
					</tr>

				</table>
			</form>
		</div>

	</div>
</body>
</html>