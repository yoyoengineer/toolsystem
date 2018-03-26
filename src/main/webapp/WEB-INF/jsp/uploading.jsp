<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ToolRespository</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Loading Bootstrap Flat UI-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/flat-ui.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="img/icon.jpg">
	<link rel="stylesheet" type="text/css" href="css/docs.css" />
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js" type="text/javascript" charset="utf-8"></script>

	<link rel="stylesheet" type="text/css" href="css/uploadTool.css" />

</head>

<body>
<div class="container" id="container666">
	<div class="row">

		<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">

			<div class="navbar-header">
				<a class="navbar-brand" href="toolsDisplay">ToolRepository</a>
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
					<a href="displayByToolType/${toolType.getId()}"/>
					<c:out value="${toolType.getCategory()}"/>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="col-md-10" id="col10" >
		<div class="col-md-10" style="background: rgb(26,188,156);height: 100%;">
			<div class="" style="width: 100%; padding-top: 0px;min-height:80px ;">
				<h3 style="padding-top: 0px; text-align: center;">&nbsp;&nbsp;玩命上传中,请耐心等待....</h3>
			</div>
			<div class="row">
				<div class="col-md-3"><img src="img/Watches.png" alt="欢迎来到上传页面" /></div>
				<div class="col-md-6" style="text-align: center;">
					<div class="progress" style="margin-top: 100px;">
						<div class="progress-bar progress-bar-info" style="min-width: 2em; width: 10%;">
							10%</div>
					</div>
					<div style="text-align: center;">
						<button class="btn btn-embossed btn-danger cancelButton" id="cancelUpload">取消上传</button>
					</div>
					<div style="text-align: center;">
						<a href="toolDisplay.html" class="btn btn-embossed btn-danger returnButton">返回首页</a>
					</div>
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
	<script type="text/javascript">
        $(document).ready(function() {
            $("#cancelUpload").click(function() {
                $(".progress").hide();
                $(".cancelButton").hide();
                $(".returnButton").show();
                $("h3").html("您已取消上传！");

            });
        });
	</script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/flat-ui.min.js"></script>
	<script src="js/video.js"></script>
	<script src="js/prettify.js"></script>
	<script src="js/application.js"></script>
</body>

</html>