$(document).ready(function () {
    $('#nuevoUser').on('click', function () {
        $.ajax({
            url: '/formulario',
            type: 'GET',
            success: function (html) {
                $('#modal-content').html(html);
                const modal = new bootstrap.Modal(document.getElementById('modalNuevoUser'));
                modal.show();
                bindFormulario();
            },
            error: function () {
                alert("Error al cargar el formulario.");
            }
        });
    });
});

function bindFormulario() {
    $('#formNuevoTrabajador').on('submit', function (e) {
        e.preventDefault();

        const datos = {
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val()
        };

        $.ajax({
            url: '/nuevo',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(datos),
            success: function () {
                alert('Trabajador creado correctamente');
                location.reload();
            },
            error: function () {
                alert('Error al guardar el trabajador');
            }
        });
    });
}
