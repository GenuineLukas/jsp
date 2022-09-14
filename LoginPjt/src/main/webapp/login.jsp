// login.jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%
        // 저장된 쿠키를 모두 가져온다.
        Cookie[] cookies = request.getCookies();

        // 쿠키가 비어있지 않으면
        if(cookies != null){
            //모든 쿠키를 살펴봐서
            for(Cookie c: cookies){
                //"memberId"라는 이름의 쿠키가 있으면
                if(c.getName().equals("memberId")){
                    // 로그인 완료 화면으로 응답해준다. 
                    response.sendRedirect("loginOk.jsp");
                }
            }
        }
    %>

    <form action="loginCheck" method="post">
        ID: <input type="text" name="userID"><br>
        Password: <input type="password" name="userPwd"><br>
        <input type="submit" value="login">
    </form>
</body>
</html>