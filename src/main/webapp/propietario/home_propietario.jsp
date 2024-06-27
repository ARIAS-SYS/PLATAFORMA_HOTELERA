<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%@page import="java.util.Date" %>

<%
    // Crear una instancia de la fecha actual
    Date fechaActual = new Date();
    // Colocar la fecha en el contexto de la página
    pageContext.setAttribute("fechaActual", fechaActual);
%>

<fmt:formatDate value="${fechaActual}" pattern="yyyy-MM-dd" var="fechaHoy" />


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- flowbite graficos -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />


    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">


</head>

<body class="bg-[#0F1522]">
    
    <div class="flex h-screen">
                
        <jsp:include page="../layout/sidebar_propietario.jsp" />


        <div class="flex flex-col flex-1 h-full overflow-hidden">

            <!-- main -->
            <main class="flex-1 max-h-full p-5 overflow-hidden overflow-y-scroll">

                <!-- resumen -->
                <div class="flex gap-2 mx-5">
                    
                    <c:set var="reserAct" value="0" />
                    <c:set var="reserDia" value="0" />
                    <c:set var="cantHab" value="0" />
                    <c:set var="porHab" value="0" />
                    <c:set var="canHue" value="0" />

                    <c:forEach var="item" items="${reservas}">
                        <c:if test="${hotel.id==item.idHabit.idHotelHab.id}">
                            <c:if test="${item.estado=='Reservado'}">
                                <c:set var="reserAct" value="${reserAct+1}" />
                            </c:if>
                            <c:if test="${item.estado=='Reservado' && item.fechaReserva==fechaHoy}">
                                <c:set var="reserDia" value="${reserDia+1}" />
                            </c:if>
                        </c:if>

                    </c:forEach>
                    
                    <c:forEach var="hab" items="${hotel.habitacionList}">
                        <c:set var="cantHab" value="${cantHab+1}" />
                        <c:if test="${hab.estado=='Ocupado'}">
                            <c:set var="porHab" value="${porHab+1}" />
                            <c:set var="canHue" value="${canHue+hab.capacidad}" />
                            
                        </c:if>
                    </c:forEach>
                    
                    <!-- card -->
                    <div class="h-[8rem] bg-[#8F9EB31C] flex-1 p-5 flex justify-between">
                        <div class="flex h-full flex-col justify-between">
                            <h3 class="text-gray-300 font-bold">
                                Reservas Actuales
                            </h3>
                            <span class="text-white font-bold text-2xl">
                                ${reserAct}
                            </span>
                        </div>
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-calendar4-week text-sky-500 size-8" viewBox="0 0 16 16">
                                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z"/>
                                <path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5z"/>
                            </svg>
                        </div>
                    </div>

                    <!-- card -->
                    <div class="h-[8rem] bg-[#8F9EB31C] flex-1 p-5 flex justify-between">
                        <div class="flex h-full flex-col justify-between">
                            <h3 class="text-gray-300 font-bold">
                                Reservas de Día
                            </h3>
                            <span class="text-white font-bold text-2xl">
                                ${reserDia}
                            </span>
                        </div>
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-calendar-check text-green-500 size-8" viewBox="0 0 16 16">
                                <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4z"/>
                            </svg>
                        </div>
                    </div>

                    <!-- card -->
                    <div class="h-[8rem] bg-[#8F9EB31C] flex-1 p-5 flex justify-between">
                        <div class="flex h-full flex-col justify-between">
                            <h3 class="text-gray-300 font-bold">
                                Habitaciones Ocupadas
                            </h3>
                            <span class="text-white font-bold text-2xl">
                                <c:if test="${cantHab==0}">
                                    <c:set var="porcentajeOcupacion" value="S/H" />
                                    ${porcentajeOcupacion}
                                </c:if>
                                <c:if test="${cantHab>0}">                                    
                                    <c:set var="porcentajeOcupacion" value="${(porHab / cantHab) * 100}" />
                                    ${porcentajeOcupacion}%
                                </c:if>
                            </span>
                        </div>
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-building-check text-orange-500 size-8" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m1.679-4.493-1.335 2.226a.75.75 0 0 1-1.174.144l-.774-.773a.5.5 0 0 1 .708-.708l.547.548 1.17-1.951a.5.5 0 1 1 .858.514"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </div>
                    </div>

                    <!-- card -->
                    <div class="h-[8rem] bg-[#8F9EB31C] flex-1 p-5 flex justify-between">
                        <div class="flex h-full flex-col justify-between">
                            <h3 class="text-gray-300 font-bold">
                                Número de Huespedes
                            </h3>
                            <span class="text-white font-bold text-2xl">
                                ${canHue}
                            </span>
                        </div>
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-people text-yellow-500 size-8" viewBox="0 0 16 16">
                                <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1zm-7.978-1L7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002-.014.002zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0M6.936 9.28a6 6 0 0 0-1.23-.247A7 7 0 0 0 5 9c-4 0-5 3-5 4q0 1 1 1h4.216A2.24 2.24 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816M4.92 10A5.5 5.5 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0m3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4"/>
                            </svg>
                        </div>
                    </div>

                </div>

                <div class="flex w-full gap-2 px-5 mt-2">

                    <!-- char lineal -->
                    <div class="w-[70%] rounded-lg bg-[#8F9EB31C] p-4">

                        <div class="w-full">
                            <h5 class="text-gray-300 text-center text-xl font-bold">
                                Tendencias de Reservas
                            </h5>
                        </div>
                        <!-- grafico lineal  -->
                        <div class="py-6" id="line-chart"></div>
                    </div>

                    <!-- char circular -->
                    <div class="w-[30%] rounded-lg bg-[#8F9EB31C] p-4">

                        <div class="w-full">
                            <h5 class="text-gray-300 text-center text-xl font-bold">
                                Habitaciones mas Populares
                            </h5>
                        </div>
                        <!-- grafico lineal  -->
                        <div class="py-6" id="pie-chart"></div>
                    </div>
                    
                    
                </div>

            </main>

        </div>

    </div>
    
    <!-- flowbite -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>

    <!-- apex char -->
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    
    <c:set var="fechasString" value="" />
    <c:set var="cantidadesString" value="" />
    <c:set var="huespedesString" value="" />

    <c:forEach var="reserva" items="${reservas}">
        <c:if test="${hotel.id==reserva.idHabit.idHotelHab.id}">


            <c:set var="fechaReserva" value="${reserva.fechaReserva}"/>

            <fmt:formatDate var="fechaFormateada" value="${fechaReserva}" pattern="dd-MM" />

            <!-- Verificar si la fecha ya está en fechasString -->
            <c:if test="${fn:indexOf(fechasString, fechaFormateada) eq -1}">
                <!-- Conteo de reservas para la fecha actual -->
                <c:set var="cantidad" value="0"/>
                <c:set var="hues" value="0"/>
                <c:forEach var="otraReserva" items="${reservas}">
                    <c:if test="${fechaReserva == otraReserva.fechaReserva}">
                        <c:set var="cantidad" value="${cantidad + 1}"/>
                        <c:set var="hues" value="${hues + otraReserva.idHabit.capacidad}"/>
                    </c:if>
                </c:forEach>

                <!-- Construcción de las cadenas -->
                <c:set var="fechasString" value="${fechasString}${fechaFormateada},"/>
                <c:set var="cantidadesString" value="${cantidadesString}${cantidad},"/>
                <c:set var="huespedesString" value="${huespedesString}${hues},"/>
            </c:if>
        </c:if>
    </c:forEach>

    <!-- Eliminar la última coma de cada cadena si es necesario -->
    <c:set var="fechasString" value="${fn:substring(fechasString, 0, fn:length(fechasString) - 1)}"/>
    <c:set var="cantidadesString" value="${fn:substring(cantidadesString, 0, fn:length(cantidadesString) - 1)}"/>
    <c:set var="huespedesString" value="${fn:substring(huespedesString, 0, fn:length(huespedesString) - 1)}"/>

    <c:set var="tipoHabString" value="" />
    <c:set var="cantReservasString" value="" />

    <c:forEach var="reserva" items="${reservas}">
        <c:if test="${hotel.id == reserva.idHabit.idHotelHab.id}">
            <c:set var="tipoHab" value="${reserva.idHabit.idTipoHab.id}" />
            <c:set var="tipoHabNom" value="${reserva.idHabit.idTipoHab.tipo}" />

            <!-- Verificar si el tipo de habitación ya está en tipoHabString -->
            <c:if test="${fn:indexOf(tipoHabString, tipoHab) eq -1}">
                <!-- Conteo de reservas para el tipo de habitación actual -->
                <c:set var="cantidadReservas" value="0"/>
                <c:forEach var="otraReserva" items="${reservas}">
                    <c:if test="${reserva.idHabit.idTipoHab.id == otraReserva.idHabit.idTipoHab.id}">
                        <c:set var="cantidadReservas" value="${cantidadReservas + 1}"/>
                    </c:if>
                </c:forEach>

                <!-- Construcción de las cadenas -->
                <c:set var="tipoHabString" value="${tipoHabString}${tipoHab},"/>
                <c:set var="cantReservasString" value="${cantReservasString}${cantidadReservas},"/>
            </c:if>
        </c:if>
    </c:forEach>

    <!-- Eliminar la última coma de cada cadena si es necesario -->
    <c:set var="tipoHabString" value="${fn:substring(tipoHabString, 0, fn:length(tipoHabString) - 1)}"/>
    <c:set var="cantReservasString" value="${fn:substring(cantReservasString, 0, fn:length(cantReservasString) - 1)}"/>

    
    <c:set var="nombresString" value="" />
    
    <c:set var="idsList" value="${fn:split(tipoHabString, ',')}" />
    
    <c:forEach var="id" items="${idsList}">
        <c:forEach var="tipo" items="${tipoHabitaciones}">
            <c:if test="${tipo.id == id}">
                <c:set var="nombresString" value="${nombresString}${tipo.tipo}," />
            </c:if>
        </c:forEach>
    </c:forEach>
    
    <c:set var="nombresString" value="${fn:substring(nombresString, 0, fn:length(nombresString) - 1)}" />

    

    <!-- cral circle -->
    <script>
        
        let tipoHabString="<c:out value="${nombresString}" />";
        let cantReservasString=[<c:out value="${cantReservasString}" />];
        
        const getChartOptions = () => {
            return {
                series: cantReservasString,
                colors: ["#1C64F2", "#ff0000", "#16BDCA", "#FFA500", "#9061F9", "#00FF00", "#FF1493", "#00FFFF", "#FFD700", "#8A2BE2", "#32CD32", "#FF4500", "#9932CC", "#008080", "#FF69B4"],
                chart: {
                height: 420,
                width: "100%",
                type: "pie",
                },
                stroke: {
                colors: ["white"],
                lineCap: "",
                },
                plotOptions: {
                pie: {
                    labels: {
                    show: true,
                    },
                    size: "100%",
                    dataLabels: {
                    offset: -25
                    }
                },
                },
                labels: tipoHabString.split(",").map(s => s.trim()),
                dataLabels: {
                enabled: true,
                style: {
                    fontFamily: "Inter, sans-serif",
                },
                },
                legend: {
                position: "bottom",
                fontFamily: "Inter, sans-serif",
                },
                yaxis: {
                labels: {
                    formatter: function (value) {
                    return value + " reservas"
                    },
                },
                },
                xaxis: {
                labels: {
                    formatter: function (value) {
                    return value  + " reservas"
                    },
                },
                axisTicks: {
                    show: false,
                },
                axisBorder: {
                    show: false,
                },
                },
            }
        }

        if (document.getElementById("pie-chart") && typeof ApexCharts !== 'undefined') {
        const chart = new ApexCharts(document.getElementById("pie-chart"), getChartOptions());
        chart.render();
        }

    </script>

    <!-- char lineal -->
    <script>
        
        let stringFecha="<c:out value="${fechasString}" />";
        let cantF=[<c:out value="${cantidadesString}" />];
        let cantH=[<c:out value="${huespedesString}" />];
        
        const options = {
            chart: {
                height: "100%",
                maxWidth: "100%",
                type: "line",
                fontFamily: "Inter, sans-serif",
                dropShadow: {
                enabled: false,
                },
                toolbar: {
                show: false,
                },
            },
            tooltip: {
                enabled: true,
                x: {
                show: false,
                },
            },
            dataLabels: {
                enabled: false,
            },
            stroke: {
                width: 6,
            },
            grid: {
                show: true,
                strokeDashArray: 4,
                padding: {
                left: 2,
                right: 2,
                top: -26
                },
            },
            series: [
                {
                name: "Reservas",
                data: cantF,
                color: "#1A56DB",
                },
                {
                name: "Huespedes",
                data: cantH,
                color: "#7E3AF2",
                },
            ],
            legend: {
                show: false
            },
            stroke: {
                curve: 'smooth'
            },
            xaxis: {
                categories: stringFecha.split(",").map(s => s.trim()),
                labels: {
                show: true,
                style: {
                    fontFamily: "Inter, sans-serif",
                    cssClass: 'text-xs font-normal fill-gray-500 dark:fill-gray-400'
                }
                },
                axisBorder: {
                show: false,
                },
                axisTicks: {
                show: false,
                },
            },
            yaxis: {
                show: false,
            },
        }

        if (document.getElementById("line-chart") && typeof ApexCharts !== 'undefined') {
            const chart = new ApexCharts(document.getElementById("line-chart"), options);
            chart.render();
        }

    </script>
    
    

</body>
</html>