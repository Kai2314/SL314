#Servlet 學習筆記
---

用到網頁:

1. [主網頁](https://shps951023.github.io/SL314/)
2. [Servlet 3.0 API - Apache Tomcat 7.0.73](https://tomcat.apache.org/tomcat-7.0-doc/servletapi/)
3. [jsp-api-2.2-javadoc ](https://shps951023.github.io/SL314/jsp-api-2.2-javadoc/index.html)
4.  [servlet-3.0-final-javadoc](https://shps951023.github.io/SL314/servlet-3_0-final-javadoc/index.html)

---

- 容器、Servlet與JSP:

  Servlet/JSP 所認得的唯一網站就是Web容器;Servlet/JSP各司其職。

  - [何為容器]()
  - [第一個Servlet]()
  - [第一個JSP]()
  - [關於MVC/Model2]()


- 關於請求:

  取得使用者的請求加以處理是 Web 程式服務的開端。

  - [URL 模式]()
  - [doGet()、doPost()...]()
  - [請求參數、標頭]()
  - [getReader()、getInputStream()]()
  - [getPart()、getParts()]()
  - [調派請求]()


- 課程大綱 part1
  - 1.Web Application概觀與開發環境準備
  - 2.撰寫 與 佈署 HTTP Servlet
  - 3.[Servlet的生命週期(Servlet介面)](docs/CH03.md)
  - 4.撰寫資訊(HttpServletRequest,ServletConfig,ServeletContext介面)
  - 5.傳送HTML資訊(HttpServletRequest介面)
  - 6.Session Tracking(HttpSession介面)
  - 7.資料庫連結(DataSource介面&JNDI)
  - 8.Servlet協同運作(HttpServletRequest,RequestDispatcher介面)


- 課程大綱 part2
  - 9.JavaServer Pages(JSP)
  - 10.運算式語言EL
  - 11.JSTL


- 課程大綱 part3
  - 12.監聽器(HttpSessionBindingListener,ServletContextListener介面)
  - 13.過濾器(Filter介面)
  - 14.安全性(security)
