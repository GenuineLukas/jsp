//loginCheck.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("userID");
        String userPwd = request.getParameter("userPwd");

        out.println(userId);
        out.println(userPwd);

        Cookie[] cookies = request.getCookies(); // 저장된 쿠키들을 담기위한 배열
        Cookie cookie = null;

        // 저장되어 있는 쿠키 배열 검색
        for(Cookie c: cookies){
            System.out.println("cookie name: "+c.getName());
            System.out.println("cookie value: "+c.getValue());

            // 쿠키의 이름이 "memberId"와 같으면 cookie에 그 정보를 담아라.
            if(c.getName().equals("memberId")){
                cookie = c;
            }
        }

        // 쿠키 배열을 모두 살펴보아도 정보가 없는 경우 쿠키 생성
        if(cookie == null){
            System.out.println("cookie is null");
            cookie = new Cookie("memberId", userId);
        }

        // 쿠키 값을 추가해준다.
        response.addCookie(cookie);

        // 쿠키 생명 시간 설정 (1시간)
        cookie.setMaxAge(60 * 60);

        // view 페이지로 응답해줌
        response.sendRedirect("loginOk.jsp");
    }
}