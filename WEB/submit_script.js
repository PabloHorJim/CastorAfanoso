document.getElementById("submit").addEventListener("click", submitClick);

function submitClick() {
    console.log("click");
    const latitud = document.getElementById("latitud").value ;
    const longitud = document.getElementById("longitud").value;
    const radio = document.getElementById("radius").value;

    // if (latitud != "" || longitud != "" || radio != "") {
    //     alert('Por favor, ingrese valores válidos para latitud, longitud y distancia.');
    //     return; // Detiene la función si los valores no son válidos
    // }

    const url = `http://localhost:8080/?x=${encodeURIComponent(latitud)}&y=${encodeURIComponent(longitud)}&dist=${radio}`;
    console.log(url);

    fetch(url)
        .then(response => {
            // Verifica si la respuesta es exitosa
            if (response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json(); // Convierte la respuesta a JSON
        })
        .then(data => {
            // Muestra los datos en el div con id="result"
            const resultDiv = document.getElementById('result');
            resultDiv.innerHTML = JSON.stringify(data, null, 2); // Convierte el JSON a string y lo formatea
        })
        .catch(error => {
            console.error('Hubo un problema con la petición Fetch:', error);
        });
}