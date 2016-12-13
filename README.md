Á¿¸q:JAVAµ{¦¡»y¨¥(Java Web Application) µ§°O:ªLİÂ¿« Á¿¸q§@Í:§d¥Ã§Ó
===
<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->


<!-- /TOC -->

---

<h1 name="CH01">
	CH01:Web Application ·§Æ[»P¶}µoÀô¹Ò·Ç
</h1>

---

# CH02:¼¶¼g»P§G¸pHTTP Servlet

---

# CH03:Servletªº¥Í©R¶g´Á

---

<h2 name="P48">
	P48 Init Parameter(ªì©l°Ñ¼Æ)
</h2>
- Init Parameter(ªì©l°Ñ¼Æ)
	- ³]©w:web.xmlÀÉ®×³]©w¦p¤U
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
- µ{¦¡:¦bServletªºinit() method¤º¥H
String initial_Value = getInitParamet
s
---

# CH04:Â^¨ú¸ê°T(HttpServletRequest,ServletConfig,ServerletContext¤¶­±)

---

## P62 ¨ú±oServlet¦Û¨­ªº¸ê°T(¤@)

- **¨ú±oServletªì©l°Ñ¼Æ**
	- ``String getInitParameter(String name)`` ¨ú±oServletªì©l°Ñ¼Æªº¡u­È¡v
	- ``Enumeration getInitParameterNames()`` ¦CÁ|Servletªì©l°Ñ¼Æªº¡u°Ñ¼Æ¡v
	- µù:<font color=red>»İ°t¦Xweb.xml;</font>(°Ñ¨£p48¤Î¤U¤@­¶µ{¦¡¤ù¬q)
- **¨ú±oServlet¦WºÙ,Àô¹Ò(Context)**
	- ``String getServletName()`` ¨ú±o¡uServlet¦WºÙ¡v(Servlet Content)
- **»¡©ú:¥H¤W§¡ÄİServletConfig¤¶­±(¥ÑGenericServletÃş§O¹ê§@)¤§method**¡A¬Gµ{¦¡¤ºª½±µ¨Ï¥Î¡C

---

## P63 ¨ú±oServlet¦Û¨­ªº¸ê°T(¤G)
- **µ{¦¡¤ù¬q(¨ú±oweb.xml©Ò´£¨Ñªº©Ò¦³ªì©l°Ñ¼Æ¦WºÙ¡B­È)**
```java=
java.util.Enumeration enum = getInitParameterNames();
while(enum.hasMoreElements){
	String name = (String)enum.nextElement();
	out.println(name+":"+getInitParameter(name));
}
```

---

## ¨ú±oClientªº¸ê°T(¤Q¤T)

- Request¤¶­±¤§Äİ©Ê(Attribute method)
	- void req.setAttribute


---
# CH05:¶Ç°eHTML¸ê°T(HttpServletResponse¤¶­±)

## P88 °ò¥»·§©À
- ¡uResponse Content(¦^À³¤º®e)¡v¬O¦^À³«È¤áºİ®Éªº¥D­n¤º®e
	- ¹ïHTMLºô­¶¦Ó¨¥¡AResponse Content´N¬OHTML¥»¨­¤å¦rÀÉ
	- ¹ï¹Ï¹³¨Ó»¡¡AResponse Content«h¬Oºc¦¨¨ä¼v¹³ªº¦ì¤¸²Õ(byte)
- ¥H³Ì§C¶¥ªºÆ[ÂI¨Ó¬İ¡AWeb¦øªA¾¹¨ä¹ê¬O±N¡u¾ã­Ó¦^À³¡v·í¦¨¤@³s¦êªº¦ì¤¸²Õ(byte)¶Çµ¹«È¤áºİ¦Ó¥H¡A©Ò¥HHTTP¨ó©w³W©w¦øªA¾¹¥²¶·:
	- **¥ı**°e¥X¡uStatus Line¡v©M¡uResponse Header(¦^À³¼ĞÀY)¡v¤§³]©w
	- **«á**¤~¯à°e¥X¡uResponse Content(¦^À³¤º®e)¡v
	- ¥H«K«È¤áºİ¬yÄı¾¹¯à¥ı¸ÑÅª¦^À³®Éªº¡uStatus Line¡v»P¡uResponse Header(¦^À³¼ĞÀY)¡v¤§³]©w¡A¤~¯à«Øºc¥X¡u¸Ó¦ê«á¨ìªº¦ì¤¸²Õ(byte)¡v

## ¸ê®Æ«¬ºA&¿é¥X¸ê®Æ¬y(¤@)
- ¸ê®Æ«¬ºA³]©w
	- **¥Øªº**:°e¥X¡uResponse Content(¦^À³¤º®e)¡v¤§«e¡A»İ¥ı³]©w´Á¤º®e«¬ºA
	- **¹ê§@¤èªk:void res.setContentType(String type)**
		³]©wResponse(¦^À³)ªº¤º®e«¬ºA
		- ¨Ò1:
			```java
			res.setContentType("text/html")
			res.setContentType("text/html;charset=ISO-8859-1");
			res.setContentType("text/html;charset=UTF-8");
			res.setContentType("text/html;charset=Big5");
			res.setContentType("text/html;charset=Shift_JIS");
			```
		- ¨Ò2:
			res.setContentType("image/gif");...
	- »¡©ú:
		- ¥i¦P®É«ü©w¶i¦æ¦r¤¸½s½X(character encoding)®É©Ò±Ä¥Îªº**¦r½X¶°(charset)**
		- ¥H¤Wres«üServletResponse«¬§Oª«¥ó
		- ¦bHTTP Servlet¡A¦¹¤èªk·|³]©w¡uResponse Header(¦^À³¼ĞÀY)¡v¤¤Content-Type¼ĞÀY(header)
