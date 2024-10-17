// Realizar la petición al servidor para obtener el JSON
fetch('http://localhost:8080/Cuenca')
.then(response => response.json()) // Convertir la respuesta a JSON
.then(data => {
    const select = document.getElementById('cuenca');
    select.innerHTML = ''; // Limpiar opciones iniciales

    // Recorrer el JSON y agregar cada opción al select
    data.forEach(item => {
        const option = document.createElement('option');
        option.value = item.id; // Usar el 'id' como valor
        option.textContent = item.name; // Usar el 'name' como texto visible
        select.appendChild(option);
    });
})
.catch(error => {
    console.error('Error al cargar las cuencas:', error);
    document.getElementById('cuenca').innerHTML = '<option>Error al cargar</option>';
});