// Inicializar el mapa y establecer la vista centrada en España
var map = L.map('map').setView([40.416775, -3.703790], 6); // Coordenadas de Madrid como centro inicial

// Cargar el mapa desde OpenStreetMap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    maxZoom: 18
}).addTo(map);

// Evento para obtener las coordenadas al hacer clic en el mapa
map.on('click', function(e) {
    // Obtener latitud y longitud del clic
    var lat = e.latlng.lat;
    var lng = e.latlng.lng;

    // Mostrar latitud y longitud en los cuadros de texto
    document.getElementById('latitud').value = lat.toFixed(6);
    document.getElementById('longitud').value = lng.toFixed(6);
});
