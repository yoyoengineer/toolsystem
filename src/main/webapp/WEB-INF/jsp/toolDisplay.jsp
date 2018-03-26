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

		<link rel="stylesheet" type="text/css" href="/statics/css/managerToolDisplay.css" />

	</head>

	<body>
	<%--<% if(session.isNew())--%>
		<%--response.sendRedirect("index");%>--%>
		<div class="container" id="container666">
			<div class="row">

				<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">
					<%--<div class="navbar navbar-default navbar-static-top " role="navigation">--%>
					<div class="navbar-header">
						<a class="navbar-brand" href="toolsDisplay">toolSystem</a>
					</div>
					<div>
						<form class="navbar-form navbar-left" role="search" action="searchTools" method="post">
							<div class="form-group">
								<input type="text" class=" text form-control" name="search">
							</div>
							<input type="submit" class="btn btn-default">搜索</input>
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
			<div class="col-md-2" id="col2">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<c:forEach var="toolType" items="${toolTypes}" >
						<li>
							<a href="displayByToolType/${toolType.getId()}">
							<c:out value="${toolType.getCategory()}"/>
							</a>
						</li>
					</c:forEach>
					<%--<li class="active">--%>
						<%--<a href="#">--%>
							<%--系统工具--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">--%>
							<%--图形图像--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">--%>
							<%--游戏娱乐--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">--%>
							<%--图表统计--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">--%>
							<%--系统工具--%>
						<%--</a>--%>
					<%--</li>--%>
					
				</ul>
			</div>
			<div class="col-md-10" id="col10">
				<div class="col-md-10">
					<div class="panel panel-default">
						<%--<div class="panel-heading">系统工具</div>--%>
						<ul class="list-group">
							<%--<c:forEach var="tool" items="${tools}" >--%>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h6 style="margin-top: 0px;"><a href="/toolDetails/${tool.getId()}"><c:out value="${tool.getToolname()}"/></a></h6>--%>
									<%--<p ><c:out value="${tool.getDescription()}"/></p>--%>
									<%--<div class="info">--%>
										<%--<span>分类：<a href="displayByToolTypeForSubManager/${toolType.getId()}" target="_blank"><c:out value="${tool.getCategory()}"/></a></span>--%>
										<%--<span>更新：<em><c:out value="${tool.getUploadtime()}"/></em></span>--%>
										<%--<span>人气：<em><c:out value="${tool.getLikenum()}"/></em></span>--%>
										<%--<span>标签：<em><c:out value="${tool.getTooltags()}"/></em></span>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</li>--%>
							<%--</c:forEach>--%>
								<c:if test="${pager.totalRecord!=0}">
							<c:forEach var="tool" items="${pager.dataList}" >
								<li class="list-group-item" style="height: 25%;">
									<div>
										<h6 style="margin-top: 0px;"><a href="/toolDetails/${tool.getId()}"><c:out value="${tool.getToolname()}"/></a></h6>
										<p ><c:out value="${tool.getDescription()}"/></p>
										<div class="info">
											<span>分类：<a href="displayByToolTypeForSubManager/${toolType.getId()}" target="_blank"><c:out value="${tool.getCategory()}"/></a></span>
											<span>更新：<em><c:out value="${tool.getUploadtime()}"/></em></span>
											<span>人气：<em><c:out value="${tool.getLikenum()}"/></em></span>
											<span>标签：<em><c:out value="${tool.getTooltags()}"/></em></span>
											<span>下载量：<em><c:out value="${tool.downloadtimes}"/></em></span>
										</div>
									</div>
								</li>
							</c:forEach>
								</c:if>
						</ul>
					</div>

					<div class="pull-right">
						<div>

							<c:if test="${pager.totalPage>1}">
								<ul class="pagination pagination-minimal">
									<li class="previous">
										<a href="pageDisplay/${pager.currentPage-1}"><</a>
									</li>
									<c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
										<li>
											<a href="pageDisplay/${i}"><c:out value="${i}"/></a>
										</li>
									</c:forEach>
									<li class="next">
										<a href="pageDisplay/${pager.currentPage+1}">></a>
									</li>
								</ul>
							</c:if>

							<%----%>
							<%--<ul class="pagination pagination-minimal">--%>
								<%--<li class="previous"><a href="#fakelink" class="fui-arrow-left"></a></li>--%>
								<%--<li class="active"><a href="#fakelink">1</a></li>--%>
								<%--<li><a href="#fakelink">2</a></li>--%>
								<%--<li><a href="#fakelink">3</a></li>--%>
								<%--<li><a href="#fakelink">4</a></li>--%>
								<%--<li><a href="#fakelink">5</a></li>--%>
								<%--<li><a href="#fakelink">6</a></li>--%>
								<%--<li><a href="#fakelink">7</a></li>--%>
								<%--<li><a href="#fakelink">8</a></li>--%>
								<%--<li><a href="#fakelink">9</a></li>--%>
								<%--<li><a href="#fakelink">10</a></li>--%>
								<%--<li class="pagination-dropdown dropup">--%>
									<%--<a href="#fakelink" class="dropdown-toggle" data-toggle="dropdown">--%>
										<%--<i class="fui-triangle-up"></i>--%>
									<%--</a>--%>
									<%--<ul class="dropdown-menu">--%>
										<%--<li><a href="#fakelink">10–20</a></li>--%>
										<%--<li><a href="#fakelink">20–30</a></li>--%>
										<%--<li><a href="#fakelink">40–50</a></li>--%>
									<%--</ul>--%>
								<%--</li>--%>
								<%--<li class="next"><a href="#fakelink" class="fui-arrow-right"></a></li>--%>
							<%--</ul>--%>
						</div>
					</div>


					<%--<div class="pull-right">--%>
						<%--<c:if test="${pager.totalPage>1}">--%>
						<%--<ul class="pagination-plain">--%>
							<%--<li class="previous">--%>
								<%--<a href="pageDisplay/${pager.currentPage-1}"><span class="glyphicon glyphicon-arrow-left"></span>上一页</a>--%>
							<%--</li>--%>
							<%--<c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">--%>
							<%--<li>--%>
								<%--<a href="pageDisplay/${i}"><c:out value="${i}"/></a>--%>
							<%--</li>--%>
							<%--</c:forEach>--%>
							<%--<li class="next">--%>
								<%--<a href="pageDisplay/${pager.currentPage+1}">下一页 <span class="glyphicon glyphicon-arrow-right"></span></a>--%>
							<%--</li>--%>
						<%--</ul>--%>
						<%--</c:if>--%>
					<%--</div>--%>
				</div>
				<div class="col-md-2">

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