
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/*
 * 要先運行Get，才能放Set
 * 
 * O存活時間ServletContent > Session
 *   content除非server關必要不然會保存資料
 *   session關閉瀏覽器，資料就會刪除。(or 存活三十分鐘)
 * O可見度ServletContent > Session:
 * 	content 兩個瀏覽器之間可以看到
 * 	session 不可以 
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