## ¸ê®Æ«¬ºA&¿é¥X¸ê®Æ¬y(¤G)
- ¤å¦r¸ê®Æ(characte text)¿é¥X
	- ¨Ò
		```java
			res.setContentType("text/html;charset=UTF-8")
			PrintWriter out = res.getWriter();
		```
	- **µù:**·|¥ı±N¦¬¨ìªºUnicoide¦r¤¸Âà´«¦¨©Ò«ü©wªº¦r½X¶°(charset)ªº¹ïÀ³¦r¤¸¡AµM«á¤~¼g¤JResponse(¦^À³)

- ¤G¦ì¤¸¸ê®Æ(binary data)¿é¥X
	- ¨Ò:
	```java
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
	```
	- **µù:¥i¶i¦æ¥ô¦óªº½s½Xµ{§Ç!**
	- **ª`·N¨Æ¶µ:**
		- ¥H¤W¨â­Ó¤èªk¥u¯à**¾Ü¤@¨Ï¥Î**¡A§_«h±N²£¥Í°õ¦æ®É´Áªºjava.lang.**IllegalStateException**¨Ò¥~ **<--°²¦p¥X²{¬Oµ²ºc°İÃD(°²¦p¥X²{½Ğ§ä¦Ñ®v)**

---

## P91 «ùÄò©Ê³s½u&¦^À³½w½Ä°Ï(¤@)
- «ùÄò«¬³s½u(persistent connection)
	- ¥Øªº:Åı«È¤áºİ¯à°÷«O«ùµÛ¨Ï¥Î¦P¤@­Ósocket³s½u¡A¥H¨ú±oºô­¶ªº¦h­Ó¤ù¬q(Ä´¦pºô­¶¤º§t¦h­Ó¹ÏÀÉ)¡AºÙ¤§«ùÄò©Ê³s½u(persistent connection) <--(±M¦³¦Wµü)
	- ¹ê§@¤èªk:
		```java
			void res.setContentLength(int len)//(¨£¥H¤U»¡©ú)(¨Ó³]©w½w½Ä°Ïªº¤j¤p)
		```
		- ³]©wResponse(¦^À³)ªº¤º®eªø«×
	- »¡©ú:
		- ¥H¤Wres«üServletResponse«¬§Oª«¥ó
		- ¦bHTTP Servlet¡A¦¹¤èªk·|³]©w¡uResponse Header(¦^À³¼ĞÀY)¡v¤¤Content-Length¼ĞÀY (header)
		- ¦bHTTP Servlet ¥i§Q¥Î¦¹¤èªk¨Ó«O«ù**«ùÄò©ÊÁp²{(persistent connection¡A¦³®ÉºÙ¤§keep-alive connection)**<--(«O«ù¦P¤@­Ó³q¹D)
		- µ{¦¡³]­p®v¦B³¡¤@©w­n¦Û¤v­pºâ¤º®eªø«×¡A¦pªG¦^À³¤º®eªºªø«×¦b«ü©wªº**¦^À³½w½Ä°Ï(Response buffer)**®e¶q¤§¤º¡A¦øªA¾¹**³q±`**À°§A³]©w¤º®eªø«×


