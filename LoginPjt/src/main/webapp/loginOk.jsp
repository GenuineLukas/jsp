//loginOk.jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login OK </title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();

        for(Cookie c: cookies){
            out.print("name: "+ c.getName() + "<br>");
            out.print("value: " + c.getValue()+"<br>");
            out.print("----------------------------------<br>");
        }
    %>
</body>
</html>