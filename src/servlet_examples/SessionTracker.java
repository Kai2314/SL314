package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * getAttribute取出List的索引值用?
 */

public class SessionTracker extends HttpServlet {

	String url = "http yahoo";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		// Get the current session object, create one if necessary
		HttpSession session = req.getSession();

		/*
		// Increment the hit count for this page. The value is saved
		// in this client's session under the name "tracker.count".
		Integer count = (Integer) session.getAttribute("tracker.count");
		if (count == null)
			count = new Integer(1);
		else
			count = new Integer(count.intValue() + 1);
		session.setAttribute("tracker.count", count);
		*/
		
		
		ArrayList<String> arr = (ArrayList<String>) session.getAttribute("造訪過網頁");
//		Integer count = (Integer) session.getAttribute("造訪網頁順序");
		if(arr==null ){			
			arr = new ArrayList<>();
			arr.add(url+arr.size());
		}
		else
			arr.add(url+arr.size());
		session.setAttribute("造訪過網頁",arr);

		
		for(String str : arr){
			System.out.println(str);
		}
		System.out.println("=====================");
		/*
		out.println("<HTML><HEAD><TITLE>SessionTracker</TITLE></HEAD>");
		out.println("<BODY><H1>Session Tracking Demo</H1>");

		// Display the hit count for this page
		out.println("You've visited this page " + count + ((count.intValue() == 1) ? " time." : " times."));

		out.println("<P>");

		out.println("<H2>Here is your session data:</H2>");
		Enumeration en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			out.println(name + ": " + session.getAttribute(name) + "<BR>");
		}
		out.println("</BODY></HTML>");
		*/
	}
}
