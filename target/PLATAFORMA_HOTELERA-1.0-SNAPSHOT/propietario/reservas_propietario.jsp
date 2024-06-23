
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- flowbite -->
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

                <!-- encabezado -->
                <div class="bg-[#8f9eb31c] p-5">
                    <h2 class="text-gray-300 text-2xl font-bold mb-4">
                        Reservas
                    </h2>
                    <div class="flex gap-5 pb-2">
                        <label for="item1" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item1" checked> Pendientes
                        </label>
                        <label for="item2" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item2"> En Estadia
                        </label>
                        <label for="item3" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item3"> Completados
                        </label>
                        <label for="item4" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item4"> Todos
                        </label>
                    </div>
                </div>

                <!-- tabla -->
                <div class="bg-[#8f9eb31c] mt-2 pt-1">
                    <h3 class="px-5 text-white text-xl font-bold my-4">
                        Todas Las Reservas
                    </h3>
                    <table class="text-white w-full">
                        <tr class="border-b border-slate-600">
                            <th class="py-3 pl-2 text-left">Id</th>
                            <th class="text-center">Imagen</th>
                            <th class="text-left">Cliente</th>
                            <th class="text-left">Precio</th>
                            <th class="text-left">Habitación</th>
                            <th class="text-left">Comodidades</th>
                            <th class="text-left">Estado</th>
                            <th class="text-left">Fechas</th>
                            <th class="text-center">Actualizar</th>
                        </tr>
                        <tr class="border-b border-slate-600 hover:bg-[#363F4F]">
                            <td class="pl-2">1</td>
                            <td class="">
                                <img class="rounded-full w-20 h-20 object-cover object-center my-1 mx-auto" src="https://cdn.pixabay.com/photo/2020/09/02/05/17/hotel-room-5537364_960_720.jpg"  alt="">
                            </td>
                            <td>Ronaldo Arias</td>
                            <td>20 Bs.</td>
                            <td>Habitación Estandar</td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                            </td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-sky-400">Pendiente</span>
                            </td>
                            <td>
                                12-06-2024 al 15-06-2024
                            </td>
                            <td class="text-center">                           
                                <button id="dropdownDefaultButton" data-dropdown-toggle="dropdown" class="text-blue-400 font-bold" type="button">
                                    Estado 
                                </button>  
                            </td>
                        </tr>
                        <tr class="border-b border-slate-600 hover:bg-[#363F4F]">
                            <td class="pl-2">1</td>
                            <td class="">
                                <img class="rounded-full w-20 h-20 object-cover object-center my-1 mx-auto" src="https://cdn.pixabay.com/photo/2020/09/02/05/17/hotel-room-5537364_960_720.jpg"  alt="">
                            </td>
                            <td>Ronaldo Arias</td>
                            <td>20 Bs.</td>
                            <td>Habitación Estandar</td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                            </td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-green-400">En Estadía</span>
                            </td>
                            <td>
                                12-06-2024 al 15-06-2024
                            </td>
                            <td class="text-center">                           
                                <button id="dropdownDefaultButton" data-dropdown-toggle="dropdown" class="text-blue-400 font-bold" type="button">
                                    Estado 
                                </button>  
                            </td>
                        </tr>
                        <tr class="border-b border-slate-600 hover:bg-[#363F4F]">
                            <td class="pl-2">1</td>
                            <td class="">
                                <img class="rounded-full w-20 h-20 object-cover object-center my-1 mx-auto" src="https://cdn.pixabay.com/photo/2020/09/02/05/17/hotel-room-5537364_960_720.jpg"  alt="">
                            </td>
                            <td>Ronaldo Arias</td>
                            <td>20 Bs.</td>
                            <td>Habitación Estandar</td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                                <span class="inline-block px-2 rounded-full bg-gray-500">Wi-Fi</span>
                            </td>
                            <td>
                                <span class="inline-block px-2 rounded-full bg-purple-700">Completado</span>
                            </td>
                            <td>
                                12-06-2024 al 15-06-2024
                            </td>
                            <td class="text-center">                           
                                <button id="dropdownDefaultButton" data-dropdown-toggle="dropdown" class="text-blue-400 font-bold" type="button">
                                    Estado 
                                </button>  
                            </td>
                        </tr>
                    </table>
                </div>

            </main>

        </div>

    </div>
    

    <!-- Dropdown menu -->
    <div id="dropdown" class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
        <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefaultButton">
            <li>
                <a href="#" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Pendiente</a>
            </li>
            <li>
                <a href="#" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">En Estadia</a>
            </li>
            <li>
                <a href="#" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Completado</a>
            </li>
        </ul>
    </div>

    <!-- flowbite -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>

    
</body>
</html>