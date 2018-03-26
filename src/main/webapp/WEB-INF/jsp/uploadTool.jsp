<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="utf-8">
	<title>toolSystem</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Loading Bootstrap Flat UI-->
	<link href="/statics/css/bootstrap.min.css" rel="stylesheet">
	<link href="/statics/css/flat-ui.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="/statics/img/Ts.ico">
	<link rel="stylesheet" type="text/css" href="/statics/css/docs.css" />
	<script src="/statics/js/html5shiv.js"></script>
	<script src="/statics/js/respond.min.js" type="text/javascript" charset="utf-8"></script>

	<link rel="stylesheet" type="text/css" href="/statics/css/uploadTool.css" />
</head>

<body>
<%--<% if(session.isNew())--%>
	<%--response.sendRedirect("index");%>--%>
	<div class="container" style="height:100%">
		<div class="container" id="container3">
			<div class="row">
				<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">
					<div class="navbar-header">
						<a class="navbar-brand" href="toolsDisplay">toolSystem</a>
					</div>
					<div class="btn-group nav  navbar-right">
						<button class="btn btn-inverse dropdown-toggle" type="button" data-toggle="dropdown">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu dropdown-menu-inverse " role="menu">
							<li>
								<a href="upload">上传工具</a>
							</li>
							<%--<li>--%>
							<%--<a href="#">修改密码</a>--%>
							<%--</li>--%>
							<li>
								<a href="myDownloadPage">我的下载</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="/logout">注销</a>
							</li>
						</ul>
					</div>
					<!--<button class="btn btn-inverse navbar-btn navbar-right">Log out</button>-->
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		<div class="jumbotron" style="background: rgb(26,188,156);height: 100%;">
			<div class="" style="height: 100%;">
				<div class="" style="width: 100%; padding-top: 0px;">
					<h3 style="padding-top: 0px;">请正确无误地填写完整以下信息：</h3>
				</div>
				<div class="row">
					<div class="col-md-3"><img src="/statics/img/file.png" alt="Welcome to Mail App"  class=" pull-right"/></div>
						<form action="uploadT" method="post" style="text-align: center;" enctype="multipart/form-data">
							<div class="col-md-4" style="text-align: center;">
							<div class="form-group has-success">
								<%--<input class="form-control" type="text" placeholder="请以“名称+版本号+版本类别”的格式输入"  />--%>
								<input class="form-control" type="text" placeholder="请以“版本类别”的格式输入"  name="version"/>
							</div>
							<div class="form-group has-success">
								<input class="form-control" type="text" placeholder="可用的操作系统平台：例如：win10/win7" name="systemSupport"/>
							</div>
							<%--<div class="form-group has-success">--%>
								<%--<input class="form-control" type="text" placeholder="软件语言：例如：中文简体" />--%>
							<%--</div>--%>
							<div class="form-group has-success">
								<input class="form-control" type="file" name="multipartFile"/>
							</div>
							<div class="form-group has-error">
								<textarea class="form-control" placeholder="请就该工具的具体用途，注意事项，突出的特性，上传原因及安装方法等方面选择性地做一个详细的介绍!" style="height: 120px;" wrap="hard" name="description"></textarea>
							</div>
							<div class="form-group">
								<input type="submit" class="btn-block btn-danger" value="确认提交" />
							</div>
					</div>
					<div class="col-md-4 " >
						请选择工具类别：<br />
						<select name="category" class="form-control select select-primary select-block mbl">
							<c:forEach items="${toolCategorys}" var="toolCategory">
								<option value="${toolCategory.getId()}">${toolCategory.getCategory()}</option>
							</c:forEach>
						</select>
						<%--<select class="form-control select select-primary select-block mbl">--%>
							<%--<optgroup label="catagory">--%>
								<%--<option value="0">系统工具</option>--%>
								<%--<option value="1">图形图像</option>--%>
								<%--<option value="2">游戏娱乐</option>--%>
								<%--<option value="3">办公软件</option>--%>
								<%--<option value="4">内部专用</option>--%>
							<%--</optgroup>--%>
						<%--</select>--%>
						<br />
						请给该工具添加标签（最多六个）：
						<div class="tagsinput-primary">
							<input name="tags" class="tagsinput" data-role="tagsinput" value="" />
						</div>
					</div>
							<div class="col-md-1"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--注销模态框-->
	<%--<div class="modal fade" id="modalLogOut1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
		<%--<div class="modal-dialog">--%>
			<%--<div class="modal-content">--%>
				<%--<div class="modal-header">--%>
					<%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
					<%--<h4 class="modal-title" id="myModalLabel">注销</h4>--%>
				<%--</div>--%>
				<%--<div class="modal-body">您确定要注销吗？</div>--%>
				<%--<div class="modal-footer">--%>
					<%--<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>--%>
					<%--<button type="button" class="btn btn-primary">确认</button>--%>
				<%--</div>--%>
			<%--</div>--%>
			<%--<!-- /.modal-content -->--%>
		<%--</div>--%>
		<%--<!-- /.modal -->--%>
	<%--</div>--%>
	<%--<!--管理员登陆signIn模态框-->--%>
	<%--<div class="modal fade" id="adminSignIn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
		<%--<div class="modal-dialog">--%>
			<%--<div id="login-form">--%>
				<%--<h1>管理员通道</h1>--%>

				<%--<form action="" method="post">--%>
					<%--<fieldset>--%>
						<%--<input type="text" name="signUpUsername" placeholder="用户名">--%>
						<%--<input type="password" name="signUpPassword" placeholder="密码">--%>

						<%--<input type="submit" value="登录">--%>
						<%--<input type="reset" value="重置" />--%>
					<%--</fieldset>--%>
				<%--</form>--%>
			<%--</div>--%>
			<%--<!-- /.modal -->--%>
		<%--</div>--%>
	<%--</div>--%>

	<script type="text/javascript">
		$("select").select2({ dropdownCssClass: 'dropdown-inverse' });
	</script>
	<script src="/statics/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	
	<script src="/statics/js/video.js"></script>
	<script src="/statics/js/flat-ui.min.js"></script>
	<script src="/statics/js/prettify.js"></script>
	<script src="/statics/js/application.js"></script>
</body>

</html>