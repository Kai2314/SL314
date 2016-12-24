<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="com.google.appengine.api.channel.*"%>
<%
String channelName = "PsMonkey";
ChannelService channel = ChannelServiceFactory.getChannelService();
String token =  channel.createChannel(channelName);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='/_ah/channel/jsapi'></script>
<script type='text/javascript'>
var name;
var socket;

sendMessage = function(message) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'server.jsp?id=<%=token%>&msg='+message, true);
	xhr.send();
};

onOpened = function() {
	sendMessage("「"+name + "」進入聊天室......");
};

onMessage = function(msg) {
	document.getElementById("output").innerHTML += "<div>"+msg.data +"</div>";
}

onError = function(e){
	alert(
		"發生什麼事了？居然有 error......\n"+
		"Exception Description : "+e.description+"\n"+
		"Exception Code : "+e.code
	);
}

onClosed = function(){
	sendMessage("「"+name + "」離開聊天室......");
}

openChannel = function() {
	var channel = new goog.appengine.Channel("<%=token%>");
	var handler = {
		'onopen' : onOpened,
		'onmessage' : onMessage,
		'onerror' : onError,
		'onclose' : onClosed,
	};
	socket = channel.open(handler);
}

initialize = function() {
	name = prompt("請輸入名字：");
	openChannel();
}

send = function(){
	var sentence = document.getElementById("sentence");
	sendMessage(name + " : "+sentence.value);
	sentence.value = "";
}

goodbye = function(){
	socket.close();
	alert("掰掰...... [奸笑]");
}

setTimeout(initialize, 100);
</script>
<title>Chat Room using Channel API</title>
</head>
<body onunload="goodbye()">
<div id="output"></div>
<input type="text" id="sentence" size="30">
<input type="button" onclick="send()" value="送出">
</body>
</html>