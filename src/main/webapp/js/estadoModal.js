$(document).ready(function(){
    $(".estado").click(function(e){
        e.preventDefault();
        
        var button = $(this);
        var reservaId = button.data("id");
        var modal = $('#estadoModal'); // Seleccionamos el modal usando jQuery

        const modalOptions = $('#modalOptions'); // Seleccionamos modalOptions por su ID

        // Generar el contenido del modal dinámicamente
        modalOptions.html(`
            <li>
                <a href="ReservasController?action=cambiarEstado&opcion=reservado&id=${reservaId}" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Reservado</a>
            </li>
            <li>
                <a href="ReservasController?action=cambiarEstado&opcion=estadia&id=${reservaId}" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">En Estadia</a>
            </li>
            <li>
                <a href="ReservasController?action=cambiarEstado&opcion=completado&id=${reservaId}" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Completado</a>
            </li>
        `);

        // Obtener las coordenadas del botón
        var buttonRect = button[0].getBoundingClientRect();
        var buttonTop = buttonRect.top + window.scrollY;
        var buttonLeft = buttonRect.left + window.scrollX;
        var buttonHeight = buttonRect.height;

        // Ajustar la posición del modal justo debajo del botón
        modal.css({
            top: buttonTop + buttonHeight + 'px',
            left: buttonLeft + 'px'
        });

        modal.removeClass('hidden');
    });

    // Cerrar el modal si se hace clic fuera de él
    $(document).on('click', function(event) {
        if (!$(event.target).closest('#estadoModal').length && !$(event.target).hasClass('estado')) {
            $('#estadoModal').addClass('hidden');
        }
    });
});
