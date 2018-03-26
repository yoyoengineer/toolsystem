<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link rel="stylesheet" href="/statics/css/indexLogIn.css" />
      <link href="/statics/css/signUpB.css" rel="stylesheet">
      <link rel="icon" href="/statics/img/Ts.ico">
    <title>toolSystem-index</title>
  </head>
  <body>
    <form method="post" action="/">
      <h2>工具上传下载管理系统:</h2>
      <input type="text" name="usernum" id="usernum" placeholder="请输入你的员工号" />
      <input type="password" name="password" id="password" placeholder="请输入你的密码" />
      <input type="submit" value="用户登陆" id="submit"  />
      <input type="button" value="修改密码" id="reg" data-toggle="modal" onClick="bot()"/>
    </form>
      <div id="Register" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">修改密码</h3>
          </div>
          <div class="modal-body">
            <form class="form-signin" method="post" action="editPassWord">
                <input type="text" placeholder="员工号" name="usernum">
                <input type="text" placeholder="姓名" name="username">
                <%--<input type="text" placeholder="性别" name="email">--%>
                <input type="password" placeholder="原密码" name="oldPassword">
                <input type="password" placeholder="新密码" name="password">
                <input type="password" placeholder="请再次输入密码" name="passwordA">
                <button class="btn btn-large btn-block btn-primary" type="submit">继续</button>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
          </div>
        </div>
        
    <script type="text/javascript">
		function bot(){
            $('#Register').modal('show');
		}
	</script> 
    <script src="/statics/js/jquery-3.1.1.js"></script>
       <script src="/statics/js/bootstrap-modal.js"></script>
  </body>
</html>