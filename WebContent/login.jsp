<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta charset="utf-8">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>首页</title>
	<link rel="stylesheet" href="/shop/common/layui/css/layui.css">
	<link rel="stylesheet" href="/shop/common/css/sccl.css">
  <link rel="stylesheet" href="/shop/common/iconfont/1.0.1/iconfont.css"/>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
  
  <body class="login-bg">
    <div class="login-box">
        <header>
            <h1>商城登录界面</h1>
        </header>
        <div class="login-main">
			<form action="http://localhost:8080/shop/LoginServlet?m=get"  method="post">
姓名：<input type="text" id="name" name="name"><br>
密码：<input type="password" id="password" name="password"><br>
手机号码：<input type="text"  id="phone" name="phone"><br>
<button type="submit" >登录</button>
</form>
					<div class="clear"></div>
				</div>
		</div>
        <footer>
            <p>登录系统</p>
        </footer>
    <img src="../common/layui/images/face/0.gif" />
    <script type="text/html" id="code-temp">
        <div class="login-code-box">
            <input type="text" class="layui-input" id="code" />
            <img id="valiCode" src="http://192.168.1.115:8080/health/image.jsp" alt="验证码" />
        </div>
    </script>
    <script type="text/javascript" src="../common/lib/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../common/js/jquery.xdomainrequest.min.js" ></script>
    <script src="../common/layui/layui.js"></script>
    <script src="../common/js/md5.js"></script>
    <script src="../common/js/sccl-util.js"></script>
    
    <script>
		$(function(){
    jQuery.support.cors = true;
        layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
				$ = layui.jquery,
				form = layui.form();
				
            form.verify({
                userName: function (value) {
                    if (value === '')
                        return '请输入用户名';
                },
                password: function (value) {
                    if (value === '')
                        return '请输入密码';
                }
            });

            var errorCount = 4;
form.on('switch(rememberMe)', function(data){
  console.log(data.elem.checked); //是否被选中，true或者false
  if(data.elem.checked==true){
  	console.log("已选中");
  }else{
  	console.log("没选中");
  };
})
        form.on('submit(login)', function (data) {
				//window.location.href = "index.html";
                if (errorCount > 5) {
                    layer.open({
                        title: '<img src="../common/layui/images/face/0.gif" alt="[害羞]">输入验证码',
                        type: 1,
                        content: document.getElementById('code-temp').innerHTML,
                        btn: ['确定'],
                        yes: function (index, layero) {
                            var $code = $('#code');
                            if ($code.val() === '') {
                                layer.msg('输入验证码啦，让我知道你是人类。');
                                isCheck = false;
                            } else {
                                var params={};
                                params.checkNum = $("#code").val();
                                params.username = $('input[name=userName]').val();
                                params.password = hex_md5($('input[name=password]').val());
                              //  params=JSON.stringify(params);
                                console.log(params)
                                submit($,params);
                                layer.close(index);
                            }
                        },
                        area: ['250px', '150px']
                    });
                    $('#valiCode').off('click').on('click', function () {
                        this.src = myurl()+'/health/image.jsp?v=' + new Date().getTime();
                    });
                }else{
                	var params={};
                  params.username = $('input[name=userName]').val();
                  params.password = hex_md5($('input[name=password]').val());
                  //params=JSON.stringify(params);
                    submit($,params);
                }

                return false;
            });

        });
				
        function submit($,params){
		alert(111)
		window.location.href="index.html";
        	var url=myurl()+"/admin/innerUser/login"+"?"+new Date().getTime();
        	/*ajax(url,params,"json",function(data){
        		console.log(data);
        		if(data.code==1){
        			window.location.href="index.html";
        		}else{
        			layer.msg('登录失败');
        		}
        	})*/
        //	ajax(url,params,"json","")
        // $("#loinfom").attr("action",url);
        //    $("#loinfom").submit();
        }
        
		})
    </script>
  </body>
</html>
