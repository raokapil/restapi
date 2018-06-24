<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/rest/show-on-screen/1">Test</a>

<form action="${pageContext.request.contextPath}/rest/show-on-screen/login" method="post" onsubmit="validate();">
<input type="text" name="name" id="name" value='' />
<input type="submit" name="submit" value="submit"/>
</form>

</body>
<script>

function validate(){
	let name = document.getElementById("name").value;
	alert(name);
	if(name == ' ' || name == undefined){
		alert("Please enter name.");
		event.preventDefault();
		var self = this;
		window.setTimeout(function() {
			self.submit();
		}, 2000);
		return false;
	}
	
	return true;
}

</script>
</html>