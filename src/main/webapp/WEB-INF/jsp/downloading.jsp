<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="taskDownload" class="com.yo.toolsystem.service.serviceImpl.DownloadFileBeanImpl" scope="session"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>toolSystem</title>
	<%
		if(!taskDownload.isCompleted()){%>
	<script language="JavaScript">
        setTimeout("location='update'",1000);
	</script>
	<%} %>


	<title>ToolRespository</title>
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
<%--response.sendRedirect("index.jsp");%>--%>
<%--<h1 align="center">JSP Progress Bar</h1>--%>
<%--<h2 align="center">--%>
<%--<% int percent =taskDownload.getPercentage();  %>--%>
<%--<%=percent%>%--%>
<%--</h2>--%>
<%----%>
<%--<table width="60%" align="center"--%>
<%--border="1" cellpadding="0" cellspacing="2">--%>
<%--<tr>--%>
<%--<%for (int i=10; i <= percent; i +=10){ %>--%>
<%--<td width="10%" bgcolor="#000080">&nbsp;</td>--%>
<%--<%} %>--%>
<%--<%for (int i=100; i > percent; i-=10){ %>--%>
<%--<td width="10%">&nbsp;</td>--%>
<%--<%} %>--%>
<%--</tr>--%>
<%--</table>--%>
<%--<table width="100%" border="0" cellpadding="0" cellspacing="0">--%>
<%--<tr>--%>
<%--<td align="center">--%>
<%--<%if(taskDownload.isRunning()){--%>
<%--//	 					out.println("Running");--%>
<%--}--%>
<%--else {--%>
<%--if(taskDownload.isCompleted()){--%>
<%--//	 		    	  		out.println("Completed");--%>
<%--//  		task.getFileAccessI().getoSavedFile().close();%>--%>
<%--<%    }--%>
<%--else { --%>
<%--//	 		    	    	out.println("Stopped");--%>
<%--} --%>
<%--// 		      		request.getRequestDispatcher("updateDB").forward(request, response);--%>
<%--}--%>
<%--%>--%>
<%----%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td align="center">--%>
<%--<br>--%>
<%--<%if (taskDownload.isRunning()){%>--%>
<%--<form  action="stopDownload" method="post">--%>
<%--<input type="submit" value="Stop">--%>
<%--</form>--%>

<%--<%}else if(!taskDownload.isCompleted()&&!taskDownload.isRunning()){--%>
<%--//				   task.getFileAccessI().getoSavedFile().close();--%>
<%--%>--%>
<%--&lt;%&ndash;<c:out value="${toolId}"/>&ndash;%&gt;--%>
<%--<form  action="downloadTool" method="post">--%>
<%--<input type="hidden" value="1" name="cont">--%>
<%--<input type="hidden" value="${toolId}" name="toolId">--%>
<%--&lt;%&ndash;<input type="hidden" value="Git.rar" name="filename">&ndash;%&gt;--%>
<%--<input type="submit" value="Continue">--%>
<%--</form>--%>
<%--<%}%>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>






<div class="container" id="container666">
	<div class="row">

		<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">

			<div class="navbar-header">
				<a class="navbar-brand" href="toolsDisplay">toolSystem</a>
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
<div class="container" style="height: 100%;">
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
	<div class="col-md-10" id="col10" >
		<div class="col-md-10" style="background: rgb(26,188,156);height: 100%;">
			<div class="" style="width: 100%; padding-top: 0px;min-height:80px ;">
				<%if (taskDownload.isRunning()&&!taskDownload.isCompleted()){%>
				<h3 style="padding-top: 0px; text-align: center;">&nbsp;&nbsp;玩命下载中,请耐心等待....</h3>
				<%}else if (taskDownload.isCompleted()){%>
				<h3 style="padding-top: 0px; text-align: center;">&nbsp;&nbsp;恭喜您，下载已完成！</h3>
				<%}%>
			</div>
			<div class="row">
				<div class="col-md-3"><img src="/statics/img/Watches.png" alt="欢迎来到下载页面" /></div>
				<div class="col-md-6" style="text-align: center;">
					<div class="progress" style="margin-top: 100px;">
						<div class="progress-bar progress-bar-info" style="min-width: 2em; width: ${taskDownload.getPercentage()}%;">
							${taskDownload.getPercentage()}%</div>
					</div>
					<div style="text-align: center;">





						<%if (taskDownload.isRunning()&&!taskDownload.isCompleted()){%>
						<form  action="stopDownload"  method="post">
							<input type="submit" value="暂停" class="btn btn-embossed btn-danger cancelButton">
						</form>

						<%}else if(!taskDownload.isCompleted()&&!taskDownload.isRunning()){
//				   task.getFileAccessI().getoSavedFile().close();
						%>
						<%--<c:out value="${toolId}"/>--%>
						<form  action="downloadTool" method="post" >
							<input type="hidden" value="1" name="cont">
							<input type="hidden" value="${toolId}" name="toolId">
							<%--<input type="hidden" value="Git.rar" name="filename">--%>
							<input type="submit" value="继续"class="btn btn-embossed btn-danger cancelButton">
						</form>
						<%}%>



						<%--<button class="btn btn-embossed btn-danger cancelButton" id="cancelUpload">取消上传</button>--%>
					</div>
					<%--<div style="text-align: center;">--%>
					<%--<a href="toolDisplay.html" class="btn btn-embossed btn-danger returnButton">返回首页</a>--%>
					<%--</div>--%>
				</div>
				<div class="col-md-3">

				</div>
			</div>
		</div>
		<div class="col-md-2">

		</div>
	</div>
</div>
<script src="js/jquery.min.js"></script>
<%--<script type="text/javascript">--%>
<%--$(document).ready(function() {--%>
<%--$("#cancelUpload").click(function() {--%>
<%--$(".progress").hide();--%>
<%--$(".cancelButton").hide();--%>
<%--$(".returnButton").show();--%>
<%--$("h3").html("您已取消上传！");--%>

<%--});--%>
<%--});--%>
<%--</script>--%>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/statics/js/flat-ui.min.js"></script>
<script src="/statics/js/video.js"></script>
<script src="/statics/js/prettify.js"></script>
<script src="/statics/js/application.js"></script>
</body>
</html>