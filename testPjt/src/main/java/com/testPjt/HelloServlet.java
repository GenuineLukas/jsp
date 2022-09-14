package com.testPjt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hs")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//web dynamic project 통해 servlet을 만들 수 있고 servlet 상에서 어떤 것을 출력하려면
		//PrintWriter 이라는 객체를 얻어내 정의 된 변수 + .print 메소드를 통해 출력할 수 있다.
		//Servlet 파일을 생성할 때 url mapping 이라고 하는 것은 url 구성요소 중 맨 뒤에(article permalink) 
		//에 해당하는 값을 지정하기 위함이다.
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<body>");
		out.print("<p>Hello Servlet!!</p>");
		out.print("</body>");
		out.print("</head>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
