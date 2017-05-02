function loadStationsToInput(dataListId) {

    var request = new XMLHttpRequest();

    request.open('GET', 'stations.json');

    var stations = JSON.parse(request.responseText);

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {

            var modify = document.getElementById(dataListId);

            var output = '';

            for (var i = 0; i < stations.length; i++) {
                output += '<option>' + 'opop' + '</option>';
            }

            modify.innerHTML = output;
        }
    };
    console.log(stations);
    request.send();
}


