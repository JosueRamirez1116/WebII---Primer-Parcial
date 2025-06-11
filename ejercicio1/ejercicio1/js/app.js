function agregarTarea() {
  const input = document.getElementById("tareaInput");
  const lista = document.getElementById("listaTareas");

  if (input.value.trim() === "") return;

  const li = document.createElement("li");
  li.innerHTML = `<span>${input.value}</span>
                            <button onclick="completarTarea(this)">✔</button>
                            <button onclick="eliminarTarea(this)">❌</button>`;

  lista.appendChild(li);
  input.value = "";
}

function contarTarea(){
  var lista = document.getElementById("listaTareas");
  var cuenta = lista.childNodes.length
  let encabezadoNuevo = "Lista de Tareas (" + cuenta + ")";
  document.getElementById("encabezado").textContent = encabezadoNuevo;

}

function completarTarea(boton) {
  boton.parentElement.children[0].classList.toggle("completado");
}

function eliminarTarea(boton) {
  boton.parentElement.remove();
  contarTarea()
}


