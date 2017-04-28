<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inputfield.css"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>

<datalist id="stations">
    <option>Moscow</option>
    <option>Saint-Petersbutg</option>
    <option>Nizniy Novgorod</option>
</datalist>


<div class="container-fluid">
    <div id="stationInputRow" class="row">
        <div class="col-xs-5"></div>
        <div class="col-xs-2">
            <div>
                <form class="form-group-lg">
                    <input type="text" class="form-control" id="train" list="stations" >
                </form>
            </div>
        </div>
        <div class="col-xs-5"></div>
    </div>
</div>


</body>

</html>
