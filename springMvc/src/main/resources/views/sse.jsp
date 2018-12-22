<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <base href="<%=basePath%>">
    
    <title>SSE Demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value="assets/js/jquery-3.3.1.js"/>"></script>
	<script type="text/javascript">
		if(window.EventSource){//1
			var source = new EventSource('push');
			s='';
			source.addEventListener('message',function(e){//2
				s+=e.data+"<br/>";
				$("#msgFrompPush").html(s);
			});
			source.addEventListener('open',function(e){
				console.log("连接打开。");
			},false);
			
			source.addEventListener('error',function(e){
				if(e.readyState == EventSource.CLOSED){
					console.log("连接关闭。");
				}else{
					console.log("连接正常。");
				}
			},false);
		}else{
			console.log("你的浏览器不支持SSE.");
		}
	</script>
  </head>
  
  <body>
    <div id="msgFrompPush"></div>
  </body>
</html>
  
