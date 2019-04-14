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

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/登录密码.png">
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>
	<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				请<a href="/login">[登录]</a>
			</div>
			<ul class="nav">
				<li><a href="/">首页</a></li>
			</ul>
		</div>
	</div>
	<form class="m-form m-form-ht n-login" id="loginForm"
		onsubmit="return false;" autocomplete="on">
		<div class="fmitem">
			<label class="fmlab">用户名：</label>
			<div class="fmipt">
				<input class="u-ipt" name="userName" autofocus />
			</div>
		</div>
		<div class="fmitem">
			<label class="fmlab">密码：</label>
			<div class="fmipt">
				<input class="u-ipt" type="password" name="password" />
			</div>
		</div>
		<div class="fmitem fmitem-nolab fmitem-btn">
			<div class="fmipt">
				<button type="submit"
					class="u-btn u-btn-primary u-btn-lg u-btn-block">登 录</button>
			</div>
		</div>
		<input id="url" name="redirectURL" type="hidden" value="${redirectURL }" />
	</form>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
	<script type="text/javascript" src="/js/md5.js"></script>
	<script type="text/javascript" src="/js/global.js"></script>
	<script type="text/javascript" src="/js/pageLogin.js"></script>
</body>


</html>
