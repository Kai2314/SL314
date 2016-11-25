package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleCounter extends HttpServlet {

  int count = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException { 
	//不是CGI所以count可以保存，類似服務生還在等待
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();
    count++;
    out.println("Since loading, this servlet has been accessed " +
                count + " times.e"); // Reloading Context with name [/SL314] is completed 修改會reloading重新載入 之前的服務生會換新的
  }
}
