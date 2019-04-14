<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/商品.png">
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>
	<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
	<div class="n-head">
		<div class="g-doc f-cb">
			<c:choose>
				<c:when test="${sessionScope.user != null}">
					<div class="user">
						买家你好，<span class="name">${sessionScope.user.nickname }</span>！<a
							href="/logout">[退出]</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="user">
						请<a href="/login">[登录]</a>
					</div>
				</c:otherwise>
			</c:choose>
			<ul class="nav">
				<li><a href="/">首页</a></li>
				<li><a href="/account">账务</a></li>
				<li><a href="/settleAccount">购物车</a></li>
			</ul>
		</div>
	</div>
	<div class="g-doc">
		<div class="n-show f-cb" id="showContent">
			<div class="img">
				<img src="${contentWithBLOBs.image }"
					alt="${contentWithBLOBs.title }">
			</div>
			<div class="cnt">
				<h2>${contentWithBLOBs.title }</h2>
				<p class="summary">${contentWithBLOBs.digest }</p>
				<div class="price">
					<span class="v-unit">¥</span><span class="v-value">${contentWithBLOBs.price/100
						}元</span>
				</div>
				<div class="num">
					购买数量：<span id="plusNum" class="lessNum"><a>-</a>
					</span><span class="totalNum" id="allNum">1</span><span id="addNum"
						class="moreNum"><a>+</a>
					</span>
				</div>
				<div class="oprt f-cb">
				<c:if test="${sessionScope.user != null && sessionScope.user.seller == 0}">
					<button class="u-btn u-btn-primary" id="add" data-id="${contentWithBLOBs.cid }"
						data-title="${contentWithBLOBs.title }" data-price="${contentWithBLOBs.price/100}">加入购物车</button>
					</c:if> 
					<c:if test="${sessionScope.user == null}">
						<a href="/login?redirectURL=http://localhost:8080/show?cid=${contentWithBLOBs.cid }" class="u-btn u-btn-primary" id="add" data-id="${contentWithBLOBs.cid }"
						data-title="${contentWithBLOBs.title }" data-price="${contentWithBLOBs.price/100}">登陆后加入购物车</a>
					</c:if>
					<c:choose>
						<c:when test="${sessionScope.user != null && sessionScope.user.seller == 1}">
							<a href="/edit?cid=${contentWithBLOBs.cid }"
								class="u-btn u-btn-primary">编 辑</a>
						</c:when>
						<c:otherwise>
							<!-- <span class="u-btn u-btn-primary z-dis">需要判断当时是否已经购买</span> -->
							<c:if test="${oldPrice != null}">
							<span class="buyprice">当时购买价格：¥${oldPrice/100}</span>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>详细信息</h2>
		</div>
		<div class="n-detail">${contentWithBLOBs.article }</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
	<script type="text/javascript" src="/js/global.js"></script>
	<script type="text/javascript" src="/js/pageShow.js"></script>
</body>

</html>
