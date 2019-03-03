/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const alive = "http://localhost:8084/ExamPrepRest/api/pet/allAlive";
const size = "http://localhost:8084/ExamPrepRest/api/pet/petcount";
const byEvent = "http://localhost:8084/ExamPrepRest/api/pet/all/2015-07-07";
const allPets = "http://localhost:8084/ExamPrepRest/api/pet/all";

/* global fetch*/
function getAllPetsAlive() {
    fetch(alive)
            .then(res => res.json())
            .then(data => {
                var table = "";
                table += "<table>";
                table += "<tr>";
                table += "<th>ID</th>";
                table += "<th>Name</th>";
                table += "<th>Birth date</th>";
                table += "<th>Specie</th>";
                table += "<th>Owner</th>";
                table += "</tr>";
                data.forEach(function (pet) {
                    table += "<tr>";
                    table += "<td>" + pet.id + "</td>";
                    table += "<td>" + pet.name + "</td>";
                    table += "<td>" + pet.birth + "</td>";
                    table += "<td>" + pet.species + "</td>";
                    table += "<td>" + pet.owner + "</td>";
                    table += "</tr>";
                });
                table += "</table>";
                document.getElementById("getAllAlivePets").innerHTML = table;

            });
}

function getAllPetsByEvent() {
    fetch(byEvent)
            .then(res => res.json())
            .then(data => {
                var table = "";
                table += "<table>";
                table += "<tr>";
                table += "<th>ID</th>";
                table += "<th>Name</th>";
                table += "<th>Birth date</th>";
                table += "<th>Specie</th>";
                table += "<th>Owner</th>";
                table += "</tr>";
                data.forEach(function (pet) {
                    table += "<tr>";
                    table += "<td>" + pet.id + "</td>";
                    table += "<td>" + pet.name + "</td>";
                    table += "<td>" + pet.birth + "</td>";
                    table += "<td>" + pet.species + "</td>";
                    table += "<td>" + pet.owner + "</td>";
                    table += "</tr>";
                });
                table += "</table>";
                document.getElementById("getAllAlivePets").innerHTML = table;

            });
}

function getAllPets() {
    fetch(allPets)
            .then(res => res.json())
            .then(data => {
                var table = "";
                table += "<table>";
                table += "<tr>";
                table += "<th>ID</th>";
                table += "<th>Name</th>";
                table += "<th>Birth date</th>";
                table += "<th>Specie</th>";
                table += "<th>Owner</th>";
                table += "</tr>";
                data.forEach(function (pet) {
                    table += "<tr>";
                    table += "<td>" + pet.id + "</td>";
                    table += "<td>" + pet.name + "</td>";
                    table += "<td>" + pet.birth + "</td>";
                    table += "<td>" + pet.species + "</td>";
                    table += "<td>" + pet.owner + "</td>";
                    table += "</tr>";
                });
                table += "</table>";
                document.getElementById("getAllAlivePets").innerHTML = table;

            });
}