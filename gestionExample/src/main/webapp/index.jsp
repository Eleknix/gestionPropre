<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Hello struts 2</title>
</head>
<body>
	<h1>
		<a href="<s:url action="hello"/>"> Hello!</a>
	</h1>
	<s:form action="new" namespace="/">
		<s:textfield class="form-control" name="personne.firstName"
			label="First name?" />
		<s:textfield class="form-control" name="personne.lastName"
			label="Last name?" />
		<s:textfield class="form-control" name="personne.title" label="Title?" />
		<s:textfield class="form-control" name="personne.age" label="Age?" />
		<s:textfield class="form-control" type="date"
			name="personne.startDate" label="Start date?" format="dd/MM/yyyy" />
		<s:radio label="Vaccinated?" name="personne.vaccinated"
			list="#{'Yes':'Yes','No':'No'}" value="No" />
		<s:radio label="Gender?" name="personne.gender"
			list="#{'Male':'Male','Female':'Female'}" value="Female" />
		<s:submit value="Envoyer" />
	</s:form>
</body>
</html>