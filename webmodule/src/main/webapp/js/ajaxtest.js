function loadStationsToInput(dataListId) {

    var request = new XMLHttpRequest();

    request.open('GET', 'stations.json');

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {

            var items = JSON.parse(request.responseText);

            var modify = document.getElementById(dataListId);

            var output = '';

            for (var key in items) {
                output += '<option>' + items[key].name + '</option>';
            }

            modify.innerHTML = output;
        }
    };

    request.send();
}


