
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

                    <!-- card -->
                    <div class="h-[8rem] bg-[#8F9EB31C] flex-1 p-5 flex justify-between">
                        <div class="flex h-full flex-col justify-between">
                            <h3 class="text-gray-300 font-bold">
                                Reservas Actuales
                            </h3>
                            <span class="text-white font-bold text-2xl">
                                12
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
                                12
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
                                12%
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
                                12
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

    <!-- cral circle -->
    <script>
        
        const getChartOptions = () => {
            return {
                series: [52.8, 26.8, 10.4, 10],
                colors: ["#1C64F2", "#16BDCA", "#9061F9", "#ff0000"],
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
                labels: ["Habitacion Estandar", "Suit", "Habitación Familiar", "Habitación Ejecutiva"],
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
                    return value + "%"
                    },
                },
                },
                xaxis: {
                labels: {
                    formatter: function (value) {
                    return value  + "%"
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
                data: [0, 0, 0, 6526, 6356, 6456],
                color: "#1A56DB",
                },
                {
                name: "Huespedes",
                data: [0, 6356, 6526, 6332, 6418, 6500],
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
                categories: ['Enero', 'Febrero', 'Marzo', 'Abril', '05 Feb', '06 Feb', '07 Feb'],
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