<%--
  Created by IntelliJ IDEA.
  User: lei
  Date: 12/1/2016
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="comm-header.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>

    <!--360浏览器优先以webkit内核解析-->


    <title>H+ 后台主题UI框架 - 主页示例</title>

    <link rel="shortcut icon" href="${contextPath}/favicon.ico">
    <link href="${contextPath}/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${contextPath}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="${contextPath}/resources/css/animate.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">您是否需要自己做一款后台、会员中心等等的，但是又缺乏html等前端知识…
            <br>您是否一直在苦苦寻找一款适合自己的后台主题…
            <br>您是否想做一款自己的web应用程序…
            <br>…………
            <h4 class="text-danger">那么，现在H+来了</h4>
        </blockquote>

        <hr>
    </div>


</div>


<script src="${contextPath}/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${contextPath}/resources/js/plugins/layer/layer.min.js"></script>
<script src="${contextPath}/resources/js/content.min.js"></script>
<script src="${contextPath}/resources/js/welcome.min.js"></script>
</body>

</html>
