���q:JAVA�{���y��(Java Web Application) ���O:�L�¿� ���q�@��:�d�ç�
===

[TOC]

---



# CH01:Web Application ���[�P�}�o���ҷǳ�

---

# CH02:���g�P�G�pHTTP Servlet

---

# CH03:Servlet���ͩR�g��

---

# P48 Init Parameter(��l�Ѽ�)
<a name="p48">p48</a>
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
	- ��:<font color=red>�ݰt�Xweb.xml;</font>(�Ѩ�<a href=#p48>p48</a>  �ΤU�@���{�����q)
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

```xml
 <META 
```

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
	- 1 res.getHeader("Cache-Control","no-store");
---

## P101 ���~�B�z(�G)
- ���~�B�z(��)
	- 
---
## P104 ���~�B�z(��)
- �ɥR1:�ҥ~(exception)��**javax.servlet.ServletException���d�I**
	- ���A�ݪ����~�A�i���d�I(catch)**javax.servlet.ServletException**��N����X **(throw):**
	(1:)��Ѧ��A���B�z�A��
	(2:)�浹web.xml�ɩҫ��w���{���B�z�Aweb.xml�p�U�ҥ�:
	```xml
	<web-app>
		<error-page>
			<exception-type>javax.servlet.ServletException</exception-type>
			<location>/ErrorDisplay</location>
		</error-page>
	</web-app>
	<!--
		1.�o�O�@�ӰʺA��Servlet�{��
		2.can do anything
	-->
	```

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
	- 2.�{�� (Servlet)
	- 3.�s�边
	- 4.���A��
	- 5.WorkSpace (Eclipse)
		- (windows->Preference->WorkSpace->Text file encoding)
		- ���ƻ�n��?
			- �]���@�~�t�Υ�Mac���ɭ�
		- �`�N:
			- �ζ��}�o�n�Τ@
	- 6.����
 
:::success
:warning: <font color=Red>**�`��:�@�����`���F�A�N�|�����C**</font>
:::
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
--- 
 
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


