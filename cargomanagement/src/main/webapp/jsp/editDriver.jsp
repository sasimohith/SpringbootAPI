<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cargo management — Edit driver</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body class="container py-4">

<h1 class="h4">Edit driver</h1>

<form:form action="update" modelAttribute="dri" method="post" cssClass="col-md-6">
	<form:hidden path="dno"/>
	<div class="mb-3">
		<label class="form-label" for="firstname">First name</label>
		<form:input path="firstname" cssClass="form-control" id="firstname"/>
	</div>
	<div class="mb-3">
		<label class="form-label" for="lastname">Last name</label>
		<form:input path="lastname" cssClass="form-control" id="lastname"/>
	</div>
	<div class="mb-3">
		<label class="form-label" for="phoneno">Phone</label>
		<form:input path="phoneno" cssClass="form-control" id="phoneno"/>
	</div>
	<div class="mb-3">
		<label class="form-label" for="licenseno">License number</label>
		<form:input path="licenseno" cssClass="form-control" id="licenseno"/>
	</div>
	<button type="submit" class="btn btn-primary">Save</button>
	<a class="btn btn-outline-secondary" href="viewAll">Cancel</a>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
