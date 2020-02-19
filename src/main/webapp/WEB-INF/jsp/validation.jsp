<%@ page import="am.bagiryan.sboot.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13.02.2020
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    if (request.getAttribute("code") != null) {
        response.getWriter().println(request.getAttribute("code"));
    }
%>
<% User user = (User) session.getAttribute("user"); %>
<p>code is <%=user.getCode()%></p>
<form action="/validate" method="post">
    <b>
        enter your validation code
    </b></br>
    <input type="number" name="code" size="5" >
    </br>
    <input type="submit" value="Validate"/>
</form>
<button onclick="window.location.href = '/';">Back to Login</button>

</body>
</html>

