<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Login Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="/resources/js/login.js"></script>
</head>
<body>
	<!-- The Login Form -->
	<form:form id="login-form" action="/login" method="post">
		<div class="container">
			<h1>Dashboard</h1>

			<div class="required">
				<input type="text" name="username" placeholder="Username" required> 
			</div>

			<div class="required">
				<input type="password" name="password" placeholder="Password" required>
			</div>
			
			<div class="form-btn-area">
 				<button type="submit" id="submitbtn" value="Submit">Sign In</button>
				<button type="button" class="btn" onclick="location.href='/signup';">Sign Up</button>
			</div>
		</div>
	</form:form>
</body>

</html>