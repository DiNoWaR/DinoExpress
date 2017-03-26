<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<div align="center">
    <h1>${greetings}</h1>
</div>

<div align="center">
    <c:forEach items="${wagonTypes}" var="type">
        <p>Class: <c:out value="${type.classCode}"/> ,
            ID : <c:out value="${type.id}"/> ,
            <c:out value="${type.description}"/></p>
    </c:forEach>
</div>

<div align="center">
    <c:forEach items="${stations}" var="station">
        <p><c:out value="${station.name}"/></p>
    </c:forEach>
</div>


</body>

</html>
