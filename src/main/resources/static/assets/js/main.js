const elementosCohorte = document.querySelector("#elementosCohorte")

window.addEventListener("load", () => {

    fetch('http://localhost:8080/api/cohorte/all').then(resp => resp.json()).then(datos => {

        datos.forEach( cohorte => {

            const templateTitulo =  `
                                        <div class="bg-success p-3">
                                            <h5 class="card-title d-inline">Cohorte ${cohorte.numeroCohorte}</h5>
                                            <small>${cohorte.ciudad}</small>
                                        </div>
                                     `;

            let templateAlumnos = "";

            if(cohorte.alumnos.length != 0){

                cohorte.alumnos.forEach(alumno => {

                    templateAlumnos += `<div class="row">
                                            <div class="col">
                                                <ul>
                                                    <li>${alumno.nombre}</li>
                                                    <li>${alumno.edad}</li>
                                                    <li>${alumno.correo}</li>
                                                </ul>
                                            </div>
                                            
                                        </div>`
    
                })
            }
            
            let templateInstructor = ""

            if(cohorte.instructor != null){
                templateInstructor = `<div class="row">
                                            <div class="col">
                                                <ul>
                                                    <li>${cohorte.instructor.nombre}</li>
                                                    <li>${cohorte.instructor.supervisor}</li>
                                                    <li>${cohorte.instructor.puesto}</li>
                                                </ul>
                                            </div>
                                            
                                        </div>`
            }

            const templateFinal = ` <div class="col mb-4">
                                        <div class="card">

                                            ${templateTitulo}

                                            <div class="card-body">

                                                <p class="card-text">Alumnos:</p>
                                                ${templateAlumnos}

                                                <p class="card-text">Instructor:</p>
                                                ${templateInstructor}

                                            </div>
                                           
                                        </div>
                                    </div>`

            elementosCohorte.innerHTML += templateFinal;

        });

    })
    .catch((error) => {
        console.error(error);
    })

})