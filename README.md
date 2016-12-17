���q:JAVA�{���y��(Java Web Application) ���O:�L�¿� ���q�@��:�d�ç�
===
[TOC]

---

<h1 name="CH01">
	CH01:Web Application ���[�P�}�o���ҷ�
</h1>

---

# CH02:���g�P�G�pHTTP Servlet

---

# CH03:Servlet���ͩR�g��

---

<h2 name="P48">
	P48 Init Parameter(��l�Ѽ�)
</h2>
- Init Parameter(��l�Ѽ�)
	- �]�w:web.xml�ɮ׳]�w�p�U
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
- �{��:�bServlet��init() method���H
String initial_Value = getInitParamet

---

# CH04:�^����T(HttpServletRequest,ServletConfig,ServerletContext����)

---

## P62 ���oServlet�ۨ�����T(�@)

- **���oServlet��l�Ѽ�**
	- ``String getInitParameter(String name)`` ���oServlet��l�Ѽƪ��u�ȡv
	- ``Enumeration getInitParameterNames()`` �C�|Servlet��l�Ѽƪ��u�Ѽơv
	- ��:<font color=red>�ݰt�Xweb.xml;</font>(�Ѩ�p48�ΤU�@���{�����q)
- **���oServlet�W��,����(Context)**
	- ``String getServletName()`` ���o�uServlet�W�١v(Servlet Content)
- **����:�H�W����ServletConfig����(��GenericServlet���O��@)��method**�A�G�{���������ϥΡC

---

## P63 ���oServlet�ۨ�����T(�G)
- **�{�����q(���oweb.xml�Ҵ��Ѫ��Ҧ���l�ѼƦW�١B��)**
```java=
java.util.Enumeration enum = getInitParameterNames();
while(enum.hasMoreElements){
	String name = (String)enum.nextElement();
	out.println(name+":"+getInitParameter(name));
}
```

---

## ���oClient����T(�Q�T)

- Request�������ݩ�(Attribute method)
	- void req.setAttribute


---
# CH05:�ǰeHTML��T(HttpServletResponse����)

## P88 �򥻷���
- �uResponse Content(�^�����e)�v�O�^���Ȥ�ݮɪ��D�n���e
	- ��HTML�����Ө��AResponse Content�N�OHTML������r��
	- ��Ϲ��ӻ��AResponse Content�h�O�c����v�����줸��(byte)
- �H�̧C�����[�I�ӬݡAWeb���A�����O�N�u��Ӧ^���v���@�s�ꪺ�줸��(byte)�ǵ��Ȥ�ݦӥH�A�ҥHHTTP��w�W�w���A������:
	- **��**�e�X�uStatus Line�v�M�uResponse Header(�^�����Y)�v���]�w
	- **��**�~��e�X�uResponse Content(�^�����e)�v
	- �H�K�Ȥ�ݬy���������Ū�^���ɪ��uStatus Line�v�P�uResponse Header(�^�����Y)�v���]�w�A�~��غc�X�u�Ӧ��쪺�줸��(byte)�v

## ��ƫ��A&��X��Ƭy(�@)
- ��ƫ��A�]�w
	- **�ت�**:�e�X�uResponse Content(�^�����e)�v���e�A�ݥ��]�w�����e���A
	- **��@��k:void res.setContentType(String type)**
		�]�wResponse(�^��)�����e���A
		- ��1:
			```java
			res.setContentType("text/html")
			res.setContentType("text/html;charset=ISO-8859-1");
			res.setContentType("text/html;charset=UTF-8");
			res.setContentType("text/html;charset=Big5");
			res.setContentType("text/html;charset=Shift_JIS");
			```
		- ��2:
			res.setContentType("image/gif");...
	- ����:
		- �i�P�ɫ��w�i��r���s�X(character encoding)�ɩұĥΪ�**�r�X��(charset)**
		- �H�Wres��ServletResponse���O����
		- �bHTTP Servlet�A����k�|�]�w�uResponse Header(�^�����Y)�v��Content-Type���Y(header)
