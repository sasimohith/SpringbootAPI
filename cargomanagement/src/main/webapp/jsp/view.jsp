<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cargo management — Drivers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<link href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
$(function() {
	$('#dritab').DataTable({ pagingType: 'full_numbers' });
});
</script>
</head>
<body class="container py-4">
	<h1 class="h4">Drivers</h1>
	<p><a href="${pageContext.request.contextPath}/">Add driver</a></p>
	<table id="dritab" class="table table-striped table-bordered" style="width:100%">
		<thead>
			<tr>
				<th>Driver ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Contact</th>
				<th>License</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${drivers}" var="dri">
				<tr>
					<td>${dri.dno}</td>
					<td>${dri.firstname}</td>
					<td>${dri.lastname}</td>
					<td>${dri.phoneno}</td>
					<td>${dri.licenseno}</td>
					<td><a href="editDri?did=${dri.dno}">Edit</a></td>
					<td><a href="deleteDri?did=${dri.dno}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
