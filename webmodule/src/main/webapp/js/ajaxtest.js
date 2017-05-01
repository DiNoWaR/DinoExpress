var request = new XMLHttpRequest();

request.open('GET', 'data.xml');


request.onreadystatechange = function () {

    if (request.status === 200 && request.readyState === 4) {

        var modify = document.getElementById("update");

        var items = request.responseXML.getElementsByTagName('name');

        var output = '<ul>';

        for (var i = 0; i < items.length; i++) {
            output += '<li>' + items[i].firstChild.nodeValue + '</li>';
        }

        output += '</ul>';

        modify.innerHTML = output;
        console.log(request);
        console.log('----------------------');
        console.log(items);
    }

};

request.send();




