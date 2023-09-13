<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<h1>AUTHORS</h1>
<form:form method="post" modelAttribute="authors">
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>first name</th>
            <th>last name</th>
            <th>actions</th>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>
                    <form style="display: inline" method="post" action="/authors/delete">
                        <input type="hidden" name="id" value="${author.id}" />
                        <button type="submit">delete</button>
                    </form>
                    <button>
                        <a href="/authors/update?id=${author.id}">update</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <button>
        <a href="/authors/add">add Author</a>
    </button>
</div>
</form:form>
</body>
</html>