## ��ƫ��A&��X��Ƭy(�G)
- ��r���(characte text)��X
	- ��
		```java
			res.setContentType("text/html;charset=UTF-8")
			PrintWriter out = res.getWriter();
		```
	- **��:**�|���N���쪺Unicoide�r���ഫ���ҫ��w���r�X��(charset)�������r���A�M��~�g�JResponse(�^��)

- �G�줸���(binary data)��X
	- ��:
	```java
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
	```
	- **��:�i�i����󪺽s�X�{��!**
	- **�`�N�ƶ�:**
		- �H�W��Ӥ�k�u��**�ܤ@�ϥ�**�A�_�h�N���Ͱ���ɴ���java.lang.**IllegalStateException**�ҥ~ **<--���p�X�{�O���c���D(���p�X�{�Ч�Ѯv)**

---

## P91 ����ʳs�u&�^���w�İ�(�@)
- ���򫬳s�u(persistent connection)
	- �ت�:���Ȥ�ݯ���O���ۨϥΦP�@��socket�s�u�A�H���o�������h�Ӥ��q(Ĵ�p�������t�h�ӹ���)�A�٤�����ʳs�u(persistent connection) <--(�M���W��)
	- ��@��k:
		```java
			void res.setContentLength(int len)//(���H�U����)(�ӳ]�w�w�İϪ��j�p)
		```
		- �]�wResponse(�^��)�����e����
	- ����:
		- �H�Wres��ServletResponse���O����
		- �bHTTP Servlet�A����k�|�]�w�uResponse Header(�^�����Y)�v��Content-Length���Y (header)
		- �bHTTP Servlet �i�Q�Φ���k�ӫO��**������p�{(persistent connection�A���ɺ٤�keep-alive connection)**<--(�O���P�@�ӳq�D)
		- �{���]�p�v�B���@�w�n�ۤv�p�⤺�e���סA�p�G�^�����e�����צb���w��**�^���w�İ�(Response buffer)**�e�q�����A���A��**�q�`**���A�]�w���e����


---
## P92 ����ʳs�u&�^���w�İ�(�G) (���ҭ���)
- �^���w�İ�(Response buffer)
- **void res.setBufferSize(int size) <-(�����D)8K�j�p**
		Sets the preferred buffer size for the body of the response.
		- <font color=red>**�ت�:�����w�İϤj�p�A�����į�
		��]:���Socket������**
		</font>
		- **P.S**
			- �q�`�H���@�ʥu��3.6��A�n�J�@�ʥu��0��C
			- �����ɥN�C�C�]�Ӥ������p�A�N�O8K���w�İ�

	- **int res.getBufferSize()**
		Returns the actual buffer size used for the response.
	- **boolean res.isCommitted()**
		Return boolean indicating if the response has been committed.
	- **void res.flushBuffer() throws java.io.IOException**
		Forces any content in the buffer to written to the client.
	- ��:
		- �H�Wres��ServletResponse���O����

�d��:
[KeepAlive.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/KeepAlive.java)
[Buffering.java](https://github.com/shps951023/SL314/blob/8b45fb60311b14527892dc3a5536e311f38a9d2e/src/servlet_examples/Buffering.java)

---

## P93 ���A�X�]�w(�@)

- ���A�X(Status Code)
	- <b>�ت�:</b> �ǥѪ��A�X(Status Code)���ϥΡAServlet�N�i�@��h���Ʊ��A�Ҧp�A���i�H**����**(redirect)�@��request�A�άO**�^�����~**
	�Ҧ������A�X��:[������](https://i.imgur.com/EF3Fyff.png)
	- **1xx:**

```
PS.
```

---

## P94 ���A�X�]�w(�G)
- �]�w���A�X(Status Code)
	- **void res.setStatus(int sc)**
		- �]�wHTTP���A�X(Status Code)
		- �i�Τ@��ƭȡA��**HttpServletResponse�����ҩw�q��SC_XXX�`�ƨӪ��**�F�ݩ�e�X(Response)�^���D�餧�e�ϥΡC
		- void

