<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <div>
        <label>title
            <form:input path="title"/>
        </label>
    </div>
    <div>
        <label>content
            <form:input path="content"/>
        </label>
    </div>
    <div>
        <label>author:
            <form:select path="author.id" items="${authorsList}" itemLabel="lastName" itemValue="id"/>
        </label>
    </div>
    <div>
        <label>categories:
            <form:select path="categories" items="${categoryList}" itemLabel="name" itemValue="id" multiple="true"/>
        </label>
    </div>

    <button>save</button>

</form:form>
</body>
</html>