---
## P92 «ùÄò©Ê³s½u&¦^À³½w½Ä°Ï(¤G) (¥²¦Ò­¶¼Æ)
- ¦^À³½w½Ä°Ï(Response buffer)
- **void res.setBufferSize(int size) <-(¥²¦ÒÃD)8K¤j¤p**
		Sets the preferred buffer size for the body of the response.
		- <font color=red>**¥Øªº:´£°ª½w½Ä°Ï¤j¤p¡A´£°ª®Ä¯à
		­ì¦]:´î¤ÖSocketªº¤Á´«**
		</font>
		- **P.S**
			- ³q±`¤Hªº­@©Ê¥u¦³3.6¬í¡Aµn¤J­@©Ê¥u¦³0¬í¡C
			- ¼·±µ®É¥NºCºC¶]·Ó¤ùªº±¡ªp¡A´N¬O8Kªº½w½Ä°Ï

	- **int res.getBufferSize()**
		Returns the actual buffer size used for the response.
	- **boolean res.isCommitted()**
		Return boolean indicating if the response has been committed.
	- **void res.flushBuffer() throws java.io.IOException**
		Forces any content in the buffer to written to the client.
	- µù:
		- ¥H¤Wres«üServletResponse«¬§Oª«¥ó

½d¨Ò:
[KeepAlive.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/KeepAlive.java)
[Buffering.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/Buffering.java)

---

## P93 ª¬ºA½X³]©w(¤@)

- ª¬ºA½X(Status Code)
	- <b>¥Øªº:</b> ÂÇ¥Ñª¬ºA½X(Status Code)ªº¨Ï¥Î¡AServlet±N¥i§@§ó¦hªº¨Æ±¡¡A¨Ò¦p¡A¥¦¥i¥H**­«¾É**(redirect)¤@­Órequest¡A©Î¬O**¦^³ø¿ù»~**
	©Ò¦³ªºª¬ºA½X¨£:[ªş¿ı¤­](https://i.imgur.com/EF3Fyff.png)
	- **1xx:**

```
PS.
```

---

## P94 ª¬ºA½X³]©w(¤G)
- ³]©wª¬ºA½X(Status Code)
	- **void res.setStatus(int sc)**
		- ³]©wHTTPª¬ºA½X(Status Code)
		- ¥i¥Î¤@¯ë¼Æ­È¡A©Î**HttpServletResponse±µ­±©Ò©w¸qªºSC_XXX±`¼Æ¨Óªí¥Ü**¡F»İ©ó°e¥X(Response)¦^À³¥DÅé¤§«e¨Ï¥Î¡C
		- void

PS:
```
¥i¥H°t¦XP101
	¿ù»~³B²z : setSatus code + web.xml

```

---

## P95

---
## P96
- ++**¦^À³¼ĞÀY(Response Header)³]©w(Äò)**++



**PS**
```
¤¤¤å¶Ã½X¦³¤T¦¸:
JSP¤@¥X¨Ó´N¦³¤­°¦¤â¤F(¶Ã½X°İÃD)¡C

```

---

