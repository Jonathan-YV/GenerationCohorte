
const formSignin = document.querySelector("#form-signin");

console.log(formSignin);

formSignin.addEventListener("submit", (e) => {
    e.preventDefault();
    console.log(1);

    const inputNombre = document.querySelector("#inputNombre").value;
    const inputCorreo = document.querySelector("#inputCorreo").value;
    const inputPassword = document.querySelector("#inputPassword").value;

    console.log(inputNombre,inputCorreo, inputPassword );

    fetch('http://localhost:8080/api/usuario', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre: inputNombre,
            correo: inputCorreo,
            password: inputPassword
        })
    })
    .then(resp => resp.json()).then(data => {

        console.log(data);
        fetch('http://localhost:8080/login', {
        method: 'POST',
        body: JSON.stringify( {
            correo: inputCorreo,
            password: inputPassword
        }),
        headers: {
            'Content-type': 'application/json'
        }
        }).then(resp => {
            const token = resp.headers.get('Authorization');
            
            if(token && token.includes('Bearer') && resp.ok) {
                localStorage.setItem('token', token);
                console.log(token);
                url = window.location;
                const path = url.pathname.substring(0, url.pathname.lastIndexOf('/') + 1)
                location.href = path +  'admin.html';
            } else {
                localStorage.removeItem('token');
            }
        })
    })
    .catch((error) => {
        console.error(error);
    })

})