PS:
```
�i�H�t�XP101
	���~�B�z : setSatus code + web.xml

```

---

## P95

---
## P96
- ++**�^�����Y(Response Header)�]�w(��)**++



**PS**
```
����ýX���T��:
JSP�@�X�ӴN��������F(�ýX���D)�C

```

---

## P97 ����1 - ���ɽШD
- ���ɽШD()
	- **�ت�:**�N�Ȥ�ݤ��ШD�A����(Redirect)�ܫ��w���a�I


**PS:**
```
���T�ӲĤ褣�@��
1.
2.


- Context �� Map���޳N


P150 ��http�e���[�W/ �|�O�������|���W�h

- �׽u(/)����:
	html
	CSS
	AJS
	jQuery
	Xml
::: warning
	���@��׽u(/)
:::


```

---
## P98 ����2-�Ȥ�ݴ���
- �Ȥ�ݴ���(Client Pull)
	- �ت�:�Ȥ�ݤ��h����(pull)�U�@����
	- �Ҧ�����:�Ȥ�ݴ���(Client PUll)�A
	- ��@��k:
		- res.setHeader

�d��:
<b>
[SiteSelector](https:// "title")
[ClientPull](https:// "title")
[ClientPullMove](https:// "title")
</b>

---

## P99 not to cache the response
- Tell the browser not to caher the response
- <font color=blue>**�ت�:**</font>**�קK�s�������󪺧֨�(cache)**
- <font color=blue>**��@��k:**</font>�f�t�ϥΥH�U3�ؤ�k�H�קK�s�������󪺧֨�
	- <font color=red><b>res.getHeader("Cache-Control","no-store");</b></font> //HTTP 1.1
		- �p�G�N�w�]��no-store�A��ܦ�������ӳQ�֨��A�]���i�H�x�s�bproxy���A����
		- �p�G�N�w�]��no-caache�A(�h�u)��ܦ�������ӳQ�֨�
	- <font color=red><b>res.setHeader("Pragma","no-cache");</b></font> //HTTP 1.0
		-	�ߤ@���X�k�Ȭ� **no-cache**,��ܦ�������ӳQ�֨��C
	-  <font color=red><b>res.setDateHeader("Expires",0);</b></font>
		-  ������T���Ī��ɶ�
		-  �p�G�N�w�]��0�ɡA���Ӥ��ߧY���ġC

PS.
```
- proxy���A��(�N�z���A��)
	- ��������
	- �ت�:
		- �`�ٺ����y�q
