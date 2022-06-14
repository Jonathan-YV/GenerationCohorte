let cohorteForm = document.getElementById("cohorte");

cohorteForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const numeroCohorte = parseInt(document.querySelector("#numeroCohorte").value);
    const ciudad = document.querySelector("#ciudadCohorte").value;

    const token = localStorage.getItem('token') || null;

    fetch('http://localhost:8080/api/cohorte', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': token
        },
        body: JSON.stringify({
            ciudad: ciudad,
            numeroCohorte: numeroCohorte
        })
    })
    .then(resp => resp.json()).then(data => {
        console.log(data);
        location.reload();
    })
    .catch((error) => {
		console.error(error);
	})
});

setTimeout(() => {
    const btnEliminar = document.querySelectorAll(".cohorte");
    
    const token = localStorage.getItem('token') || null;
    
    btnEliminar.forEach(btn => {
        btn.addEventListener("click", (e)=>{
            const idCohorte = e.target.id.split("_").pop();
            fetch('http://localhost:8080/api/cohorte/delete/' + idCohorte, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': token
                }
            })
            .then(res => res)
            .then(res => location.reload())
        })
    })
},100)


