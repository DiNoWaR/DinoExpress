<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inputfield.css"/>
</head>

<body>

<datalist id="stations">
</datalist>


<div class="container-fluid">
    <div id="stationInputRow" class="row">
        <div class="col-xs-5"></div>
        <div class="col-xs-2">
            <div>
                <input id="stationInput" type="text" class="form-control" list="stations">
            </div>
        </div>
        <div class="col-xs-5"></div>
    </div>
</div>

<div align="center">
    <button id="speakersButton" type="button" class="btn-sm btn-danger" onclick="showSpeakers()">Show Speakers</button>
</div>

<div id="update">

</div>


<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxtest.js"></script>
</body>


</html>
