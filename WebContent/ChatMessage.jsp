
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="chat_room.MessageStorage"%>
<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"
	language="java" errorPage=""%>
<%
	//獲取輸入內容
	request.setCharacterEncoding("Big5");
	String nameInput = new String(request.getParameter("nameInput").getBytes("ISO-8859-1"),"Big5") ;
	String messageInput = new String(request.getParameter("messageInput").getBytes("ISO-8859-1"),"Big5");
	boolean isNull = ((nameInput == null && messageInput == null));
	JSONObject obj = MessageStorage.main(isNull,nameInput, messageInput);
	if(!isNull)
		System.out.println(nameInput+"  "+messageInput);
%>
<%=obj%>