package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

	// 改為post讓它抱錯
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 先
		req.setCharacterEncoding("UTF-8");

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		// 後
		String name = req.getParameter("name");

		// 再
		String name2 = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String name3 = null;
		// 錯誤方式:

		//測試空值差別
		// System.out.println(name3 == null);
		// System.out.println(name2 == null);
		// System.out.println(name2.trim().length() == 0); // JDK1.0就有
		// System.out.println(name2.trim().isEmpty()); // JDK1.6才有
		// System.out.println(name2.trim().equals(""));

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, " + name2 + "</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, 你好: " + name2+"<BR>");
		out.println("Hello, 你好: " + name+"<BR>");
		out.println("</BODY></HTML>");
	}
}