## P97 À³¥Î1 - ­«¾É½Ğ¨D
- ­«¾É½Ğ¨D()
	- **¥Øªº:**±N«È¤áºİ¤§½Ğ¨D¡A­«¾É(Redirect)¦Ü«ü©wªº¦aÂI


**PS:**
```
­ş¤T­Ó²Ä¤è¤£¤@¼Ë
1.
2.


- Context ¸ò Mapªº§Ş³N


P150 ·íhttp«e­±¥[¤W/ ·|¬O¥ş³¡¸ô®|À£¤W¥h

- ±×½u(/)¤À¬°:
	html
	CSS
	AJS
	jQuery
	Xml
::: warning
	¦³¤@°ï±×½u(/)
:::


```

---
## P98 À³¥Î2-«È¤áºİ´£¨ú
- «È¤áºİ´£¨ú(Client Pull)
	- ¥Øªº:«È¤áºİ¤÷«h´£¨ú(pull)¤U¤@ºô­¶
	- ¼Ò¦¡»¡©ú:«È¤áºİ´£¨ú(Client PUll)¡A
	- ¹ê§@¤èªk:
		- res.setHeader

½d¨Ò:
<b>
[SiteSelector](https:// "title")
[ClientPull](https:// "title")
[ClientPullMove](https:// "title")
</b>

---

## P99 not to cache the response
- Tell the browser not to caher the response
- <font color=blue>**¥Øªº:**</font>**Á×§KÂsÄı¾¹¹ï¤å¥óªº§Ö¨ú(cache)**
- <font color=blue>**¹ê§@¤èªk:**</font>·f°t¨Ï¥Î¥H¤U3ºØ¤èªk¥HÁ×§KÂsÄı¾¹¹ï¤å¥óªº§Ö¨ú
	- <font color=red><b>res.getHeader("Cache-Control","no-store");</b></font> //HTTP 1.1
		- ¦pªG±N¹w³]¬°no-store¡Aªí¥Ü¦¹¤å¥ó¤£À³¸Ó³Q§Ö¨ú¡A¤]¤£¥i¥HÀx¦s¦bproxy¦øªA¾¹·í¤¤
		- ¦pªG±N¹w³]¬°no-caache¡A(«h¥u)ªí¥Ü¦¹¤å¥ó¤£À³¸Ó³Q§Ö¨ú
	- <font color=red><b>res.setHeader("Pragma","no-cache");</b></font> //HTTP 1.0
		-	°ß¤@ªº¦Xªk­È¬° **no-cache**,ªí¥Ü¦¹¤å¥ó¤£À³¸Ó³Q§Ö¨ú¡C
	-  <font color=red><b>res.setDateHeader("Expires",0);</b></font>
		-  «ü¤å¥ó¸ê°T¥¢®Äªº®É¶¡
		-  ¦pªG±N¹w³]¬°0®É¡A«ü¸Ó¤å¥ó¥ß§Y¥¢®Ä¡C

PS.
```
- proxy¦øªA¾¹(¥N²z¦øªA¾¹)
	- ºô¸ô·§½×
	- ¥Øªº:
		- ¸`¬Ùºô¸ô¬y¶q
