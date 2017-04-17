var Index = {
	urlConfig : {
		loginCommitUrl : "",//登录提交地址
		registUrl:""//注册提交地址
	},
	element : {
		loginEl : undefined,//登录窗的对象
		registEl : undefined//注册窗的对象

	},
	login : {
		init : function(selector) {
			if (Index.element.loginEl == undefined) {
				Index.element.loginEl = $(selector).window({
					width : 300,
					height : 200,
					modal : true,
					openAnimation : 'slide',
					closed : true,
					inline : true,
					border : 'thin',
					title : '用户登录',
					minimizable : false,
					maximizable : false,
					draggable : false,
					resizable : false,
					constrain : true
				});
			}
		},
		show : function() {
			Index.element.loginEl.window("open");
		},
		close : function() {
			Index.element.loginEl.window("close");
		},
		login : function(form) {
			$.ajax({
				url : Index.urlConfig.loginCommitUrl,
				type : 'post',
				dataType : 'json',
				async : false,
				data : {
					formData : JSON.stringify(form)
				},
				success : function(res) {
					alert("登录成功！");
				}
			})
		}
	},
	regist : {
		init:function(selector){
			if (Index.element.registEl == undefined) {
				Index.element.registEl = $(selector).window({
					width : 400,
					height : 600,
					modal : true,
					openAnimation : 'slide',
					closed : true,
					inline : true,
					border : 'thin',
					title : '注册',
					minimizable : false,
					maximizable : false,
					draggable : false,
					resizable : false,
					constrain : true
				});
			}
		},
		show:function(){
			Index.element.registEl.window("open");
		},
		close : function() {
			Index.element.registEl.window("close");
		},
		regist : function(form) {
			$.ajax({
				url : Index.urlConfig.registUrl,
				type : 'post',
				dataType : 'json',
				data : {
					formData : JSON.stringify(form)
				},
				success : function(res) {
					alert("注册成功！");
				}
			})
		}
	},
	forget:function(){
		alert("密码都能忘记,你能做什么?");
		return;
	}

};