<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;IE=EDGE">
		<title>订单页面</title>
		<link rel="shortcut icon" href="favicon.ico" type="image/x-ico" />
		<link rel="stylesheet" href="css/big.css" />

		<link rel="stylesheet" href="css/Product.css" />

		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

	
		<link rel="stylesheet" href="css/gadget.css" />
		<script type="text/javascript" src="js/gadget.js"></script>

		<style>
			.selectShop {
				padding-left: 10px;
				margin-top: 10px;
				margin-bottom: 10px;
				margin-left: 50px;
				margin-right: 30px;
				border: #33ccff solid 1px;
				border-radius: 4px;
				text-align: left;
			}
		</style>
	</head>

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
					<a class="heashopa">我的订单</a>
				</div>

			</div>
			
			<div class="shoppro">

				<div class="shopnice" name="0">
					<div class="shopimg">
						<div href="http://7xloj2.com1.z0.glb.clouddn.com/1482733487700" id="demo" style="position: relative;float:left;"><img class="shopimgbig" src="${p.simg}"><img class="shopimgbig" src="imgeas/diyan.jpg" style="display: none;" width="960" height="720">
							<div style="position: absolute; left: 228px; top: 0px; background-color: rgb(255, 210, 77); border: 1px solid rgb(255, 128, 0); width: 148px; height: 148px; opacity: 0.4; cursor: move; display: none;"></div>
							<div id="mmm" style="position: absolute; left: 388px; top: 0px; background-color: rgb(255, 255, 255); overflow: hidden; width: 480px; height: 360px; border: 1px solid rgb(221, 221, 221); display: none;"><img src="imgeas/diyan.jpg" style="position: absolute; display: block; width: 960px; height: 520px; left: -729.6px; top: 0px;"></div>
						</div>
						<div class="shopcityimg">
							<ul>
								<li><img id="img" src="${p.simg}"></li>
							</ul>
						</div>
					</div>
			
			
			
			<!-- 订单显示 -->
			<input type="hidden" id="nid"  value="${order.order_Code}"/>
					<div class="shopimgnice"><span id="isotc">otc</span>
						<h5 id="namecn">订单号：${order.order_Code}</h5>
						
						<p>收货人姓名：${order.ssname}</p>
						<p>收货人地址：${order.ssaddress}</p>
						<p>收货人电话：${order.ssphone}</p>
						<p>订单备注： ${order.smsg}</p>
						<p>采购价：￥<span id="dispri">${p.nprice}</span></p>
						<p>当前库存：<span id="shopkuc" st="2" ty="0"><c:if test="${p.smctag==1}">有货</c:if><c:if test="${p.smctag==0}">缺货</c:if></span></p>
					      <p>商品介绍：${p.sdescription}</p> 
						<p class="shopcart"></span></p><span class="shopgmsl">购买数量 :</span><input class="shopsf" id="shopsfjia" type="button" value="+"><input id="shopval" type="number" onkeyup="checkn(this)" onafterpaste="checkm(this)" name="number" minnum="1" value="1"><input class="shopsf" id="shopsfjian" type="button" value="-">
						<br><input type="button" class="createBtn" value="支付宝支付" onclick="Shop()" style="cursor: pointer;">&nbsp;&nbsp;<input type="button" value="微信支付" onclick="addShop()" style="cursor: pointer;">
						<div class="shoptishi"></div>
					</div>
				<!-- </div> -->
				
					</div>
			</div>
				
				
				

			<div class="heashoptop">
				<a class="heashopa" style="cursor: pointer;" onclick="Order()">去结算</a>
			</div>
			
		
		</header>

	</body>
	
	<script>
		function del()
		{
		var num= $("#shopval").val();
		var nid = $("#nid").val();
		var namecn = $("#namecn").text();
		alert(namecn)
		//发送请求到服务器 
		location.href="http://localhost:8080/shop/CartWeb?m=del";
		//
		}
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
		</script>
</html>