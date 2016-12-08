package han;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuth extends HttpServlet {
	Map<String, String> users = new Hashtable<String, String>();
	String allowPsw = "allowed";

	public void doGet(HttpServletRequest req , HttpServletResponse res) {//
		
	}
	public void init() throws ServletException {// why throws ServletException
		users.put("peter1:111", allowPsw);
		users.put("peter2:222", allowPsw);
	}
}
