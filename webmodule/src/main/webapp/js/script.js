function loadStationsToInput(dataListId, inputFieldId) {

    var datalistUpdate = document.getElementById(dataListId);

    var stationSearch = document.getElementById(inputFieldId).value;

    var myExp = new RegExp(stationSearch, "i");

    var request = new XMLHttpRequest();
    request.open('GET', 'stations.json');

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {

            var items = JSON.parse(request.responseText);

            var output = '';

            for (var key in items) {

                if (items[key].name.search(myExp) !== -1 && stationSearch !== '') {
                    output += '<option>' + items[key].name + '</option>';
                }
            }
            datalistUpdate.innerHTML = output;
        }
    };
    request.send();
}

function testAjaxServlet() {

    var firstLetter = document.getElementById('testAjaxServlet').value;

    var url = 'ajax?letter=' + firstLetter;

    var request = new XMLHttpRequest();
    request.open('GET', url);

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {
            console.log(request.responseText);
        }

    };
    request.send();
}