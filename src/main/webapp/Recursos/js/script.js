$(document).ready(function () {
  listar();
});

let vp = 0;
let idalum;

function listar() {
  $.get("AlumnoController", { opc: 1 }, function (data) {
    let x = JSON.parse(data);
    $("#tbd tr").remove();
    for (let i = 0; i < x.length; i++) {
      $("#tbd").append(
        "<tr><td>" +
          (i + 1) +
          "</td><td>" +
          x[i].idalum +
          "</td><td>" +
          x[i].nombre +
          "</td><td>" +
          x[i].direccion +
          "</td><td>" +
          x[i].telefono +
          "</td><td><a href='#' onclick='editar(" +
          x[i].idalum +
          ")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" +
          x[i].idalum +
          ")'><i class='fas fa-trash-alt'></i></a></td></tr>"
      );
    }
  });
}

$("#agregar").click(function () {
  if (vp == 0) {
    let param = {
      nombre: $("#nombre").val(),
      direccion: $("#direccion").val(),
      telefono: $("#telefono").val(),
      opc: 2,
    };
    $.ajax({
      beforeSend: function () {
        console.log("Trayendo");
      },
      data: param,
      url: "AlumnoController",
      type: "POST",
      success: function (response) {
        alert(response);
        limpiar();
        listar();
      },
      error: function (jqXHR, estado, error) {
        console.log(estado);
        console.log(error);
      },
      complete: function (jqXHR, estado) {
        console.log(estado);
      },
    });
    limpiar();
  } else {
    alert(idalum);
    $.post(
      "AlumnoController",
      {
        id:idalum,
        nombre: $("#nombre").val(),
        direccion: $("#direccion").val(),
        telefono: $("#telefono").val(),
        opc: 4,
      },
      function (data) {
        listar();
        limpiar();
      }
    );
  }
});

function editar(id) {
  $("#agregar").html("Editar");
  $.get("AlumnoController", { id: id, opc: 3 }, function (data) {
    let x = JSON.parse(data);
    idalum=x.idalum;
    $("#nombre").val(x.nombre);
    $("#direccion").val(x.direccion);
    $("#telefono").val(x.telefono);
    vp = 1;
    alert(idalum);
  });
}

 function eliminar(id) {
   $.get("AlumnoController", { id: id, opc: 5 }, function () {
     listar();
   });
 }

function limpiar() {
  $("#nombre").val("");
  $("#direccion").val("");
  $("#telefono").val("");
  $("#nombre").focus();
}
