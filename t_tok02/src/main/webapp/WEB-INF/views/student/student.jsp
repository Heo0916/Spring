<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<c:set var="action" value ="" />
<c:if test="${empty student.seq }">
	<c:set var="action" value="add/student.do" />
</c:if>
<c:if test ="${not empty student.seq }">
	<c:set var="action" value="update/student.do" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록 화면</title>
</head>
<body>
	<h2>학생 정보 등록</h2>
	<form:form method="POST" action="${action }" commandName="student">
		<form:hidden path="seq"/>
		<table>
			<tr>
				<td>
					<form:label path="id">id</form:label>
				</td>
				<td>
					<form:input path="id"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="name">이름</form:label>
				</td>
				<td>
					<form:input path="name"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="age">나이</form:label>
				</td>
				<td>
					<form:input path="age"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장">
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>