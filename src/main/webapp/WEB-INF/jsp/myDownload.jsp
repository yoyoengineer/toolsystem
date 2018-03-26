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
	<link href="/statics/css3/bootstrap.min.css" rel="stylesheet">
	<link href="/statics/css3/flat-ui.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="/statics/img/Ts.ico">
	<link rel="stylesheet" type="text/css" href="/statics/css3/docs.css" />
	<script src="/statics/js3/html5shiv.js"></script>
	<script src="/statics/js3/respond.min.js" type="text/javascript" charset="utf-8"></script>

	<link rel="stylesheet" type="text/css" href="/statics/css3/managerToolDisplay.css" />

</head>
	<body>
	<div class="container" id="container666">
		<div class="row">

			<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">

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
				</ul>
			</div>
			<div class="col-md-10" id="col10">
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-heading" style="color: rgb(244,211,19);"><b>未完成的下载</b></div>
						<ul class="list-group">
							<c:forEach var="tool" items="${pager.dataList}" >
							<li class="list-group-item">
								<div>
									<h9 style="margin-top: 0px;"><a disabled="disabled"><c:out value="${tool.getToolname()}"/></a></h9>
								</div>
								<a href="#" class="btn btn-sm btn-embossed btn-danger pull-right"  style="margin-left:5px;">取消下载</a>
								<form  action="downloadTool" method="post" >
									<input type="hidden" value="1" name="cont">
									<input type="hidden" value="${tool.id}" name="toolId">
										<%--<input type="hidden" value="Git.rar" name="filename">--%>
									<input type="submit" value="继续下载"class="btn btn-sm btn-embossed btn-success pull-right">
									<%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
								</form>

									<%--<a href="#" class="btn btn-sm btn-embossed btn-success pull-right">继续下载</a>--%>


							</li>
							</c:forEach>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h9 style="margin-top: 0px;"><a href="#">公务员考试宝典2010版</a></h9>--%>
								<%--</div>--%>
									<%--<a href="#" class="btn btn-sm btn-embossed btn-success pull-right">继续下载</a>&nbsp;&nbsp;--%>
									<%--<a href="#" class="btn btn-sm btn-embossed btn-danger pull-right">取消下载</a>--%>
							<%--</li>--%>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h9 style="margin-top: 0px;"><a href="#">公务员考试宝典2010版</a></h9>--%>
								<%--</div>--%>
									<%--<a href="#" class="btn btn-sm btn-embossed btn-success pull-right">继续下载</a>&nbsp;&nbsp;--%>
									<%--<a href="#" class="btn btn-sm btn-embossed btn-danger pull-right">取消下载</a>--%>
							<%--</li>--%>
						</ul>
					</div>
					<%--<div class="panel panel-default">--%>
						<%--<div class="panel-heading" style="color: #104E8B;"><b>下载完成</b></div>--%>
						<%--<ul class="list-group">--%>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h9 style="margin-top: 0px;"><a href="#">公务员考试宝典2010版</a></h9>--%>
								<%--</div>--%>
							<%--</li>--%>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h9 style="margin-top: 0px;"><a href="#">公务员考试宝典2010版</a></h9>--%>
								<%--</div>--%>
									<%----%>
							<%--</li>--%>
							<%--<li class="list-group-item">--%>
								<%--<div>--%>
									<%--<h9 style="margin-top: 0px;"><a href="#">公务员考试宝典2010版</a></h9>--%>
								<%--</div>--%>
							<%--</li>--%>
						<%--</ul>--%>
					<%--</div>--%>
					<div class="pull-right">
						<c:if test="${pager.totalPage>1}">
							<ul class="pagination-plain">
								<li class="previous">
									<a href="downloadDisplay/${pager.currentPage-1}"><span class="glyphicon glyphicon-arrow-left"></span>上一页</a>
								</li>
								<c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
									<li>
										<a href="downloadDisplay/${i}"><c:out value="${i}"/></a>
									</li>
								</c:forEach>
								<li class="next">
									<a href="downloadDisplay/${pager.currentPage+1}">下一页 <span class="glyphicon glyphicon-arrow-right"></span></a>
								</li>
							</ul>
						</c:if>
					</div>
				</div>
				<div class="col-md-2">

				</div>
			</div>
		</div>
			<script src="/statics/js3/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="/statics/js3/flat-ui.min.js"></script>
			<script src="/statics/js3/video.js"></script>
			<script src="/statics/js3/prettify.js"></script>
			<script src="/statics/js3/application.js"></script>
	</body>

</html>