<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tabla Alumno</title>
    <link
      href="./Recursos/faw/web-fonts-with-css/css/fontawesome-all.css"
      rel="stylesheet"
      type="text/css"
    />
    <link rel="stylesheet" href="./Recursos/css/bootstrap.min.css" />
  </head>
  <body>
    <form class="container">
      <div>
        <h1>Registro Alumno</h1>
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-emoji-smile"
            viewBox="0 0 16 16"
          >
            <path
              d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"
            />
            <path
              d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"
            />
          </svg>
        </span>
        <input
          type="text"
          class="form-control"
          placeholder="Nombre"
          aria-label="Nombre"
          aria-describedby="basic-addon1"
          id="nombre"
        />
      </div>

      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          placeholder="Direccion"
          aria-label="Recipient's username"
          aria-describedby="basic-addon2"
          id="direccion"
        />
        <span class="input-group-text" id="basic-addon2"
          >Direccion mz i lote 4</span
        >
      </div>

      <label for="basic-url" class="form-label">Telefono</label>
      <div class="input-group mb-3">
        <input
          placeholder="Telefono"
          type="number"
          class="form-control"
          id="telefono"
          aria-describedby="basic-addon3"
        />
      </div>
      <div class="form-group">
        <button class="btn btn-success" id="agregar">Agregar</button>
      </div>
    </form>

    <!-- Tabla  -->

    <table class="table container mt-3">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Id</th>
          <th scope="col">Nombre</th>
          <th scope="col">Direccion</th>
          <th scope="col">Telefono</th>
          <th scope="col" colspan="2">Acción</th>
        </tr>
      </thead>
      <tbody id="tbd"></tbody>
    </table>

    <script src="./Recursos/js/jquery.js"></script>
    <script src="./Recursos/js/bootstrap.min.js"></script>
    <script src="./Recursos/js/script.js"></script>
  </body>
</html>
