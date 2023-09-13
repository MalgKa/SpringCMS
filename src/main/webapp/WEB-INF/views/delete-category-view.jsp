<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete Category</title>
    <style>
        button{
            width: fit-content;
            padding-inline:0.8rem;
            background-color: #fa923f;
        }
        a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<h3 style="color:red">Are you sure you want to delete the category: "${category.name}" ?</h3>

<form:form method="post" modelAttribute="category">
    <input type="hidden" name="id" value="${category.id}">
    <div>
        <button>yes</button>
        <button><a href="${pageContext.request.contextPath}/categories/list">no</a></button>
    </div>
</form:form>

</body>
</html>
