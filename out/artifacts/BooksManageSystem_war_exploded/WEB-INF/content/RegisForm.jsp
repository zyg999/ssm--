<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title> 用户注册 </title>
</head>
<body>
  <img src="${pageContext.request.contextPath}/images/regis.jpg" class="rounded offset-3 d-block" style="height: 500px"><br>
  <form method="post" action="${pageContext.request.contextPath}/addUser">
      <div class="form-group row">
          <label for="username" class="col-sm-3 col-form-label">用户名：</label>
          <div class="col-sm-6">
              <input type="text" id="username" name="userName"
                     class="form-control" placeholder="输入用户名">
          </div>
          <div class="col-sm-3 text-danger">
              <form:errors path="user.userName"/>
          </div>
      </div>
      <div class="form-group row">
          <label for="pass" class="col-sm-3 col-form-label">密码：</label>
          <div class="col-sm-6">
              <input type="password" id="pass" name="userPass"
                     class="form-control" placeholder="输入密码">
          </div>
          <div class="col-sm-3 text-danger">
              <form:errors path="user.userPass"/>
          </div>
      </div>
      <div class="form-group row">
        
         <input type="submit" class="btn-primary btn col-3 offset-4" value="注册">
          
      </div>
  </form>

</body>