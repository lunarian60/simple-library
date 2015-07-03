<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>National Library</h1>

	<table>
		<h2>People List</h2>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td><c:out value="${person.name}" /></td>
				<td><c:out value="${person.phoneNumber}" /></td>
				<td><c:out value="${person.email}" /></td>
			</tr>
		</c:forEach>
		<c:if test="${empty persons}">
            no users added yet.
        </c:if>
	</table>

	<table>
		<h2>Book List</h2>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.title}" /></td>
				<td><c:out value="${book.author}" /></td>
				<td><c:out value="${book.isbn}" /></td>
			</tr>
		</c:forEach>
		<c:if test="${empty books}">
            no books added yet.
        </c:if>
	</table>
</body>
</html>