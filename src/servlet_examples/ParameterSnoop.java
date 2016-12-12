/*
 * http://localhost:8888/SL314/ParameterSnoop?name1=peter1&name2=peter2&name3=peter3
 */

package servlet_examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 表單核取方塊 checkbox
 */
public class ParameterSnoop extends HttpServlet {

	
//	public void doGet(HttpServletRequest req,HttpServletResponse res)
//	throws ServletException,IOException
//	{
//		res.setContentType("text/plain;charset=Big5");
//		PrintWriter out = res.getWriter();
//		
//		out.println("Query String:");
//		out.println(req.getQueryString());
//		out.println();
//
//	}
//	public void doPost(HttpServletRequest req,HttpServletResponse res)
//	throws ServletException,IOException
//	{
////		doGet(req,res);
//	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=Big5");
		PrintWriter out = res.getWriter();

		out.println("Query String:");
		out.println(req.getQueryString());
		out.println();
		
		/*先*/req.setCharacterEncoding("UTF-8");
		out.println("Request Character Encoding:");
		/*後*/out.println(req.getCharacterEncoding());/*如果沒有"先"，req.getCharacterEncoding()為null */
		out.println();
		
		out.println("Request Parameters:");
		Enumeration en = req.getParameterNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String values[] = req.getParameterValues(name);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					out.println(name + " [" + i + "]: " + values[i]);
					System.out.println(name + " [" + i + "]: " + values[i]);
				}
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
