<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;IE=EDGE">
		<title>购物车</title>
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
					<a class="heashopa">我的购物车</a>
				</div>

			</div>
			<div class="selectShop">
				<form id="selectForm" action="/Order?m=list" name="selectForm" method="post">
					<table>
					<!-- 一行就是一个商品 -->
					<c:forEach items="${cart}" var="c">
					<tr>
								<td><input type="checkbox" name="nid" value="${c.value.nid }" /></td>
								<td> <img src="${c.value.img }"width="150px" height="100px" /></td>
								<td>&nbsp;商品名:${c.value.name }&nbsp;&nbsp; 
									数量:<input type="number" name="num" value="${c.value.num }" width="10px" />&nbsp;
									金额:${c.value.num*c.value.price } &nbsp;
									<input type="button" name="del" onclick="del" value="删除"/></td>
							</tr>
					</c:forEach>
							
							</table>

				</form>
			</div>

			<div class="heashoptop">
				<a class="heashopa" style="cursor: pointer;" onclick="Shop()">去结算</a>
			</div>
			
			<!-- 弹出层 start -->
		<div id="light" class="white_content">
			<form method="post"   action="http://localhost:8080/shop/Order?m=add">
			<!-- 把选中的节点的id放在这个表单里面 -->
			<!-- 想提高的数据可以放在隐藏输入框里面 -->
			<input type="hidden" id="pid" name="pid">
				请输入收货人姓名 :<input type="text"  name="ssname"/><br>
				请输入收货人地址 :<input type="text"  name="ssaddress"/><br>
				请输入收货人电话 :<input type="text"  name="ssphone"/><br>
				 订单备注 :<input type="text"  name="smsg"/><br>
				<input type="button" value="提交"onclick="Order()">
			</form>
			<a href="javascript:void(0)" onclick="two()">Close</a>
		</div>
		<div id="fade" class="black_overlay">
		</div>
		<!-- 弹出层 end -->

		</header>

	</body>
	<script>
		//get(url: String, data: Map, success: Function, dataType: String
		//post(url: String, data: Object, success: Function(String,String,jQuery.jqXHR), dataType: String):
		function submit() {

			//先获取选中的的checkbox 然后看数量有么有填写
            	var arrayObj = new Array();
			 $("input[name=pid]:checked").each(function(){
				if($(this).siblings().last().val()=="")
				{
					//结束代码
					alert("请填写购买数量")
					$(this).siblings().last().focus();
					return;
				}else{
					var itemid = $(this).attr('value');
				var num = $(this).siblings().last().val()
					arrayObj.push(itemid+"-"+num)
				}
			});
			console.log(arrayObj)
			//发送ajax提交数据 因为是提交的数组 所以我们在服务器端接受使用getParamterValues
			$.get("url",{"data":arrayObj},function(data,http,xmlHttp)
			{
				
			});
		}
		
		function del()
		{
		var num= $("#shopval").val();
		var nid = $("#nid").val();
		var namecn = $("#namecn").text();
		alert(namecn)
		//发送请求到服务器 
		location.href="http://localhost:8080/shop/CartWeb?m=del"+"&nid="+nid;
		//
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