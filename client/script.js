function httpGet() {
    fetch('http://localhost:8080/api/v1/users', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
        },
    })
        .then(response => response.json())
        .then(array => {
            const usersBody = document.querySelector("#users-table > tbody");
            while (usersBody.firstChild) {
                usersBody.removeChild(usersBody.firstChild);
            }
            array.forEach((row) => {
                let json_data = row;
                let result = [];

                for (let i in json_data) {
                    switch (i) {
                        case "dateOfBirth":
                            let db = json_data[i].day + "/" + json_data[i].month + "/" + json_data[i].year
                            result.push(db)
                            break;
                        case "address":
                            let ad = json_data[i].number + " " + json_data[i].street + " " + json_data[i].zipCode + " " + json_data[i].city + " " + json_data[i].country
                            result.push(ad)
                            break;
                        default:
                            result.push(json_data [i]);
                            break;
                    }
                }
                const tr = document.createElement("tr");
                result.forEach((cell) => {
                    const td = document.createElement("td");
                    td.textContent = cell;
                    tr.appendChild(td);
                })
                usersBody.appendChild(tr);
            })
        })
}

const form = document.getElementById('get-user');

form.addEventListener('submit', function (e) {
    e.preventDefault();

    let url = new URL('http://localhost:8080/api/v1/user')
    const payload = new FormData(form);
    let params = {"email": [...payload][0][1]}
    url.search = new URLSearchParams(params).toString()
    fetch(url)
        .then(response => response.json())
        .then(res => {
            if (!res.status) {
                let result = document.getElementById("result");

                let child = result.lastElementChild;
                while (child) {
                    result.removeChild(child);
                    child = result.lastElementChild;
                }

                let id = document.createElement("p");
                let fullName = document.createElement("p");
                let dateOfBirth = document.createElement("p");
                let email = document.createElement("p");
                let gender = document.createElement("p");
                let address = document.createElement("p");
                let createdAt = document.createElement("p");
                id.textContent = "ID: " + res.id;
                fullName.textContent = "Nom complet: " + res.firstName + " " + res.lastName;
                dateOfBirth.textContent = "Date de naissance: " + res.dateOfBirth.day + "/" + res.dateOfBirth.month + "/" + res.dateOfBirth.year;
                email.textContent = "Email: " + res.email;
                gender.textContent = "Genre: " + res.gender;
                address.textContent = "Adresse: " + res.address.number + " " + res.address.street + " " + res.address.zipCode + " " + res.address.city + " " + res.address.country;
                createdAt.textContent = "Créé le: " + res.createdAt;
                result.append(id);
                result.append(fullName);
                result.append(dateOfBirth);
                result.append(email);
                result.append(gender);
                result.append(address);
                result.append(createdAt);
            } else {
                let result = document.getElementById("result");
                let message = document.createElement("p");
                message.textContent = res.message;
                message.style.color = "red";
                result.append(message);
            }
        })
})

form.addEventListener('reset', function (e) {
    let result = document.getElementById("result");
    let child = result.lastElementChild;
    while (child) {
        result.removeChild(child);
        child = result.lastElementChild;
    }
})

const registerForm = document.getElementById('register-user');

registerForm.addEventListener('submit', function (e) {
    e.preventDefault();

    const data = new FormData(registerForm);
    let json = {dateOfBirth: {}, address: {}}
    data.forEach((value, key) => {
        if (key === "day" || key === "month" || key === "year") {
            json.dateOfBirth[key] = value;
        } else if (key === "number" || key === "street" || key === "zipCode" || key === "city" || key === "country") {
            json.address[key] = value;
        } else {
            json[key] = value;
        }
    });

    fetch('http://localhost:8080/api/v1/register', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(json)})
        .then(response => {
            if (response.status === 200) {
                //window.alert("Utilisateur enregistré avec succès!");
                //window.location.reload();
                let response = document.getElementById("response");

                let child = response.lastElementChild;
                while (child) {
                    response.removeChild(child);
                    child = response.lastElementChild;
                }
                let message = document.createElement("p");
                message.style.color = 'green'
                message.textContent = "Utilisateur enregistré avec succès!";
                response.append(message);
                httpGet()
            } else {
                response.json()
                    .then(res => {
                        let response = document.getElementById("response");

                        let child = response.lastElementChild;
                        while (child) {
                            response.removeChild(child);
                            child = response.lastElementChild;
                        }
                        if (res.status !== 200) {
                            let message = document.createElement("p");
                            message.style.color = 'red'
                            message.textContent = res.message;
                            response.append(message);
                        }
                    })
            }
        })
})