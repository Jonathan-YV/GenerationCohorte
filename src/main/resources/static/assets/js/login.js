const formLogin = document.querySelector('.form-signin');
const email = document.querySelector('#inputEmail');
const password = document.querySelector('#inputPassword');

console.log(formLogin);

formLogin.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log(email.value, password.value);

    if(username != '' && password != '') {
        fetch('http://localhost:8080/login', {
            method: 'POST',
            body: JSON.stringify( {
                username,
                password
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
                location.href = path +  'administrador.html';
            } else {
                localStorage.removeItem('token');
                Swal.fire({
                    title: 'Correo electronico o contraseña incorrecta',
                    text: 'Reintentar',
                    icon: 'error',
                    confirmButtonText: 'ok'
                });
            }
        })
    }

})