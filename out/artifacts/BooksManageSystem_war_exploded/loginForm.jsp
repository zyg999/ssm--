<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/js/bootstrap.min.js">
    </script>
    <title> 用户登录 </title>
</head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/images/book.jpg"  class="rounded mx-auto d-block"><h4>用户登录</h4>
    <form method="post" action="login">
        <div class="form-group row">
            <label for="username" class="col-sm-3 col-form-label">用户名：</label>
            <div class="col-sm-9">
                <input type="text" id="username" name="userName"
                       class="form-control" placeholder="输入用户名">
            </div>
        </div>
        <div class="form-group row">
            <label for="pass" class="col-sm-3 col-form-label">密码：</label>
            <div class="col-sm-9">
                <input type="password" id="pass" name="userPass"
                       class="form-control" placeholder="输入密码">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-6 text-right">
                <input type="submit" class="btn-primary btn" value="登录">
            </div>
            <div class="col-sm-6">
                <a href="${pageContext.request.contextPath}/userRegis" class="btn-primary btn">注册</a>
            </div>
        </div>
        <span style="color: red" class="offset-4">${tip}</span>
        <span style="color: red"; size="10dp" class="offset-4">请先登录</span>
    </form>
</div>
</body>
</html>
