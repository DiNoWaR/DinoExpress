function ajaxAutoComplete() {

    var stationName = document.getElementById("stationInput").value;

    var xhttp = new XMLHttpRequest();

    var url = "http://localhost:8080/dinoexpress/ajax";
    xhttp.open("GET", url, true);

    var param = "stationName=" + stationName;

    xhttp.send(param);
}