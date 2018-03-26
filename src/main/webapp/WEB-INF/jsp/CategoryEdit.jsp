<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>toolSystem</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Loading Bootstrap Flat UI-->
		<link href="/statics/css/bootstrap.min.css" rel="stylesheet">
		<link href="/statics/css/flat-ui.min.css" rel="stylesheet">
		<link rel="shortcut icon" href="/statics/img/Ts.ico">
		<link rel="stylesheet" type="text/css" href="/statics/css/docs.css" />
		<script src="/statics/js/html5shiv.js"></script>
		<script src="/statics/js/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/statics/css/manager.css" />
	</head>

	<body>
	<%--<% if(session.isNew())--%>
		<%--response.sendRedirect("index.jsp");%>--%>
		<div class="container" id="container666">
			<div class="row">

				<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">

					<div class="navbar-header">
						<a class="navbar-brand" href="superManagerPage">toolSystem</a>
					</div>
					<div>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class=" text form-control" placeholder="请输入工具名">
							</div>
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
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
		<div class="container">
			<div class="col-md-2">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<%--<li class="active">--%>
					<%--<a href="#">--%>
					<%--<i class="glyphicon glyphicon-th-large"></i> 首页--%>
					<%--</a>--%>
					<%--</li>--%>
					<li>
						<a href="#selfManagement" class="nav-header collapsed" data-toggle="collapse">
							<i class="glyphicon glyphicon-cog"></i> 员工管理
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="selfManagement" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<%--<li>--%>
							<%--<a href="#"><i class="glyphicon glyphicon-user"></i>个人资料</a>--%>
							<%--</li>--%>
							<%--<li>--%>
							<%--<a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a>--%>
							<%--</li>--%>
							<li>
								<a href="superManagerPage"><i class="glyphicon glyphicon-user"></i>子管理员管理</a>
							</li>
							<li>
								<a href="managesUserPage"><i class="glyphicon glyphicon-user"></i>普通员工管理</a>
							</li>
							<%--<li>--%>
								<%--<a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a>--%>
							<%--</li>--%>
						</ul>
					</li>
					<%--<li>--%>
					<%--<a href="#toolManagement" class="nav-header collapsed" data-toggle="collapse">--%>
					<%--<i class="glyphicon glyphicon-credit-card"></i> 工具管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span>--%>
					<%--</a>--%>
					<%--<ul id="toolManagement" class="nav nav-list collapse secondmenu" style="height: 0px;">--%>
					<%--<li>--%>
					<%--<a href="manageCategory"><i class="glyphicon glyphicon-user"></i>工具类别</a>--%>
					<%--</li>--%>
					<%--<li>--%>
					<%--<a href="#"><i class="glyphicon glyphicon-edit"></i>工具标签</a>--%>
					<%--</li>--%>
					<%--<li>--%>
					<%--<a href="#"><i class="glyphicon glyphicon-edit"></i>新增工具</a>--%>
					<%--</li>--%>
					<%--</ul>--%>
					<%--</li>--%>
					<%--<li>--%>
					<%--<a href="#">--%>
					<%--<i class="glyphicon glyphicon-globe"></i> 待审核工具--%>
					<%--<span class="label label-warning pull-right">5</span>--%>
					<%--</a>--%>
					<%--</li>--%>
					<%--<li>--%>
					<%--<a href="#">--%>
					<%--<i class="glyphicon glyphicon-calendar"></i> 图表统计--%>
					<%--</a>--%>
					<%--</li>--%>
					<li>
						<a href="managesToolsBySuperManager">
							<i class="glyphicon glyphicon-fire"></i> 工具管理
						</a>
					</li>
					<li>
						<a href="manageCategory">
							<i class="glyphicon glyphicon-fire"></i> 工具类别
						</a>
					</li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-fire"></i> 关于系统
						</a>
					</li>
					<%--<c:forEach var="toolType" items="${toolTypes}" >--%>
					<%--<li>--%>
					<%--<a href="displayByToolTypeForSubManager/${toolType.getId()}">--%>
					<%--<c:out value="${toolType.getCategory()}"/>--%>
					<%--</a>--%>
					<%--</li>--%>
					<%--</c:forEach>--%>
				</ul>
			</div>
			<div class="col-md-10">
				<div style="margin-top: 20px;">
					<h3>请小心修改工具名称：</h3>
				</div>
				<div class="col-md-3">
					<img src="/statics/img/Pensils.png"/>
				</div>
				<div class="col-md-9">					
					<form:form action="editCategory" method="post" style=" width: 80%;" modelAttribute="toolType">
							<div class="form-group has-warning">
								工具种类：<form:input class="form-control EditInput" path="category"/>
							</div>
							<div class="form-group">
								<input type="submit" class="btn  btn-success EditInput" value="确认修改" />
							</div>
					</form:form>
				</div>
			</div>
		</div>
			<script src="/statics/js/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="/statics/js/flat-ui.min.js"></script>
			<script src="/statics/js/video.js"></script>
			<script src="/statics/js/prettify.js"></script>
			<script src="/statics/js/application.js"></script>
	</body>

</html>