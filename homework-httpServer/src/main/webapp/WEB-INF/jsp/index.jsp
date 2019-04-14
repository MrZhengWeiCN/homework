<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>电商作业Demo</title>

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
				<c:when test="${sessionScope.user == null}">
					<div class="user">
						请<a href="/login">[登录]</a>
					</div>
				</c:when>
				<c:when test="${sessionScope.user.seller==0}">
					<div class="user">
						买家你好，<span class="name">${sessionScope.user.nickname }</span>！<a
							href="/logout">[退出]</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="user">
						卖家你好，<span class="name">${sessionScope.user.nickname }</span>！<a
							href="/logout">[退出]</a>
					</div>
				</c:otherwise>
			</c:choose>


			<ul class="nav">
				<li><a href="/">首页</a>
				</li>
				<c:if test="${sessionScope.user != null}">
					<li><a href="/account">账务</a>
				</li>
					<li><a href="/settleAccount">购物车</a>
				</li>
				</c:if>
				<c:if
					test="${sessionScope.user.seller != null &&sessionScope.user.seller==1}">
					<li><a href="/public">发布</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="g-doc">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<div class="tab">
				<ul>
					<li class="z-sel"><a href="/">所有内容</a>
					</li>
					<c:if test="${sessionScope.user!=null && sessionScope.user.seller==0}">
						<li><a href="/?type=1">未购买的内容</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="n-plist">
			<ul class="f-cb" id="plist">
				<c:forEach var="contentWithTag" items="${contentWithTags}">
					<li id="p-1"><a href="/show?cid=${contentWithTag.contentWithBLOBs.cid}" class="link">
							<div class="img">
								<img src="${contentWithTag.contentWithBLOBs.image}" alt="${contentWithTag.contentWithBLOBs.title}">
							</div>
							<h3>${contentWithTag.contentWithBLOBs.title}</h3>
							<div class="price">
								<span class="v-unit">¥</span><span class="v-value">${contentWithTag.contentWithBLOBs.price/100}</span>
							</div> 
							<c:if test="${sessionScope.user != null &&sessionScope.user.seller == 1 && contentWithTag.contentWithBLOBs.repertory>0}">
							<span class="had"><b>售${contentWithTag.contentWithBLOBs.repertory }件</b></span>
							</c:if>
							<c:if test="${sessionScope.user != null &&sessionScope.user.seller == 0 && contentWithTag.buy==1}">
								<span class="had"><b>已购买</b></span>
							</c:if>
							</a>
							<c:if test="${sessionScope.user != null &&sessionScope.user.seller == 1 && contentWithTag.contentWithBLOBs.repertory==0}">
								<span class="u-btn u-btn-normal u-btn-xs del" data-del="${contentWithTag.contentWithBLOBs.cid}">删除</span>
							</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
	<script type="text/javascript" src="/js/global.js"></script>
	<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>

</html>
