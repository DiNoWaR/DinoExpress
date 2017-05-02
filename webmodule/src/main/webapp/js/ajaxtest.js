function loadStationsToInput(dataListId) {

    var request = new XMLHttpRequest();

    request.open('GET', 'stations.json');

    var returnedData = JSON.parse(request.responseText);

    request.onreadystatechange = function () {


        if (request.status === 200 && request.readyState === 4) {

            var modify = document.getElementById(dataListId);

            var output = '';

            var stations = ['Moscow','Saint-Petersburg','Nizniy Novgorod'];

            for (var i = 0; i < stations.length; i++) {
                output += '<option>' + stations[i] + '</option>';
            }

            modify.innerHTML = output;
        }
    };

    request.send();
    console.log(returnedData);
}


