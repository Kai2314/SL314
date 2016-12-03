package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;

/*
Servlet有三個方法
 -init
 -server
 -destory
PS.伺服器會幫你呼叫

ServletConfig有四個方法
-getParameter
-get
---
因為GenericServlet繼承上面兩個
所以有七個方法壓在他身上

 */
/*
 * Snoop的命名規則:
 * 	刺探軍情，測試使用而以。
 */
public class InitSnoop extends GenericServlet {

  // No init() method needed

  public void service(ServletRequest req, ServletResponse res)
                             throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    out.println("Init Parameters:");
    /*
     * Java5(JDK1.5) 新增Enum 列舉子 
     * 	enum變成關鍵字 
     * Enumeration 沒有順序性
     * 	沒有順序性沒有關係，因為key帶value
     * 
     */
    Enumeration en = getInitParameterNames();
    while (en.hasMoreElements()) {
      String name = (String) en.nextElement();
      out.println(name + ": " + getInitParameter(name));
    }
  }
}
