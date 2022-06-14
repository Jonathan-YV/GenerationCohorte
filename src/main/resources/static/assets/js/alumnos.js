let alumnoForm = document.querySelector("#alumno");

alumnoForm.addEventListener("submit",(e) => {
    e.preventDefault();
    const nombreAlumno = document.querySelector("#nombreAlumno").value;
    const edadAlumno = parseInt(document.querySelector("#edadAlumno").value);
    const correoAlumno = document.querySelector("#correoAlumno").value;
    const cohorteAlumno = parseInt(document.querySelector("#cohorteAlumno").value);

    const token = localStorage.getItem('token') || null;
    
    fetch("http://localhost:8080/api/cohorte/numero/" + cohorteAlumno, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': token
        }
    })
    .then(resp => resp.json())
    .then(datos => {

        console.log(datos);
        fetch('http://localhost:8080/api/alumno', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token
            },
            body: JSON.stringify({
                nombre: nombreAlumno,
                edad: edadAlumno,
                correo: correoAlumno,
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

    }).catch((err) => alert("La cohorte no existe"))

})