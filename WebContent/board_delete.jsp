<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="gw.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기안 작성</title>
</head>
<body>
<%
	int boardNum = 1;
	if(request.getParameter("board") == null) {
		response.sendRedirect("main.jsp?idx1=3&idx2=1");
	}
	else {
		boardNum = Integer.parseInt(request.getParameter("board"));
		boardDAO.delete(boardNum);	
	}
%>
<center>
게시물이 삭제되었습니다.<br><br>
<input type="button" value="확인" style="width: 80px;" onclick="javascript_: location.href='main.jsp?idx1=3&idx2=1';">
</center>

</body>
</html>