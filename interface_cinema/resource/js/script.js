programacaoCinema = [];

function RegistrarFilme(movie_name, parental_rating, size_room) {

    const initDetails = {
        method: 'post',
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        mode: "cors"
    }
    //http://127.0.0.1:8000/api/programacaos?movie_name=22&parental_rating=1
    const uri = "http://127.0.0.1:8000/api";
    const route = "/programacaos";
    const data = "?movie_name=" + movie_name + "&parental_rating=" + parental_rating + "&size_room=" + size_room;
    fetch((uri + route + data) , initDetails)
    .then( response =>
        {
            if ( response.status !== 200 )
            {
                console.log( 'Looks like there was a problem. Status Code: ' +
                    response.status );
                return;
            }
            return response.json();
        }
        ).then(myJson =>{
            console.log(JSON.stringify(myJson));
    })
}

function iFrameProgramacaoCinema() {

    const iF = document.getElementById("iF");
    iF.innerHTML += "";

    iF.innerHTML += `
    <form action="/">
      <div class="title">
        <h2>Cadastro de Filme</h2>
      </div>
      <div class="info">
        <input id="nomeFilme" type="text" name="name" placeholder="Nome do Filme">
        <input id="faixaEtaria" type="text" name="name" placeholder="Faixa Etaria">
        <input id="capacidadeSala" type="text" name="name" placeholder="Capacidade da Sala">
      </div>
    </form>
    <button id="registrarFilme" onclick="RegistrarFilme(
      document.getElementById('nomeFilme').value, 
      document.getElementById('faixaEtaria').value, 
      document.getElementById('capacidadeSala').value
        )">Cadastrar</button>`;

    //document.getElementById('iFrame').src = "views/programacaoCinema.html";
}

function iFrameAgendamento() {
    document.getElementById('iFrame').src = "views/agendamento.html";
}

function iFrameRelatorio() {
    document.getElementById('iFrame').src = "views/relatorio.html";
}

function Relatorio() {
    const initDetails = {
        method: 'get',
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        mode: "cors"
    }
    
    fetch("http://127.0.0.1:8000/api/programacaos", initDetails)
    .then( response =>
        {
            if ( response.status !== 200 )
            {
                console.log( 'Looks like there was a problem. Status Code: ' +
                    response.status );
                return;
            }
            return response.json();
        }
        ).then(myJson =>{
            console.log(JSON.stringify(myJson));
    })
}

function RegistrarAgendamento(people_name, age_people, id_programacao) {
    const retorno = document.getElementById("retorno");
    body.innerHTML += "";

    const initDetails = {
        method: 'post',
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        mode: "cors"
    }
    
    const uri = "http://127.0.0.1:8000/api";
    const route = "/agendamentos";
    const data = "?people_name=" + people_name + "&age_people=" + age_people + "&id_programacao=" + id_programacao;

    fetch((uri + route + data) , initDetails)
    .then( response =>
        {
            if ( response.status !== 200 )
            {
                console.log(response.status );
                return;
            }
            return response.json();
        }
        ).then(myJson =>{
            body.innerHTML += `
                <p>${myJson.retorno}</p>`
            console.log(JSON.stringify(myJson));
    })
}

function RelatorioMovie(movie) {
    const primeiraFila = document.getElementById("primeiroFila");
    primeiraFila.innerHTML = "";
    
    const initDetails = {
        method: 'get',
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        mode: "cors"
    }
    const uri = "http://127.0.0.1:8000/api";
    const route = "/agendamentos/per_movie/";
    const data = movie;

    fetch((uri + route + data) , initDetails)
    .then( response =>
        {
            if ( response.status !== 200 )
            {
                console.log(response.status );
                return;
            }
            return response.json();
        }
    ).then(myJson =>{
            myJson.forEach(json => {
                primeiraFila.innerHTML += `
                    <th class="tabela-1">${json.people_name}</th>`
        })
    })
}