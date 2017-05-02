function loadStationsToInput(dataListId) {

    var datalistUpdate = document.getElementById(dataListId);

    var stationSearch = document.getElementById(dataListId).value;

    var myExp = new RegExp(stationSearch, "i");

    var request = new XMLHttpRequest();
    request.open('GET', 'stations.json');

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {

            var items = JSON.parse(request.responseText);

            var output = '';

            for (var key in items) {

                if (items[key].name.search(myExp) != -1) {
                    output += '<option>' + items[key].name + '</option>';
                }
            }

            datalistUpdate.innerHTML = output;
        }
    };

    request.send();
}

$('#search').keyup(function () {

    var searchField = $('#search').val();

    var myExp = new RegExp(searchField, "i");

    $.getJSON('data.json', function (data) {

        var output = '<ul class="searchresults">';

        $.each(data, function (key, val) {
            if ((val.name.search(myExp) != -1) ||
                (val.bio.search(myExp) != -1)) {
                output += '<li>';
                output += '<h2>' + val.name + '</h2>';
                output += '<img src="images/' + val.shortname + '_tn.jpg" alt="' + val.name + '" />';
                output += '<p>' + val.bio + '</p>';
                output += '</li>';
            }
        });

        output += '</ul>';

        $('#update').html(output);

    }); //get JSON
});

