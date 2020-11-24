<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세 정보</title>
</head>
<body>
	<h2>학생 상세 정보</h2>
	<table>
		<tr>
			<td>ID:</td>
			<td>${student.id}</td>
		</tr>
		<tr>
			<td>이름:</td>
			<td>${student.name}</td>
		</tr>
		<tr>
			<td>나이:</td>
			<td>${student.age}</td>
		</tr>
	</table>	
	<c:if test ="${not empty student.seq }">
		<a href="move_update.do?seq=${student.seq }">${student.name} 수정</a> <br />
		<a href="student_delete.do?seq=${student.seq }">${student.name} 삭제</a> <br />
	</c:if>
	<a href="student_list.do">목록</a>
	
</body>
</html>