package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;

/*
Servlet���T�Ӥ�k
 -init
 -server
 -destory
PS.���A���|���A�I�s

ServletConfig���|�Ӥ�k
-getParameter
-get
---
�]��GenericServlet�~�ӤW�����
�ҥH���C�Ӥ�k���b�L���W

 */
/*
 * Snoop���R�W�W�h:
 * 	�뱴�x���A���ըϥΦӥH�C
 */
public class InitSnoop extends GenericServlet {

  // No init() method needed

  public void service(ServletRequest req, ServletResponse res)
                             throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    out.println("Init Parameters:");
    /*
     * Java5(JDK1.5) �s�WEnum �C�|�l 
     * 	enum�ܦ�����r 
     * Enumeration �S�����ǩ�
     * 	�S�����ǩʨS�����Y�A�]��key�avalue
     * 
     */
    Enumeration en = getInitParameterNames();
    while (en.hasMoreElements()) {
      String name = (String) en.nextElement();
      out.println(name + ": " + getInitParameter(name));
    }
  }
}
