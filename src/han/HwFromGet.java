package han;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HwFromGet {
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

		System.out.println(name3 == null);
		System.out.println(name2 == null);
		System.out.println(name2.trim().length() == 0); // JDK1.0就有
		System.out.println(name2.trim().isEmpty()); // JDK1.6才有
		System.out.println(name2.trim().equals(""));

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, 你好: " + name);
		out.println("</BODY></HTML>");
	}
}
