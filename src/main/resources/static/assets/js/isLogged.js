const token = localStorage.getItem('token');

if(!token) {
    url = window.location;
    const path = url.pathname.substring(0, url.pathname.lastIndexOf('/') + 1)
    location.href = path +  'index.html';
}