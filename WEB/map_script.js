// Coordenadas aproximadas del límite de España (sudoeste y noreste)
var bounds = [
    [35.0, -10.0], // Sudoeste de España
    [44.0, 5.0]    // Noreste de España
];

// Inicializar el mapa y establecer la vista centrada en España
var map = L.map('map', {
    center: [40.416775, -3.703790], // Coordenadas de Madrid como centro inicial
    zoom: 6, // Nivel de zoom inicial
    maxBounds: bounds, // Limitar el área de desplazamiento al contorno de España
    maxBoundsViscosity: 1.0 // Impide salir de los límites con facilidad
});

// Cargar el mapa desde OpenStreetMap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    maxZoom: 18,
    minZoom: 6 // Establecer un zoom mínimo para evitar alejarse demasiado
}).addTo(map);

var circle; // Variable to store the circle

// Evento para obtener las coordenadas al hacer clic en el mapa y agregar un círculo
map.on('click', function(e) {
    // Obtener latitud y longitud del clic
    var lat = e.latlng.lat;
    var lng = e.latlng.lng;

    // Mostrar latitud y longitud en los cuadros de texto
    document.getElementById('latitud').value = lat.toFixed(6);
    document.getElementById('longitud').value = lng.toFixed(6);

    // Agregar el círculo de 10 km de radio en el mapa
    addCircle(lat, lng);
});

// Función para agregar un círculo basado en las coordenadas
function addCircle(lat, lng) {
    // Si ya hay un círculo, eliminarlo
    if (circle) {
        removeAllLayers();
    }
    // Agregar un círculo de 10 km (10000 metros) de radio
    circle = L.circle([lat, lng], {
        color: 'red',
        fillColor: 'green',
        fillOpacity: 0.1,
        radius: document.getElementById('radius').value*1000 // x km
    }).addTo(map);
}

function addChinchet(lat, lng) {
    // Agregar un círculo de 10 km (10000 metros) de radio
    circle = L.circle([lat, lng], {
        color: 'red',
        fillColor: 'red',
        fillOpacity: 1,
        radius: 2000 // x km
    }).addTo(map);
}

function removeAllLayers() {
    map.eachLayer(function(layer) {
        // Check if the layer is not the base map tile layer
        if (!(layer instanceof L.TileLayer)) {
            map.removeLayer(layer);
        }
    });
}


// Función para agregar un círculo basado en los valores de los cuadros de texto
function addCircleFromInput() {
    var lat = parseFloat(document.getElementById('latitud').value);
    var lng = parseFloat(document.getElementById('longitud').value);

    // Solo agregar si las coordenadas son válidas
    if (!isNaN(lat) && !isNaN(lng)) {
        addCircle(lat, lng);
    } else {
        alert("Please enter valid latitude and longitude values.");
    }
}