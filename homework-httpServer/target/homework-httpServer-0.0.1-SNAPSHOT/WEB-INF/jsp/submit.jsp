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

<title>�����ɹ���</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="/image/�ɹ�.png">
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>
	<div class="n-support">��ʹ��Chrome��Safari��webkit�ں˵��������</div>
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				��<a href="/login">[��¼]</a>
			</div>
			<ul class="nav">
				<li><a href="/">��ҳ</a></li>
			</ul>
		</div>
	</div>
	<div class="g-doc">
		<div class="n-result">
			<h3>�����ɹ���</h3>
			<p>
				<a href="/show?cid=${cid}">[�鿴����]</a><a href="/">[������ҳ]</a>
			</p>
		</div>
	</div>
	<!-- <div class="n-foot">
		<p>
			��Ȩ���У������ƿ���<a
				href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java��������ʦ(Web����)</a>΢רҵ�Ŷ�
		</p>
	</div> -->
</body>

</html>
