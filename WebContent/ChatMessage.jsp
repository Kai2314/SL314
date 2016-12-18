
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="chat_room.MessageStorage"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%
	//獲取輸入內容
	String nameInput = request.getParameter("nameInput");
	String messageInput = request.getParameter("messageInput");
	boolean isNull = ((nameInput == null && messageInput == null));
	JSONObject obj = MessageStorage.main(isNull,nameInput, messageInput);
%>
<%=obj%>