<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>toolSystem</title>
</head>
<body>
<%
    com.yo.toolsystem.service.serviceImpl.TaskBean task = (com.yo.toolsystem.service.serviceImpl.TaskBean)session.getAttribute("task");
    %>
<h1 align="center">Upload Status</h1>
<h2 align="center">
    <% int percent =task.getPercentage();  %>
    <%=percent%>%
</h2>

<table width="60%" align="center"
       border="1" cellpadding="0" cellspacing="2">
    <tr>
        <%for (int i=10; i <= percent; i +=10){ %>
        <td width="10%" bgcolor="#000080">&nbsp;</td>
        <%} %>
        <%for (int i=100; i > percent; i-=10){ %>
        <td width="10%">&nbsp;</td>
        <%} %>
    </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center">
            <% if(task.isCompleted()){
                out.println("Completed");
            }
            else {
                out.println("Upload Cancelled");
            }
                session.removeAttribute("task");
            %>

        </td>
    </tr>
    <tr>
        <td align="center">
            <br>
            <a href="toolDisplay">Go to the home page</a>
        </td>
    </tr>
</table>

</body>
</html>