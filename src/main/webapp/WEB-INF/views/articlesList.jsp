<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>articles</title>
</head>
<body>
<h1>ARTICLES</h1>
<div>
    <table cellspacing="5" border="1">
        <tr>
            <th>Id</th>
            <th>title</th>
            <th>content</th>
            <th>created</th>
            <th>updated</th>
            <th>author</th>
            <th>categories</th>
            <th>actions</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.content}</td>
                <td>${article.created}</td>
                <td>${article.updated}</td>
                <td>${article.author.firstName} ${article.author.lastName}</td>
                <td>
                    <ul>
                        <c:forEach items="${article.categories}" var="category">
                            <li>name: ${category.name}, description:  ${category.description}</li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <form style="display: inline" method="post" action="${pageContext.request.contextPath}/articles/delete">
                        <input type="hidden" name="id" value="${article.id}" />
                        <button type="submit">delete</button>
                    </form>
                    <button><a href="${pageContext.request.contextPath}/articles/update?id=${article.id}">update</a></button>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
<div>
    <button><a href="${pageContext.request.contextPath}/articles/add">add article</a></button>
</div>

</body>
</html>
