<%--
  Created by IntelliJ IDEA.
  User: lei
  Date: 12/1/2016
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <title>后台-登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${contextPath}/favicon.ico">
    <link href="${contextPath}/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${contextPath}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="${contextPath}/resources/css/animate.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">xxxx</h1>

        </div>
        <h3>欢迎使用 xxx</h3>

        <form class="m-t" role="form" action="" method="post" id="inputForm">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="用户名" name="username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>
<script src="${contextPath}/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${contextPath}/resources/js/jquery.validate.js"></script>
<script src="${contextPath}/resources/js/messages_zh.js"></script>
<script type="text/javascript">
$(function () {
    $("#inputForm").validate({
        rules:{
            username:{
                required:true
            },
            password:{
                required:true
            }
        },
        messages:{
            username:{
                required: "不能为空",
            },
            password:{
                required: "不能为空",
            }
        },

        submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form
            alert("提交表单");
            form.submit();   //提交表单
        },

    });

})

</script>
</body>
</html>
