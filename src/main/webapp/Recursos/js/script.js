$(document).ready(function () {
  listar();
});

let vp = 0;

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
          x[i].idrol +
          ")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" +
          x[i].idrol +
          ")'><i class='fas fa-trash-alt'></i></a></td></tr>"
      );
    }
  });
}

$("#agregar").click(function () {
  alert("Pulsado");
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
    alert($("#id").val() + "/" + $("#nomrol").val());
    $.post(
      "rc",
      { id: $("#id").val(), rol: $("#nomrol").val(), opc: 4 },
      function (data) {
        listar();
        limpiar();
      }
    );
  }
});

// function editar(id) {
//   $("#boton2").html("Editar");
//   $.get("rc", { id: id, opc: 3 }, function (data) {
//     var x = JSON.parse(data);
//     $("#nomrol").val(x.nomrol);
//     $("#id").val(x.idrol);
//   });
// }
// function eliminar(id) {
//   $.get("rc", { id: id, opc: 5 }, function () {
//     listar();
//   });
// }
function limpiar() {
  $("#nombre").val("");
  $("#direccion").val("");
  $("#telefono").val("");
  $("#nomrol").focus();
}
