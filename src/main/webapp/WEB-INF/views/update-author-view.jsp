<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update author</title>
</head>
<body>
<form:form method="post" modelAttribute="author" >
    <label>first name:
        <form:input path="firstName"/>
    </label>
    <label>last name:
        <form:input path="lastName"/>
    </label>
    <button>update</button>
</form:form>
</body>
</html>
