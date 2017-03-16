<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>Starter</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

   	<c:url value="/css/style.css" var="cssStyle" />
	<link href="${cssStyle}" rel="stylesheet" />
</head>
<body>
	<h1>Spring Boot Starter</h1>
	<h2>Message: ${message}</h2>
</body>

</html>