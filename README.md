講義:JAVA程式語言(Java Web Application) 筆記:林暐翰 講義作者:吳永志
===

[TOC]

---



# CH01:Web Application 概觀與開發環境準備

---

# CH02:撰寫與佈署HTTP Servlet

---

# CH03:Servlet的生命週期

---

# P48 Init Parameter(初始參數)
<a name="p48">p48</a>
- Init Parameter(初始參數)
	- 設定:web.xml檔案設定如下
```xml
<servlet>
	<servlet-name>InitCounter</servlet-name>
	<servlet-class>servlet_examples.InitCounter</servlet-class>
	<init-param>
		<param-name>initial</param-name>
		<param-value>1000</param-value>
	</init-param>
</servlet>
<servlet-mapping>
	<servlet-name>InitCounter</servlet-name>
	<url-pattern>/InitCounter</url-pattern>
</servlet-mapping>
```
- 程式:在Servlet的init() method內以
String initial_Value = getInitParamet

---

# CH04:擷取資訊(HttpServletRequest,ServletConfig,ServerletContext介面)

---

## P62 取得Servlet自身的資訊(一)

- **取得Servlet初始參數**
	- ``String getInitParameter(String name)`` 取得Servlet初始參數的「值」
	- ``Enumeration getInitParameterNames()`` 列舉Servlet初始參數的「參數」
	- 註:<font color=red>需配合web.xml;</font>(參見<a href=#p48>p48</a>  及下一頁程式片段)
- **取得Servlet名稱,環境(Context)**
	- ``String getServletName()`` 取得「Servlet名稱」(Servlet Content)
- **說明:以上均屬ServletConfig介面(由GenericServlet類別實作)之method**，故程式內直接使用。

---

## P63 取得Servlet自身的資訊(二)
- **程式片段(取得web.xml所提供的所有初始參數名稱、值)**
```java=
java.util.Enumeration enum = getInitParameterNames();
while(enum.hasMoreElements){
	String name = (String)enum.nextElement();
	out.println(name+":"+getInitParameter(name));
}
```

---

## 取得Client的資訊(十三)

- Request介面之屬性(Attribute method)
	- void req.setAttribute


---
# CH05:傳送HTML資訊(HttpServletResponse介面)

## P88 基本概念
- 「Response Content(回應內容)」是回應客戶端時的主要內容
	- 對HTML網頁而言，Response Content就是HTML本身文字檔
	- 對圖像來說，Response Content則是構成其影像的位元組(byte)
- 以最低階的觀點來看，Web伺服器其實是將「整個回應」當成一連串的位元組(byte)傳給客戶端而以，所以HTTP協定規定伺服器必須:
	- **先**送出「Status Line」和「Response Header(回應標頭)」之設定
	- **後**才能送出「Response Content(回應內容)」
	- 以便客戶端流覽器能先解讀回應時的「Status Line」與「Response Header(回應標頭)」之設定，才能建構出「該串後到的位元組(byte)」

## 資料型態&輸出資料流(一)
- 資料型態設定
	- **目的**:送出「Response Content(回應內容)」之前，需先設定期內容型態
	- **實作方法:void res.setContentType(String type)**
		設定Response(回應)的內容型態
		- 例1:
			```java
			res.setContentType("text/html")
			res.setContentType("text/html;charset=ISO-8859-1");
			res.setContentType("text/html;charset=UTF-8");
			res.setContentType("text/html;charset=Big5");
			res.setContentType("text/html;charset=Shift_JIS");
			```
		- 例2:
			res.setContentType("image/gif");...
	- 說明:
		- 可同時指定進行字元編碼(character encoding)時所採用的**字碼集(charset)**
		- 以上res指ServletResponse型別物件
		- 在HTTP Servlet，此方法會設定「Response Header(回應標頭)」中Content-Type標頭(header)
## 資料型態&輸出資料流(二)
- 文字資料(characte text)輸出
	- 例 
		```java
			res.setContentType("text/html;charset=UTF-8")
			PrintWriter out = res.getWriter();
		```
	- **註:**會先將收到的Unicoide字元轉換成所指定的字碼集(charset)的對應字元，然後才寫入Response(回應)

- 二位元資料(binary data)輸出
	- 例:
	```java
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
	```
	- **註:可進行任何的編碼程序!**
	- **注意事項:**
		- 以上兩個方法只能**擇一使用**，否則將產生執行時期的java.lang.**IllegalStateException**例外 **<--假如出現是結構問題(假如出現請找老師)**

---

## P91 持續性連線&回應緩衝區(一)
- 持續型連線(persistent connection)
	- 目的:讓客戶端能夠保持著使用同一個socket連線，以取得網頁的多個片段(譬如網頁內含多個圖檔)，稱之持續性連線(persistent connection) <--(專有名詞)
	- 實作方法:
		```java
			void res.setContentLength(int len)//(見以下說明)(來設定緩衝區的大小)
		```
		- 設定Response(回應)的內容長度
	- 說明:
		- 以上res指ServletResponse型別物件
		- 在HTTP Servlet，此方法會設定「Response Header(回應標頭)」中Content-Length標頭 (header)
		- 在HTTP Servlet 可利用此方法來保持**持續性聯現(persistent connection，有時稱之keep-alive connection)**<--(保持同一個通道)
		- 程式設計師冰部一定要自己計算內容長度，如果回應內容的長度在指定的**回應緩衝區(Response buffer)**容量之內，伺服器**通常**幫你設定內容長度


---
## P92 持續性連線&回應緩衝區(二) (必考頁數)
- 回應緩衝區(Response buffer)
- **void res.setBufferSize(int size) <-(必考題)8K大小**
		Sets the preferred buffer size for the body of the response.
		- <font color=red>**目的:提高緩衝區大小，提高效能
		原因:減少Socket的切換**
		</font>
		- **P.S** 
			- 通常人的耐性只有3.6秒，登入耐性只有0秒。
			- 撥接時代慢慢跑照片的情況，就是8K的緩衝區
		
	- **int res.getBufferSize()**
		Returns the actual buffer size used for the response.
	- **boolean res.isCommitted()**
		Return boolean indicating if the response has been committed.
	- **void res.flushBuffer() throws java.io.IOException**
		Forces any content in the buffer to written to the client.
	- 註:
		- 以上res指ServletResponse型別物件

範例:
[KeepAlive.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/KeepAlive.java)
[Buffering.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/Buffering.java)

---

## P93 狀態碼設定(一)

- 狀態碼(Status Code)
	- <b>目的:</b> 藉由狀態碼(Status Code)的使用，Servlet將可作更多的事情，例如，它可以**重導**(redirect)一個request，或是**回報錯誤**
	所有的狀態碼見:[附錄五](https://i.imgur.com/EF3Fyff.png)
	- **1xx:** 

```
PS.
```

---

## P94 狀態碼設定(二)
- 設定狀態碼(Status Code)
	- **void res.setStatus(int sc)**
		- 設定HTTP狀態碼(Status Code)
		- 可用一般數值，或**HttpServletResponse接面所定義的SC_XXX常數來表示**；需於送出(Response)回應主體之前使用。
		- void 

PS:
```
可以配合P101
	錯誤處理 : setSatus code + web.xml
	
```

---

## P95

---
## P96
- ++**回應標頭(Response Header)設定(續)**++

```xml
 <META 
```

**PS**
```
中文亂碼有三次:
JSP一出來就有五隻手了(亂碼問題)。
	
```

---

## P97 應用1 - 重導請求
- 重導請求()
	- **目的:**將客戶端之請求，重導(Redirect)至指定的地點


**PS:**
```
哪三個第方不一樣
1.
2.


- Context 跟 Map的技術


P150 當http前面加上/ 會是全部路徑壓上去
	
- 斜線(/)分為:
	html 
	CSS
	AJS
	jQuery
	Xml
::: warning
	有一堆斜線(/)
:::


```

---
## P98 應用2-客戶端提取
- 客戶端提取(Client Pull)
	- 目的:客戶端父則提取(pull)下一網頁
	- 模式說明:客戶端提取(Client PUll)，
	- 實作方法:
		- res.setHeader

範例:
<b>
[SiteSelector](https:// "title")
[ClientPull](https:// "title")
[ClientPullMove](https:// "title")
</b>

---

## P99 not to cache the response
- Tell the browser not to caher the response
- <font color=blue>**目的:**</font>**避免瀏覽器對文件的快取(cache)**
- <font color=blue>**實作方法:**</font>搭配使用以下3種方法以避免瀏覽器對文件的快取 
	- 1 res.getHeader("Cache-Control","no-store");
---

## P101 錯誤處理(二)
- 錯誤處理(續)
	- 
---
## P104 錯誤處理(五)
- 補充1:例外(exception)及**javax.servlet.ServletException之攔截**
	- 伺服端的錯誤，可由攔截(catch)**javax.servlet.ServletException**後將之丟出 **(throw):**
	(1:)交由伺服器處理，或
	(2:)交給web.xml檔所指定的程式處理，web.xml如下所示:
	```xml
	<web-app>
		<error-page>
			<exception-type>javax.servlet.ServletException</exception-type>
			<location>/ErrorDisplay</location>
		</error-page>
	</web-app>
	<!--
		1.這是一個動態的Servlet程式
		2.can do anything
	-->
	```

## P162 Directive Elements(1/2)
-  Directive Elements主要用來提供整個網頁的說明
	- ``<%@ ... %>``型式出現也分三類
		- 1 ``<%@ ... %>``
		- 2
		- 3

PS:
```
charset是下指令給瀏覽器
pageEncoding是下指令給伺服器
	假如不一樣會造成通知錯誤，會讓Tomcat誤以為
- 要先pageEncoding正確編碼，在確定charset
- 結論:只要pageEncoding正確就好
- 如果 pageEncoding 省略，會拿charset來用
- Eclipse會自動幫你轉碼(Ex.pageEncoding="UTF-8"，會自動幫你轉成UTF-8)，只有在uE環境才可以
- charset會改變(檢視->編碼)的對應。
	- 從Eclipse (export->file)，會轉出對應pageEncoding的編碼。
	- 強烈建議:假如從Eclipse導出到UE不要亂動編碼。
	- 要轉碼請使用Big5 ->ASII 
	不要使用Big5->Unicode(因為有Utf-16
	)
	- 小結論: 如果希望任何編輯器都沒有編碼錯誤，請使用pageEncoding=Big5

- UTF-8 有(檔首有無BOM)，微軟的問題。
記事本會自動生出來

```
 
### 網頁亂碼的問題 
- 編碼的手有哪幾隻?
	- 1.瀏覽器
	- 2.程式 (Servlet)
	- 3.編輯器
	- 4.伺服器
	- 5.WorkSpace (Eclipse)
		- (windows->Preference->WorkSpace->Text file encoding)
		- 為甚麼要改?
			- 因為作業系統用Mac的時候
		- 注意:
			- 團隊開發要統一
	- 6.雲端
 
:::success
:warning: <font color=Red>**總結:一個環節錯了，就會全錯。**</font>
:::
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
--- 
 
```

---
	出現RunetimeException通常都是自己粗心的問題
		媽媽的例子
		
	Runetime	
---

---
- 讀檔案時要讀取IOException
- 資料庫會有 SQLException
- 但是IllgalException是RuntimeException 運行時錯誤，可捕捉，可不捕捉

---
	IllegalStateException因為Tomcat緩衝區是彈性的。
---

---
資料庫連結P140
SL314-DBGifReader
---

不可擇一使用。

---
可以一對多，
甚麼通通解決
不會有"後者蓋前者問題"

Q 請求參數
Src是

Q HTML

Q.甚麼是DB
DBGifReader?


Q.為甚麼是文字輸出"text/html"
裡面會有文字輸出



# 圖片放在資料庫
當我從資料庫查出庫自時
用PrintWriter語法

圖片出來時 要用
ServletOutputStream



BufferReaderIN
Reader


必考:P90
PrintWriter
getOutputStream
差別
前者會幫你你進行編碼(轉charset)



文字出口會先將收到的字元轉換成對應字元

而二位元 不進行

黑箱->Header->Content

P97十顆星方法 sendRedirect

setHeader 只有這個標頭嗎?
p223有一群標頭 跟它是同一個位階
```

---
# PS


req.getSession()
裡面有藏boolean


---



---
# 照片補充:
![](https://i.imgur.com/TWeY8n3.jpg)
- Error是廣島原子彈，
	- AssertionError可以哀一聲在死(java 1.4)才有
	- ...Error 安靜的死去
- Exception
	- ....Exception
	- SQLException
	- IOException

![](https://i.imgur.com/lUdmLWl.jpg)
![](https://i.imgur.com/nIC67GK.jpg)
![](https://i.imgur.com/BJd4YZH.jpg)
![](https://i.imgur.com/9kpYpyJ.jpg)
![](https://i.imgur.com/pIzdJQl.jpg)
![](https://i.imgur.com/QYyrfVk.jpg)
![](https://i.imgur.com/kGcHN6O.jpg)
![](https://i.imgur.com/4p37qC2.jpg)
![](https://i.imgur.com/mAczc9a.jpg)
![](https://i.imgur.com/ULKzZuH.jpg)

1210功課
![](https://i.imgur.com/zH1H9YZ.png)


