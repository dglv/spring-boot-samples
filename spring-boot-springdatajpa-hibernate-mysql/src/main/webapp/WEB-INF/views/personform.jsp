<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<title>Save Person Data</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
	<h3>Save Person Data</h3>
	<form:form action="person/save" method="post">
		Username:<input type="text" name="username"> <br/>
		Password:<input type="password" name="password"> <br/>
      	Name:<input type="text" name="name"> <br/>
      	Age :<input type="text" name="age"/><br/>
    	<input type="submit" value="Submit"/>
  </form:form>
</body>

</html>