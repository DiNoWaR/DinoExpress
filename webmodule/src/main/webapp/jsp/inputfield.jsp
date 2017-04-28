<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inputfield.css"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajaxtest.js"></script>
</head>

<body>

<datalist id="stations">
    <c:forEach var="station" items="${stations}">
        <option><c:out value="${station.name}"/></option>
    </c:forEach>
</datalist>


<div class="container-fluid">
    <div id="stationInputRow" class="row">
        <div class="col-xs-5"></div>
        <div class="col-xs-2">
            <div>
                <input id="stationInput" type="text" class="form-control" list="stations"
                       onchange="ajaxAutoComplete()">
            </div>
        </div>
        <div class="col-xs-5"></div>
    </div>
</div>


</body>

</html>
