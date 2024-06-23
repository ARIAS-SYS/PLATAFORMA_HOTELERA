
    // Obtener los elementos del DOM
    const openModalSesion = document.getElementById('openModalSesion');
    const openModalSesion2 = document.getElementById('openModalSesion2');
    const openModalRegister = document.getElementById('openModalRegister');
    const modalSesion = document.getElementById('modalSesion');
    const modalRegister = document.getElementById('modalRegister');


    // Función para abrir el modal sesion
    openModalSesion.addEventListener('click', () => {
        $.ajax({
            url: "MainController",
            method: "POST",
            data: {
                action: 'sessionExist'
            },
            success: function(response) {
                if (response.sessionExists) {
                    if(response.isCliente){
                        window.location.href = 'MainController?action=cliente';                         
                    }else{
                        window.location.href = 'MainController?action=propietario';                         
                    }
                }else{
                    modalSesion.classList.remove('hidden');
                }
            }
        });

    });

    // Función para cerrar el modal y abrir
    openModalRegister.addEventListener('click', () => {
      modalSesion.classList.add('hidden');
      modalRegister.classList.remove('hidden');
    });

    // Función para cerrar el modal y abrir
    openModalSesion2.addEventListener('click', () => {
      modalRegister.classList.add('hidden');
      modalSesion.classList.remove('hidden');
    });

    // Cerrar el modal al hacer clic fuera del contenido del modal sesion
    window.addEventListener('click', (e) => {
      if (e.target == modalSesion) {
        modalSesion.classList.add('hidden');
      }
      if (e.target == modalRegister) {
        modalRegister.classList.add('hidden');
      }
    });
