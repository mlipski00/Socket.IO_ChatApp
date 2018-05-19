<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chat Content Repository</title>
</head>
<body>
<style><%@include file="../css/styles.css"%></style>
<body>
<div align="center"><h2>Chat Content Repository</h2></div>
<div>
	<table align="center" border=1>
		<tr font color="#aaa">
			<th>ID</th>
			<th>NickName</th>
			<th>Message</th>
			<th>SocketID</th>
			<th>Datetime</th>
		</tr>
		<c:forEach items="${chatContentList}" var="chatContent">
			<tr>
				<td>${chatContent.id}</td>
				<td>${chatContent.nickName}</td>
				<td>${chatContent.message}</td>
				<td>${chatContent.socketID}</td>
				<td>${chatContent.datetime}</td>
				
			</tr>
		</c:forEach>
	</table>
		<br>
</div>

</body>
</html>