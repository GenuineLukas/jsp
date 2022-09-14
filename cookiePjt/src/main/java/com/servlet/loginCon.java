package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginCon() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	
	String mId = request.getParameter("mID");
	String mPw = request.getParameter("mPW");
	
	Cookie[] cookies = request.getCookies(); //cookies are saved client side.
	Cookie cookie = null;
	
		for( Cookie c : cookies) {
			System.out.println("c.getName: " + c.getName() + "c.getValue: " + c.getValue());
			
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		} 
		
		if(cookie == null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberID", "mID");
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOk.jsp");
 	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
