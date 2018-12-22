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
    
    <title>HttpMessageConverter Demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>
    <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
    	function req(){
    		$.ajax({
    			url:"convert",
    			data:"1-wangyunfei",//1
    			type:"POST",
    			contentType:"application/x-wisely",//自定义的媒体类型
    			success:function(data){
    				$("#resp").html(data);
    			}
    		});
    	}
    </script>
  </body>
</html>
