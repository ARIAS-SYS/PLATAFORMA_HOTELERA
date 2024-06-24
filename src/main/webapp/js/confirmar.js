
$(document).ready(function(){
    
    const btnConfirmar = document.getElementById('btnConfirmar');
    const habitacionId = btnConfirmar.getAttribute("data-habitacion");
    const precio = btnConfirmar.getAttribute("data-precio");
    const login = document.getElementById('openModalSesion');
    
    

    
    // Función para abrir el modal sesion
    btnConfirmar.addEventListener('click', () => {
        
        const dateRangeInput = document.getElementById('date-range');
        const fechas = dateRangeInput.value;
        
        // Texto de ejemplo
        //let fechas = "23 de Junio - 24 de Junio";

        // Obtener el año actual
        let currentYear = new Date().getFullYear();

        // Función para convertir una fecha en español al formato "dd-MM-yyyy"
        function convertirFecha(fechaTexto, year) {
            const meses = {
                "Enero": "01",
                "Febrero": "02",
                "Marzo": "03",
                "Abril": "04",
                "Mayo": "05",
                "Junio": "06",
                "Julio": "07",
                "Agosto": "08",
                "Septiembre": "09",
                "Octubre": "10",
                "Noviembre": "11",
                "Diciembre": "12"
            };

            // Separar el día y el mes
            let [dia, de, mes] = fechaTexto.trim().split(" ");

            // Obtener el mes en formato numérico
            mes = meses[mes];

            // Retornar la fecha en formato "dd-MM-yyyy"
            return `${dia.padStart(2, '0')}-${mes}-${year}`;
        }

        // Dividir el texto en dos partes
        let [fechaInicioTexto, fechaFinTexto] = fechas.split(" - ");

        // Convertir las fechas al formato "dd-MM-yyyy"
        let fechaInicio = convertirFecha(fechaInicioTexto, currentYear);
        let fechaFin = convertirFecha(fechaFinTexto, currentYear);

        console.log("Fecha de inicio: " + fechaInicio); // "23-06-2024"
        console.log("Fecha de fin: " + fechaFin);       // "24-06-2024"
        
        function calcularDiferenciaEnDias(fecha1, fecha2) {
            // Separar día, mes y año de fecha1
            let partesFecha1 = fecha1.split("-");
            let dia1 = parseInt(partesFecha1[0], 10);
            let mes1 = parseInt(partesFecha1[1], 10) - 1; // Meses en JavaScript van de 0 a 11
            let anio1 = parseInt(partesFecha1[2], 10);

            // Separar día, mes y año de fecha2
            let partesFecha2 = fecha2.split("-");
            let dia2 = parseInt(partesFecha2[0], 10);
            let mes2 = parseInt(partesFecha2[1], 10) - 1; // Meses en JavaScript van de 0 a 11
            let anio2 = parseInt(partesFecha2[2], 10);

            // Crear objetos Date para ambas fechas
            let fechaObj1 = new Date(anio1, mes1, dia1);
            let fechaObj2 = new Date(anio2, mes2, dia2);

            // Calcular la diferencia en milisegundos
            let diferenciaMs = fechaObj2 - fechaObj1;

            // Convertir la diferencia de milisegundos a días
            let diferenciaDias = Math.floor(diferenciaMs / (1000 * 60 * 60 * 24));

            return diferenciaDias;
        }
        
        let cantidadDias = calcularDiferenciaEnDias(fechaInicio, fechaFin);
        
        let today = new Date();

        // Obtener el día, mes y año
        let dd = String(today.getDate()).padStart(2, '0');
        let mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0, por lo tanto sumamos 1
        let yyyy = today.getFullYear();

        // Crear la fecha en formato "dd-MM-yyyy"
        let fechaActual = dd + '-' + mm + '-' + yyyy;

        
        $.ajax({
            url: "MainController",
            method: "POST",
            data: {
                action: 'sessionExist'
            },
            success: function(response) {
                if (response.sessionExists) {
                    $.ajax({
                        url: "MainController",
                        method: "POST",
                        data: {
                            action: 'reservar',
                            habitacionId: habitacionId,
                            precio: precio,
                            fechaInicio: fechaInicio,
                            fechaActual: fechaActual,
                            cantidadDias: cantidadDias,
                            fechaFin: fechaFin
                        },
                        success: function(response) {
                            if (response.success) {
                                window.location.href = 'MainController?action=success';                         
                            }
                        }
                    });
                }else{
                    login.click();
                }
            }
        });

    });

});


