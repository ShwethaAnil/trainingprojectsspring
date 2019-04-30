<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>
<h2 align="center">Login page</h2>
${message}
<%-- <%= request.getAttribute("message") %> --%>
<form action="login">
	username: <input type="text" name="uname" required="required">
	<br/><br/><br/><br/><br/>
	password: <input type="password" name="pwd" required="required">
	<br/><br/><br/><br/><br/>
<input type="submit" value="Login">
<input type="reset" value="Cancel">
</form>

</body>
</html>
