<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="shortcut icon" href="/image/订单.png">
	<link rel="stylesheet" type="text/css" href="/css/style.css">


  </head>
  
  <body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
                    买家你好，<span class="name">buyer</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <li><a href="/account">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col/><col class="num"/><col/><col class="price"/><col/></colgroup>
        
        <c:forEach var="order" items="${orders }">
         <tr><th>订单编号</th><th>${order.oid }</th><th><fmt:formatDate value="${order.time}" pattern="yyyy-MM-dd HH:mm:ss"/></th><th>总价</th><th>￥${order.price/100 }</th></tr>
        	<thead>
            <!-- <tr><th>内容图片</th><th>内容名称</th><th>时间</th><th>数量</th><th>价格</th></tr> -->
        </thead>
        	<c:forEach var="orderItem" items="${orderItems }">
        		<c:if test="${orderItem.orderid==order.oid }">
        		<tbody>
            <tr>
                <td><a href="/show?cid=${orderItem.contentid }"><img src="${orderItem.image }" alt=""></a></td>
                <td><h4><a href="/show?cid=${orderItem.contentid }">${orderItem.title }</a></h4></td>
                <td><span class="v-time"><fmt:formatDate value="${order.time}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
                <td><span class="v-num">${orderItem.num }</span></td>
                <td><span class="v-unit">¥</span><span class="value">${orderItem.singleprice/100}</span></td>
            </tr>
            	</tbody>
        		</c:if>
        	</c:forEach>
        </c:forEach>
        <tfoot>
            <tr>
                <td colspan="4"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">333065.62</span></td>
            </tr>
        </tfoot>
    </table>
</div>
<!-- <div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div> -->
</body>

</html>