```

---

## P100 ���~�B�z(�@)
- ���~�B�z
	- <font color=blue><b>�ت�:</b></font>�B�z�Ȥ�ݪ����~(4xx)�F���A���ݪ����~(5xx�A�tjavax.servlet.ServletException�ҥ~�B�z)
	- **++��@��k1/3:++**�ҥΪ��A�X(Status Code)���]�w�A�i����~�B�z�C
	- 

---

## P101 ���~�B�z(�G)
- ���~�B�z(��)
	- **��@��k2/3:** �ҥΪ��A�X(Status Code)���]�w + web.xml�ɮ�
	�Ҧp:
```xml
<web-app>
<location>/error400.html</location> <!--/�N��IBM��Ƨ�-->
</web-app>
```

---
## P102 ���~�B�z(�T)
- ���~�B�z(��):
	```xml
		<%@ page errorPage="error.jsp"%> <!--error.jsp�w�]�Onone-->
		<%@ page isErrorPage="true"%><!--isErrorPage�w�]�Ofalse-->
	```
```
- �n�O:��کI�s�A��A�A�n���O���A�ڬOxxx
- �M�פ��|�Ψ�A�O���p���M�רϥΡC
- ���DisErrorPage�����U
```

---

## P103 ����4-���~�B�z(�|)

- �ɥR1:**�ҥ~(exception)��**javax.servlet.**ServletException���d�I**
	- �����~�Ӧ�java.lang.**RuntimeException**;java.io.**IOException**;javax.servlet.**ServletException**���ҥ~�A�~�i�H����Ѧ��A���B�z�C
	- ��L�������ҥ~(exception)�A������Servlet�ۤv�d�I�A�H�U3,4��ServletException�غc���i�H�]�˥���������exception�A�����A������k���D�ުkServletException��"���D�ڷ�"
	- public ServletException()
	- public ServletException(String message)
	- public ServletException(Throwable rootCause)
	- public ServletException(Tring message,Throwable rootCause)

```
- Throwable �terror�b�̭��F
- throws�O�I�s����k���{��
- �차�X���|��
- 500���~ NullPointerException �~�� RunnableException

```

---
## P104 ���~�B�z(��)
- �ɥR1:�ҥ~(exception)��**javax.servlet.ServletException���d�I**
	- ���A�ݪ����~�A�i���d�I(catch)**javax.servlet.ServletException**��N����X **(throw):**
	(1:)��Ѧ��A���B�z�A�� **<--500���|�N��**
	(2:)�浹web.xml�ɩҫ��w���{���B�z�Aweb.xml�p�U�ҥ�:
	
	```xml
	<web-app>
		<error-page>
			<exception-type>javax.servlet.ServletException</exception-type>
			<location>/ErrorDisplay</location>
			<!--
				1.�o�O�@�ӰʺA��Servlet�{��
				2.can do anything
			-->			
		</error-page>
	</web-app>
	```
	
	
	```
		�@�Ӱ��Ū��{���y���A�n�i�氪�Ū����~�B�z�C
			�p�G�Y�Ǯɭԭn�@���~�ɭԥ[�u�A�Ь�ErrorDisplay.java�d�ҡC
		���p���~�O500 �S���Y �i�H���Debug
	```
---	

## P106 ����4-���~�B�z(�C)
- **�ɥR2:**��x�O��
	- Servlet�i��ۤv���ʧ@�M�o�O�����x��(log file):
		- 1.``void log(String msg)``
		- 2.``void log(String msg,Throwable t)``
	- GenericServlet���O�PServletContext�����A��̬Ҧ��H�W�P�Wlog��k
- **��:**
	- GenericServlet���O��log()��k�A�Ω�**Java Servlet**
	- ServletContext������log()��k�A�Ω�**��ť��(Listener)**
		- ��ť���P��x�d�ҸԨ�:��12�椸�u��ť��(Listener����)�v
	- ��x��(log file)���A��m��:
		X:\apache-tomcat-x.x.x\ **logs\localhost.2016-xx-xx.log**
		



---

## 

---

## P162 Directive Elements(1/2)
-  Directive Elements�D�n�ΨӴ��Ѿ�Ӻ���������
	- ``<%@ ... %>``�����X�{�]���T��
		- 1 ``<%@ ... %>``
		- 2
		- 3

PS:
```
charset�O�U���O���s����
pageEncoding�O�U���O�����A��
	���p���@�˷|�y���q�����~�A�|��Tomcat�~�H��
- �n��pageEncoding���T�s�X�A�b�T�wcharset
- ����:�u�npageEncoding���T�N�n
- �p�G pageEncoding �ٲ��A�|��charset�ӥ�
- Eclipse�|�۰����A��X(Ex.pageEncoding="UTF-8"�A�|�۰����A�নUTF-8)�A�u���buE���Ҥ~�i�H
- charset�|����(�˵�->�s�X)�������C
	- �qEclipse (export->file)�A�|��X����pageEncoding���s�X�C
	- �j�P��ĳ:���p�qEclipse�ɥX��UE���n�ðʽs�X�C
	- �n��X�Шϥ�Big5 ->ASII
	���n�ϥ�Big5->Unicode(�]����Utf-16
	)
	- �p����: �p�G�Ʊ����s�边���S���s�X���~�A�Шϥ�pageEncoding=Big5

- UTF-8 ��(�ɭ����LBOM)�A�L�n�����D�C
�O�ƥ��|�۰ʥͥX��

```

### �����ýX�����D
- �s�X���⦳���X��?
	- 1.�s����
	- 2.�{�� (Servlet)<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->
	- 3.�s�边
	- 4.���A��
	- 5.WorkSpace (Eclipse)
		- (windows->Preference->WorkSpace->Text file encoding)
		- ���ƻ�n��?
			- �]���@�~�t�Υ�Mac���ɭ�
		- �`�N:
			- �ζ��}�o�n�Τ@
	- 6.����

:warning: <font color=Red><b>�`��:�@�����`���F�A�N�|�����C</b></font>

---

# CH06 Sessiion

---
## P107 Sessiion Tracking

**���I:�������A**
- 1 Seesion Tracking(�i�{�l��) - �򥻷���
	- �����|��,���O�����n��
	- ����:**�ϥ�Session Tracking�N�n**	
- 2 �������(Hidden Form Field)
- 3 URL���g
- 4 Cookie
- 5 **�ϥ�Session Tracking API** (���I)

	```
	2,3,4�����w���W���|�}
	```
 
---

## P108 �򥻷���

- �l�ܨϥΪ�
	-  �@�ӨϥΪ̦b**�s���p���h�ӭ���**�ɡA�o�������������֦��O��ӨϥΪ̪���O�A�p:**�i�ʪ����j�ϥΰO����**
	- ���\�������A�٥����b�ϥΪ̥��{�L��A�O���ߩʡA�ѤU���A�ץ��{�ɰѦҡA�p**�i�ӤH�ƪA�Ȯרҡj�ϥθ�Ʈw**
	
- **HTTP �ݩ�Stateless���q��w**�A���A���L�k�O��ϥΪ̡A���u����Request�MResponse�A_**�@���^�������A���A���P�s�����������s�u�K�|�����C**_

	``
		�Ĥ@�ӯ��I
			Socket�����D
			�|�����@�ӱM���W��
				�ѨMSocket���D�A��b�w�İϡC
		�ĤG�ӯ��I
			
	``

---

## P109 �򥻷���

- �ت�:
	- ��Web���A������l�ܨϥΪ̪����A(state)�٤�**Sesstion Tracking**�A�i�ϫe�@�ӽШD�Ҷǰe�����
	
	
- ��:
	- 1.�e�T�جO�ǲΤ�k�A�U������I�A�̫�@�جO�ثe�̱`�ΡA�̦��Ī��ѨM��סC //���w���W���|�}
	- 2.���g���LHTTP�������Ҿ���//P71~P72

	```
		O�n�J�Ҥl:(authntication)
			��ı�|�l�ܡA����ڤW�S���l��
	```

---

## P110 �������(Hidden Form Field)
-  ����:**�ϥ�HTML���{����Hidden�ݩ�**
- ��@�覡:
	- �e�@����:
	```xml
		<form action="�U�@����">
		</form>
	```
- �u�I:
	- �D�n���s�����Ҥ���������;�s��������ܨ�ȡF����
- ���I:
	- 1.�u��@�s��ʺA����Form���
	- 2.�˵���l�X�A��i�ݨ���ȡA�����W���|�} 	
	
	
	
	```
		���n�H��Form���O�U��
		OHidden
			���n����K���
			�Ǥ@���ơA�į����n
	```
	
	[](/SL314/images/Image 018.png)

---

## P111 URL���g

-��@�覡
	- http://server:port/servlet/Rewritten**/12345**
		- **�B�~���|��T**
	- http://server:port/servlet/Rewritten/**?sessionId = 12345**
		- **�d�ߦr��**

- �u�I
	- �s�����B���A���Ҥ䴩�F
- ���I
	- ����n���b�s�����W�A�w���W�|�}�C
	- �O�O�ϥήɧx�������A�S���S�СA�ܤ֨ϥ�


---

## P112 Cookie(�@)

- ����: Cookie�O�@�Ӥp�p��r�ɡA�Hkey,value���覡�NSeesion Tracking�����e�O���䤤�A�ӳo�Ӥ�r�ɳq�`�s�b�A���s�����Ȧs�ϩεw�Ф��A�]�O�@�ӱ`�Ϊ�Session Tracking
- ��@�覡:
	- **���̳��O�Ȯɩʪ�**
- �u�I:
	- �u�����Ĳv
- ���I
	- **�Τ���s�����i������cookie���]�w**	
	- ����L�̤j����4KB (�C�a�s�����B�׳����u�ʽվ��B��) -->(P.S Session �S������)


---

## P113 Cookie(�G)

- **Cookie(�g�XCookie�A���^Cookie)**
	- **�g��Τ���s�����W**
	```xml
		<%
			response.addCookie(myCookie);//CH05
		%>
	```
	- **���^Cookie**
	```xml
	<%
	Cookie[] cookieList = request.getCookies();//CH04
	%>
	```

---
## P115
![](https://i.imgur.com/WWxtfCy.png)

- **HttpSession�����ت�**
	- ���A���Q�ΰt�o�@��HttpSession����A��Servlet�i�H�Ψ��x�s�Ψ��o

- <b>PS</b>
	- getSession()�A()�̭��p�G�S��true�|�۰����A�[�C
	- **��������O�����A���O��k�C�̭��S��k�A���A���|�۰����A��@�C**

---

## P116 HttpSession����(�G)

![](https://i.imgur.com/2MA7bRs.png)
- ���A����@Session Tracking����z:
	- String ID = <font color=red><b>session</b></font>.getId();

- <b>PS</b>
	- cookie��id�A[P120](#P120 HttpSession����)



---

## P120 HttpSession����=
![](https://i.imgur.com/nHsDzTf.png)

























































































```

---
	�X�{RunetimeException�q�`���O�ۤv�ʤߪ����D
		�������Ҥl

	Runetime
---

---
- Ū�ɮ׮ɭnŪ��IOException
- ��Ʈw�|�� SQLException
- ���OIllgalException�ORuntimeException �B��ɿ��~�A�i�����A�i������

---
	IllegalStateException�]��Tomcat�w�İϬO�u�ʪ��C
---

---
��Ʈw�s��P140
SL314-DBGifReader
---

���i�ܤ@�ϥΡC

---
�i�H�@��h�A
�ƻ�q�q�ѨM
���|��"��̻\�e�̰��D"

Q �ШD�Ѽ�
Src�O

Q HTML

Q.�ƻ�ODB
DBGifReader?


Q.���ƻ�O��r��X"text/html"
�̭��|����r��X



# �Ϥ���b��Ʈw
��ڱq��Ʈw�d�X�w�ۮ�
��PrintWriter�y�k

�Ϥ��X�Ӯ� �n��
ServletOutputStream



BufferReaderIN
Reader


����:P90
PrintWriter
getOutputStream
�t�O
�e�̷|���A�A�i��s�X(��charset)



��r�X�f�|���N���쪺�r���ഫ�������r��

�ӤG�줸 ���i��

�½c->Header->Content

P97�Q���P��k sendRedirect

setHeader �u���o�Ӽ��Y��?
p223���@�s���Y �򥦬O�P�@�Ӧ춥
```

---
# PS


req.getSession()
�̭�����boolean


---



---
# �Ӥ��ɥR:
![](https://i.imgur.com/TWeY8n3.jpg)
- Error�O�s�q��l�u�A
	- AssertionError�i�H�s�@�n�b��(java 1.4)�~��
	- ...Error �w�R�����h
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

1210�\��
![](https://i.imgur.com/zH1H9YZ.png)
