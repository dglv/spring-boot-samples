<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>Signup Form</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>
 	<script type="text/javascript" src="/resources/js/signup.js"></script>
</head>
<body>
	<!-- The Signup Form -->
		<form:form action="person/save" method="post">
			<div class="container">
				<h1>Signup Form</h1>

				<div class="required">
					<input type="text" name="username" placeholder="Username" required>
				</div>
				
				<div class="required">
					<input type="password" name="password" placeholder="Password" required>
				</div>
				
				<div class="required">
					<input type="text" name="email" placeholder="Email" required>
				</div>

				<input type="text" name="name" placeholder="Full Name">
			
				<input type="text" name="age" placeholder="Age"/>
			
				<div class="form-btn-area">
        			<button type="submit" id="signupbtn" value="Submit">Sign Up</button>
        			<button type="button" class="btn" onclick="location.href='/person';">Cancel</button>
      			</div>
    		</div>
  		</form:form>
</body>

</html>
