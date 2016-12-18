package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=Utf-8");
		PrintWriter out = res.getWriter();
		// out.println("<HTML>");
		// out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		// out.println("<BODY>");
		// out.println("<BIG>GET</BIG>");
		// out.println("</BODY></HTML>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html; charset=Utf-8");
		 PrintWriter out = res.getWriter();
		// out.println("<HTML>");
		// out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		// out.println("<BODY>");
		// out.println("<BIG>POST</BIG>");
		// out.println("</BODY></HTML>");
	}
}
