<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/购物车.png">
	<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>
	<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				买家你好，<span class="name">buyer</span>！<a href="/logout">[退出]</a>
			</div>
			<ul class="nav">
				<li><a href="/">首页</a>
				</li>
				<li><a href="/account">账务</a>
				</li>
				<li><a href="/settleAccount">购物车</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="g-doc" id="settleAccount">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>已添加到购物车的内容</h2>
		</div>
		<table id="newTable" class="m-table m-table-row n-table g-b3">
		</table>
		<div id="act-btn">
			<button class="u-btn u-btn-primary" id="back">退出</button>
			<button class="u-btn u-btn-primary" id="Account">购买</button>
		</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
	<script type="text/javascript" src="/js/global.js"></script>
	<script type="text/javascript" src="/js/settleAccount.js"></script>
</body>

</html>