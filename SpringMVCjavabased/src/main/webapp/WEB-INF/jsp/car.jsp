<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Car Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Car
</h1>
<c:url var="addAction" value="/car/add"></c:url>


<form:form action="${addAction}" commandName="car">
<table>
	<c:if test="${!empty car.carid}">
	<tr>
		<td>
			<form:label path="carid">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="carid" readonly="true" size="8" 
			disabled="true" />
			<form:hidden path="carid" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="engine">
				<spring:message text="engine"/>
			</form:label>
		</td>
		<td>
			<form:input path="engine" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="model">
				<spring:message text="model"/>
			</form:label>
		</td>
		<td>
			<form:input path="model" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="tyre">
				<spring:message text="tyre"/>
			</form:label>
		</td>
		<td>
			<form:input path="tyre" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="gear">
				<spring:message text="gear"/>
			</form:label>
		</td>
		<td>
			<form:input path="gear" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${car.carid!=0}">
				<input type="submit"
					value="<spring:message text="Edit Car"/>" />
			</c:if>
			<c:if test="${car.carid==0}">
				<input type="submit"
					value="<spring:message text="Add Car"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>





<br><br>
<h3>Cars List</h3>
<c:if test="${!empty listcar}">
	<table class="tg">
	<tr>
		<th width="80">Car ID</th>
		<th width="120">Engine</th>
		<th width="120">Model</th>
			<th width="120">Tyre</th>
		<th width="120">Gear</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listcar}" var="car">
		<tr>
			<td>${car.carid}</td>
			<td>${car.engine}</td>
			<td>${car.model}</td>
			<td>${car.tyre}</td>
			<td>${car.gear}</td>
			<td><a href="<c:url value='/edit/${car.carid}'/>">Edit</a></td>
			<td><a href="<c:url value='/remove/${car.carid}'/>">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