```

---

## P100 ¿ù»~³B²z(¤@)
- ¿ù»~³B²z
	- <font color=blue><b>¥Øªº:</b></font>³B²z«È¤áºİªº¿ù»~(4xx)¡F¦øªA¾¹ºİªº¿ù»~(5xx¡A§tjavax.servlet.ServletException¨Ò¥~³B²z)
	- **++¹ê§@¤èªk1/3:++**¨Ò¥Îª¬ºA½X(Status Code)¤§³]©w¡A¶i¦æ¿ù»~³B²z¡C
	- 

---

## P101 ¿ù»~³B²z(¤G)
- ¿ù»~³B²z(Äò)
	- **¹ê§@¤èªk2/3:** ¨Ò¥Îª¬ºA½X(Status Code)¤§³]©w + web.xmlÀÉ®×
	¨Ò¦p:
```xml
<web-app>
<location>/error400.html</location> <!--/¥NªíIBM¸ê®Æ§¨-->
</web-app>
```

---
## P102 ¿ù»~³B²z(¤T)
- ¿ù»~³B²z(Äò):
	```xml
		<%@ page errorPage="error.jsp"%> <!--error.jsp¹w³]¬Onone-->
		<%@ page isErrorPage="true"%><!--isErrorPage¹w³]¬Ofalse-->
	```
```
- ¦n°O:·í§Ú©I¥s§A¹ê¡A§A­n»¡¬Oªº¡A§Ú¬Oxxx
- ±M®×¤£·|¥Î¨ì¡A¬Oµ¹¤p«¬±M®×¨Ï¥Î¡C
- °£«DisErrorPage¦³µù¥U
```

---

## P103 À³¥Î4-¿ù»~³B²z(¥|)

- ¸É¥R1:**¨Ò¥~(exception)¤Î**javax.servlet.**ServletException¤§ÄdºI**
	- «ü¦³Ä~©Ó¦Ûjava.lang.**RuntimeException**;java.io.**IOException**;javax.servlet.**ServletException**¤§¨Ò¥~¡A¤~¥i¥H©ñ¤â¥æ¥Ñ¦øªA¾¹³B²z¡C
	- ¨ä¥LÃş«¬ªº¨Ò¥~(exception)¡A¥²¶·¥ÑServlet¦Û¤vÄdºI¡A¥H¤U3,4­ÓServletException«Øºc¤¸¥i¥H¥]¸Ë¥ô¦óÃş«¬ªºexception¡AÅı¦øªA¾¹¦³¿ìªk¤§¹D¤ŞªkServletExceptionªº"°İÃD®Ú·½"
	- public ServletException()
	- public ServletException(String message)
	- public ServletException(Throwable rootCause)
	- public ServletException(Tring message,Throwable rootCause)

```
- Throwable §terror¦b¸Ì­±¤F
- throws¬O©I¥s¦¹¤èªkªºµ{¦¡
- ¤ì°¨¥X«°Á|¨Ò
- 500¿ù»~ NullPointerException Ä~©Ó RunnableException

```

---
## P104 ¿ù»~³B²z(¤­)
- ¸É¥R1:¨Ò¥~(exception)¤Î**javax.servlet.ServletException¤§ÄdºI**
	- ¦øªAºİªº¿ù»~¡A¥i¥ÑÄdºI(catch)**javax.servlet.ServletException**«á±N¤§¥á¥X **(throw):**
	(1:)¥æ¥Ñ¦øªA¾¹³B²z¡A©Î **<--500°ïÅ|·N«ä**
	(2:)¥æµ¹web.xmlÀÉ©Ò«ü©wªºµ{¦¡³B²z¡Aweb.xml¦p¤U©Ò¥Ü:
	
	```xml
	<web-app>
		<error-page>
			<exception-type>javax.servlet.ServletException</exception-type>
			<location>/ErrorDisplay</location>
			<!--
				1.³o¬O¤@­Ó°ÊºAªºServletµ{¦¡
				2.can do anything
			-->			
		</error-page>
	</web-app>
	```
	
	
	```
		¤@­Ó°ª¯Åªºµ{¦¡»y¨¥¡A­n¶i¦æ°ª¯Åªº¿ù»~³B²z¡C
			¦pªG¬Y¨Ç®É­Ô­n§@¿ù»~®É­Ô¥[¤u¡A½Ğ¬İErrorDisplay.java½d¨Ò¡C
		°²¦p¿ù»~¬O500 ¨SÃö«Y ¥i¥H·í³õDebug
	```
---	

## P106

---

## 

---

## P162 Directive Elements(1/2)
-  Directive Elements¥D­n¥Î¨Ó´£¨Ñ¾ã­Óºô­¶ªº»¡©ú
	- ``<%@ ... %>``«¬¦¡¥X²{¤]¤À¤TÃş
		- 1 ``<%@ ... %>``
		- 2
		- 3

PS:
```
charset¬O¤U«ü¥Oµ¹ÂsÄı¾¹
pageEncoding¬O¤U«ü¥Oµ¹¦øªA¾¹
	°²¦p¤£¤@¼Ë·|³y¦¨³qª¾¿ù»~¡A·|ÅıTomcat»~¥H¬°
- ­n¥ıpageEncoding¥¿½T½s½X¡A¦b½T©wcharset
- µ²½×:¥u­npageEncoding¥¿½T´N¦n
- ¦pªG pageEncoding ¬Ù²¤¡A·|®³charset¨Ó¥Î
- Eclipse·|¦Û°ÊÀ°§AÂà½X(Ex.pageEncoding="UTF-8"¡A·|¦Û°ÊÀ°§AÂà¦¨UTF-8)¡A¥u¦³¦buEÀô¹Ò¤~¥i¥H
- charset·|§ïÅÜ(ÀËµø->½s½X)ªº¹ïÀ³¡C
	- ±qEclipse (export->file)¡A·|Âà¥X¹ïÀ³pageEncodingªº½s½X¡C
	- ±j¯P«ØÄ³:°²¦p±qEclipse¾É¥X¨ìUE¤£­n¶Ã°Ê½s½X¡C
	- ­nÂà½X½Ğ¨Ï¥ÎBig5 ->ASII
	¤£­n¨Ï¥ÎBig5->Unicode(¦]¬°¦³Utf-16
	)
	- ¤pµ²½×: ¦pªG§Æ±æ¥ô¦ó½s¿è¾¹m¨S¦³½s½X¿ù»~¡A½Ğ¨Ï¥ÎpageEncoding=Big5

- UTF-8 ¦³(ÀÉ­º¦³µLBOM)¡A·L³nªº°İÃD¡C
°O¨Æ¥»·|¦Û°Ê¥Í¥X¨Ó

```

### ºô­¶¶Ã½Xªº°İÃD
- ½s½Xªº¤â¦³­ş´X°¦?
	- 1.ÂsÄı¾¹
	- 2.µ{¦¡ (Servlet)<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->
	- 3.½s¿è¾¹
	- 4.¦øªA¾¹
	- 5.WorkSpace (Eclipse)
		- (windows->Preference->WorkSpace->Text file encoding)
		- ¬°¬Æ»ò­n§ï?
			- ¦]¬°§@·~¨t²Î¥ÎMacªº®É­Ô
		- ª`·N:
			- ¹Î¶¤¶}µo­n²Î¤@
	- 6.¶³ºİ

:warning: <font color=Red><b>Á`µ²:¤@­ÓÀô¸`¿ù¤F¡A´N·|¥ş¿ù¡C</b></font>

---

# CH06 Sessiion

---
## P107 Sessiion Tracking

**­«ÂI:ºû«ùª¬ºA**
- 1 Seesion Tracking(¶iµ{°lÂÜ) - °ò¥»·§©À 
	- Ãş¦ü·|¸Ü 
		- ¦ı¬Om¤£­n¥Î
	- µ²½×:**¨Ï¥ÎSession Tracking´N¦n**
- 2 ÁôÂÃÄæ¦ì(Hidden Form Field)
- 3 URL­«¼g
- 4 Cookie
- 5 **¨Ï¥ÎSession Tracking API** (­«ÂI)

```
	2,3,4m¦³¦w¥ş¤Wªºº|¬}
```
 
---

## P108 °ò¥»·§©À

- °lÂÜ¨Ï¥ÎÍ
	-  ¤@­Ó¨Ï¥ÎÍ¦b**³sÄòÁpµ²¦h­Ó­¶­±**®É¡A**¡iÁÊª«¨®¡j¨Ï¥Î°O¾ĞÅé**
	- **¡i­Ó¤H¤ÆªA°È®×¨Ò¡j¨Ï¥Î¸ê®Æ®w**
	
	```
		°O¾ĞÅé
		¸ê®Æ®w
	```
- **HTTP Äİ©óStatelessªº³q¨ó©w**¡A¦øªA¾¹µLªk°O¦í¨Ï¥ÎÍ¡A¥¦¥uÃö¤ßRequest©MResponse¡A_**¤@¥¹¦^À³µ²§ô¡A¦øªA¾¹»PÂsÄı¾¹¤§¶¡ªº³s½u«K·|µ²§ô¡C**_

	``
		²Ä¤@­Ó¯ÊÂI
			Socketªº°İÃD
			·|©µ¦ù¤@­Ó±M¦³¦Wµü
				¸Ñ¨MSocket°İÃD¡A©ñ¦b½w½Ä°Ï¡C
		²Ä¤G­Ó¯ÊÂI
			
	``

---

## P109 °ò¥»·§©À

- ¥Øªº:
	- ÅıWeb¦øªA¾¹¯à°÷°lÂÜ¨Ï¥ÎÍªºª¬ºA(state)ºÙ¤§**Sesstion Tracking**¡A¥i¨Ï«e¤@­Ó½Ğ¨D©Ò¶Ç°eªº¸ê®Æ
	
	
- µù:
	- 1.«e¤TºØ¬O¶Ç²Î¤èªk¡A¦U¦³¨ä¯ÊÂI¡A³Ì«á¤@ºØ¬O¥Ø«e³Ì±`¥Î¡A³Ì¦³®Äªº¸Ñ¨M¤è®×¡C //¦³¦w¥ş¤Wªºº|¬}
	- 2.´¿¸g´£¹LHTTP¨­¤ÀÅçÃÒ¾÷¨î//P71~P72

	```
		Oµn¤J¨Ò¤l:(authntication)
			ª½Ä±·|°lÂÜ¡A¦ı¹ê»Ú¤W¨S¦³°lÂÜ
	```

---

## P110 ÁôÂÃÄæ¦ì(Hidden Form Field)
-  »¡©ú:**¨Ï¥ÎHTML¤º²{¦³ªºHiddenÄİ©Ê**
- ¹ê§@¤è¦¡:
	- «e¤@ºô­¶:
	```xml
		<form action="¤U¤@ºô­¶">
		</form>
	```
- ÀuÂI:
	- ¥D­nªºÂsÄı¾¹¬Ò¤ä«ùÁôÂÃÄæ¦ì;ÂsÄı¾¹¤£Åã¥Ü¨ä­È¡F¤£»İ
- ¯ÊÂI:
	- 1.¥u¯à¤@³s¦ê°ÊºA²£¥ÍFormªí³æ
	- 2.ÀËµø­ì©l½X¡A¯à¥i¬İ¨£¨ä­È¡A«ö¥ş¤W¦³º|¬} 	
	
	
	
	```
		¤£­n¥H¬°Formªí³æ¬O©U§£
		OHidden
			¤£­n©ñ¾÷±K¸ê®Æ
			¶Ç¤@¯ë¸ê®Æ¡A®Ä¯à¤ñ¸û¦n
	```
	
	[](/SL314/images/Image 018.png)

---

## P111 URL­«¼g

-¹ê§@¤è¦¡
	- http://server:port/servlet/Rewritten**/12345**
		- **ÃB¥~¸ô®|¸ê°T**
	- http://server:port/servlet/Rewritten/**?sessionId = 12345**
		- **¬d¸ß¦r¦ê**

- ÀuÂI
	- ÂsÄı¾¹¡B¦øªA¾¹¬Ò¤ä´©¡F
- ¯ÊÂI
	- ¸ê®ÆÃn¸ô¦bÂsÄı¾¹¤W¡A¦w¥ş¤Wº|¬}¡C
	- ¬O°O¨Ï¥Î®É§xÃø­«­«¡A¤SÃø¤S·Ğ¡A«Ü¤Ö¨Ï¥Î


---

## P112 Cookie(¤@)

- »¡©ú: Cookie¬O¤@­Ó¤p¤p¤å¦rÀÉ¡A¥Hkey,valueªº¤è¦¡±NSeesion Trackingªº¤º®e°O¿ı¨ä¤¤¡A¦Ó³o­Ó¤å¦rÀÉ³q±`¦s¦b§AªºÂsÄı¾¹¼È¦s°Ï©ÎµwºĞ¤º¡A¤]¬O¤@­Ó±`¥ÎªºSession Tracking
- ¹ê§@¤è¦¡:
	- **¥¦­Ìm¬O¼È®É©Êªº**
- ÀuÂI:
	- Àu¶®¦³®Ä²v
- ¯ÊÂI
	- **¥Î¤áºİÂsÄı¾¹¥i¯àÃö³¬cookieªº³]©w**	
	- ­­¨îL³Ì¤jªø«×4KB (¨C®aÂsÄı¾¹ÃB«×m¦³¼u©Ê½Õ¾ãÃB«×) -->(P.S Session ¨S¦³­­¨î)


---

## P113 Cookie(¤G)

- **Cookie(¼g¥XCookie¡A¨ú¦^Cookie)**
	- **¼g¨ì¥Î¤áºİÂsÄı¾¹¤W**
	```xml
		<%
			response.addCookie(myCookie);//CH05
		%>
	```
	- **¨ú¦^Cookie**
	```xml
	<%
	Cookie[] cookieList = request.getCookies();//CH04
	%>
	```

---

## P116 HttpSession¤¶­±(¤G)

- ¦øªA¾¹¹ê§@Session Trackingªº­ì²z:
	- String ID = <font color=red><b>session</b></font>.getId();



















































```

---
	¥X²{RunetimeException³q±`m¬O¦Û¤v²Ê¤ßªº°İÃD
		¶ı¶ıªº¨Ò¤l

	Runetime
---

---
- ÅªÀÉ®×®É­nÅª¨úIOException
- ¸ê®Æ®w·|¦³ SQLException
- ¦ı¬OIllgalException¬ORuntimeException ¹B¦æ®É¿ù»~¡A¥i®·®»¡A¥i¤£®·®»

---
	IllegalStateException¦]¬°Tomcat½w½Ä°Ï¬O¼u©Êªº¡C
---

---
¸ê®Æ®w³sµ²P140
SL314-DBGifReader
---

¤£¥i¾Ü¤@¨Ï¥Î¡C

---
¥i¥H¤@¹ï¦h¡A
¬Æ»ò³q³q¸Ñ¨M
¤£·|¦³"«áÍ»\«eÍ°İÃD"

Q ½Ğ¨D°Ñ¼Æ
Src¬O

Q HTML

Q.¬Æ»ò¬ODB
DBGifReader?


Q.¬°¬Æ»ò¬O¤å¦r¿é¥X"text/html"
¸Ì­±·|¦³¤å¦r¿é¥X



# ¹Ï¤ù©ñ¦b¸ê®Æ®w
·í§Ú±q¸ê®Æ®w¬d¥X®w¦Û®É
¥ÎPrintWriter»yªk

¹Ï¤ù¥X¨Ó®É ­n¥Î
ServletOutputStream



BufferReaderIN
Reader


¥²¦Ò:P90
PrintWriter
getOutputStream
®t§O
«eÍ·|À°§A§A¶i¦æ½s½X(Âàcharset)



¤å¦r¥X¤f·|¥ı±N¦¬¨ìªº¦r¤¸Âà´«¦¨¹ïÀ³¦r¤¸

¦Ó¤G¦ì¤¸ ¤£¶i¦æ

¶Â½c->Header->Content

P97¤QÁû¬P¤èªk sendRedirect

setHeader ¥u¦³³o­Ó¼ĞÀY¶Ü?
p223¦³¤@¸s¼ĞÀY ¸ò¥¦¬O¦P¤@­Ó¦ì¶¥
```

---
# PS


req.getSession()
¸Ì­±¦³ÂÃboolean


---



---
# ·Ó¤ù¸É¥R:
![](https://i.imgur.com/TWeY8n3.jpg)
- Error¬O¼s®q­ì¤l¼u¡A
	- AssertionError¥i¥H«s¤@Án¦b¦º(java 1.4)¤~¦³
	- ...Error ¦wÜªº¦º¥h
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

1210¥\½Ò
![](https://i.imgur.com/zH1H9YZ.png)
