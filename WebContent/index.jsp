<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="Access-Control-Allcontent=" IE=9;IE=8;IE=7;IE=EDGE ">
		<title>商城首页
		</title><!-- <meta http-equiv="X-UA-Compatible" 电商网站> -->
		<title>index</title>
		<link rel="shortcut icon" href="favicon.ico" type="image/x-ico" />
		<link rel="stylesheet" href="/shop/css/big.css" />

		<link rel="stylesheet" href="/shop/css/index.css" />

		<script type="text/javascript" src="/shop/js/jquery-1.8.3.min.js"></script>

		<link rel="stylesheet" href="/shop/css/gadget.css" />

		<script type="text/javascript" src="/shop/js/inde_n.js"></script>

	</head>

	<body id="body">
		<div class="dengl">
			<div>
				<ul class="dengul">
					<li>您好！欢迎来到&nbsp;&nbsp;
						<a href="login.jsp">登录</a>&nbsp;&nbsp;
						<a href="Register.jsp">注册</a>
					</li>
					<li class="dengfl dengo">
						<a id="dengomy" href="login.jsp">用户中心</a>
					</li>
					<li class="dengo">
						<a id="denmyorder" href="login.jsp">我的订单</a>
					</li>
					<li class="dengo">
						<a href="help.html">帮助中心</a>
					</li>
					<li class="dengo">
						<a href="feedback.html">意见反馈</a>
					</li>

				</ul>
			</div>
		</div>
		<div class="zhandlog">

			<div class="logsu">
				<a href="index.html"><img class="logo" src="imgeas/shop.jpg"></a>
				<div class="zhan"></div>
				<div class="sosu">
					<div class="searchbig">
						<input class="logtex" name="search" type="text" placeholder="请输入商品名称" />
						<input class="logsub" name="0" type="button" value="搜 索" />
						<div id="shophover">

							<ul id="shoplik">
								<li>商品名</li>
							</ul>

						</div>
					</div>

				</div>
			</div>
		</div>
		<div id="header">
			<div class="headh">
				<a class="heafenl" href="#"><i class="heafots">&#xe601;</i> 全部商品分类</a>
				<a href="index.jsp" class="heaxz">首 页</a>

				<a href="shop.html">商家</a>

			</div>
			<!-- 商品分类显示的地方-->
			<div class="heafenlx">
				<ul id="heafenul">
			<!-- 	<li class="fenlifi" name="3"><i class="heafots">&#xe605;</i>
				<a href="classification.html?i=3" target="_blank" name="3">商品分类</a>
				<div class="heafotxx" >
				<h4 class="heafothfo"><a href="classification.html?i=3" target="_blank" name="3"></a></h4>
				<ul class="liuliuo">
							<li class="heafotxxli">
							<p>
									<a href="classification.html?i=106" target="_blank" name="106">二级分类</a>
								</p>
					<a href="classification.html?i=106" target="_blank" name="107">
				</a>
				</li>
				</ul>
			</div>
			</li> -->
			</ul>
			</div>
			
			<!-- 首页图片-->
			<div class="healunb" class="big_pic_t">
				<div class="big_pic_s">
					<a href="http://baidu.com"><img src="imgeas/background.jpg" /></a>
					<a href="#"><img src="imgeas/background.jpg" /></a>

				</div>

			</div>
			<div class="heagg">
				<div class="heatab">
					<p>公告</p>
					<p>订单动态</p>
				</div>
				<div class="heagongg">
					<ul class="heaggone">

					</ul>
					<ul class="headingd">

					</ul>
				</div>

			</div>
		</div>
		<br>
		<div id="banner">
			<a href="/shop/ProductWeb?m=get&id=1">商品详情页</a>

		</div>

	</body>
<script type="text/javascript">
//用jquery来写 
$(function() {
	
	//发送jax请求 
	$.get("http://localhost:8080/shop/ProductTypeWeb?m=treelist",null,function(data){
		if(data!=null)
			{
			var html = "";
			//动态生成数据
			for(i = 0;i<data.length;i++)
				{
				//获取每一个一级分类 
				var onecate = data[i];
				console.log(onecate);
				html+='<li class="fenlifi" name="3"><i class="heafots">&#xe605;</i>'+
				'<a href="classification.html?i=3" target="_blank" name="3">'+onecate.text+'</a>';
				html+='<div class="heafotxx" >'+
				'<h4 class="heafothfo"><a href="classification.html?i=3" target="_blank" name="3">'+onecate.text+'</a></h4>';
				html+='<ul class="liuliuo">'+
							'<li class="heafotxxli">'+
							'	<p>'+
									'<a href="classification.html?i=106" target="_blank" name="106">二级分类</a>'+
								'</p>';
				//拼接二级分类
				for(var j = 0;j<onecate.children.length;j++)
					{
					var twocate = onecate.children[j];
					html+='<a href="http://localhost:8080/shop/ProductWeb?m=get&id='+twocate.id+' "target="_blank" name="107">'+twocate.text+'</a>';
					/* html+='<a href="http://localhost:8080/shop/ProductWeb?m=get&id=5" target="_blank" name="107">'+twocate.text+'</a>'; */
					}
				html+='	</li>'+
				'	</ul>'+
			'	</div>';
				}
			html+="</li>";
			}
		//吧生成的html放到哪个ul中 
		//现获取ul元素
		console.log(html)
		$("#heafenul").html(html);
		
		//绑定事件
	$("#heafenul>li").mouseover(function(){
		//显示当前选中的分类的div
			$(this).children("div").css("display","block");
			//某个节点的所有兄弟节点 siblings
			$(this).siblings().children("div").css("display","none");
		}) 
	});
	
});

</script>
</html>