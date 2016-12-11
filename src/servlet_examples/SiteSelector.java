package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SiteSelector extends HttpServlet {

  Vector<String> sites = new Vector<String>();//物件變數，第三章
  Random random = new Random();

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    int siteIndex = Math.abs(random.nextInt()) % sites.size();//用物件的size求餘數
    String site = sites.get(siteIndex);
    res.sendRedirect(site);//相檔於下方兩個
//    res.setStatus(HttpServletResponse.SC_FOUND);//設定403
//    res.setHeader("Location", site);//連結網頁連結
  }
  public void init() throws ServletException {
    sites.add("http://www.oracle.com/technetwork/java/index.html");
    sites.add("http://www.apache.org/");
    sites.add("http://struts.apache.org/");
    sites.add("https://tw.yahoo.com");
  }
}
