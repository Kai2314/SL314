package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SiteSelector extends HttpServlet {

  Vector<String> sites = new Vector<String>();//�����ܼơA�ĤT��
  Random random = new Random();

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    int siteIndex = Math.abs(random.nextInt()) % sites.size();//�Ϊ���size�D�l��
    String site = sites.get(siteIndex);
    res.sendRedirect(site);//���ɩ�U����
//    res.setStatus(HttpServletResponse.SC_FOUND);//�]�w403
//    res.setHeader("Location", site);//�s�������s��
  }
  public void init() throws ServletException {
    sites.add("http://www.oracle.com/technetwork/java/index.html");
    sites.add("http://www.apache.org/");
    sites.add("http://struts.apache.org/");
    sites.add("https://tw.yahoo.com");
  }
}
