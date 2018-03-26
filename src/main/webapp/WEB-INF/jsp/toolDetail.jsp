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
	<script src="/statics/js/jquery.min.js"></script>

	<link rel="stylesheet" type="text/css" href="/statics/css/toolDetail.css" />

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
	<div class="col-md-7" id="col10">
		<div class="col-md-11" style="margin-top: 50px;">
			<div class="row">
				<div class="col-md-6">
					<div style="width: 80%; text-align: center;">
						<img src="/statics/img/baiduBrowser.png" style="width: 100%;" />
					</div>
				</div>
				<div class="col-md-6" class="pull-left">
					<b><c:out value="${tool.getToolname()}"/></b><br />
					<span>大小：<c:out value="${tool.getSizeoftool()}"/></span>&nbsp;&nbsp;&nbsp;<span>版本：<c:out value="${tool.getVersion()}"/></span><br />
					<span>更新日期：<c:out value="${tool.getUploadtime()}"/></span><br />
					<span>支持系统：<c:out value="${tool.getSystemsupport()}"/></span><br />
					<span>上传者：<c:out value="${tool.publisher}"/>(<c:out value="${user.username}"/>)</span><br />
					<button class="btn btn-warning btn-embossed" id="downloadButton"><span class="glyphicon glyphicon-download-alt"></span>&nbsp;立即下载</button>&nbsp;
					<a class="btn btn-embossed btn-success" href="addLike/${tool.getId()}"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;觉得很赞</a>
					<div id="" style="margin-top:20px;">
						<form action="downloadTool" method="post" id="form" style="display: none;">
							<div class="form-group has-success">
								<input type="hidden" name="filename" value="${tool.getToolname()}">
								<input type="hidden" name="toolPath" value="${tool.getDirectory()}">
								<input type="hidden" name="toolId" value="${tool.getId()}">
								<input class="form-control" type="text" placeholder="请输入该工具的存储地址" required="required" name="localPath" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn-block btn-danger" value="确认提交" />
							</div>
						</form>
					</div>

				</div>
			</div>
			<div class="" style="margin-top: 50px;">
				<b>软件介绍</b>
			</div>
			<div class="" style="font-size: medium;">
				<p><c:out value="${tool.getDescription()}"/></p>
				<%--<p id="p1" style="display: none;">开发商：百度 <br />软件官网： http://shurufa.baidu.com <br /> 新版特征--%>
					<%--<br /> 新增: <br />1. 新增春生品牌词库，百度输入法助力新创企业组织茁壮成长。 <br />优化：<br /> 1. 修复win8/win10下metro应用无法使用软键盘的问题； <br />2. 优化智能模糊音出词策略，猜你所想更精确。</p>--%>
				<%--<button style="font-size: small;" class="pull-right btn-info" id="button1">展开全部</button>--%>
			</div>
			<div class="">
				<hr style="color:royalblue;"/>
				<div class="col-md-12">
					<div style="margin-top: 50px;">
						<b>热门评论</b>
					</div>
					<div class="comments-app" ng-app="commentsApp" ng- controller="CommentsController as cmntCtrl">
						<!-- From -->
						<div class="comment-form">
							<!-- Comment Avatar -->
							<div class="comment-avatar">
								<img src="/statics/img/head.png">
							</div>
							<form class="form" name="form" action="comments" method="post">
								<div class="form-row">
									<textarea class="input" style="width: 100%;" placeholder="添加评论..." required="required" name="comment"></textarea>
								</div>
								<%--<div class="form-row">--%>
									<%--<input class="input" ng-class="{ disabled: cmntCtrl.comment.anonymous }" ng-disabled="cmntCtrl.comment.anonymous" ng-model="cmntCtrl.comment.author" ng-required="!cmntCtrl.comment.anonymous" placeholder="输入您的邮箱以便联系" type="email">--%>
								<%--</div>--%>
								<%--<div class="form-row text-right">--%>
									<%--<input id="comment-anonymous" ng- change="cmntCtrl.anonymousChanged()" ng-model="cmntCtrl.comment.anonymous" type="checkbox">--%>
									<%--<label for="comment-anonymous">匿名</label>--%>
								<%--</div>--%>
								<input type="hidden" name="toolId" value="${tool.getId()}">
								<div class="form-row" style="font-size: medium;">
									<input type="submit" value="提交评论">
								</div>
							</form>
						</div>
						<!--所有的评论-->

						<div class="comments">
							<!-- Comment -->
							<c:forEach var="comment" items="${comments}" >
								<!-- 评论一个-->
								<div class="comment">
									<!-- Comment Avatar -->
									<div class="comment-avatar">
										<img src="http://lorempixel.com/200/200/people">
									</div>
									<!-- Comment Box -->
									<div class="comment-box">
										<div class="comment-text"><c:out value="${comment.getContents()}"/>
										</div>
										<div class="comment-footer">
											<div class="comment-info">
														<span class="comment-author">
														<a href="#">评论时间</a>
													</span>
												<span class="comment-date"><c:out value="${comment.getCommentstime()}"/></span>
											</div>
											<div class="comment-actions">
												<a href="#"><c:out value="${comment.getUsernum()}"/><c:out value="("/><c:out value="${comment.getUsername()}"/><c:out value=")"/></a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

							<!-- 评论一个-->
							<%--<div class="comment">--%>
								<%--<!-- Comment Avatar -->--%>
								<%--<div class="comment-avatar">--%>
									<%--<img src="http://lorempixel.com/200/200/people">--%>
								<%--</div>--%>
								<%--<!-- Comment Box -->--%>
								<%--<div class="comment-box">--%>
									<%--<div class="comment-text">Eligendi voluptatum ducimus architecto tempore, quaer corporis totam reprehenderit quasi sapiente--%>
									<%--</div>--%>
									<%--<div class="comment-footer">--%>
										<%--<div class="comment-info">--%>
														<%--<span class="comment-author">--%>
														<%--<a href="#">Ximme</a>--%>
													<%--</span>--%>
											<%--<span class="comment-date">Jan 31, 1986 11:32:04 PM</span>--%>
										<%--</div>--%>
										<%--<div class="comment-actions">--%>
											<%--<a href="#">Reply</a>--%>
										<%--</div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<%--<div class="comment">--%>
								<%--<!-- Comment Avatar -->--%>
								<%--<div class="comment-avatar">--%>
									<%--<img src="http://lorempixel.com/200/200/people">--%>
								<%--</div>--%>
								<%--<!-- Comment Box -->--%>
								<%--<div class="comment-box">--%>
									<%--<div class="comment-text">Eligendi voluptatum ducimus architecto tempore, quaer corporis totam reprehenderit quasi sapiente--%>
									<%--</div>--%>
									<%--<div class="comment-footer">--%>
										<%--<div class="comment-info">--%>
														<%--<span class="comment-author">--%>
														<%--<a href="#">Ximme</a>--%>
													<%--</span>--%>
											<%--<span class="comment-date">Jan 31, 1986 11:32:04 PM</span>--%>
										<%--</div>--%>
										<%--<div class="comment-actions">--%>
											<%--<a href="#">Reply</a>--%>
										<%--</div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<!-- 评论在此后添加-->
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-3" style="margin-top: 50px;" id="col3">
		<div style="text-align: center;">
			<img src="/statics/img/Clipboard.png" />
		</div>
	</div>
</div>

<script>
    $(document).ready(function() {
        $("#button1").click(function() {
            $("#p1").slideToggle("slow");
        });
        $("#downloadButton").click(function(){
            $("#form").show();
        });
    });
</script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/statics/js/flat-ui.min.js"></script>
<script src="/statics/js/video.js"></script>
<script src="/statics/js/prettify.js"></script>
<script src="/statics/js/application.js"></script>
</body>

</html>