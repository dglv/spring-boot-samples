<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>Spring Boot REST</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

	<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
</head>
<body>
	<script type="text/javascript">
		function getRestContextPath(){
			return "${pageContext.request.contextPath}/person";
		}
	</script>
	
	<h1>Spring Boot REST Service Example</h1>
	
	<p>Target Context Path:<br>
  	<input type="text" id="input-context-path" size="50" value="${pageContext.request.contextPath}/person">
  	</p>
  	
  	<p>Body Request Payload:<br>
  	<textarea id="input-textarea" cols="50" rows="20"></textarea>
  	</p>

	<button type="button" onclick="doGet()">GET</button>
	<button type="button" onclick="doPost()">POST</button>
	<button type="button" onclick="doDelete()">DELETE</button>
	
	<p>Output:<br>
	<textarea id="output-textarea" cols="50" rows="20"></textarea>
	</p>
</body>

</html>