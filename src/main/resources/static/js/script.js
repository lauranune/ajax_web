var app={
    init:function(){
        app.initDatatable('#trabajadores')
    },
    initDatatable : function (id){
        $(id).DataTable();
    }
};
$(document).ready(function (){
    app.init()
});

function bindFormulario() {
    $(document).on('submit', '#formNuevoTrabajador', function (e) {
        e.preventDefault();

        $.ajax({
            url: '/nuevo',
            type: 'POST',
            data: $(this).serialize(),
            success: function (data) {
                if ($(data).find(".alert.alert-warning").length > 0) {
                    $('#formContainer').html(data);
                    bindFormulario();
                }else {
                    alert('Trabajador creado correctamente');
                    location.reload();
                }

            },
            error: function () {
                alert('Error al guardar el trabajador');
            }
        });
    });
}

    $(document).ready(function () {
        $('#nuevoUser').on('click', function () {
            const $formContainer = $('#formContainer');

            if ($formContainer.is(':visible')) {
                $formContainer.slideUp().empty();
            } else {
                $.ajax({
                    url: '/formulario',
                    method: 'GET',
                    success: function (data) {
                        $('#formContainer').html(data).slideDown();
                        bindFormulario();
                    },
                    error: function () {
                        alert("Error al cargar el formulario.");
                    }
                });
            }
        });

        $(document).on('click', '.borrar-btn', function () {
            const id = $(this).data('id');

            if (confirm("Quieres borrar este trabajador?")) {
                $.ajax({
                    type: 'GET',
                    url:  `/borrar/${id}` ,
                    success: function () {
                        alert("Trabajador borrado correctamente.");
                        location.reload();
                    },
                    error: function () {
                        alert("Error al borrar el trabajador.");
                    }
                });
            }
        });

        $(document).ready(function () {
            $(document).on('click', '.editar-btn', function () {
                const id = $(this).data('id');

                $.ajax({
                    url: `/editar?id=${id}`,
                    type: 'GET',
                    success: function (html) {
                        $('body').append(html);

                        const modal = new bootstrap.Modal(document.getElementById('modalEditar'));
                        modal.show();

                        $('#modalEditar').on('hidden.bs.modal', function () {
                            $(this).remove();
                        });

                        $('#formEditar').on('submit', function (e) {
                            e.preventDefault();

                            $.ajax({
                                url: $(this).attr('action'),
                                type: 'POST',
                                data: $(this).serialize(),
                                success: function () {
                                    alert('Trabajador actualizado correctamente');
                                    modal.hide();
                                    location.reload();
                                },
                                error: function () {
                                    alert('Error al actualizar el trabajador');
                                }
                            });
                        });
                    },
                    error: function () {
                        alert("Error al cargar el formulario de edición.");
                    }
                });
            });
        });
    });