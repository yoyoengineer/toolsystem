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
        <style type="text/css">
          input[type="text"] {
            display: inline;
          }
        </style>
		<link href="/statics/css/bootstrap.min.css" rel="stylesheet">
		<link href="/statics/css/flat-ui.min.css" rel="stylesheet">
		<link rel="shortcut icon" href="/statics/img/Ts.ico">
		<link rel="stylesheet" type="text/css" href="/statics/css/docs.css" />
		<script src="/statics/js/html5shiv.js"></script>
		<script src="/statics/js/respond.min.js" type="text/javascript" charset="utf-8"></script>

		<link rel="stylesheet" type="text/css" href="/statics/css/manager.css" />

	</head>

	<body onload="load()">
	<%--<% if(session.isNew())--%>
		<%--response.sendRedirect("index");%>--%>
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
					<h3>欢迎来到员工管理页面</h3>
				</div>
				<div>
					<button type="button" class="btn btn-embossed  btn-info" aria-label="Left Align" style="" onClick="addM()">添加子管理员
  					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					</button>
				</div>
				<div>
					<table class="table table-hover">
						<caption>子管理员：</caption>
						<thead>
							<tr>
								<th>员工号</th>
								<th>员工姓名</th>
								<th>员工性别</th>
								<th>所管工具类别</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${pager.totalRecord!=0}">
						<c:forEach var="person" items="${pager.dataList}" >
							<%--<c:if test="${person.getCategory()eq'子管理员'}">--%>
								<tr>
									<td><c:out value="${person.getUsernum()}"/></td>
									<td><c:out value="${person.getUsername()}"/></td>
									<td>
										<%--<c:choose>--%>
											<%--<c:when test="${person.getGender()==1}">--%>
												<%--<c:out value="男"/>--%>
											<%--</c:when>--%>
											<%--<c:otherwise>--%>
												<%--<c:out value="女"/>--%>
											<%--</c:otherwise>--%>
										<%--</c:choose>--%>
										<c:out value="${person.gender}"/>
									</td>
									<td><c:out value="${person.tooltypemanage}"/></td>
									<td><a href="editPerson/${person.getUsernum()}" class="btn btn-embossed  btn-success">编辑</a>&nbsp; <a href="deletePerson/${person.getUsernum()}" class="btn btn-embossed  btn-warning">删除</a></td>
								</tr>
							<%--</c:if>--%>
						</c:forEach>
						</c:if>
                            <tr class="active" id="addManager">
								<form method="post" action="addManager">
									<td>
										<input type="text" name="usernum" >
                                    </td>
								    <td>
                                        <input type="text" name="username">
									</td>
                                    <td>
                                        <input type="text" name="gender">
									</td>
									<td>
										<%--<input type="text" name="tooltypemanage">--%>
											<select name="tooltypemanage" class="form-control select select-primary select-block mbl">
												<c:forEach items="${toolTypes}" var="toolCategory">
													<option value="${toolCategory.id}">${toolCategory.getCategory()}</option>
												</c:forEach>
												<option value="-1">所有类别</option>
											</select>
									</td>
									<td>
										<input type="submit" value="添加" class="btn btn-embossed  btn-success">&nbsp;&nbsp;
										<input type="button" value="取消" class="btn btn-embossed  btn-warning" onClick="cancleM()">
									</td>
								</form>
							</tr>
						</tbody>
					</table>
				</div>
				<%--<div>--%>
					<%--<button type="button" class="btn btn-embossed  btn-info" aria-label="Left Align" style="" onClick="addU()">添加普通员工--%>
  					<%--<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>--%>
					<%--</button>--%>
				<%--</div>--%>
				<%--<div>--%>
					<%--<table class="table table-hover">--%>
						<%--<caption>普通员工员如下：</caption>--%>
						<%--<thead>--%>
							<%--<tr>--%>
								<%--<th>员工号</th>--%>
								<%--<th>员工姓名</th>--%>
								<%--<th>员工性别</th>--%>
								<%--<th>操作</th>--%>
							<%--</tr>--%>
						<%--</thead>--%>
						<%--<tbody>--%>
						<%--<c:forEach var="person" items="${people}" >--%>
							<%--<c:if test="${person.getCategory()==1}" var="condition">--%>
								<%--<tr>--%>
									<%--<td><c:out value="${person.getUsernum()}"/></td>--%>
									<%--<td><c:out value="${person.getUsername()}"/></td>--%>
									<%--<td>--%>
									<%--<c:choose>--%>
									<%--<c:when test="${person.getGender()==1}">--%>
									<%--<c:out value="男"/>--%>
									<%--</c:when>--%>
										<%--<c:otherwise>--%>
									<%--<c:out value="女"/>--%>
										<%--</c:otherwise>--%>
									<%--</c:choose>--%>
									<%--</td>--%>
									<%--<td><a href="editPerson/${person.getUsernum()}" class="btn btn-embossed  btn-success">编辑</a>&nbsp; <a href="deletePerson/${person.getUsernum()}" class="btn btn-embossed  btn-warning">删除</a></td>--%>
								<%--</tr>--%>
							<%--</c:if>--%>
						<%--</c:forEach>--%>
                            <%--<tr class="active" id="addUser">--%>
								<%--<form method="post" action="addUser">--%>
									<%--<td>--%>
										<%--<input type="text" name="usernum" >--%>
                                    <%--</td>--%>
								    <%--<td>--%>
                                        <%--<input type="text" name="username">--%>
									<%--</td>--%>
                                    <%--<td>--%>
                                        <%--<input type="text" name="gender">--%>
									<%--</td>--%>
									<%--<td>--%>
										<%--<input type="submit" value="添加" class="btn btn-embossed  btn-success">&nbsp;&nbsp;--%>
										<%--<input type="button" value="取消" class="btn btn-embossed  btn-warning" onClick="cancleU()">--%>
									<%--</td>--%>
								<%--</form>--%>
							<%--</tr>--%>
						<%--</tbody>--%>
					<%--</table>--%>
				<%--</div>--%>
				<div class="pull-right">
					<c:if test="${pager.totalPage>1}">
					<ul class="pagination pagination-minimal">
						<li class="previous">
							<a href="personDisplay/${pager.currentPage-1}"><</a>
						</li>
						<c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
							<li>
								<a href="personDisplay/${i}"><c:out value="${i}"/></a>
							</li>
						</c:forEach>
						<li class="next">
							<a href="personDisplay/${pager.currentPage+1}">></a>
						</li>
					</ul>
					</c:if>
				</div>
			</div>
        </div>
        <script type="text/javascript">
			function load() {
                $('#addUser').hide();
                $('#addManager  ').hide();
            }
            function addU(){
                $('#addUser').fadeIn(300);
		    }
            function cancleU(){
                $('#addUser').fadeOut(300);
            }
            function addM(){
                $('#addManager').fadeIn(300);
		    }
            function cancleM(){
                $('#addManager').fadeOut(300);
            }
        </script>
			<script src="/statics/js/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="/statics/js/flat-ui.min.js"></script>
			<script src="/statics/js/video.js"></script>
			<script src="/statics/js/prettify.js"></script>
			<script src="/statics/js/application.js"></script>
	</body>

</html>