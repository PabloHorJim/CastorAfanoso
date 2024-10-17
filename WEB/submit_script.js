document.getElementById("submit").addEventListener("click", submitClick);

function submitClick() {
    
    const latitud = document.getElementById("latitud").value;
    const longitud = document.getElementById("longitud").value;
    const radio = document.getElementById("radius").value;

    // Validación de los valores ingresados
    if (latitud === "" || longitud === "" || radio === "") {
        alert('Por favor, ingrese valores válidos para latitud, longitud y distancia.');
        return; // Detiene la función si los valores no son válidos
    }

    const url = `http://localhost:8080/?x=${encodeURIComponent(latitud)}&y=${encodeURIComponent(longitud)}&dist=${radio}`;

    fetch(url)
        .then(response => {
            // Verifica si la respuesta es exitosa
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json(); // Convierte la respuesta a JSON
        })
        .then(data => {
            // Muestra los datos en el div con id="result"
            const resultDiv = document.getElementById('result');
            resultDiv.innerHTML = ''; // Limpiar el contenido previo

            // Crear un elemento ul para la lista
            const ul = document.createElement('ul');

            // Iterar sobre los datos y crear elementos li
            data.forEach(embalse => {

                addChinchet(parseFloat(embalse.x), parseFloat(embalse.y));

                const div = document.createElement('div');
                div.id = "output";
                div.innerHTML = `
                    <div id="out_info">
                    <strong>Nombre:</strong> ${embalse.embalse_nombre}<br>
                    <strong>Ámbito:</strong> ${embalse.ambito_nombre}<br>
                    <strong>Agua Total:</strong> ${embalse.agua_total} m³<br>
                    <strong>Provincia:</strong> ${embalse.provincia}<br>
                    <strong>CCAA:</strong> ${embalse.ccaa}<br>
                    <strong>Tipo:</strong> ${embalse.tipo}<br>
                    </div>
                `;
                ul.appendChild(div); // Añadir el li a la lista
            });

            resultDiv.appendChild(ul); // Añadir la lista al div result
        })
        .catch(error => {
            console.error('Hubo un problema con la petición Fetch:', error);
        });
}
