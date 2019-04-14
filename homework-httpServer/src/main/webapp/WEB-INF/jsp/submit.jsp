<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

<title>发布成功！</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/成功.png">
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
	<div class="g-doc">
		<div class="n-result">
			<h3>发布成功！</h3>
			<p>
				<a href="/show?cid=${cid}">[查看内容]</a><a href="/">[返回首页]</a>
			</p>
		</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
</body>

</html>
