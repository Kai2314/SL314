package han;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HwFromGet {
	// �אּpost�������
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ��
		req.setCharacterEncoding("UTF-8");

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		// ��
		String name = req.getParameter("name");

		// �A
		String name2 = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String name3 = null;
		// ���~�覡:

		System.out.println(name3 == null);
		System.out.println(name2 == null);
		System.out.println(name2.trim().length() == 0); // JDK1.0�N��
		System.out.println(name2.trim().isEmpty()); // JDK1.6�~��
		System.out.println(name2.trim().equals(""));

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, �A�n: " + name);
		out.println("</BODY></HTML>");
	}
}
