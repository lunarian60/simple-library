<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$(".btn-info").click(function(event) {
			var id = $(this).attr('id');
			$('#stage').load('book?personId=' + id);
		});
	});
</script>
</head>
<body>

	<div class="container">
		<h1>National Library</h1>

		<table class="table table-striped">
			<h2>People List</h2>
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>Lent Books</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${persons}">
					<tr>
						<td><c:out value="${person.name}" /></td>
						<td><c:out value="${person.phoneNumber}" /></td>
						<td><c:out value="${person.email}" /></td>
						<td><input type="button" class="btn btn-info"
							id="${person.personId}" value="VIEW" /></td>
					</tr>
				</c:forEach>
				<c:if test="${empty persons}">
            no users added yet.
        </c:if>
			</tbody>
		</table>

		<div id="stage" style="background-color: cc0;"></div>

		<table class="table table-striped">
			<h2>Total Book List</h2>
			<thead>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>ISBN</th>
				</tr>
			</thead>
			<tbody>
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
			</tbody>
		</table>
	</div>
</body>
</html>