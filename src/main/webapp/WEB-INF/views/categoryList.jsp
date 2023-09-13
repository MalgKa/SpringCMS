<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h1>CATEGORIES</h1>
<div>
    <table cellpadding="5" border="1">
        <tr>
            <th>Id</th>
            <th>name</th>
            <th>description</th>
            <th>actions</th>
        </tr>
       <c:forEach items="${categoryList}" var="category">
           <tr>
               <td>${category.id}</td>
               <td>${category.name}</td>
               <td>${category.description}</td>
               <td><button><a href="${pageContext.request.contextPath}/categories/delete?id=${category.id}">delete</a></button>
               <button><a href="${pageContext.request.contextPath}/categories/update?id=${category.id}">update</a></button>
               </td>
           </tr>
       </c:forEach>
    </table>
</div>
<div>
    <a href="${pageContext.request.contextPath}/categories/add">add Category</a>
</div>
</body>
</html>
