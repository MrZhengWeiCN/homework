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

<title>编辑</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/编辑.png">
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>
	<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				卖家：<span class="name">${sessionScope.user.nickname }</span>，您好！<a
					href="/logout">[退出]</a>
			</div>
			<ul class="nav">
				<li><a href="/">首页</a>
				</li>
				<li><a href="/public">发布</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="g-doc">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>内容编辑</h2>
		</div>
		<div class="n-public">
			<form class="m-form m-form-ht" id="form" method="post"
				action="/editSubmit?cid=${content.cid}" onsubmit="return false;"
				autocomplete="off">
				<div class="fmitem">
					<label class="fmlab">标题：</label>
					<div class="fmipt">
						<input type="hidden" name="id" value="${content.cid}" /> <input
							class="u-ipt ipt" name="title" value="${content.title} "
							placeholder="2-80字符" />
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">摘要：</label>
					<div class="fmipt">
						<input class="u-ipt ipt" name="summary" value="${content.digest}"
							placeholder="2-140字符"／>
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">图片：</label>
					<div class="fmipt" id="uploadType">
						<input name="pic" type="radio" value="url" checked /> 图片地址 <input
							name="pic" type="radio" value="file" /> 本地上传
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab"></label>
					<div class="fmipt" id="urlUpload">
						<input class="u-ipt ipt" name="image" value="${content.image}" />
					</div>
					<div class="fmipt" id="fileUpload" style="display:none">
						<input class="u-ipt ipt" name="file" type="file" id="fileUp" />
						<button class="u-btn u-btn-primary" id="upload">上传</button>
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">正文：</label>
					<div class="fmipt">
						<textarea class="u-ipt" name="detail" rows="10"
							placeholder="2-1000个字符">${content.article}</textarea>
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">价格：</label>
					<div class="fmipt">
						<input class="u-ipt price" name="price" value="${content.price}" />元
					</div>
				</div>
				<div class="fmitem fmitem-nolab fmitem-btn">
					<div class="fmipt">
						<button type="submit" class="u-btn u-btn-primary u-btn-lg">保
							存</button>
					</div>
				</div>
			</form>
			<span class="imgpre"><img
				src="${content.image}"
				alt="${content.image}" id="imgpre"> </span>
		</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			版权所有：网易云课堂<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队
		</p>
	</div> -->
	<script type="text/javascript" src="/js/global.js"></script>
	<script type="text/javascript" src="/js/public.js"></script>
</body>

</html>