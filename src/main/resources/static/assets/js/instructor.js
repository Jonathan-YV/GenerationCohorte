let instructorForm = document.querySelector("#instructor");

instructorForm.addEventListener("submit",(e) => {
    e.preventDefault();
    const nombreInstructor = document.querySelector("#nombreInstructor").value;
    const supervisorInstructor = document.querySelector("#supervisorInstructor").value;
    const puestoInstructor = document.querySelector("#puestoInstructor").value;
    const cohorteInstructor = parseInt(document.querySelector("#cohorteInstructor").value);

    fetch("http://localhost:8080/api/cohorte/numero/" + cohorteInstructor)
    .then(resp => resp.json())
    .then(datos => {

        console.log(datos);
        console.log(datos.instructor);
        if(datos.instructor === null){
            fetch('http://localhost:8080/api/instructor', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    nombre: nombreInstructor,
                    supervisor: supervisorInstructor,
                    puesto: puestoInstructor,
                    cohorte: {
                        id: datos.id
                    }
                })
            })
            .then(resp => resp.json()).then(data => {
                console.log(data);
                location.reload();
            })
            .catch((error) => {
                console.error(error);
            })
        }
        else{
            alert("Solo puede existir un instructor por cohorte")
        }
        

    }).catch((err) => alert("La cohorte no existe"))

})