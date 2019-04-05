let query = 1;

function setQuery() {
    let reportIDX = document.getElementById("reports").value;
    let n = document.getElementById("Nvalue").value;
    let continent = document.getElementById("continent").value;
    let region = document.getElementById("region").value;
    let country = document.getElementById("country").value;
    let district = document.getElementById("district").value;
    let queryprams = '?';

    if(n !== ''){
        queryprams = queryprams + 'n='+n + '&';
    }
    if(continent !== ''){
        queryprams = queryprams + 'continent=' +continent + '&';
    }
    if(region !== ''){
        queryprams = queryprams + 'region=' + region + '&';
    }
    if(country !== ''){
        queryprams = queryprams + 'country='+country + '&';
    }
    if(district !== ''){
        queryprams = queryprams + 'district='+district;
    }

    if(reportIDX > 0 && reportIDX < 7){
        getCountryReport(queryprams, reportIDX);
    }
    if(reportIDX > 6 && reportIDX < 23){
        getCityReport(queryprams, reportIDX);
    }
}

function getCountryReport(queryprams, idx) {
    let messages = [];
    const url = `http://localhost:8080/api/CountryReport/${idx-1}/${queryprams}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then((res) => {
        return res.json()
    }).then(data => {
        drawTable(data);

    })
        .catch((err) => {
            alert(err);
        });


}

function getCityReport(queryprams, idx) {
    let messages = [];
    const url = `http://localhost:8080/api/CityReport/${idx-1}/${queryprams}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then((res) => {
        return res.json()
    }).then(data => {
        drawTable(data);

    })
        .catch((err) => {
            alert(err);
        });


}

function drawTable(data) {
    let col = [];
    for (let i = 0; i < data.length; i++) {
        for (let key in data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    let table = document.createElement("table");
    table.style.width = "100%";

    let tr = table.insertRow(-1);

    for (let i = 0; i < col.length; i++) {
        let th = document.createElement("th");
        th.align = 'left';
        th.innerHTML = col[i];
        tr.appendChild(th);
    }
    for (let i = 0; i < data.length; i++) {

        tr = table.insertRow(-1);

        for (let j = 0; j < col.length; j++) {
            let tabCell = tr.insertCell(-1);
            tabCell.innerHTML = data[i][col[j]];
        }
    }

    let divContainer = document.getElementById("table_field");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);


}
