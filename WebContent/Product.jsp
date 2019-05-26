<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;IE=EDGE">
		<title>商品详情</title>
		<link rel="shortcut icon" href="favicon.ico" type="image/x-ico" />
		<link rel="stylesheet" href="css/big.css" />
		<link rel="stylesheet" href="css/my_im.css" />

		<link rel="stylesheet" href="css/Product.css" />

		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

		<script type="text/javascript" src="js/jquery.cookie.js"></script>
		<link rel="stylesheet" href="css/gadget.css" />
		<script type="text/javascript" src="js/gadget.js"></script>
		<script type="text/javascript" src="js/inam.js"></script>
		<script type="text/javascript" src="js/jquery.enlarge.min.js"></script>
		<!--		<script type="text/javascript" src="js/Product.js"></script>-->

	</head>
	<style>
	.black_overlay {
			display: none;
			position: absolute;
			top: 0%;
			left: 0%;
			width: 100%;
			height: 100%;
			background-color: black;
			z-index: 1001;
			-moz-opacity: 0.6;
			opacity: .60;
			filter: alpha(opacity=60);
		}
		
		.white_content {
			display: none;
			position: absolute;
			top: 25%;
			left: 25%;
			width: 50%;
			height: 50%;
			padding: 16px;
			/*border: 16px solid orange;*/
			background-color: white;
			z-index: 1002;
			overflow: auto;
		}
	</style>

	<body id="body">
		<div class="dengl">
			<div>
				<ul class="dengul">
					<li>您好！欢迎&nbsp;&nbsp;
						<a href="login.jsp">登录</a>&nbsp;&nbsp;
						<a href="Register.jsp">注册</a>
					</li>
					<li class="dengfl dengo">
						<a id="dengomy" href="#">用户中心</a>
					</li>
					<li class="dengo">
						<a id="denmyorder" href="#">我的订单</a>
					</li>
					<li class="dengo">
						<a href="#">帮助中心</a>
					</li>
					<li class="dengo">
						<a href="#">意见反馈</a>
					</li>

				</ul>
			</div>
		</div>
		<div class="zhandlog">

			<div class="logsu">
				<a href="http://localhost:8080/shop/index.jsp"><img class="logo" src="imgeas/shop.jpg"></a>
				<div class="zhan"></div>
				<div class="sosu">
					<div class="searchbig">
						<input class="logtex" name="search" type="text" placeholder="请输入商品名称" autocomplete="off">
						<input class="logsub" name="0" type="button" value="搜 索">
						<div id="shophover">
							<div class="hover_mous">
								<img id="hover_mous_t" src="imgeas/diyan.jpg">
							</div>
							<ul id="shoplik">
								<li>商品</li>
							</ul>

						</div>
						<div id="min_sel_t" style="display: none;">
							<ul></ul>
						</div>
					</div>

				</div>
			</div>
		</div>

		<header>
			<div class="heashopt">
				<div class="heashoptop">
					<a class="heashopa">商品详情</a>
				</div>

			</div>
			
			<div class="shoppro">

				<div class="shopnice" name="0">
					<div class="shopimg">
						<div href="http://7xloj2.com1.z0.glb.clouddn.com/1482733487700" id="demo" style="position: relative;float:left;"><img class="shopimgbig" src="${p.simg}"><img class="shopimgbig" src="imgeas/diyan.jpg" style="display: none;" width="960" height="720">
							<div style="position: absolute; left: 228px; top: 0px; background-color: rgb(255, 210, 77); border: 1px solid rgb(255, 128, 0); width: 148px; height: 148px; opacity: 0.4; cursor: move; display: none;"></div>
							<div id="mmm" style="position: absolute; left: 388px; top: 0px; background-color: rgb(255, 255, 255); overflow: hidden; width: 480px; height: 360px; border: 1px solid rgb(221, 221, 221); display: none;"><img src="imgeas/diyan.jpg" style="position: absolute; display: block; width: 960px; height: 720px; left: -729.6px; top: 0px;"></div>
						</div>
						<div class="shopcityimg">
							<ul>
								<li><img id="img" src="${p.simg}"></li>
							</ul>
						</div>
					</div>
					<!-- 商品id -->
					<input type="hidden" id="nid"  value="${p.nid}"/>
					<div class="shopimgnice"><span id="isotc">otc</span>
						<h5 id="namecn">${p.sname}</h5>
						
						<p>通用名：${p.sname}</p>
						<p>采购价：￥<span id="dispri">${p.nprice}</span></p>
						<p>当前库存：<span id="shopkuc" st="2" ty="0"><c:if test="${p.smctag==1}">有货</c:if><c:if test="${p.smctag==0}">缺货</c:if></span></p>
					      <p>商品介绍：${p.sdescription}</p>
						<p class="shopcart"></span></p><span class="shopgmsl">购买数量 :</span><input class="shopsf" id="shopsfjia" type="button" value="+"><input id="shopval" type="number" onkeyup="checkn(this)" onafterpaste="checkm(this)" name="number" minnum="1" value="1"><input class="shopsf" id="shopsfjian" type="button" value="-">
						<br><input type="button" class="createBtn" value="立即购买" onclick="Shop()" style="cursor: pointer;">&nbsp;&nbsp;<input type="button" value="加入购物车" onclick="addShop()" style="cursor: pointer;">
						<div class="shoptishi"></div>
					</div>
				</div>
				
				
			<!-- 	添加订单 -->
				<!-- 弹出层 start -->
		<div id="light" class="white_content">
			<form method="post"   action="http://localhost:8080/shop/Order?m=add"> 
			<!-- 把选中的节点的id放在这个表单里面 -->
			<!-- 想提高的数据可以放在隐藏输入框里面 -->
			<input type="hidden" id="pid" name="pid">
				请输入收货人姓名 :<input type="text"  name="ssname" id="ssname"/><br>
				请输入收货人地址 :<input type="text"  name="ssaddress" id="ssaddress"/><br>
				请输入收货人电话 :<input type="text"  name="ssphone" id="ssphone"/><br>
				 订单备注 :<input type="text"  name="smsg" id="smsg"/><br>
				<input type="button" value="提交"onclick="Order()">
			 </form> 
			<a href="javascript:void(0)" onclick="two()">Close</a>
		</div>
		<div id="fade" class="black_overlay">
		</div>
		<!-- 弹出层 end -->
		
				<div id="shoppronot">
					<img src="${p.simg}">
					<p>药品没找到，请刷新重试或看看其他药品吧</p>
				</div>

				<div class="shopdetailed">

					<div class="shopsuomi">
						<h5><span>商品说明书</span></h5>

					</div>

					<div class="shopliuc">
						<img src="${p.simg}">
					</div>
					<div class="shopcity">

					</div>
					<div class="shopxx">
						<h5>商品详情</h5>
						<div class="shopxximg">
                               <p>商品介绍：${p.sdescription}</p>
							<img src="${p.simg}"><br></div>

					</div>
				</div>

			</div>
		</header>

	</body>
	<script>
		function addShop()
		{
		var num= $("#shopval").val();
		var nid = $("#nid").val();
		var namecn = $("#namecn").text();
		var img=$("#img").attr("src");
		var price=$("#dispri").text();
		alert(namecn)
		//发送请求到服务器 
		location.href="http://localhost:8080/shop/CartWeb?m=add&nid="+nid+"&num="+num+"&name="+namecn+"&img="+img+"&price="+price;
		}
		//添加订单
		function Order()
		{
		var num= $("#shopval").val();
		var nid = $("#nid").val();
		var namecn = $("#namecn").text();
		var img=$("#img").attr("src");
		var price=$("#dispri").text();
		var ssname=$("#ssname").val();
		var ssaddress=$("#ssaddress").val();
		var ssphone=$("#ssphone").val();
		var smsg=$("#smsg").val();
		alert(namecn)
		//发送请求到服务器 
		location.href="http://localhost:8080/shop/Order?m=add&nid="+nid+"&num="+num+"&name="+namecn
				+"&img="+img+"&price="+price+"&ssname="+ssname+"&ssaddress="+ssaddress+"&ssphone="+ssphone+"&smsg="+smsg;
		}
		//弹出js自带的输入框
		function diag(item) { //prompt第一个参数是提示语
			var str = prompt(item, "");
			return str;
		}

		function Shop() {
			document.getElementById('light').style.display = 'block';
			document.getElementById('fade').style.display = 'block'
		}

		function two() {
			//先获取数据  通过 ajax提交数据 然后在让当前弹出层消失
			//$("form")[0].submit();
			document.getElementById('light').style.display = 'none';
			document.getElementById('fade').style.display = 'none'

		}
	</script>

</html>