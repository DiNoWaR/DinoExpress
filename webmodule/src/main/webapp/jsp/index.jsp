<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inputfield.css"/>
</head>

<body>

<datalist id="departureStations">
</datalist>

<datalist id="arrivalStations">
</datalist>

<div class="container-fluid">
    <div id="header" class="row">

    </div>

    <div id="stationInputRow" class="row">
        <div class="col-xs-2">
            <form>
                <div class="form-group">
                    <input id="departureStationInput" list="departureStations" type="text" class="form-control"
                           placeholder="Enter departure station"
                           onkeyup="loadStationsToInput('departureStations','departureStationInput')">
                </div>
                <div class="form-group">
                    <input id="arrivalStationInput" list="arrivalStations" type="text" class="form-control"
                           placeholder="Enter arrival station"
                           onkeyup="loadStationsToInput('arrivalStations','arrivalStationInput')">
                </div>
                <div class="form-group">
                    <input id="journeyDate" type="date" class="form-control"
                           placeholder="Enter journey date">
                </div>
                <button type="submit" class="btn btn-warning">Submit</button>
            </form>
        </div>
        <div class="col-xs-10"></div>
    </div>

    <div id="testAjaxRow" class="row">
        <div class="col-xs-5">
        </div>
        <div class="col-xs-2">
            <input id="testAjaxServlet" type="text" class="form-control" placeholder="Enter whatever" onkeyup="testAjaxServlet()">
        </div>
        <div class="col-xs-5">
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>


</html>
