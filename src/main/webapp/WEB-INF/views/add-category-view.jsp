<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
  <div>
      <label>
          name:
          <form:input path="name"/>
      </label>
  </div>
    <div>
        <label>
            description:
            <form:input path="description"/>
        </label>
    </div>
    <button>save</button>
</form:form>



</body>
</html>
