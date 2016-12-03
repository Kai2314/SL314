
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/*
 * �n���B��Get�A�~���Set
 * 
 * O�s���ɶ�ServletContent > Session
 *   content���Dserver�����n���M�|�O�s���
 *   session�����s�����A��ƴN�|�R���C(or �s���T�Q����)
 * O�i����ServletContent > Session:
 * 	content ����s���������i�H�ݨ�
 * 	session ���i�H 
 * 
 */

public class ServletContext_Get extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		ServletContext context = getServletContext();
		Object myName1 = context.getAttribute("myName1");
		out.println(myName1);
	}
}
