// Variables globales
const input = document.getElementById('nueva-tarea');
const boton = document.getElementById('btn-agregar');
const lista = document.getElementById('lista-tareas');
const contador = document.getElementById('contador');

let tareas = [];

// Función para agregar tarea
function agregarTarea() {
    const texto = input.value;
    
    if (texto === '') {
        alert('Debes escribir algo');
        return;
    }

    const nuevaTarea = {
        id: Date.now(),
        texto: texto,
        completada: false
    };

    tareas.push(nuevaTarea);
    input.value = '';
    mostrarTareas();
}

// Función para mostrar las tareas en el HTML
function mostrarTareas() {
    lista.innerHTML = '';
    
    tareas.forEach(t => {
        const li = document.createElement('li');
        if (t.completada) {
            li.classList.add('completada');
        }

        li.innerHTML = `
            <span onclick="marcarCompletada(${t.id})">${t.texto}</span>
            <button class="btn-borrar" onclick="eliminarTarea(${t.id})">Eliminar</button>
        `;
        lista.appendChild(li);
    });

    actualizarContador();
}

// Función para eliminar
function eliminarTarea(id) {
    tareas = tareas.filter(t => t.id !== id);
    mostrarTareas();
}

// Función para marcar como completada
function marcarCompletada(id) {
    tareas = tareas.map(t => {
        if (t.id === id) {
            return { ...t, completada: !t.completada };
        }
        return t;
    });
    mostrarTareas();
}

// Función para el contador
function actualizarContador() {
    const pendientes = tareas.filter(t => !t.completada).length;
    contador.innerText = 'Tareas pendientes: ' + pendientes;
}

// Evento del botón
boton.addEventListener('click', agregarTarea);

// Evento tecla Enter
input.addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        agregarTarea();
    }
});
