$(function(){
	
	 $("#btnLogin").click(function () { //“登录”按钮单击事件
         //获取用户名称
         var strTxtName = encodeURI($("#userName").val());
         //获取输入密码
         var strTxtPass = encodeURI($("#passWord").val());
         //开始发送数据
         $.ajax({ //请求登录处理页
        	 type: 'POST',
             url: "log_userLogin.action", //登录处理页
             dataType: "html",
             //传送请求数据
             data: { userName: strTxtName, passWord: strTxtPass },
             success: function (data) { //登录成功后返回的数据
            	 alert(data);
                if(data == 1){
                	windows.location.href = "index.jsp";
                }else{
                	alert("账号密码有误！");
                }
             }
         })
     })
	
	
});